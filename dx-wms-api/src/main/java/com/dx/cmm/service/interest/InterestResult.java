package com.dx.cmm.service.interest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InterestResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6700851993523004947L;
	
	/*
	 * 姓名
	 */
	private String custName;
	
	/*
	 * 身份证
	 */
	private String idCard;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 出借方式
	 */
	private String productName;
	
	/*
	 * 回收利息
	 */
	private BigDecimal incomeAmount;
	
	/*
	 * 账户级别
	 */
	private String accountLevel;
	
	/*
	 * 账单日
	 */
	private Integer billDay;
	
	/*
	 * 统计时间
	 */
	private Date date;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
