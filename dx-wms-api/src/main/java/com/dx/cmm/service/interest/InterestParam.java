package com.dx.cmm.service.interest;

import java.io.Serializable;
import java.util.Date;

public class InterestParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5420723380158474692L;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 报告日
	 */
	private Date reportDayTimeBegin;
	
	/*
	 * 产品编号
	 */
	private Long productId;
	
	

	public InterestParam() {
		super();
	}

	public InterestParam(String lenderCode, Date reportDay, Long productId) {
		super();
		this.lenderCode = lenderCode;
		this.reportDayTimeBegin = reportDay;
		this.productId = productId;
	}

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public Date getReportDayTimeBegin() {
		return reportDayTimeBegin;
	}

	public void setReportDayTimeBegin(Date reportDayTimeBegin) {
		this.reportDayTimeBegin = reportDayTimeBegin;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
