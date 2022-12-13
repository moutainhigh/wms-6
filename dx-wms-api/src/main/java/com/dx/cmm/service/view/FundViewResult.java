package com.dx.cmm.service.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;

public class FundViewResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -478506330500826759L;

	private static final String ZERO = "0.00";
	
	private static final String FUND = "客户资金出借情况报告-";
	
	private static final String BLANK = " ";

	/**
	 * 资金池编号
	 */
	private Long poolId;

	/*
	 * 报告日
	 */
	private Date reportDate;

	private String reportDateView;

	/**
	 * 初始投资金额
	 */
	private BigDecimal initTotalAmount;

	private String initTotalAmountView;
	/**
	 * 产品编号
	 */
	private Long productId;

	/**
	 * 出借编号
	 */
	private String lenderCode;

	/**
	 * 当前期数
	 */
	private Integer currentPeriod;

	/**
	 * 客户编号
	 */
	private String lenderCustCode;

	/**
	 * 客户姓名
	 */
	private String custName;

	/**
	 * 业务id
	 */
	private Long bizId;

	/**
	 * 客户地址
	 */
	private String custAddress;

	/**
	 * 邮编
	 */
	private String zipCode;

	private String zipCodeView;

	/**
	 * 账单日
	 */
	private Integer billDay;

	/*
	 * 报告周期起
	 */
	private Date reportPeriodBegin;

	private String reportPeriodBeginView;

	/*
	 * 账户级别
	 */
	private String accountLevel;

	/*
	 * 出借方式
	 */
	private String productView;

	/*
	 * 初始出借日期
	 */
	private Date initLoanDay;

	private String initLoanDayView;

	/*
	 * 上个报告日资产总价值
	 */
	private BigDecimal lastTotalAmount;

	private String lastTotalAmountView;

	/*
	 * 本报告日资产总价值
	 */
	private BigDecimal totalAmount;

	private String totalAmountView;

	/*
	 * 本报告日出借人应回收金额
	 */
	private BigDecimal recycleAmount;

	private String recycleAmountView;

	/*
	 * 本报告日预计出借金额
	 */
	private BigDecimal loanAmount;

	private String loanAmountView;

	/*
	 * 本报告日实际回收利息
	 */
	private BigDecimal income;

	private String incomeView;

	/*
	 * 账户管理费率
	 */
	private BigDecimal accountManageRate;

	private String accountManageRateView;

	/*
	 * 账户管理费
	 */
	private BigDecimal accountManageAmount;

	private String accountManageAmountView;

	/**
	 * 下个报告日-债权转让总价值
	 */
	private BigDecimal nextTransferTotalAmount;

	/**
	 * 下个报告日-还款总价值
	 */
	private BigDecimal nextRepaymentTotalAmount;

	/**
	 * 下个报告日-利息总价值
	 */
	private BigDecimal nextInterestTotalAmount;

	/**
	 * 下个报告日-本金总价值
	 */
	private BigDecimal nextPrincalTotalAmount;
	
	private String fileName;

	public Long getPoolId() {
		return poolId;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public BigDecimal getInitTotalAmount() {
		return initTotalAmount;
	}

	public void setInitTotalAmount(BigDecimal initTotalAmount) {
		this.initTotalAmount = initTotalAmount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

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

	public Long getBizId() {
		return bizId;
	}

	public void setBizId(Long bizId) {
		this.bizId = bizId;
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

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public Date getReportPeriodBegin() {
		return reportPeriodBegin;
	}

	public void setReportPeriodBegin(Date reportPeriodBegin) {
		this.reportPeriodBegin = reportPeriodBegin;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}

	public String getProductView() {
		return productView;
	}

	public void setProductView(String productView) {
		this.productView = productView;
	}

	public FundViewResult setProductView(Map<Long, String> product) {
		setProductView(product.get(getProductId()));
		return this;
	}

	public Date getInitLoanDay() {
		return initLoanDay;
	}

	public void setInitLoanDay(Date initLoanDay) {
		this.initLoanDay = initLoanDay;
	}

	public BigDecimal getLastTotalAmount() {
		return lastTotalAmount;
	}

	public void setLastTotalAmount(BigDecimal lastTotalAmount) {
		this.lastTotalAmount = lastTotalAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getRecycleAmount() {
		return recycleAmount;
	}

	public void setRecycleAmount(BigDecimal recycleAmount) {
		this.recycleAmount = recycleAmount;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getAccountManageRate() {
		return accountManageRate;
	}

	public void setAccountManageRate(BigDecimal accountManageRate) {
		this.accountManageRate = accountManageRate;
	}

	public BigDecimal getAccountManageAmount() {
		return accountManageAmount;
	}

	public void setAccountManageAmount(BigDecimal accountManageAmount) {
		this.accountManageAmount = accountManageAmount;
	}

	public BigDecimal getNextTransferTotalAmount() {
		return nextTransferTotalAmount;
	}

	public void setNextTransferTotalAmount(BigDecimal nextTransferTotalAmount) {
		this.nextTransferTotalAmount = nextTransferTotalAmount;
	}

	public BigDecimal getNextRepaymentTotalAmount() {
		return nextRepaymentTotalAmount;
	}

	public void setNextRepaymentTotalAmount(BigDecimal nextRepaymentTotalAmount) {
		this.nextRepaymentTotalAmount = nextRepaymentTotalAmount;
	}

	public BigDecimal getNextInterestTotalAmount() {
		return nextInterestTotalAmount;
	}

	public void setNextInterestTotalAmount(BigDecimal nextInterestTotalAmount) {
		this.nextInterestTotalAmount = nextInterestTotalAmount;
	}

	public BigDecimal getNextPrincalTotalAmount() {
		return nextPrincalTotalAmount;
	}

	public void setNextPrincalTotalAmount(BigDecimal nextPrincalTotalAmount) {
		this.nextPrincalTotalAmount = nextPrincalTotalAmount;
	}

	public Integer getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public String getInitTotalAmountView() {
		return initTotalAmountView;
	}

	public void setInitTotalAmountView(String initTotalAmountView) {
		this.initTotalAmountView = initTotalAmountView;
	}

	public FundViewResult setInitTotalAmountView() {
		setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
		return this;
	}

	public String getZipCodeView() {
		return zipCodeView;
	}

	public void setZipCodeView(String zipCodeView) {
		this.zipCodeView = zipCodeView;
	}

	public FundViewResult setZipCodeView() {
		String zipCode = "";
		for (Character zipCodeChar : getZipCode().toCharArray()) {
			zipCode += (zipCodeChar + " ");
		}
		setZipCodeView(zipCode.trim());
		return this;
	}

	public String getInitLoanDayView() {
		return initLoanDayView;
	}

	public void setInitLoanDayView(String initLoanDayView) {
		this.initLoanDayView = initLoanDayView;
	}

	public FundViewResult setInitLoanDayView() {
		setInitLoanDayView(DateUtils.format(getInitLoanDay(),"yyyy/MM/dd"));
		return this;
	}

	public String getLastTotalAmountView() {
		return lastTotalAmountView;
	}

	public void setLastTotalAmountView(String lastTotalAmountView) {
		this.lastTotalAmountView = lastTotalAmountView;
	}

	public FundViewResult setLastTotalAmountView() {
		setLastTotalAmountView(AmountUtils.format(getLastTotalAmount(), ZERO));
		return this;
	}

	public String getTotalAmountView() {
		return totalAmountView;
	}

	public void setTotalAmountView(String totalAmountView) {
		this.totalAmountView = totalAmountView;
	}

	public FundViewResult setTotalAmountView() {
		setTotalAmountView(AmountUtils.format(getTotalAmount(), ZERO));
		return this;
	}

	public String getRecycleAmountView() {
		return recycleAmountView;
	}

	public void setRecycleAmountView(String recycleAmountView) {
		this.recycleAmountView = recycleAmountView;
	}

	public FundViewResult setRecycleAmountView() {
		setRecycleAmountView(AmountUtils.format(getRecycleAmount(), ZERO));
		return this;
	}

	public String getLoanAmountView() {
		return loanAmountView;
	}

	public void setLoanAmountView(String loanAmountView) {
		this.loanAmountView = loanAmountView;
	}

	public FundViewResult setLoanAmountView() {
		setLoanAmountView(AmountUtils.format(getLoanAmount(), ZERO));
		return this;
	}

	public String getIncomeView() {
		return incomeView;
	}

	public void setIncomeView(String incomeView) {
		this.incomeView = incomeView;
	}

	public FundViewResult setIncomeView() {
		setIncomeView(AmountUtils.format(getIncome(), ZERO));
		return this;
	}

	public String getAccountManageRateView() {
		return accountManageRateView;
	}

	public void setAccountManageRateView(String accountManageRateView) {
		this.accountManageRateView = accountManageRateView;
	}

	public FundViewResult setAccountManageRateView() {
		setAccountManageRateView((getAccountManageRate() != null ? (getAccountManageRate().multiply(new BigDecimal(100)).setScale(3,BigDecimal.ROUND_HALF_UP).toString()) : ZERO) +"%" );
		return this;
	}

	public String getAccountManageAmountView() {
		return accountManageAmountView;
	}

	public void setAccountManageAmountView(String accountManageAmountView) {
		this.accountManageAmountView = accountManageAmountView;
	}

	public FundViewResult setAccountManageAmountView() {
		setAccountManageAmountView(AmountUtils.format(getAccountManageAmount(), ZERO));
		return this;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportDateView() {
		return reportDateView;
	}

	public void setReportDateView(String reportDateView) {
		this.reportDateView = reportDateView;
	}

	public FundViewResult setReportDateView() {
		setReportDateView(DateUtils.format(getReportDate(),"yyyy/MM/dd"));
		return this;
	}

	public String getReportPeriodBeginView() {
		return reportPeriodBeginView;
	}

	public void setReportPeriodBeginView(String reportPeriodBeginView) {
		this.reportPeriodBeginView = reportPeriodBeginView;
	}

	public FundViewResult setReportPeriodBeginView() {
		setReportPeriodBeginView(DateUtils.format(getReportPeriodBegin(),"yyyy/MM/dd"));
		return this;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public FundViewResult setFileName(){
		StringBuffer fileNameBuffer = new StringBuffer();
		setFileName(fileNameBuffer.append(FUND).append(DateUtils.format(getReportDate(), "yyyyMMdd")).append("期").append(BLANK).append(getCustName()).append(BLANK).append(getLenderCode()).toString());
		return this;
	}

	public void set(Map<Long, String> product) {
		setReportDateView().setInitTotalAmountView().setZipCodeView().setInitLoanDayView().setLastTotalAmountView()
				.setTotalAmountView().setRecycleAmountView().setLoanAmountView().setIncomeView()
				.setAccountManageAmountView().setAccountManageRateView().setReportPeriodBeginView()
				.setProductView(product).setFileName();
	}
}
