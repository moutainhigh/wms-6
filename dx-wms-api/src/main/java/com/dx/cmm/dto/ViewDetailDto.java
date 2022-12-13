package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 视图详情Dto<br>
 * 视图详情Dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ViewDetailDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5263115922674396423L;

    /**
     * 债权编号
     */
    private Long creditorId;

    /**
     * 债权姓名
     */
    private String name;

    /**
     * 身份号
     */
    private String idCard;

    /**
     * 本次转让债权价值
     */
    private BigDecimal transferAmount;

    /**
     * 需支付对价
     */
    private BigDecimal equalsAmount;

    /**
     * 借款人职业情况
     */
    private String professionInfo;

    /**
     * 借款人借款用途
     */
    private String loanInfo;

    private String bizAttr;

    /**
     * 还款起始日期
     */
    private Date beginDate;

    /**
     * 还款期限（月）
     */
    private Integer period;

    /**
     * 剩余还款月数
     */
    private Integer remainPeriod;

    /**
     * 预计债权收益率（年）
     */
    private BigDecimal rateYear;

    public Long getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(Long creditorId) {
        this.creditorId = creditorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public BigDecimal getEqualsAmount() {
        return equalsAmount;
    }

    public void setEqualsAmount(BigDecimal equalsAmount) {
        this.equalsAmount = equalsAmount;
    }

    public String getProfessionInfo() {
        return professionInfo;
    }

    public void setProfessionInfo(String professionInfo) {
        this.professionInfo = professionInfo;
    }

    public String getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(String loanInfo) {
        this.loanInfo = loanInfo;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }

   
}
