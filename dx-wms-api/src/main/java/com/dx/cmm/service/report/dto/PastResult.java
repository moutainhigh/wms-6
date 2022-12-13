package com.dx.cmm.service.report.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PastResult implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 6014100751175649023L;
	
	/*
	 * 客户姓名
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
	 * 出借金额
	 */
	private BigDecimal lenderAmount;
	
	/*
	 * 回款匹配金额
	 */
	private BigDecimal backMatchAmount;
	
	/*
	 * 出借方式
	 */
	private Long productId;
	
	/*
	 * 报告日
	 */
	private int reportDay;
	
	/*
	 * 投资生效日
	 */
	private Date investDay;
	
	/*
	 * 资金池id
	 */
	private Long poolId;
	
	/*
	 * 当前期数currentPeriod
	 */
	private Integer currentPeriod;

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

	public BigDecimal getLenderAmount() {
		return lenderAmount;
	}

	public void setLenderAmount(BigDecimal lenderAmount) {
		this.lenderAmount = lenderAmount;
	}

	public BigDecimal getBackMatchAmount() {
		return backMatchAmount;
	}

	public void setBackMatchAmount(BigDecimal backMatchAmount) {
		this.backMatchAmount = backMatchAmount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getReportDay() {
		return reportDay;
	}

	public void setReportDay(int reportDay) {
		this.reportDay = reportDay;
	}

	public Date getInvestDay() {
		return investDay;
	}

	public void setInvestDay(Date investDay) {
		this.investDay = investDay;
	}

	public Long getPoolId() {
		return poolId;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public Integer getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	
	
}
