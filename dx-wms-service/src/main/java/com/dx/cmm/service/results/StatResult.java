package com.dx.cmm.service.results;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4005315513415296377L;

    /**
     * 转让总价值
     */
    private BigDecimal transTotal = BigDecimal.ZERO;

    /**
     * 支付总价值
     */
    private BigDecimal payTotal = BigDecimal.ZERO;

    /**
     * 报告日
     */
    private Date reportDate;

    /**
     * 债权比例
     */
    private BigDecimal creditRate = BigDecimal.ZERO;

    /**
     * 还款总金额
     */
    private BigDecimal repayTotal = BigDecimal.ZERO;

    /**
     * 总本金
     */
    private BigDecimal capitalTotal = BigDecimal.ZERO;

    /**
     * 总利息
     */
    private BigDecimal intTotal = BigDecimal.ZERO;

    /**
     * 理财收益总利息
     */
    private BigDecimal incomeIntTotal = BigDecimal.ZERO;

    /**
     * 总数
     */
    private Integer count = 0;

    /**
     * 资金池编号
     */
    private Long poolId;

    public BigDecimal getTransTotal() {
        return transTotal;
    }

    public void setTransTotal(BigDecimal transTotal) {
        this.transTotal = transTotal;
    }

    public BigDecimal getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(BigDecimal payTotal) {
        this.payTotal = payTotal;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(BigDecimal creditRate) {
        this.creditRate = creditRate;
    }

    public BigDecimal getRepayTotal() {
        return repayTotal;
    }

    public void setRepayTotal(BigDecimal repayTotal) {
        this.repayTotal = repayTotal;
    }

    public BigDecimal getCapitalTotal() {
        return capitalTotal;
    }

    public void setCapitalTotal(BigDecimal capitalTotal) {
        this.capitalTotal = capitalTotal;
    }

    public BigDecimal getIntTotal() {
        return intTotal;
    }

    public void setIntTotal(BigDecimal intTotal) {
        this.intTotal = intTotal;
    }

    public BigDecimal getIncomeIntTotal() {
        return incomeIntTotal;
    }

    public void setIncomeIntTotal(BigDecimal incomeIntTotal) {
        this.incomeIntTotal = incomeIntTotal;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

}
