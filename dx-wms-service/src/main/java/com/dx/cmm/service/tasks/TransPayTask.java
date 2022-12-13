package com.dx.cmm.service.tasks;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.ResultIntParamCalc;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.google.gson.Gson;

@Service("transPayTask")
public class TransPayTask extends SyncTask {

    @Autowired
    private Calc<ResultIntParamCalc, BigDecimal> resultIntTransCalc;

    @Override
    public synchronized void execute() throws TaskException {
        List<MatchBizBase> bases = investBizBase.queryArray(true, BizBaseStatus.TRANS);
        for (final MatchBizBase base : bases) {
            final InvestmentPool pool = investPool.query(base);
            LOG.info("Pool[{}] execute trans", pool.getInvestmentPoolId());
            if (!Assert.checkParam(pool)) {
                LOG.error("Base[{}] not found pool", new Gson().toJson(base));
                continue;
            }
            if (Assert.equals(pool.getDataStatus(), BizBaseStatus.TRANS.getCode())) {
                LOG.error("Pool[{}] is trans", new Gson().toJson(pool));
                continue;
            }
            if (!Assert.equals(pool.getDataStatus(), BizBaseStatus.SUCCESS.getCode())) {
                LOG.error("Pool[{}] must be success", new Gson().toJson(pool));
                continue;
            }
            final InvestAttr attr = base.invest();
            if (!Assert.checkParam(attr.getPayTime())) {
                LOG.error("Base[{}] has no pay time", new Gson().toJson(base));
                continue;
            }
            dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                @Override
                public Boolean invoke() {
                    BigDecimal interest = execute(pool,
                            investResult.queryArray(pool.getInvestmentPoolId(), pool.getCurrentPeriod()));
                    execute(pool, attr, interest);
                    investBizBase.save(base);
                    return true;
                }
            });
        }
    }

    private void execute(InvestmentPool pool, InvestAttr attr, BigDecimal interest) {
        pool.pay(attr.getPayTime(), interest);
        InvestmentFund fund = investFund.query(pool.getInvestmentPoolId());
        fund.trans(pool, interest);
        investFund.save(fund);
        investPool.save(pool);
    }

    private BigDecimal execute(InvestmentPool pool, List<MatchResult> results) {
        BigDecimal interest = BigDecimal.ZERO;
        for (MatchResult result : results) {
            BigDecimal partInt = resultIntTransCalc
                    .calc(new ResultIntParamCalc(result, pool.getTransTime(), pool.getBillDay()));
            result.setTransferEaPartInterestAmount(partInt);
            interest = interest.add(partInt);
            execute(result);
        }
        return interest;
    }

    private void execute(MatchResult result) {
        CreditorPool pool = creditPool.query(result.getCreditorPoolId());
        pool.rollback(result.getTransferTotalAmount());
        creditPool.save(pool);
        result.del();
        investResult.save(result);
        execute(pool);
    }

    private void execute(CreditorPool pool) {
        if (Assert.equals(pool.getInitPeriod(), pool.getRemainPeriod())
                && Assert.equals(pool.getDataStatus(), BizBaseStatus.WAIT.getCode())) {
            creditBizBase.save(pool.getMatchBizBaseId(), BizBaseStatus.CREATED);
        }
    }
}
