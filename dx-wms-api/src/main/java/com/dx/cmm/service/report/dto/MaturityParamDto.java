package com.dx.cmm.service.report.dto;

import java.io.Serializable;
import java.util.Date;

public class MaturityParamDto implements Serializable{
	
	/**
	 * UUID
	 */
	private static final long serialVersionUID = 1128507117049796273L;

	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 身份证号
	 */
	private Long idCard;
	
	/*
     * 转让日期-起
     */
    private Date transTimeBegin;
    
    /*
     * 转让日期-止
     */
    private Date transTimeEnd;
	
	/*
	 * 账单日
	 */
	private Integer billdayDay;
	
	/**
     * 出借方式
     */
    private Long productId;

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

	public Date getTransTimeBegin() {
		return transTimeBegin;
	}

	public void setTransTimeBegin(Date transTimeBegin) {
		this.transTimeBegin = transTimeBegin;
	}

	public Date getTransTimeEnd() {
		return transTimeEnd;
	}

	public void setTransTimeEnd(Date transTimeEnd) {
		this.transTimeEnd = transTimeEnd;
	}

	public Integer getBilldayDay() {
		return billdayDay;
	}

	public void setBilldayDay(Integer billdayDay) {
		this.billdayDay = billdayDay;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
    
    
    
}
