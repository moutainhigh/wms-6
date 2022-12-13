package com.dx.wms.web.change.vo;

import java.util.Date;

/**
 * 
 * 变更参数Vo
 *
 * @author tony
 */
public class ParamChangeVo extends ChangeVo {

    /**
     */
    private static final long serialVersionUID = 1760881150594762508L;
    
    /**
     * 变更日志主键编号
     */
    private Long pkId;
    
    /**
     * 账户状态
     */
    private String accountStatus;

    /**
     * 签单日期-起
     */
    private Date signDateBegin;

    /**
     * 签单日期-止
     */
    private Date signDateEnd;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 编号{detail=account,id=accountId},{detail=apply,id=applyId}
     */
    private Long id;
    
    /**
     * 申请单状态
     */
    private String currentStep;
    
    
    public Long getPkId() {
		return pkId;
	}

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public ParamChangeVo() {
    }
    
	public Date getSignDateBegin() {
		return signDateBegin;
	}

	public void setSignDateBegin(Date signDateBegin) {
		this.signDateBegin = signDateBegin;
	}

	public Date getSignDateEnd() {
		return signDateEnd;
	}

	public void setSignDateEnd(Date signDateEnd) {
		this.signDateEnd = signDateEnd;
	}

	public Integer getLenderAmountArea() {
		return lenderAmountArea;
	}

	public void setLenderAmountArea(Integer lenderAmountArea) {
		this.lenderAmountArea = lenderAmountArea;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(String currentStep) {
		this.currentStep = currentStep;
	}
    
}
