package com.dx.cmm.service.report.manageFee;

import java.io.Serializable;
import java.util.Date;

public class ManageFeeParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8584607891319975424L;
	
	/**
	 * 出借编号
	 */
	private String lenderCode;
	
	/**
	 * 账单日
	 */
	private String billDay;
	
	/**
	 * 统计日期（年/月）
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
