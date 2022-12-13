/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderDetailDto.java
 * Author:   蔡登勇
 * Date:     2015年8月1日 下午5:49:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 出借明细Dto
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InvestDetailDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = 2460297582060701181L;

    /** 出借编号 */
    private String lenderCode;

    /** 资金出借及回收方式 */
    private Long productId;

    /** 初始出借日期 */
    private Date bizStartDate;

    /** 初始出借金额 */
    private BigDecimal lenderAmount;

    /** 本报告日 */
    private Date reportDate;

    /** 下一个报告日 */
    private Date nextReportDate;

    /** 上一个报告日资产总额 */
    private BigDecimal lastRepAssetAmount;

    /** 本报告日资产总额 */
    private BigDecimal thisRepAssetAmount;

    /** 下一个报告日资产总额 */
    private BigDecimal nextRepAssetAmount;
    
    /** 下一个报告期借款人应还款额 */
    private BigDecimal nextRepRepayAmount;

    /** 报告期内借款人应还款金额（或还款风险金代偿金额） */
    private BigDecimal repaymentAmount;

    /** 报告日您选择受让的债权金额 */
    private BigDecimal assigneeAmount;

    /** 当期回收金额 */
    private BigDecimal recoveryAmount;

    /** 账户管理费率 */
    private BigDecimal accountManagerRate;

    /** 账户管理费 */
    private BigDecimal accountManagerAmount;

    /** 报告日实际资产总额 */
    private BigDecimal rdFinalAssetAmount;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getBizStartDate() {
        return bizStartDate;
    }

    public void setBizStartDate(Date bizStartDate) {
        this.bizStartDate = bizStartDate;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public BigDecimal getLastRepAssetAmount() {
        return lastRepAssetAmount;
    }

    public void setLastRepAssetAmount(BigDecimal lastRepAssetAmount) {
        this.lastRepAssetAmount = lastRepAssetAmount;
    }

    public BigDecimal getThisRepAssetAmount() {
        return thisRepAssetAmount;
    }

    public void setThisRepAssetAmount(BigDecimal thisRepAssetAmount) {
        this.thisRepAssetAmount = thisRepAssetAmount;
    }

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public BigDecimal getAssigneeAmount() {
        return assigneeAmount;
    }

    public void setAssigneeAmount(BigDecimal assigneeAmount) {
        this.assigneeAmount = assigneeAmount;
    }

    public BigDecimal getRecoveryAmount() {
        return recoveryAmount;
    }

    public void setRecoveryAmount(BigDecimal recoveryAmount) {
        this.recoveryAmount = recoveryAmount;
    }

    public BigDecimal getAccountManagerRate() {
        return accountManagerRate;
    }

    public void setAccountManagerRate(BigDecimal accountManagerRate) {
        this.accountManagerRate = accountManagerRate;
    }

    public BigDecimal getAccountManagerAmount() {
        return accountManagerAmount;
    }

    public void setAccountManagerAmount(BigDecimal accountManagerAmount) {
        this.accountManagerAmount = accountManagerAmount;
    }

    public BigDecimal getRdFinalAssetAmount() {
        return rdFinalAssetAmount;
    }

    public void setRdFinalAssetAmount(BigDecimal rdFinalAssetAmount) {
        this.rdFinalAssetAmount = rdFinalAssetAmount;
    }

    public Date getNextReportDate() {
        return nextReportDate;
    }

    public void setNextReportDate(Date nextReportDate) {
        this.nextReportDate = nextReportDate;
    }

    public BigDecimal getNextRepAssetAmount() {
        return nextRepAssetAmount;
    }

    public void setNextRepAssetAmount(BigDecimal nextRepAssetAmount) {
        this.nextRepAssetAmount = nextRepAssetAmount;
    }

    public BigDecimal getNextRepRepayAmount() {
        return nextRepRepayAmount;
    }

    public void setNextRepRepayAmount(BigDecimal nextRepRepayAmount) {
        this.nextRepRepayAmount = nextRepRepayAmount;
    }
    
}
