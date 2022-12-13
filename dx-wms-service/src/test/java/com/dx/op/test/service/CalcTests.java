package com.dx.op.test.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.InvestIntParamCalc;
import com.dx.cmm.service.calc.MonthParamCalc;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.common.test.BaseTest;

public class CalcTests extends BaseTest {

    @Autowired
    private Calc<MonthParamCalc, Integer> monthCalc;

    @Test
    public void creditMonthCalc() {
        System.out.println(monthCalc.calc(new MonthParamCalc(new Date(), new Date())));
    }

    @Autowired
    private Calc<InvestmentFund, BigDecimal> totalTransCalc;

    @Test
    public void totalTransCalc() {
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentPoolId(1L);
        fund.setCurrentPeriod(6);
        fund.nextCurrentPeriod();
        BigDecimal result = totalTransCalc.calc(fund);
        System.out.println(result);
    }

    @Autowired
    private Calc<InvestIntParamCalc, BigDecimal> investIntCalc;

    @Test
    public void investIntCalc() {
        InvestIntParamCalc param = new InvestIntParamCalc();
        param.setTotalInterest(new BigDecimal("1113.39"));
        param.setRefDay(1);
        param.setRefDate(DateUtils.parseForDay("2016-05-05"));
        param.setCurrentPeriod(1);
        System.out.println(investIntCalc.calc(param));
    }

    @Autowired
    private Calc<Integer, Date> reportDateCalc;

    @Test
    public void reportDateCalc() {
        System.out.println(reportDateCalc.calc(5));
    }

    @Autowired
    private Calc<InvestmentPool, BigDecimal> accountFeeCalc;

    @Test
    public void accountFeeCalc() {
        InvestmentPool pool = new InvestmentPool();
        pool.setInvestmentPoolId(162L);
        pool.setMatchUserId(701L);
        pool.setProductId(16L);
        System.out.println(accountFeeCalc.calc(pool));
    }

  
}
