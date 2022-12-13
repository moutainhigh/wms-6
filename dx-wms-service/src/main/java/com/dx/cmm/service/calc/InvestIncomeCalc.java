package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

/**
 * 
 * 理财收益运算
 *
 * @author tony
 */
@Service("investIncomeCalc")
public class InvestIncomeCalc extends CalcAbs<InvestmentFund, BigDecimal> {

    private static final Long L002 = 12L;

    private static final Long L007 = 34L;

    @Override
    public BigDecimal calc(InvestmentFund fund) {
        LOG.info("Fund [{}]", new Gson().toJson(fund));
        if (Assert.equals(L002, fund.getProductId()) || Assert.equals(L007, fund.getProductId())) {
            return fund.getNextInterestTotalAmount().subtract(fund.getAccountManagementFee());
        }
        return BigDecimal.ZERO;
    }
}
