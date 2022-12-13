package com.dx.report.web.controller;

import java.math.BigDecimal;

public class ManageFeeExcelResult {

    /**
     * 出借编号
     */
    private String lenderCode;
	
    /**
     * 客户姓名
     */
    private String custName; 
    
    /**
     * 身份证号
     */
    private String idCard;
    
    /**
     * 账户级别名
     */
    private String accountLevelName;
	
    /**
     * 理财产品名
     */
    private String productName;
    
    /**
     * 账单日
     */
    private String billDay;
    
    /**
     * 服务费
     */
    private BigDecimal accountManagementFee = BigDecimal.ZERO;
    
    /**
     * 开户银行(分行)
     */
    private String bankName;
    
    /**
    * 账户名
    */
    private String accountName;
    
    /**
    * 账号
    */
    private String accountNum;
   
    
    /**
    * 营业部名
    */
    private String orgName;
    
    /**
     * 统计日期
     */
    private String statisticDate;

	/**
	 * @return the lenderCode
	 */
	public String getLenderCode() {
		return lenderCode;
	}

	/**
	 * @param lenderCode the lenderCode to set
	 */
	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the accountLevelName
	 */
	public String getAccountLevelName() {
		return accountLevelName;
	}

	/**
	 * @param accountLevelName the accountLevelName to set
	 */
	public void setAccountLevelName(String accountLevelName) {
		this.accountLevelName = accountLevelName;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the billDay
	 */
	public String getBillDay() {
		return billDay;
	}

	/**
	 * @param billDay the billDay to set
	 */
	public void setBillDay(String billDay) {
		this.billDay = billDay;
	}

	/**
	 * @return the accountManagementFee
	 */
	public BigDecimal getAccountManagementFee() {
		return accountManagementFee;
	}

	/**
	 * @param accountManagementFee the accountManagementFee to set
	 */
	public void setAccountManagementFee(BigDecimal accountManagementFee) {
		this.accountManagementFee = accountManagementFee;
	}

	
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}

	/**
	 * @param accountNum the accountNum to set
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	/**
	 * @return the statisticDate
	 */
	public String getStatisticDate() {
		return statisticDate;
	}

	/**
	 * @param statisticDate the statisticDate to set
	 */
	public void setStatisticDate(String statisticDate) {
		this.statisticDate = statisticDate;
	}


}
