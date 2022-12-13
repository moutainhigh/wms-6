package com.dx.report.web.vo;

import org.springframework.beans.BeanUtils;


public class PastExcelVo {
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
	 * 出借金额View
	 */
	private String lenderAmountView;
	
	/*
	 * 回款匹配金额View
	 */
	private String backMatchAmoutView;
	
	/*
	 * 出借方式
	 */
	private String productName;
	
	/*
	 * 报告日
	 */
	private Integer reportDay;
	
	/*
	 * 投资生效日View
	 */
	private String investDayView;

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

	public String getLenderAmountView() {
		return lenderAmountView;
	}

	public void setLenderAmountView(String lenderAmountView) {
		this.lenderAmountView = lenderAmountView;
	}

	public String getBackMatchAmoutView() {
		return backMatchAmoutView;
	}

	public void setBackMatchAmoutView(String backMatchAmoutView) {
		this.backMatchAmoutView = backMatchAmoutView;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getReportDay() {
		return reportDay;
	}

	public void setReportDay(Integer reportDay) {
		this.reportDay = reportDay;
	}

	public String getInvestDayView() {
		return investDayView;
	}

	public void setInvestDayView(String investDayView) {
		this.investDayView = investDayView;
	}
	
	public PastExcelVo(PastResultVo dto){
		BeanUtils.copyProperties(dto, this);
	}
	
}
