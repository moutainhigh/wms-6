package com.dx.cmm.service.report.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PastParamDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2457770259737369044L;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 身份证号
	 */
	private Long idCard;
	
	/*
	 * 账单日
	 */
	private String createTime;
	
	/*
	 * 报告日
	 */
	private String reportDate;
	
	/*
	 * 出借编号集合
	 */
	private List<String> lenderCodes;
	
	/*
     * 导出是否需要查询lendercodes
     */
    private String isQuery;

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public List<String> getLenderCodes() {
		return lenderCodes;
	}

	public void setLenderCodes(List<String> lenderCodes) {
		this.lenderCodes = lenderCodes;
	}

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	
	

}
