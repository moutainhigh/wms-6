package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.income.Incomes;
import com.dx.cmm.service.income.InjectException;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

@Service("creditRemainCalc")
public class CreditRemainCalc extends CalcAbs<CreditorPool, Boolean> {

    @Autowired
    private Calc<CreditorPool, List<BigDecimal>> creditResultCalc;

    @Autowired
    private Funds<CreditorFund> creditFund;

    @Autowired
    private Pools<CreditorPool> creditPool;

    @Autowired
    private Incomes<CreditorFund> remainCreditIncome;

    @Override
    public Boolean calc(CreditorPool pool) throws CalcException {
        if (!Assert.checkParam(pool)) {
            LOG.error("Pool must not be null");
            throw error("Pool must not be null");
        }
        try {
            LOG.info("Pool[{}] execute remain", pool.getCreditorPoolId());
            int current = creditFund.current(pool.getCreditorPoolId()) + 1;//从债券资金表中获得当前期数+1
            for (int currentPeriod = current; currentPeriod <= pool.getRemainMonths(); currentPeriod++) {
                CreditorFund fund = new CreditorFund(pool, currentPeriod);
                LOG.info("Fund[{}]", new Gson().toJson(fund));
                creditFund.save(fund);
                pool.setCurrentReportDate(fund.getReportDay());
                List<BigDecimal> amounts = creditResultCalc.calc(pool);
                pool.remain(amounts.get(0), amounts.get(1));
                remainCreditIncome.inject(fund);
                creditPool.save(pool);
            }
        } catch (SaveException | InjectException e) {
            LOG.error("Pool[{}] save fund error[{}]", pool.getCreditorPoolId(), e.getMessage());
            throw error("Pool[{0}] save fund error[{1}]", pool.getCreditorPoolId(), e.getMessage());
        }
        return true;
    }
}
