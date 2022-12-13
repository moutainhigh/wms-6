/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderDetailVo.java
 * Author:   蔡登勇
 * Date:     2015年8月4日 下午10:00:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.vo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderDetailVo implements Serializable {
    /**
     */
    private static final long serialVersionUID = 7635174231456480503L;

    /** 出借编号 */
    private String lenderCode;

    /** 资金出借及回收方式 */
    private String productName;

    /** 初始出借日期 */
    private String bizStartDate;

    /** 初始出借金额 */
    private String lenderAmount;

    /** 本报告日 */
    private String reportDate;

    /** 下一个报告日 */
    private String nextReportDate;

    /** 上一个报告日资产总额 */
    private String lastRepAssetAmount;

    /** 本报告日资产总额 */
    private String thisRepAssetAmount;

    /** 下一个报告日资产总额 */
    private String nextRepAssetAmount;
    
    /** 下一个报告期借款人应还款额 */
    private String nextRepRepayAmount;

    /** 报告期内借款人应还款金额（或还款风险金代偿金额） */
    private String repaymentAmount;

    /** 报告日您选择受让的债权金额 */
    private String assigneeAmount;

    /** 当期回收金额 */
    private String recoveryAmount;

    /** 账户管理费率 */
    private String accountManagerRate;

    /** 账户管理费 */
    private String accountManagerAmount;

    /** 报告日实际资产总额 */
    private String rdFinalAssetAmount;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBizStartDate() {
        return bizStartDate;
    }

    public void setBizStartDate(String bizStartDate) {
        this.bizStartDate = bizStartDate;
    }

    public String getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(String lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getNextReportDate() {
        return nextReportDate;
    }

    public void setNextReportDate(String nextReportDate) {
        this.nextReportDate = nextReportDate;
    }

    public String getLastRepAssetAmount() {
        return lastRepAssetAmount;
    }

    public void setLastRepAssetAmount(String lastRepAssetAmount) {
        this.lastRepAssetAmount = lastRepAssetAmount;
    }

    public String getThisRepAssetAmount() {
        return thisRepAssetAmount;
    }

    public void setThisRepAssetAmount(String thisRepAssetAmount) {
        this.thisRepAssetAmount = thisRepAssetAmount;
    }

    public String getNextRepAssetAmount() {
        return nextRepAssetAmount;
    }

    public void setNextRepAssetAmount(String nextRepAssetAmount) {
        this.nextRepAssetAmount = nextRepAssetAmount;
    }

    public String getNextRepRepayAmount() {
        return nextRepRepayAmount;
    }

    public void setNextRepRepayAmount(String nextRepRepayAmount) {
        this.nextRepRepayAmount = nextRepRepayAmount;
    }

    public String getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(String repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public String getAssigneeAmount() {
        return assigneeAmount;
    }

    public void setAssigneeAmount(String assigneeAmount) {
        this.assigneeAmount = assigneeAmount;
    }

    public String getRecoveryAmount() {
        return recoveryAmount;
    }

    public void setRecoveryAmount(String recoveryAmount) {
        this.recoveryAmount = recoveryAmount;
    }

    public String getAccountManagerRate() {
        return accountManagerRate;
    }

    public void setAccountManagerRate(String accountManagerRate) {
        this.accountManagerRate = accountManagerRate;
    }

    public String getAccountManagerAmount() {
        return accountManagerAmount;
    }

    public void setAccountManagerAmount(String accountManagerAmount) {
        this.accountManagerAmount = accountManagerAmount;
    }

    public String getRdFinalAssetAmount() {
        return rdFinalAssetAmount;
    }

    public void setRdFinalAssetAmount(String rdFinalAssetAmount) {
        this.rdFinalAssetAmount = rdFinalAssetAmount;
    }
    
}
