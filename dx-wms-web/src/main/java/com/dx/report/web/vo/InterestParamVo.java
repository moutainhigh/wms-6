package com.dx.report.web.vo;

import java.io.Serializable;
import java.util.Date;

public class InterestParamVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7098028451456466561L;
	
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
	private Date reportDayTimeBegin;

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

	public Date getReportDayTimeBegin() {
		return reportDayTimeBegin;
	}

	public void setReportDayTimeBegin(Date reportDayTimeBegin) {
		this.reportDayTimeBegin = reportDayTimeBegin;
	}
}
