package com.dx.op.web.vo;

import java.math.BigDecimal;

public class LoanApplyExcelVo {

    /**
     * 借贷部
     */
    private String loanDepartmentInfo;

    /**
     * 区域
     */
    private String areaInfo;

    /**
     * 营业部
     */
    private String salesDepartmentInfo;

    /**
     * 团队
     */
    private String teamInfo;

    /**
     * 团队经理
     */
    private String teamManagerInfo;

    /**
     * 客户经理
     */
    private String customerManagerInfo;
    
    /**
     * 团队经理工号
     */
    private String teamManagerWorkerNo;
    
    /**
     * 客户经理工号
     */
    private String customerManagerWorkerNo;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 借款职业情况
     */
    private String professionStatusInfo;

    /**
     * 借款用途
     */
    private String loanTypeInfo;

    /**
     * 申请产品类型
     */
    private String prodTypeInfo;

    /**
     * 纸质申请时间
     */
    private String applyTime;
    
    /**
     * 申请时间
     */
    private String createTime;

    /**
     * 申请额度
     */
    private BigDecimal applyAmount;
    
    /**
     * 申请期限
     */
    private String applyDeadline;
    
    /**
     * 审批进度
     */
    private String formStatus;
    
    

    
    public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public String getLoanDepartmentInfo() {
        return loanDepartmentInfo;
    }

    public void setLoanDepartmentInfo(String loanDepartmentInfo) {
        this.loanDepartmentInfo = loanDepartmentInfo;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public String getSalesDepartmentInfo() {
        return salesDepartmentInfo;
    }

    public void setSalesDepartmentInfo(String salesDepartmentInfo) {
        this.salesDepartmentInfo = salesDepartmentInfo;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public String getTeamManagerInfo() {
        return teamManagerInfo;
    }

    public void setTeamManagerInfo(String teamManagerInfo) {
        this.teamManagerInfo = teamManagerInfo;
    }

    public String getCustomerManagerInfo() {
        return customerManagerInfo;
    }

    public void setCustomerManagerInfo(String customerManagerInfo) {
        this.customerManagerInfo = customerManagerInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProfessionStatusInfo() {
        return professionStatusInfo;
    }

    public void setProfessionStatusInfo(String professionStatusInfo) {
        this.professionStatusInfo = professionStatusInfo;
    }

    public String getLoanTypeInfo() {
        return loanTypeInfo;
    }

    public void setLoanTypeInfo(String loanTypeInfo) {
        this.loanTypeInfo = loanTypeInfo;
    }

    public String getProdTypeInfo() {
        return prodTypeInfo;
    }

    public void setProdTypeInfo(String prodTypeInfo) {
        this.prodTypeInfo = prodTypeInfo;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

	/**
	 * @return the applyDeadline
	 */
	public String getApplyDeadline() {
		return applyDeadline;
	}

	/**
	 * @param applyDeadline the applyDeadline to set
	 */
	public void setApplyDeadline(String applyDeadline) {
		this.applyDeadline = applyDeadline;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the teamManagerWorkerNo
	 */
	public String getTeamManagerWorkerNo() {
		return teamManagerWorkerNo;
	}

	/**
	 * @param teamManagerWorkerNo the teamManagerWorkerNo to set
	 */
	public void setTeamManagerWorkerNo(String teamManagerWorkerNo) {
		this.teamManagerWorkerNo = teamManagerWorkerNo;
	}

	/**
	 * @return the customerManagerWorkerNo
	 */
	public String getCustomerManagerWorkerNo() {
		return customerManagerWorkerNo;
	}

	/**
	 * @param customerManagerWorkerNo the customerManagerWorkerNo to set
	 */
	public void setCustomerManagerWorkerNo(String customerManagerWorkerNo) {
		this.customerManagerWorkerNo = customerManagerWorkerNo;
	}

}
