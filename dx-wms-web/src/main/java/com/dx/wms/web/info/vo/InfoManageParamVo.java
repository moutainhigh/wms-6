package com.dx.wms.web.info.vo;

import java.io.Serializable;

public class InfoManageParamVo implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = -7831756327461346018L;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 客户姓名
	 */
	private String custName;
	
	/*
	 * 证件号码
	 */
	private String idCard;
	
	/*
	 * 出借方式
	 */
	private Integer productId;
	
	/*
	 * 状态
	 */
	private Integer currentStep;

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

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


	public Integer getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(Integer currentStep) {
		this.currentStep = currentStep;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	
}
