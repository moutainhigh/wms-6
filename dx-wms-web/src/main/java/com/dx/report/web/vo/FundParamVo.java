package com.dx.report.web.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FundParamVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6115915111936643245L;
	
	/*
	 * 客户编号
	 */
	private String lenderCustCode;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 账单日
	 */
	private Integer billDay;
	
	/*
	 * 统计时间
	 */
	private String countTime;
	
	/*
	 * 报告日
	 */
	private Date reportDay;
	
	/*
	 * 出借编号集合
	 */
	private List<String> lenderCodes;

	public String getLenderCustCode() {
		return lenderCustCode;
	}

	public void setLenderCustCode(String lenderCustCode) {
		this.lenderCustCode = lenderCustCode;
	}

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public String getCountTime() {
		return countTime;
	}

	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}

	public List<String> getLenderCodes() {
		return lenderCodes;
	}

	public void setLenderCodes(List<String> lenderCodes) {
		this.lenderCodes = lenderCodes;
	}

	public Date getReportDay() {
		return reportDay;
	}

	public void setReportDay(Date reportDay) {
		this.reportDay = reportDay;
	}
}
