package com.dx.cmm.web.controller.back;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

public class ExportUsualExcelResult {

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
     * 出借方式视图
     */
    private String productName;
    /**
     * 本报告日出借人实际回收利息
     */
    private BigDecimal lenderIncomeAmount;
    /**
     * 账单日
     */
    private Integer billDay;
    /**
     * 账户级别视图
     */
    private String levelView;
    /**
     * 回款银行视图
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
    /**
     * 营业部视图
     */
    private String orgView;
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
	public BigDecimal getLenderIncomeAmount() {
		return lenderIncomeAmount;
	}
	public void setLenderIncomeAmount(BigDecimal lenderIncomeAmount) {
		this.lenderIncomeAmount = lenderIncomeAmount;
	}
	public Integer getBillDay() {
		return billDay;
	}
	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}
	public String getLevelView() {
		return levelView;
	}
	public void setLevelView(String levelView) {
		this.levelView = levelView;
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
	public String getOrgView() {
		return orgView;
	}
	public void setOrgView(String orgView) {
		this.orgView = orgView;
	}
    
    public ExportUsualExcelResult(){
    	
    }
    public ExportUsualExcelResult(UsualResult ur){
    	BeanUtils.copyProperties(ur,this);
    }
}
