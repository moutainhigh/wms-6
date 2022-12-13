package com.dx.cmm.service.tasks;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.InvestIntParamCalc;
import com.dx.cmm.service.calc.ResultIntParamCalc;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.StatResult;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.push.ILenderPushService;
import com.google.gson.Gson;

@Service("investSuccessTask")
public class InvestSuccessTask extends SyncTask {

	public static final Long L007 = 34L ;
	
    @Autowired
    private Calc<InvestIntParamCalc, BigDecimal> investIntCalc;

    @Autowired
    private Calc<ResultIntParamCalc, BigDecimal> resultIntSuccessCalc;

    @Autowired
    private ILenderPushService lenderPushService;
    
    @Autowired
    private Calc<InvestmentPool, BigDecimal> l007IncomeCalc;
    
    @Override
    public synchronized void execute() throws TaskException {
        List<MatchBizBase> bases = investBizBase.queryArray(true, BizBaseStatus.SUCCESS);
        for (final MatchBizBase base : bases) {
            final InvestmentPool pool = investPool.query(base);
            if (!Assert.checkParam(pool)) {
                LOG.error("Base[{}] not found pool", new Gson().toJson(base));
                continue;
            }
            if (Assert.equals(pool.getDataStatus(), BizBaseStatus.SUCCESS.getCode())) {
                LOG.error("Pool[{}] is success", new Gson().toJson(pool));
                continue;
            }
            if (!Assert.equals(pool.getDataStatus(), BizBaseStatus.MATCH.getCode())) {
                LOG.error("Pool[{}] has error status", new Gson().toJson(pool));
                continue;
            }
            final InvestAttr attr = base.invest();
            if (!Assert.checkParam(attr.getInterestBeginTime())) {
                LOG.error("Base[{}] has no interest begin time", new Gson().toJson(base));
                continue;
            }
            dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                @Override
                public Boolean invoke() {
                    StatResult stat = investResult.query(pool.getInvestmentPoolId(), pool.getInitBillDate());
                    InvestmentFund fund = new InvestmentFund(pool);
                    BigDecimal intTotal = investIntCalc
                            .calc(new InvestIntParamCalc(fund, stat.getIntTotal(), attr.getInterestBeginTime()));
                    List<MatchResult> results = investResult.queryArray(pool.getInvestmentPoolId(), 1);
                    execute(results, attr.getInterestBeginTime(), pool.getBillDay(), intTotal);
                    execute(pool, base, attr.getInterestBeginTime());
                    execute(fund, intTotal, stat);
                    investBizBase.save(base);
                    return true;
                }
            });
        }

    }

    private void execute(InvestmentFund fund, BigDecimal intTotal, StatResult stat) {
        fund.setNextInterestTotalAmount(intTotal);
        fund.setNextPrincalTotalAmount(stat.getCapitalTotal());
        fund.setNextTransferTotalAmount(stat.getTransTotal().add(intTotal));
        fund.setNextRepaymentTotalAmount(stat.getRepayTotal());
        investFund.save(fund);
    }

    private void execute(List<MatchResult> results, Date interestBeginTime, Integer port, BigDecimal intTotal) {
        Assert.notNull("Results or interest total must not be null", results, intTotal);
        BigDecimal tmp = intTotal;
        Integer count = 1;
        for (MatchResult result : results) {
            BigDecimal intPart = resultIntSuccessCalc.calc(new ResultIntParamCalc(result, interestBeginTime, port));
            if (Assert.equals(count, results.size())) {
                intPart = tmp;
            }
            result.setTransferEaPartInterestAmount(intPart);
            investResult.save(result);
            tmp = tmp.subtract(intPart);
            count++;
        }
    }

    private void execute(InvestmentPool pool, MatchBizBase base, Date interestBeginTime) {
    	Assert.notNull("**execute() applyDate must not be null",base.getApplyDate());
        pool.success(interestBeginTime);
        if (productService.isFix(pool.getProductId())) {
            // init trans
            BigDecimal rateMonth = productService.getRateMonth(pool.getProductId(), base.getApplyDate(),pool.getInitTotalAmount());
            BigDecimal rateYear = productService.getRateYear(pool.getProductId(), base.getApplyDate(),pool.getInitTotalAmount());
            BigDecimal firstIncome = BigDecimal.ZERO;
            if(Assert.equals(L007, pool.getProductId())){
            	firstIncome = l007IncomeCalc.calc(pool);
            }
            pool.transFix(rateMonth, rateYear,firstIncome);
            PushDataDto data = new PushDataDto();
            data.setLenderCode(base.getBizCode());
            data.setDueDate(pool.getTransTime());
            lenderPushService.push(PushCode.DUE_DATE, data);
        }
        investPool.save(pool);
    }
}
