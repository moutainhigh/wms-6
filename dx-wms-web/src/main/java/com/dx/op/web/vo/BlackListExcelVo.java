package com.dx.op.web.vo;

import java.math.BigDecimal;

public class BlackListExcelVo {
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
     * 申请时间
     */
    private String applyTime;
    
    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户身份证
     */
    private String idCard;
    
    /**
     * 申请产品类型
     */
    private String prodTypeInfo;
    
    /**
     * 申请额度
     */
    private BigDecimal applyAmount;
    
    
    /**
     * 审核人员 	
     */
    private String creater;
    
    
    /**
     * 团队
     */
    private String teamInfo;
    
    
    /**
     * 客户经理
     */
    private String customerManagerInfo;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 拒绝理由 
     */
    private String refuseReason;
    
    /**
     * 是否欺诈
     */
    private String cheat;
    
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

    

    public String getCustomerManagerInfo() {
        return customerManagerInfo;
    }

    public void setCustomerManagerInfo(String customerManagerInfo) {
        this.customerManagerInfo = customerManagerInfo;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the creater
	 */
	public String getCreater() {
		return creater;
	}

	/**
	 * @param creater the creater to set
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}

	/**
	 * @return the refuseReason
	 */
	public String getRefuseReason() {
		return refuseReason;
	}

	/**
	 * @param refuseReason the refuseReason to set
	 */
	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	/**
	 * @return the cheat
	 */
	public String getCheat() {
		return cheat;
	}

	/**
	 * @param cheat the cheat to set
	 */
	public void setCheat(String cheat) {
		this.cheat = cheat;
	}

	

}
