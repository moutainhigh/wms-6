package com.dx.cmm.service.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dx.cmm.dto.BizBase;
import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.LenderApplyDto;

public class TransViewResult extends BizBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4465842921889115118L;
	
	/*
	 * 资金池ID
	 */
	private Long poolId;
	
	/**
	 * 产品编号
	 */
	private Long productId;
	
	/**
	 * 初始投资金额
	 */
	private BigDecimal initTotalAmount;
	
	/*
	 * 初始投资金额预览
	 */
	private String initTotalAmountView;
	
	/*
	 * 初始出借时间
	 */
	private Date interestBeginTime;
	
	/*
	 * 初始出借时间预览
	 */
	private Date interestBeginTimeView;
	
	/*
	 * 转让时间
	 */
	private Date transDay;
	
	/*
	 * 转让时间预览
	 */
	private String transDayView;
	
	/*
	 * 账单日
	 */
	private Integer billDay;
	
	/*
	 * 当前周期
	 */
	private Integer currentPeriod;
	
	/*
	 * 账户管理费
	 */
	private BigDecimal accountManagementFee;
	
	
	/*
	 * 账户管理费预览
	 */
	private String accountManagementFeeView;
	
	/*
	 * 转让债权价值
	 */
	private BigDecimal transCreditorAmount;
	
	/*
	 * 转让债权价值预览
	 */
	private String transCreditorAmountView;
	
	/*
	 * 转让债权总价值
	 */
	private BigDecimal transTotalAmount;
	
	/*
	 * 转让债权总价预览
	 */
	private String transTotalAmountView;
	
	/*
	 * 当前交易总价值
	 */
	private BigDecimal currentTotalAmount;
	
	/*
	 * 当前交易总价值
	 */
	private String currentTotalAmountView;
	
	private String accountName;
	
	private String bank;
	
	private String num;
	
	/*
	 * 债权列表
	 */
	private List<CreditViewResult> creditors;

	public Long getPoolId() {
		return poolId;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Date getInterestBeginTime() {
		return interestBeginTime;
	}

	public void setInterestBeginTime(Date interestBeginTime) {
		this.interestBeginTime = interestBeginTime;
	}

	public Date getInterestBeginTimeView() {
		return interestBeginTimeView;
	}

	public void setInterestBeginTimeView(Date interestBeginTimeView) {
		this.interestBeginTimeView = interestBeginTimeView;
	}

	public Date getTransDay() {
		return transDay;
	}

	public void setTransDay(Date transDay) {
		this.transDay = transDay;
	}

	public String getTransDayView() {
		return transDayView;
	}

	public void setTransDayView(String transDayView) {
		this.transDayView = transDayView;
	}

	public BigDecimal getTransCreditorAmount() {
		return transCreditorAmount;
	}

	public void setTransCreditorAmount(BigDecimal transCreditorAmount) {
		this.transCreditorAmount = transCreditorAmount;
	}

	public String getTransCreditorAmountView() {
		return transCreditorAmountView;
	}

	public void setTransCreditorAmountView(String transCreditorAmountView) {
		this.transCreditorAmountView = transCreditorAmountView;
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

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public BigDecimal getAccountManagementFee() {
		return accountManagementFee;
	}

	public void setAccountManagementFee(BigDecimal accountManagementFee) {
		this.accountManagementFee = accountManagementFee;
	}

	public String getAccountManagementFeeView() {
		return accountManagementFeeView;
	}

	public void setAccountManagementFeeView(String accountManagementFeeView) {
		this.accountManagementFeeView = accountManagementFeeView;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public BigDecimal getCurrentTotalAmount() {
		return currentTotalAmount;
	}

	public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
		this.currentTotalAmount = currentTotalAmount;
	}

	public String getCurrentTotalAmountView() {
		return currentTotalAmountView;
	}

	public void setCurrentTotalAmountView(String currentTotalAmountView) {
		this.currentTotalAmountView = currentTotalAmountView;
	}
	
	public List<CreditViewResult> getCreditors() {
		return creditors;
	}

	public void setCreditors(List<CreditViewResult> creditors) {
		this.creditors = creditors;
	}

	public Integer getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public void set(LenderApplyDto apply){
		setAccountName(Assert.checkParam(apply.getBackAccountName()) ? apply.getBackAccountName() : "-");
		setBank(Assert.checkParam(apply.getBackAccountName(),apply.getBackSubBank()) ? apply.getBackAccountName().concat(apply.getBackSubBank()) : "-");
		setNum(Assert.checkParam(apply.getBackAccountNum()) ? apply.getBackAccountNum() : "-");
	}
}
