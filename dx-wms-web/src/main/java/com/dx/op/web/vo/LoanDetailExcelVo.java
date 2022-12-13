package com.dx.op.web.vo;

import java.math.BigDecimal;

public class LoanDetailExcelVo {

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
     * 销售团队
     */
    private String teamInfo;

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
     * 姓名
     */
    private String name;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 放款银行
     */
    private String bank;

    /**
     * 放款支行
     */
    private String subBank;

    /**
     * 放款账号
     */
    private String account;

    /**
     * 合同金额（元）
     */
    private BigDecimal contractAmount;

    /**
     * 借款职业情况
     */
    private String professionStatusInfo;

    /**
     * 借款用途
     */
    private String loanTypeInfo;

    /**
     * 首次还款日
     */
    private String refundFirstTime;

    /**
     * 还款期限（月）
     */
    private String approveDeadlineInfo;

    /**
     * 审批产品类型
     */
    private String approveProdTypeInfo;
    
    /**
     * 综合费率
     */
    private String synthesizeRatio;
    
    /**
     * 还款止日
     */
    private String refundLastTime;

    /**
     * 审批金额（元）
     */
    private BigDecimal approveAmount;

    /**
     * 划款金额（元）
     */
    private BigDecimal loanAmount;

    /**
     * 还款日
     */
    private Integer repaymentDay;

    
    /**
     * 申请日期
     */
    private String createTime;

    
    /**
     * 审批日期
     */
    private String approveTime;

    /**
     * 签约日期
     */
    private String signTime;

    /**
     * 放款日期
     */
    private String loanPayTime;

    /**
     * 咨询费（元）
     */
    private BigDecimal consultFee;

    /**
     * 乙方管理费（元）
     */
    private BigDecimal serviceFee;

    /**
     * 丙方管理费（元）
     */
    private BigDecimal serviceFeeOther;

    /**
     * 评估费（元）
     */
    private BigDecimal assessmentFee;

    /**
     * 费用合计（元）
     */
    private BigDecimal totalFee;

    /**
     * 风险金（元）
     */
    private BigDecimal riskFee;

    /**
     * 客服
     */
    private String customer;

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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
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

    public String getRefundFirstTime() {
        return refundFirstTime;
    }

    public void setRefundFirstTime(String refundFirstTime) {
        this.refundFirstTime = refundFirstTime;
    }

    public String getApproveDeadlineInfo() {
        return approveDeadlineInfo;
    }

    public void setApproveDeadlineInfo(String approveDeadlineInfo) {
        this.approveDeadlineInfo = approveDeadlineInfo;
    }

    public String getApproveProdTypeInfo() {
        return approveProdTypeInfo;
    }

    public void setApproveProdTypeInfo(String approveProdTypeInfo) {
        this.approveProdTypeInfo = approveProdTypeInfo;
    }

    public String getRefundLastTime() {
        return refundLastTime;
    }

    public void setRefundLastTime(String refundLastTime) {
        this.refundLastTime = refundLastTime;
    }

    public BigDecimal getApproveAmount() {
        return approveAmount;
    }

    public void setApproveAmount(BigDecimal approveAmount) {
        this.approveAmount = approveAmount;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getRepaymentDay() {
        return repaymentDay;
    }

    public void setRepaymentDay(Integer repaymentDay) {
        this.repaymentDay = repaymentDay;
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getLoanPayTime() {
        return loanPayTime;
    }

    public void setLoanPayTime(String loanPayTime) {
        this.loanPayTime = loanPayTime;
    }

    public BigDecimal getConsultFee() {
        return consultFee;
    }

    public void setConsultFee(BigDecimal consultFee) {
        this.consultFee = consultFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getServiceFeeOther() {
        return serviceFeeOther;
    }

    public void setServiceFeeOther(BigDecimal serviceFeeOther) {
        this.serviceFeeOther = serviceFeeOther;
    }

    public BigDecimal getAssessmentFee() {
        return assessmentFee;
    }

    public void setAssessmentFee(BigDecimal assessmentFee) {
        this.assessmentFee = assessmentFee;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getRiskFee() {
        return riskFee;
    }

    public void setRiskFee(BigDecimal riskFee) {
        this.riskFee = riskFee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    /**
     * @return the synthesizeRatio
     */
    public String getSynthesizeRatio() {
        return synthesizeRatio;
    }

    /**
     * @param synthesizeRatio the synthesizeRatio to set
     */
    public void setSynthesizeRatio(String synthesizeRatio) {
        this.synthesizeRatio = synthesizeRatio;
    }

}
