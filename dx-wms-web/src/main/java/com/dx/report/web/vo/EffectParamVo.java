package com.dx.report.web.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EffectParamVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1406133300500071635L;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 身份证
	 */
	private String idCard;
	
	/*
	 * 预计出借日期起
	 */
	private Date initMatchDateBegin;
	
	/*
	 * 预计出借日期止
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	public List<String> getLenderCodes() {
		return lenderCodes;
	}

	public void setLenderCodes(List<String> lenderCodes) {
		this.lenderCodes = lenderCodes;
	}
}
