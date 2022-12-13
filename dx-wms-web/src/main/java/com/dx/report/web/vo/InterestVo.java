package com.dx.report.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.dx.ccs.service.IAMService;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.service.apply.LenderApplyDto;

public class InterestVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5790675085524634347L;
	
	private static final String ZERO = "0.00";
	
	private static final String DEFAULTLEVEL = "财富账户";
	
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
	 * 回收利息
	 */
	private BigDecimal incomeAmount;
	
	/*
	 * 回收利息预览
	 */
	private String icomeView;
	
	/*
	 * 账户名
	 */
	private String accountName;
	
	/*
	 * 银行信息
	 */
	private String bankInfo;
	
	/*
	 *银行帐号
	 */
	private String bankNum;
	
	/*
	 * 营业部
	 */
	private String orgView;
	
	/*
	 * 统计时间
	 */
	private Date date;
	
	/*
	 * 统计时间视图
	 */
	private String dataView;

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

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
	
	public InterestVo setAccountLevel(){
		setAccountLevel(Assert.checkParam(getAccountLevel()) ? getAccountLevel() : DEFAULTLEVEL);
		return this;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	
	public InterestVo setIcomeView(){
		setIcomeView(AmountUtils.format(getIncomeAmount(),ZERO));
		return this;
	}
	
	public String getIcomeView() {
		return icomeView;
	}

	public void setIcomeView(String icomeView) {
		this.icomeView = icomeView;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public InterestVo setAccountName(LenderApplyDto apply){
		setAccountName(Assert.checkParam(apply.getBackAccountName()) ? apply.getBackAccountName() : "-");
		return this;
	}

	public String getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}
	
	public InterestVo setBankInfo(LenderApplyDto apply){
		setBankInfo(Assert.checkParam(BankCategery.getInfo(apply.getBackBank()),apply.getBackSubBank()) ? BankCategery.getInfo(apply.getBackBank()).concat(apply.getBackSubBank()) : "-");
		return this;
	}
	
	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	
	public InterestVo setBankNum(LenderApplyDto apply){
		setBankNum(Assert.checkParam(apply.getBackAccountNum()) ? apply.getBackAccountNum() : "-");
		return this;
	}
	
	public String getOrgView() {
		return orgView;
	}

	public void setOrgView(String orgView) {
		this.orgView = orgView;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDataView() {
		return dataView;
	}

	public void setDataView(String dataView) {
		this.dataView = dataView;
	}
	
	public InterestVo setDataView(){
		setDataView(DateUtils.format(getDate(), "yyyy-MM"));
		return this;
	}
	
	public void set(LenderApplyDto apply,IAMService amService){
		setIcomeView().setDataView().setAccountLevel().setAccountName(apply).setBankInfo(apply).setBankNum(apply).setOrgView(amService.queryOrgById(apply.getOrgId()).getName());
	}
}
