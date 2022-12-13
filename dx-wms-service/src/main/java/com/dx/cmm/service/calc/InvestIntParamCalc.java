package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.funds.InvestmentFund;

public class InvestIntParamCalc extends IntParamCalc {
    /**
     */
    private static final long serialVersionUID = -1168984415065935840L;

    /**
     * 总利息
     */
    private BigDecimal totalInterest;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    public InvestIntParamCalc() {

    }

    public InvestIntParamCalc(InvestmentFund fund, BigDecimal totalInt, Date refDate) {
        BeanUtils.copyProperties(fund, this);
        setRefDate(refDate);
        setRefDay(fund.getInvestmentFundDay());
        setTotalInterest(totalInt);
    }

    public InvestIntParamCalc(InvestmentFund fund) {
        BeanUtils.copyProperties(fund, this);
        setRefDate(fund.getInterestBeginTime());
        setRefDay(fund.getInvestmentFundDay());
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }
}
