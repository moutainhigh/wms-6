/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackTransResult.java
 * Author:   朱道灵
 * Date:     2016年5月9日 上午9:28:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 到期回款结果
 *
 * @author 朱道灵
 */
public class BackTransResult extends BackBaseResult {

    /**
     */
    private static final long serialVersionUID = -6536484503059347746L;
    
    /**
     * 邮编
     */
    private String zipCode;
  
    /**
     * 地址
     */
    private String custAddress;

    /**
     * 初始出借金额'
     */
    private BigDecimal initTotalAmount;

    /**
     * 转让日债权价值'
     */
    private BigDecimal transCreditorAmount;

    /**
     * 转让对价
     */
    private BigDecimal transTotalAmount;

    /**
     * 转让服务费
     */
    private BigDecimal transServiceFee; 

    /**
     * 账户管理费
     */
    private BigDecimal accountManagementFee; 

    /**
     * 初始出借日期
     */
    private Date interestBeginTime; 

    /**
     * 转让日期
     */
    private Date transTime;
    
    /**
     * 付款金额
     */
    private BigDecimal payTotalAmount;
    
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public BigDecimal getTransCreditorAmount() {
        return transCreditorAmount;
    }

    public void setTransCreditorAmount(BigDecimal transCreditorAmount) {
        this.transCreditorAmount = transCreditorAmount;
    }

    public BigDecimal getTransTotalAmount() {
        return transTotalAmount;
    }

    public void setTransTotalAmount(BigDecimal transTotalAmount) {
        this.transTotalAmount = transTotalAmount;
    }

    public BigDecimal getTransServiceFee() {
        return transServiceFee;
    }

    public void setTransServiceFee(BigDecimal transServiceFee) {
        this.transServiceFee = transServiceFee;
    }

    public BigDecimal getAccountManagementFee() {
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

	public BigDecimal getPayTotalAmount() {
		return payTotalAmount;
	}

	public void setPayTotalAmount(BigDecimal payTotalAmount) {
		this.payTotalAmount = payTotalAmount;
	}

}
