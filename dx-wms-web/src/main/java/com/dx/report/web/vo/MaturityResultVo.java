package com.dx.report.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.report.dto.MaturityResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;

public class MaturityResultVo implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 229790968477159040L;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	/*
	 * 客户姓名
	 */
	private String custName;
	/*
	 * 身份证号
	 */
	private String idCard;
	/*
	 * 邮编
	 */
	private String zipCode;
	/*
	 * 地址
	 */
	private String custAddress;
	/*
	 * 资金出借及回收方式
	 */
	private String productName;
	/*
	 * 初始出借金额
	 */
	private BigDecimal initTotalAmount;
	/*
	 * 初始出借金额view
	 */
	private String initTotalAmountView;
	/*
	 * 初始出借日期
	 */
	private Date interestBeginTime;
	/*
	 * 初始出借日期view
	 */
	private String interestBeginTimeView;
	/*
	 * 转让日债权价值
	 */
	private BigDecimal transAmount;
	/*
	 * 转让日债权价值view
	 */
	private String transAmountView;
	/*
	 * 转让对价
	 */
	private BigDecimal transTotalAmount;
	/*
	 * 转让对价view
	 */
	private String transTotalAmountView;
	/*
	 * 转让服务费
	 */
	private BigDecimal serviceCharge;
	/*
	 * 转让服务费view
	 */
	private String serviceChargeView;
	/*
	 * 账户管理费
	 */
	private BigDecimal accountFee;
	/*
	 * 账户管理费view
	 */
	private String accountFeeView;
	/*
	 * 账户名
	 */
	private String bankAccountName;
	/*
	 * 开户银行
	 */
	private String bankAccount;
	/*
	 * 账号
	 */
	private String bankAccountNum;
	/*
	 * 账单日
	 */
	private int billDay;
	/*
	 * 转让日期
	 */
	private Date transTime;
	/*
	 * 转让日期view
	 */
	private String transTimeView;
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getInitTotalAmount() {
		return initTotalAmount;
	}
	public void setInitTotalAmount(BigDecimal initTotalAmount) {
		this.initTotalAmount = initTotalAmount;
	}
	public String getInitTotalAmountView() {
		return initTotalAmountView;
	}
	public void setInitTotalAmountView(String initTotalAmountView) {
		this.initTotalAmountView = initTotalAmountView;
	}
	public MaturityResultVo setInitTotalAmountView() {
		this.initTotalAmountView=AmountUtils.format(getInitTotalAmount(), "0.00");
		return this; 
	}
	public Date getInterestBeginTime() {
		return interestBeginTime;
	}
	public void setInterestBeginTime(Date interestBeginTime) {
		this.interestBeginTime = interestBeginTime;
	}
	public String getInterestBeginTimeView() {
		return interestBeginTimeView;
	}
	public void setInterestBeginTimeView(String interestBeginTimeView) {
		this.interestBeginTimeView = interestBeginTimeView;
	}
	public void setInterestBeginTimeView() {
		setInterestBeginTimeView(DateUtils.formatForDay(getInterestBeginTime()));
    }
	public BigDecimal getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(BigDecimal transAmount) {
		this.transAmount = transAmount;
	}
	public String getTransAmountView() {
		return transAmountView;
	}
	public void setTransAmountView(String transAmountView) {
		this.transAmountView = transAmountView;
	}
	public MaturityResultVo setTransAmountView() {
		this.transAmountView=AmountUtils.format(getTransAmount(), "0.00");
		return this; 
    }
	public BigDecimal getTransTotalAmount() {
		return transTotalAmount;
	}
	public void setTransTotalAmount(BigDecimal transTotalAmount) {
		this.transTotalAmount = transTotalAmount;
	}
	public String getTransTotalAmountView() {
		return transTotalAmountView;
	}
	public void setTransTotalAmountView(String transTotalAmountView) {
		this.transTotalAmountView = transTotalAmountView;
	}
	public MaturityResultVo setTransTotalAmountView() {
		this.transTotalAmountView=AmountUtils.format(getTransTotalAmount(), "0.00");
		return this; 
    }
	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public String getServiceChargeView() {
		return serviceChargeView;
	}
	public void setServiceChargeView(String serviceChargeView) {
		this.serviceChargeView = serviceChargeView;
	}
	public MaturityResultVo setServiceChargeView() {
		this.serviceChargeView=AmountUtils.format(getServiceCharge(), "0.00");
		return this; 
    }
	public BigDecimal getAccountFee() {
		return accountFee;
	}
	public void setAccountFee(BigDecimal accountFee) {
		this.accountFee = accountFee;
	}
	public String getAccountFeeView() {
		return accountFeeView;
	}
	public void setAccountFeeView(String accountFeeView) {
		this.accountFeeView = accountFeeView;
	}
	public MaturityResultVo setAccountFeeView() {
		this.accountFeeView=AmountUtils.format(getAccountFee(), "0.00");
		return this; 
    }
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}
	public int getBillDay() {
		return billDay;
	}
	public void setBillDay(int billDay) {
		this.billDay = billDay;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public String getTransTimeView() {
		return transTimeView;
	}
	public void setTransTimeView(String transTimeView) {
		this.transTimeView = transTimeView;
	}
	
	public void setTransTimeView() {
		setTransTimeView(DateUtils.formatForDay(getTransTime()));
    }
	
	public MaturityResultVo(MaturityResult result){
		BeanUtils.copyProperties(result, this);
		setInitTotalAmountView();
		setInterestBeginTimeView();
		setTransAmountView();
		setTransTotalAmountView();
		setServiceChargeView();
		setAccountFeeView();
		setTransTimeView();
	}
	

}
