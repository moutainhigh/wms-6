package com.dx.cmm.service.trans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 推送财务数据
 * @author ZHUYIWEI
 *
 */
public class TransDataResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5270259468858294449L;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 出借方式
	 */
	private Long product;
	
	/*
	 * 初始出借金额
	 */
	private BigDecimal initTotalAmount;
	
	/*
	 * 初始出借日期
	 */
	private String initLendDate;
	
	/*
	 * 转让日期
	 */
	private String transDate;
	
	/*
	 * 债权价值
	 */
	private BigDecimal transCreditorAmount;
	
	/*
	 * 转让对价
	 */
	private BigDecimal transTotalAmount;
	
	/*
	 * 是否续投
	 */
	private Boolean isContinue; 
	
	/*
	 * 续投金额
	 */
	private BigDecimal ContinueInvestAmount;
	
	/*
	 * 付款金额
	 */
	private BigDecimal paymentAmount;
	
	/*
	 * 预计付款日期
	 */
	private String predictPaymentDate;
	
	/*
	 * 账单日
	 */
	private Integer billDay;

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
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

	public Boolean getIsContinue() {
		return isContinue;
	}

	public void setIsContinue(Boolean isContinue) {
		this.isContinue = isContinue;
	}

	public BigDecimal getContinueInvestAmount() {
		return ContinueInvestAmount;
	}

	public void setContinueInvestAmount(BigDecimal continueInvestAmount) {
		ContinueInvestAmount = continueInvestAmount;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public String getInitLendDate() {
		return initLendDate;
	}

	public void setInitLendDate(String initLendDate) {
		this.initLendDate = initLendDate;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getPredictPaymentDate() {
		return predictPaymentDate;
	}

	public void setPredictPaymentDate(String predictPaymentDate) {
		this.predictPaymentDate = predictPaymentDate;
	}
}
