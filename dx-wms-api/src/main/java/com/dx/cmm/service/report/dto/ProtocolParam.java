package com.dx.cmm.service.report.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProtocolParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6153249628226827387L;
	
	/*
	 * 报告日
	 */
	private Date reportDay;
	
	/*
	 * 账单日
	 */
	private Integer billDay;
	
	/*
	 * 产品编号
	 */
	private Long productId;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 身份证
	 */
	private String idCard;
	
	/*
	 * 转让日期-起
	 */
	private String transDayBegin;
	
	/*
	 * 转让日期-止
	 */
	private String transDayEnd;
	
	/*
	 * 客户编号
	 */
	private String lenderCustCode;
	
	  /**
     * 首次匹配日期-起
     */
    private Date initMatchDateBegin;

    /**
     * 首次匹配日期-止
     */
    private Date initMatchDateEnd;
	
	/*
	 * 出借编号集合
	 */
	private List<String> lenderCodes;
	
	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public Date getReportDay() {
		return reportDay;
	}

	public void setReportDay(Date reportDay) {
		this.reportDay = reportDay;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public String getLenderCustCode() {
		return lenderCustCode;
	}

	public void setLenderCustCode(String lenderCustCode) {
		this.lenderCustCode = lenderCustCode;
	}

	public List<String> getLenderCodes() {
		return lenderCodes;
	}

	public void setLenderCodes(List<String> lenderCodes) {
		this.lenderCodes = lenderCodes;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTransDayBegin() {
		return transDayBegin;
	}

	public void setTransDayBegin(String transDayBegin) {
		this.transDayBegin = transDayBegin;
	}

	public String getTransDayEnd() {
		return transDayEnd;
	}

	public void setTransDayEnd(String transDayEnd) {
		this.transDayEnd = transDayEnd;
	}

	public Date getInitMatchDateBegin() {
		return initMatchDateBegin;
	}

	public void setInitMatchDateBegin(Date initMatchDateBegin) {
		this.initMatchDateBegin = initMatchDateBegin;
	}

	public Date getInitMatchDateEnd() {
		return initMatchDateEnd;
	}

	public void setInitMatchDateEnd(Date initMatchDateEnd) {
		this.initMatchDateEnd = initMatchDateEnd;
	}
}
