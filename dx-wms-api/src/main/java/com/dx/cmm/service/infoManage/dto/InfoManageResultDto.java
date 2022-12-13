package com.dx.cmm.service.infoManage.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InfoManageResultDto implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = -7051522762897032623L;
	
	/**
     * 出借编号
     */
    private String lenderCode;
    
    /*
     * 申请单ID
     */
    private Long lenderApplyId;
    
    /**
     * 客户姓名
     */
    protected String custName;
    
    /**
     * 证件号码
     */
    protected String idCard;
	
    /**
     * 出借方式-编号
     */
    private Long productId;
    
    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;
    
    /**
     * 签单日期
     */
    private Date signDate;
    
    /**
     * 理财申请单状态
     */
    private Long formStatus;
    
    /**
     * 到账日
     */
    private Date settleDate;
    
    /**
     * 账单日
     */
    private Integer statementDate;
    
    /**
     * 到期日
     */
    private Date dueDate;

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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getLenderAmount() {
		return lenderAmount;
	}

	public void setLenderAmount(BigDecimal lenderAmount) {
		this.lenderAmount = lenderAmount;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Long getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(Long formStatus) {
		this.formStatus = formStatus;
	}

	public Date getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}

	public Integer getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getLenderApplyId() {
		return lenderApplyId;
	}

	public void setLenderApplyId(Long lenderApplyId) {
		this.lenderApplyId = lenderApplyId;
	}
}
