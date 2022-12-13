package com.dx.op.web.vo;

import java.io.Serializable;
import java.util.Date;

public class LoanDayQueryVo implements Serializable{
	/**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 营业部
     */
    private Long salesDepartment;

    /**
     * 客户经理
     */
    private String customerManagerId;

    /**
     * 审批产品类型
     */
    private Integer prodType;

    /**
     * 还款日
     */
    private Integer repaymentDay;

    /**
     * 申请时间起
     */
    private Date applyTimeBegin;

    /**
     * 申请时间 止
     */
    private Date applyTimeEnd;

    /**
     * 身份证号
     */
    private String idCard;
    
    /**
     * 姓名
     */
    private String name;


	/**
     * 放款日期起
     */
    private Date loanPayTimeBegin;

    /**
     * 放款日期止
     */
    private Date loanPayTimeEnd;
    
    
    /**
     * 借款用途
     */
    private Integer loanType;
    
  
	/**
     * 职业借款用途
     */
    private Integer workSituation;

    
    
    public Integer getLoanType() {
		return loanType;
	}

	public void setLoanType(Integer loanType) {
		this.loanType = loanType;
	}

	public Integer getWorkSituation() {
		return workSituation;
	}

	public void setWorkSituation(Integer workSituation) {
		this.workSituation = workSituation;
	}

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Long getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(Long salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    public String getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(String customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public Integer getProdType() {
        return prodType;
    }

    public void setProdType(Integer prodType) {
        this.prodType = prodType;
    }

    public Integer getRepaymentDay() {
        return repaymentDay;
    }

    public void setRepaymentDay(Integer repaymentDay) {
        this.repaymentDay = repaymentDay;
    }

    public Date getApplyTimeBegin() {
        return applyTimeBegin;
    }

    public void setApplyTimeBegin(Date applyTimeBegin) {
        this.applyTimeBegin = applyTimeBegin;
    }

    public Date getApplyTimeEnd() {
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(Date applyTimeEnd) {
        this.applyTimeEnd = applyTimeEnd;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getLoanPayTimeBegin() {
        return loanPayTimeBegin;
    }

    public void setLoanPayTimeBegin(Date loanPayTimeBegin) {
        this.loanPayTimeBegin = loanPayTimeBegin;
    }

    public Date getLoanPayTimeEnd() {
        return loanPayTimeEnd;
    }

    public void setLoanPayTimeEnd(Date loanPayTimeEnd) {
        this.loanPayTimeEnd = loanPayTimeEnd;
    }

}
