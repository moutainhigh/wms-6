/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: TransferEaDto.java
 * Author:   蔡登勇
 * Date:     2015年8月4日 下午5:14:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TransferTotalDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6312268335129981208L;

    /**
     * 还款总额
     */
    private BigDecimal totalRepayAmount;

    private BigDecimal remainRepayAmount;

    private BigDecimal incomeRepayAmount;
    /**
     * 利息总额
     */
    private BigDecimal totalInterestAmount;

    private BigDecimal remmainInterestAmount;

    private BigDecimal incomeInterestAmount;

    /**
     * 本金总额
     */
    private BigDecimal totalPrincalAmount;

    private BigDecimal remmainPrincalAmount;

    private BigDecimal incomePrincalAmount;

    private BigDecimal totalTransferAmount;

    private BigDecimal lenderIncomeAmount;

    private BigDecimal accountManagementAmount;

    public BigDecimal getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void setTotalTransferAmount(BigDecimal totalTransferAmount) {
        this.totalTransferAmount = totalTransferAmount;
    }

    public BigDecimal getTotalRepayAmount() {
        return totalRepayAmount;
    }

    public void setTotalRepayAmount(BigDecimal totalRepayAmount) {
        this.totalRepayAmount = totalRepayAmount;
    }

    public BigDecimal getRemainRepayAmount() {
        return remainRepayAmount;
    }

    public void setRemainRepayAmount(BigDecimal remainRepayAmount) {
        this.remainRepayAmount = remainRepayAmount;
    }

    public BigDecimal getIncomeRepayAmount() {
        return incomeRepayAmount;
    }

    public void setIncomeRepayAmount(BigDecimal incomeRepayAmount) {
        this.incomeRepayAmount = incomeRepayAmount;
    }

    public BigDecimal getTotalInterestAmount() {
        return totalInterestAmount;
    }

    public void setTotalInterestAmount(BigDecimal totalInterestAmount) {
        this.totalInterestAmount = totalInterestAmount;
    }

    public BigDecimal getRemmainInterestAmount() {
        return remmainInterestAmount;
    }

    public void setRemmainInterestAmount(BigDecimal remmainInterestAmount) {
        this.remmainInterestAmount = remmainInterestAmount;
    }

    public BigDecimal getIncomeInterestAmount() {
        return incomeInterestAmount;
    }

    public void setIncomeInterestAmount(BigDecimal incomeInterestAmount) {
        this.incomeInterestAmount = incomeInterestAmount;
    }

    public BigDecimal getTotalPrincalAmount() {
        return totalPrincalAmount;
    }

    public void setTotalPrincalAmount(BigDecimal totalPrincalAmount) {
        this.totalPrincalAmount = totalPrincalAmount;
    }

    public BigDecimal getRemmainPrincalAmount() {
        return remmainPrincalAmount;
    }

    public void setRemmainPrincalAmount(BigDecimal remmainPrincalAmount) {
        this.remmainPrincalAmount = remmainPrincalAmount;
    }

    public BigDecimal getIncomePrincalAmount() {
        return incomePrincalAmount;
    }

    public void setIncomePrincalAmount(BigDecimal incomePrincalAmount) {
        this.incomePrincalAmount = incomePrincalAmount;
    }

    public void calculate(Date arg0, Integer arg1) throws ParamException {
        Assert.notNull(new ParamException("param is null"), arg0, arg1);
        Integer full = DateUtils.getDays(DateUtils.getBeginDay(arg0, arg1), DateUtils.getLastDay(arg0, arg1));
        Integer part = DateUtils.getDays(arg0, DateUtils.getLastDay(arg0, arg1));
        setIncomeInterestAmount(getTotalInterestAmount().multiply(new BigDecimal(part.toString()))
                .divide(new BigDecimal(full), 2, BigDecimal.ROUND_HALF_UP));
        setIncomeRepayAmount(getTotalPrincalAmount().add(getIncomeInterestAmount()));
        setIncomePrincalAmount(getTotalPrincalAmount());
        setRemainRepayAmount(getTotalRepayAmount().subtract(getIncomeRepayAmount()));
        setRemmainInterestAmount(getTotalInterestAmount().subtract(getIncomeInterestAmount()));
        setRemmainPrincalAmount(getTotalPrincalAmount().subtract(getIncomePrincalAmount()));
    }

    public void calculate(InvestmentPool pool) {
        setIncomeRepayAmount(getTotalRepayAmount());
        setIncomePrincalAmount(getTotalPrincalAmount());
        if (pool.getIsFix() && pool.getIsTrans()) {
            Integer full = DateUtils.getDays(DateUtils.getBeginDay(pool.getTransTime(), pool.getBillDay()),
                    DateUtils.getLastDay(pool.getTransTime(), pool.getBillDay()));
            Integer part = DateUtils.getDays(DateUtils.getBeginDay(pool.getTransTime(), pool.getBillDay()),
                    pool.getTransTime());
            setIncomeInterestAmount(getTotalInterestAmount().multiply(new BigDecimal(part.toString()))
                    .divide(new BigDecimal(full), 2, BigDecimal.ROUND_HALF_UP));
            setAccountManagementAmount(
                    pool.getCurrentTotalAmount().add(getIncomeInterestAmount()).subtract(pool.getTransTotalAmount()));
        } else {
            setIncomeInterestAmount(getTotalInterestAmount());
            setAccountManagementAmount(BigDecimal.ZERO);
        }
        setLenderIncomeAmount(BigDecimal.ZERO);
        setRemainRepayAmount(getTotalRepayAmount().subtract(getIncomeRepayAmount()));
        setRemmainInterestAmount(getTotalInterestAmount().subtract(getIncomeInterestAmount()));
        setRemmainPrincalAmount(getTotalPrincalAmount().subtract(getIncomePrincalAmount()));
    }

    public void calculate(InvestmentPool pool, BigDecimal income) {
        setIncomeRepayAmount(getTotalRepayAmount());
        setIncomePrincalAmount(getTotalPrincalAmount());
        setIncomeInterestAmount(income);
        setAccountManagementAmount(
                pool.getCurrentTotalAmount().add(getIncomeInterestAmount()).subtract(pool.getTransTotalAmount()));
        setLenderIncomeAmount(BigDecimal.ZERO);
        setRemainRepayAmount(getTotalRepayAmount().subtract(getIncomeRepayAmount()));
        setRemmainInterestAmount(getTotalInterestAmount().subtract(getIncomeInterestAmount()));
        setRemmainPrincalAmount(getTotalPrincalAmount().subtract(getIncomePrincalAmount()));
    }

    public BigDecimal getLenderIncomeAmount() {
        return lenderIncomeAmount;
    }

    public void setLenderIncomeAmount(BigDecimal lenderIncomeAmount) {
        this.lenderIncomeAmount = lenderIncomeAmount;
    }

    public BigDecimal getAccountManagementAmount() {
        return accountManagementAmount;
    }

    public void setAccountManagementAmount(BigDecimal accountManagementAmount) {
        this.accountManagementAmount = accountManagementAmount;
    }

}
