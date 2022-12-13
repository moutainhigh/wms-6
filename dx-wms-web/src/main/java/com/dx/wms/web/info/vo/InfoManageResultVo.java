package com.dx.wms.web.info.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.infoManage.dto.InfoManageResultDto;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;

public class InfoManageResultVo implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 6587698024399181762L;
	
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
    
    /*
     * 出借方式view
     */
    private String productIdView;
    
    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;
    
    /**
     * 出借金额View
     */
    private String lenderAmountView;
    
    /**
     * 签单日期
     */
    private Date signDate;
    
    /*
     * 签单日期View
     */
    private String signDateView;
    
    /**
     * 状态
     */
    private Long formStatus;
    
    /*
     * 状态View
     */
    private String formStatusView;
    
    
    /**
     * 到账日
     */
    private Date settleDate;
    
    /*
     * 到账日View
     */
    private String settleDateView;
    
    /**
     * 账单日
     */
    private Integer statementDate;
    
    /*
     * 账单日View
     */
    private String satementDateView;
    
    /**
     * 到期日
     */
    private Date dueDate;
    
    /*
     * 到期日View
     */
    private String dueDateView;

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

	public String getLenderAmountView() {
		return lenderAmountView;
	}

	public void setLenderAmountView(String lenderAmountView) {
		this.lenderAmountView = lenderAmountView;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getSignDateView() {
		return signDateView;
	}

	public void setSignDateView(String signDateView) {
		this.signDateView = signDateView;
	}

	public Long getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(Long formStatus) {
		this.formStatus = formStatus;
	}

	public String getFormStatusView() {
		return formStatusView;
	}

	public void setFormStatusView(String formStatusView) {
		this.formStatusView = formStatusView;
	}

	public Date getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}

	public String getSettleDateView() {
		return settleDateView;
	}

	public void setSettleDateView(String settleDateView) {
		this.settleDateView = settleDateView;
	}

	public Integer getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}

	public String getSatementDateView() {
		return satementDateView;
	}

	public void setSatementDateView(String satementDateView) {
		this.satementDateView = satementDateView;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueDateView() {
		return dueDateView;
	}

	public void setDueDateView(String dueDateView) {
		this.dueDateView = dueDateView;
	}
    

	public String getProductIdView() {
		return productIdView;
	}

	public void setProductIdView(String productIdView) {
		this.productIdView = productIdView;
	}
	
	public Long getLenderApplyId() {
		return lenderApplyId;
	}

	public void setLenderApplyId(Long lenderApplyId) {
		this.lenderApplyId = lenderApplyId;
	}

	public InfoManageResultVo(InfoManageResultDto dto, Map<String, String> productMap,Map<String, String> statusMap){
		BeanUtils.copyProperties(dto, this);
		
		setProductIdView(productMap.get(getProductId().toString()));
		setFormStatusView(statusMap.get(getFormStatus().toString()));
		
		setSignDateView(DateUtils.formatForDay(getSignDate(),"--"));
		setSettleDateView(DateUtils.formatForDay(getSettleDate(),"--"));
		setSatementDateView(null==getStatementDate() ? "--":String.valueOf(getStatementDate()));
		setDueDateView(DateUtils.formatForDay(getDueDate(),"--"));
		
		setLenderAmountView(AmountUtils.format(getLenderAmount(),"--"));
	}
    
	
}
