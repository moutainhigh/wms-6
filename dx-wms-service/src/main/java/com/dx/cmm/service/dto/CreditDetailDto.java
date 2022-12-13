/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CreditorDetailDto.java
 * Author:   蔡登勇
 * Date:     2015年8月1日 下午3:50:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 债权明细Dto
 *
 * @author 蔡登勇
 * 
 */
public class CreditDetailDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7687131713903588315L;

    /** 借款人姓名 */
    private String loanCustName;

    /** 借款人身份证号码 */
    private String loanCustIdCard;

    /** 转让债权价值 */
    private BigDecimal creditorAmount;

    /** 需支付对价 */
    private BigDecimal payConsideration;

    /** 借款人职业情况 */
    private Integer loanCustWorkSituation;

    /** 借款人借款用途 */
    private Integer loanPurpose;

    /** 借款人借款用途-其他 */
    private String loanPurposeOther;

    /** 还款起始日期 */
    private Date bizStartDate;
    
    /** 还款起始日期 */
    private Date bizStartEnd;
    
    private String bizAttr;

    /** 还款期限 */
    private Integer period;

    /** 剩余还款月数 */
    private Integer remainingPeriod;

    /** 预计债权收益率 */
    private BigDecimal annualReRate;

    private Integer billDay;
    
    
    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Date getBizStartEnd() {
        return bizStartEnd;
    }

    public void setBizStartEnd(Date bizStartEnd) {
        this.bizStartEnd = bizStartEnd;
    }

    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }

    public String getLoanCustName() {
        return loanCustName;
    }

    public void setLoanCustName(String loanCustName) {
        this.loanCustName = loanCustName;
    }

    public String getLoanCustIdCard() {
        return loanCustIdCard;
    }

    public void setLoanCustIdCard(String loanCustIdCard) {
        this.loanCustIdCard = loanCustIdCard;
    }

    public BigDecimal getCreditorAmount() {
        return creditorAmount;
    }

    public void setCreditorAmount(BigDecimal creditorAmount) {
        this.creditorAmount = creditorAmount;
    }

    public BigDecimal getPayConsideration() {
        return payConsideration;
    }

    public void setPayConsideration(BigDecimal payConsideration) {
        this.payConsideration = payConsideration;
    }

    public Integer getLoanCustWorkSituation() {
        return loanCustWorkSituation;
    }

    public void setLoanCustWorkSituation(Integer loanCustWorkSituation) {
        this.loanCustWorkSituation = loanCustWorkSituation;
    }

    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Date getBizStartDate() {
        return bizStartDate;
    }

    public void setBizStartDate(Date bizStartDate) {
        this.bizStartDate = bizStartDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getRemainingPeriod() {
        return remainingPeriod;
    }

    public void setRemainingPeriod(Integer remainingPeriod) {
        this.remainingPeriod = remainingPeriod;
    }

    public BigDecimal getAnnualReRate() {
        return annualReRate;
    }

    public void setAnnualReRate(BigDecimal annualReRate) {
        this.annualReRate = annualReRate;
    }

    public String getLoanPurposeOther() {
        return loanPurposeOther;
    }

    public void setLoanPurposeOther(String loanPurposeOther) {
        this.loanPurposeOther = loanPurposeOther;
    }
    
}
