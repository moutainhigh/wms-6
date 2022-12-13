package com.dx.cmm.service.view.excel;

import java.io.Serializable;

public class ExcPastResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4862780127798261630L;

	/*
	 * 邮编
	 */
	private String zipCode;
	
	/*
	 * 出借人地址
	 */
	private String custAddress;

	/**
	 * 客户姓名
	 */
	private String custName;
	
	
	/*
	 * 身份证号
	 */
	private String idCard;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 报告日
	 */
	private String reportDay;
	
	/*
	 * 借款人姓名
	 */
	private String lendName;
	
	/*
	 * 借款人身份证号码
	 */
	private String lendIdCard;
	
	
	
	/*
	 * 初始借款金额
	 */
	private String initTotalAmountView;
	/*
	 * 本次转让对价
	 */
	private String transferTotalAmountView;
	
	/*
	 * 需支付对价
	 */
	private String payGiveAmountView;
	
	/*
	 * 借款人职业情况
	 */
	private String lendJob;
	
	/*
	 * 借款人借款用途
	 */
	private String lendUsing;
	
	/*
	 * 还款起始日期
	 */
	private String returnDate;
	
	/*
	 * 还款期数
	 */
	private String period;
	
	/*
	 * 剩余还款月数
	 */
	private String leftPeriod;
	
	/*
	 * 预计债权收益率
	 */
	private String yieldRate;
	
	/*
	 * 账单日
	 */
	private Integer billDay;

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

	public String getLendName() {
		return lendName;
	}

	public void setLendName(String lendName) {
		this.lendName = lendName;
	}

	public String getLendIdCard() {
		return lendIdCard;
	}

	public void setLendIdCard(String lendIdCard) {
		this.lendIdCard = lendIdCard;
	}

	public String getTransferTotalAmountView() {
		return transferTotalAmountView;
	}

	public void setTransferTotalAmountView(String transferTotalAmountView) {
		this.transferTotalAmountView = transferTotalAmountView;
	}

	public String getPayGiveAmountView() {
		return payGiveAmountView;
	}

	public void setPayGiveAmountView(String payGiveAmountView) {
		this.payGiveAmountView = payGiveAmountView;
	}

	public String getLendJob() {
		return lendJob;
	}

	public void setLendJob(String lendJob) {
		this.lendJob = lendJob;
	}

	public String getLendUsing() {
		return lendUsing;
	}

	public void setLendUsing(String lendUsing) {
		this.lendUsing = lendUsing;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getLeftPeriod() {
		return leftPeriod;
	}

	public void setLeftPeriod(String leftPeriod) {
		this.leftPeriod = leftPeriod;
	}

	public String getYieldRate() {
		return yieldRate;
	}

	public void setYieldRate(String yieldRate) {
		this.yieldRate = yieldRate;
	}

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


	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public String getInitTotalAmountView() {
		return initTotalAmountView;
	}

	public void setInitTotalAmountView(String initTotalAmountView) {
		this.initTotalAmountView = initTotalAmountView;
	}

	public String getReportDay() {
		return reportDay;
	}

	public void setReportDay(String reportDay) {
		this.reportDay = reportDay;
	}
	
	
	
	

}
