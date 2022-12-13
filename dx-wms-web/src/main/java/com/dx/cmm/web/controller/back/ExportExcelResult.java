package com.dx.cmm.web.controller.back;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

public class ExportExcelResult {
	/**
     * 账单日
     */
    private Integer billDay;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 出借编号
     */
    private String lenderCode;
    /**
     * 出借方式
     */
    private String productName;
    
    /**
     * 初始出借金额
     */
    private BigDecimal initTotalAmount;
    /**
     * 初始出借日期
     */
    private Date interestBeginTime;
    /**
     * 转让日期
     */
    private Date transTime;
    /**
     * 转让对价
     */
    private BigDecimal transTotalAmount;
    
    /**
     * 支付日期
     */
    private String payTimeView;
    /**
     * 付款金额
     */
    private String payTotalAmountView;
    /**
     * 回款支行
     */
    private String backBankView;
    /**
     * 回款姓名（账户名）
     */
    private String backAccountName;
    /**
     * 回款帐户
     */
    private String backAccountNum;
	public Integer getBillDay() {
		return billDay;
	}
	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
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
	public String getLenderCode() {
		return lenderCode;
	}
	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}
	
	
	public BigDecimal getInitTotalAmount() {
		return initTotalAmount;
	}
	public void setInitTotalAmount(BigDecimal initTotalAmount) {
		this.initTotalAmount = initTotalAmount;
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
	public BigDecimal getTransTotalAmount() {
		return transTotalAmount;
	}
	public void setTransTotalAmount(BigDecimal transTotalAmount) {
		this.transTotalAmount = transTotalAmount;
	}
	public String getPayTimeView() {
		return payTimeView;
	}
	public void setPayTimeView(String payTimeView) {
		this.payTimeView = payTimeView;
	}
	public String getPayTotalAmountView() {
		return payTotalAmountView;
	}
	public void setPayTotalAmountView(String payTotalAmountView) {
		this.payTotalAmountView = payTotalAmountView;
	}
	public String getBackBankView() {
		return backBankView;
	}
	public void setBackBankView(String backBankView) {
		this.backBankView = backBankView;
	}
	public String getBackAccountName() {
		return backAccountName;
	}
	public void setBackAccountName(String backAccountName) {
		this.backAccountName = backAccountName;
	}
	public String getBackAccountNum() {
		return backAccountNum;
	}
	public void setBackAccountNum(String backAccountNum) {
		this.backAccountNum = backAccountNum;
	}
    public ExportExcelResult(){
    	
    }
    public ExportExcelResult(TransResult tr){
    	BeanUtils.copyProperties(tr,this);
    }
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
    
}
