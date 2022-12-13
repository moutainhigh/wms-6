package com.dx.report.web.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PastParamVo implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = -6824770857999911915L;
	
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
	private Integer reportDay;
	
	
	/*
	 * 报告日
	 */
	private String matchDate;
	
	/*
	 *  非首期协议补报告日
	 */
	private Date matchDatePlus;
	
	
	
	/*
	 * 出借编号集合
	 */
	private List<String> lenderCodes;
	
	/*
	 * 导出查询使用的创建日期
	 */
	private String createTimePre;
    
	/*
	 * 导出查询使用的报告日
	 */
    private String reportDayPre;
    
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

	public Integer getReportDay() {
		return reportDay;
	}

	public void setReportDay(Integer reportDay) {
		this.reportDay = reportDay;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public List<String> getLenderCodes() {
		return lenderCodes;
	}

	public void setLenderCodes(List<String> lenderCodes) {
		this.lenderCodes = lenderCodes;
	}

	public String getCreateTimePre() {
		return createTimePre;
	}

	public void setCreateTimePre(String createTimePre) {
		this.createTimePre = createTimePre;
	}

	public String getReportDayPre() {
		return reportDayPre;
	}

	public void setReportDayPre(String reportDayPre) {
		this.reportDayPre = reportDayPre;
	}

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public Date getMatchDatePlus() {
		return matchDatePlus;
	}

	public void setMatchDatePlus(Date matchDatePlus) {
		this.matchDatePlus = matchDatePlus;
	}
	
	

}
