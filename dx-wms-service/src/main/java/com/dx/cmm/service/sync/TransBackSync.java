package com.dx.cmm.service.sync;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.google.gson.Gson;

@Service("transBackSync")
public class TransBackSync extends SyncAbs {

    @Override
    public void sync() {
        LOG.info("Trans back start");
        List<InvestmentPool> invests = dalClient.queryForList("batchSync.syncTransFund", null, InvestmentPool.class);
        LOG.info("Trans back invests size[{}]", invests.size());
        for (InvestmentPool invest : invests) {
            BigDecimal income = BigDecimal.ZERO;
            List<MatchResult> results = investResult.queryArray(invest.getInvestmentPoolId(),
                    invest.getCurrentPeriod());
            for (MatchResult result : results) {
                // result.calculate(invest);
                income = income.add(result.getTransferEaPartInterestAmount());
                CreditorPool credit = creditPool.query(result.getCreditorPoolId());
                credit.rollback(result.getTransferTotalAmount());
                creditPool.save(credit);
                investResult.save(result);
            }
            invest.setTransCreditorAmount(invest.getCurrentTotalAmount().add(income));
            InvestmentFund fund = investFund.query(invest.getInvestmentPoolId());
            // fund.trans(invest);
            LOG.info("Trans back fund[{}]", new Gson().toJson(fund));
            investFund.save(fund);
            investPool.save(invest);
        }

    }

}
