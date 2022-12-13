/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CreditorDetailVo.java
 * Author:   蔡登勇
 * Date:     2015年8月4日 下午9:58:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CreditorDetailVo implements Serializable {
    /**
     */
    private static final long serialVersionUID = 7635174231456480503L;

    /** 借款人姓名 */
    private String loanCustName;

    /** 借款人身份证号码 */
    private String loanCustIdCard;

    /** 转让债权价值 */
    private BigDecimal creditorAmount;

    private String creditorAmountView;

    /** 需支付对价 */
    private BigDecimal payConsideration;

    private String payConsiderationView;

    /** 借款人职业情况 */
    private Integer loanCustWorkSituation;

    private String loanCustWorkSituationView;

    /** 借款人借款用途 */
    private Integer loanPurpose;
    private String loanPurposeView;

    /** 借款人借款用途-其他 */
    private String loanPurposeOther;

    /** 还款起始日期 */
    private Date bizStartDate;
    private String bizStartDateView;
    /** 还款期限 */
    private Integer period;

    /** 剩余还款月数 */
    private Integer remainingPeriod;

    /** 预计债权收益率 */
    private BigDecimal annualReRate;

    private String annualReRateView;

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

    public String getCreditorAmountView() {
        return creditorAmountView;
    }

    public void setCreditorAmountView(String creditorAmountView) {
        this.creditorAmountView = creditorAmountView;
    }

    public BigDecimal getPayConsideration() {
        return payConsideration;
    }

    public void setPayConsideration(BigDecimal payConsideration) {
        this.payConsideration = payConsideration;
    }

    public String getPayConsiderationView() {
        return payConsiderationView;
    }

    public void setPayConsiderationView(String payConsiderationView) {
        this.payConsiderationView = payConsiderationView;
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

    public String getLoanPurposeOther() {
        return loanPurposeOther;
    }

    public void setLoanPurposeOther(String loanPurposeOther) {
        this.loanPurposeOther = loanPurposeOther;
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

    public String getAnnualReRateView() {
        return annualReRateView;
    }

    public void setAnnualReRateView(String annualReRateView) {
        this.annualReRateView = annualReRateView;
    }

    public String getLoanCustWorkSituationView() {
        return loanCustWorkSituationView;
    }

    public void setLoanCustWorkSituationView(String loanCustWorkSituationView) {
        this.loanCustWorkSituationView = loanCustWorkSituationView;
    }

    public String getLoanPurposeView() {
        return loanPurposeView;
    }

    public void setLoanPurposeView(String loanPurposeView) {
        this.loanPurposeView = loanPurposeView;
    }

    public String getBizStartDateView() {
        return bizStartDateView;
    }

    public void setBizStartDateView(String bizStartDateView) {
        this.bizStartDateView = bizStartDateView;
    }

}
