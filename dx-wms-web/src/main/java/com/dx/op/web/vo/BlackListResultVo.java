package com.dx.op.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class BlackListResultVo implements Serializable{
	/**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 借贷部
     */
    private Long loanDepartment;

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
    private Long salesDepartment;

    /**
     * 营业部
     */
    private String salesDepartmentInfo;

    /**
     * 团队
     */
    private Long team;

    /**
     * 团队
     */
    private String teamInfo;

    /**
     * 团队经理
     */
    private Long teamManager;

    /**
     * 团队经理
     */
    private String teamManagerInfo;

    /**
     * 客户经理
     */
    private String customerManagerId;

    /**
     * 客户经理
     */
    private String customerManagerInfo;

    // 客户姓名
    private String name;

    // 客户身份证
    private String idCard;
    
    /**
     * 申请产品类型
     */
    private String prodTypeInfo;

    /**
     * 审批产品类型
     */
    private String approveProdType;
    
    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 申请额度
     */
    private BigDecimal applyAmount;
    
    /**
     * 拒绝理由
     */
    private String refuseReason;
    

    /**
     * 备注
     */
    private String remark;
    
    /**
     * 客服
     */
    private String customerUser;

    /**
     * 质检人员
     */
    private String serviceQualityUser;
    
    /**
     * 初审人员
     */
    private String loanStartUser;
    
    /**
     * 终审人员
     */
    private String loanFinalUser;
    
    /**
     * loan apply id
     */
    private Long loanApplyId;
    
    /**
     * 一级拒绝理由
     */
    private String approveContentFirst;
    
    /**
     * 二级拒绝理由
     */
    private String approveContentSecond;
    
    /**
     * 是否欺诈
     */
    private String cheat ;
    
    public Long getLoanDepartment() {
        return loanDepartment;
    }

    public void setLoanDepartment(Long loanDepartment) {
        this.loanDepartment = loanDepartment;
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

    public Long getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(Long salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    public String getSalesDepartmentInfo() {
        return salesDepartmentInfo;
    }

    public void setSalesDepartmentInfo(String salesDepartmentInfo) {
        this.salesDepartmentInfo = salesDepartmentInfo;
    }

    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public Long getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(Long teamManager) {
        this.teamManager = teamManager;
    }

    public String getTeamManagerInfo() {
        return teamManagerInfo;
    }

    public void setTeamManagerInfo(String teamManagerInfo) {
        this.teamManagerInfo = teamManagerInfo;
    }

    public String getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(String customerManagerId) {
        this.customerManagerId = customerManagerId;
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
	 * @return the customerUser
	 */
	public String getCustomerUser() {
		return customerUser;
	}

	/**
	 * @param customerUser the customerUser to set
	 */
	public void setCustomerUser(String customerUser) {
		this.customerUser = customerUser;
	}

	/**
	 * @return the serviceQualityUser
	 */
	public String getServiceQualityUser() {
		return serviceQualityUser;
	}

	/**
	 * @param serviceQualityUser the serviceQualityUser to set
	 */
	public void setServiceQualityUser(String serviceQualityUser) {
		this.serviceQualityUser = serviceQualityUser;
	}

	/**
	 * @return the loanStartUser
	 */
	public String getLoanStartUser() {
		return loanStartUser;
	}

	/**
	 * @param loanStartUser the loanStartUser to set
	 */
	public void setLoanStartUser(String loanStartUser) {
		this.loanStartUser = loanStartUser;
	}

	/**
	 * @return the loanFinalUser
	 */
	public String getLoanFinalUser() {
		return loanFinalUser;
	}

	/**
	 * @param loanFinalUser the loanFinalUser to set
	 */
	public void setLoanFinalUser(String loanFinalUser) {
		this.loanFinalUser = loanFinalUser;
	}

	/**
	 * @return the loanApplyId
	 */
	public Long getLoanApplyId() {
		return loanApplyId;
	}

	/**
	 * @param loanApplyId the loanApplyId to set
	 */
	public void setLoanApplyId(Long loanApplyId) {
		this.loanApplyId = loanApplyId;
	}

	/**
	 * @return the approveProdType
	 */
	public String getApproveProdType() {
		return approveProdType;
	}

	/**
	 * @param approveProdType the approveProdType to set
	 */
	public void setApproveProdType(String approveProdType) {
		this.approveProdType = approveProdType;
	}

	/**
	 * @return the approveContentFirst
	 */
	public String getApproveContentFirst() {
		return approveContentFirst;
	}

	/**
	 * @param approveContentFirst the approveContentFirst to set
	 */
	public void setApproveContentFirst(String approveContentFirst) {
		this.approveContentFirst = approveContentFirst;
	}

	/**
	 * @return the approveContentSecond
	 */
	public String getApproveContentSecond() {
		return approveContentSecond;
	}

	/**
	 * @param approveContentSecond the approveContentSecond to set
	 */
	public void setApproveContentSecond(String approveContentSecond) {
		this.approveContentSecond = approveContentSecond;
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

	

	/**
	 * @return the approveProdType
	 */
		
}
