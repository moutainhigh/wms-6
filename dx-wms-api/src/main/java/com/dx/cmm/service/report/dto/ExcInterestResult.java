package com.dx.cmm.service.report.dto;

import java.io.Serializable;

/**
 * 月回收利息导出EXCEL数据
 * @author ZHUYIWEI
 *
 */
public class ExcInterestResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1105818077103877848L;

	/*
	 * 出借编号
	 */
	private String lenderCode;

	/*
	 * 客户姓名
	 */
	private String custName;
	
	/*
	 * 身份证
	 */
	private String idCard;
	
	/*
	 * 账户级别
	 */
	private String accountLevel;
	
	/*
	 * 出借方式
	 */
	private String productName;
	
	/*
	 * 账单日
	 */
	private Integer billDay;
	
	/*
	 * 回收利息预览
	 */
	private String icomeView;
	
	/*
	 * 银行信息
	 */
	private String bankInfo;
	
	/*
	 *银行帐号
	 */
	private String bankNum;
	
	/*
	 * 账户名
	 */
	private String accountName;
	
	/*
	 * 营业部
	 */
	private String orgView;
	
	/*
	 * 统计时间视图
	 */
	private String dataView;

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

	public String getIcomeView() {
		return icomeView;
	}

	public void setIcomeView(String icomeView) {
		this.icomeView = icomeView;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
    
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getOrgView() {
		return orgView;
	}

	public void setOrgView(String orgView) {
		this.orgView = orgView;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public String getDataView() {
		return dataView;
	}

	public void setDataView(String dataView) {
		this.dataView = dataView;
	}
}
