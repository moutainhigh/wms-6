package com.dx.cmm.service.sync;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.ResultIntParamCalc;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("transDataSync")
public class TransDataSync extends SyncAbs {

    @Autowired
    private Calc<ResultIntParamCalc, BigDecimal> resultIntTransCalc;

    @Override
    public void sync() {
        LOG.info("Trans data start");
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                List<InvestmentPool> invests = dalClient.queryForList("batchSync.syncTransFund", null,
                        InvestmentPool.class);
                LOG.info("Invests size[{}]", invests.size());
                for (InvestmentPool invest : invests) {
                    BigDecimal interest = execute(invest,
                            investResult.queryArray(invest.getInvestmentPoolId(), invest.getCurrentPeriod()));
                    invest.test(interest);
                    InvestmentFund fund = investFund.query(invest.getInvestmentPoolId());
                    fund.trans(invest, interest);
                    investFund.save(fund);
                    investPool.save(invest);
                }
                return true;
            }
        });
        LOG.info("Trans data end");

    }

    private BigDecimal execute(InvestmentPool pool, List<MatchResult> results) {
        BigDecimal interest = BigDecimal.ZERO;
        for (MatchResult result : results) {
            BigDecimal partInt = resultIntTransCalc
                    .calc(new ResultIntParamCalc(result, pool.getTransTime(), pool.getBillDay()));
            result.setTransferEaPartInterestAmount(partInt);
            interest = interest.add(partInt);
            investResult.save(result);
        }
        return interest;
    }
}
