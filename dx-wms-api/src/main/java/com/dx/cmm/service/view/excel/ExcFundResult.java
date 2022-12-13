package com.dx.cmm.service.view.excel;

import java.io.Serializable;

public class ExcFundResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6033028238262247084L;

	/**
	 * 客户编号
	 */
	private String lenderCustCode;

	/**
	 * 客户姓名
	 */
	private String custName;

	/**
	 * 客户地址
	 */
	private String custAddress;

	/**
	 * 邮编
	 */
	private String zipCode;

	/*
	 * 报告周期起
	 */
	private String reportPeriodBeginView;

	/**
	 * 账单日
	 */
	private Integer billDay;

	/*
	 * 账户级别
	 */
	private String accountLevel;

	/**
	 * 出借编号
	 */
	private String lenderCode;

	/*
	 * 出借方式
	 */
	private String productView;

	/*
	 * 初始出借日期
	 */
	private String initLoanDayView;

	/**
	 * 初始投资金额
	 */
	private String initTotalAmountView;
	
	/*
	 * 上个报告日资产总价值
	 */
	private String lastTotalAmountView;
	
	/*
	 * 本报告日资产总价值
	 */
	private String totalAmountView;
	
	/*
	 * 本报告日出借人应回收金额
	 */
	private String recycleAmountView;
	
	/*
	 * 本报告日预计出借金额
	 */
	private String loanAmountView;
	
	/*
	 * 本报告日实际回收利息
	 */
	private String incomeView;
	
	/*
	 * 账户管理费率
	 */
	private String accountManageRateView;
	
	/*
	 * 账户管理费
	 */
	private String accountManageAmountView;
	
	/*
	 * 本报告日实际资产总价值
	 */
	private String realTotalAmountView;

	public String getLenderCustCode() {
		return lenderCustCode;
	}

	public void setLenderCustCode(String lenderCustCode) {
		this.lenderCustCode = lenderCustCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getReportPeriodBeginView() {
		return reportPeriodBeginView;
	}

	public void setReportPeriodBeginView(String reportPeriodBeginView) {
		this.reportPeriodBeginView = reportPeriodBeginView;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public String getProductView() {
		return productView;
	}

	public void setProductView(String productView) {
		this.productView = productView;
	}

	public String getInitLoanDayView() {
		return initLoanDayView;
	}

	public void setInitLoanDayView(String initLoanDayView) {
		this.initLoanDayView = initLoanDayView;
	}

	public String getInitTotalAmountView() {
		return initTotalAmountView;
	}

	public void setInitTotalAmountView(String initTotalAmountView) {
		this.initTotalAmountView = initTotalAmountView;
	}

	public String getLastTotalAmountView() {
		return lastTotalAmountView;
	}

	public void setLastTotalAmountView(String lastTotalAmountView) {
		this.lastTotalAmountView = lastTotalAmountView;
	}

	public String getTotalAmountView() {
		return totalAmountView;
	}

	public void setTotalAmountView(String totalAmountView) {
		this.totalAmountView = totalAmountView;
	}

	public String getRecycleAmountView() {
		return recycleAmountView;
	}

	public void setRecycleAmountView(String recycleAmountView) {
		this.recycleAmountView = recycleAmountView;
	}

	public String getLoanAmountView() {
		return loanAmountView;
	}

	public void setLoanAmountView(String loanAmountView) {
		this.loanAmountView = loanAmountView;
	}

	public String getIncomeView() {
		return incomeView;
	}

	public void setIncomeView(String incomeView) {
		this.incomeView = incomeView;
	}

	public String getAccountManageRateView() {
		return accountManageRateView;
	}

	public void setAccountManageRateView(String accountManageRateView) {
		this.accountManageRateView = accountManageRateView;
	}

	public String getAccountManageAmountView() {
		return accountManageAmountView;
	}

	public void setAccountManageAmountView(String accountManageAmountView) {
		this.accountManageAmountView = accountManageAmountView;
	}

	public String getRealTotalAmountView() {
		return realTotalAmountView;
	}

	public void setRealTotalAmountView(String realTotalAmountView) {
		this.realTotalAmountView = realTotalAmountView;
	}
}
