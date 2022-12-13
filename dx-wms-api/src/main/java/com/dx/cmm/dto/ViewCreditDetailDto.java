package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 债权视图详情Dto<br>
 * 债权视图详情Dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ViewCreditDetailDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5263115922674396423L;

    /**
     * 债权编号
     */
    private Long poolId;

    /**
     * 借款人姓名
     */
    private String custName;

    /**
     * 身份号
     */
    private String idCard;

    /**
     * 本次转让债权价值
     */
    private BigDecimal transAmount;

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
    private Date repayDateBegin;

    /**
     * 还款期限（月）
     */
    private Integer initPeriod;

    /**
     * 剩余还款月数
     */
    private Integer remainPeriod;

    /**
     * 预计债权收益率（年）
     */
    private BigDecimal rateYear;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
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

    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }

    public Date getRepayDateBegin() {
        return repayDateBegin;
    }

    public void setRepayDateBegin(Date repayDateBegin) {
        this.repayDateBegin = repayDateBegin;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
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

}
