package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 匹配视图结果dto<br>
 * 匹配视图结果dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MatchViewResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2639332981750678745L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 出借金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 当前总资金
     */
    private BigDecimal currentTotalAmount;

    /**
     * 匹配日期
     */
    private Date matchDate;

    /**
     * 状态
     */
    private String dataStatus;

    /**
     * 投资池编号
     */
    private Long poolId;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 业务编号
     */
    private Long bizId;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 收益
     */
    private BigDecimal totalIncome;

    /**
     * 生效日期
     */
    private Date interestBeginTime;

    /**
     * 首次匹配日期
     */
    private Date initMatchTime;

    /**
     * 转让日期
     */
    private Date transTime;

    /**
     * 转让对价
     */
    private BigDecimal transTotalAmount;

    /**
     * 转让日债权价值
     */
    private BigDecimal transCreditorAmount;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public Date getInitMatchTime() {
        return initMatchTime;
    }

    public void setInitMatchTime(Date initMatchTime) {
        this.initMatchTime = initMatchTime;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public BigDecimal getTransTotalAmount() {
        return transTotalAmount;
    }

    public void setTransTotalAmount(BigDecimal transTotalAmount) {
        this.transTotalAmount = transTotalAmount;
    }

    public BigDecimal getTransCreditorAmount() {
        return transCreditorAmount;
    }

    public void setTransCreditorAmount(BigDecimal transCreditorAmount) {
        this.transCreditorAmount = transCreditorAmount;
    }

}
