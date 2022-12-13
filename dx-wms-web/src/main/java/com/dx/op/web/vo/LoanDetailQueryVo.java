package com.dx.op.web.vo;

import java.io.Serializable;
import java.util.Date;

public class LoanDetailQueryVo implements Serializable {

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
    private Date createTimeBegin;

    /**
     * 申请时间 止
     */
    private Date createTimeEnd;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 放款日期起
     */
    private Date loanPayTimeBegin;

    /**
     * 放款日期止
     */
    private Date loanPayTimeEnd;

    /**
     * 签约日期起
     */
    private Date signTimeBegin;

    /**
     * 签约日期止
     */
    private Date signTimeEnd;

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

    public Date getSignTimeBegin() {
        return signTimeBegin;
    }

    public void setSignTimeBegin(Date signTimeBegin) {
        this.signTimeBegin = signTimeBegin;
    }

    public Date getSignTimeEnd() {
        return signTimeEnd;
    }

    public void setSignTimeEnd(Date signTimeEnd) {
        this.signTimeEnd = signTimeEnd;
    }

	/**
	 * @return the createTimeBegin
	 */
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	/**
	 * @param createTimeBegin the createTimeBegin to set
	 */
	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	/**
	 * @return the createTimeEnd
	 */
	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	/**
	 * @param createTimeEnd the createTimeEnd to set
	 */
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
}
