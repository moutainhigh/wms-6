package com.dx.wms.web.change.vo;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.service.changer.InfoChangeDto;
import com.dx.wms.service.changer.ResultChanger;
import com.dx.wms.service.log.LogJsonDto;
import com.google.gson.Gson;

/**
 * 
 * 变更结果Vo
 *
 * @author tony
 */
public class ResultChangeVo extends ChangeVo {

    /**
     */
    private static final long serialVersionUID = -153606508109189525L;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 证件类型
     */
    private String idType;

    /** 账户级别编号 */
    private String accountLevelId;

    /** 开户日期 */
    private String openDate;

    /** 性别 */
    private String sex;

    /** 状态 */
    private String dataStatus;

    /** 账户状态 */
    private String accountStatus;

    /** 账户状态 */
    private Integer accountStatuCode;
    /** 客户出借申请-编号 */
    private Long lenderApplyId;

    /** 签单日期 */
    private String signDate;

    /** 状态 */
    private String currentStep;

    /** 状态key */
    private String currentStepKey;

    /** 支付方式 */
    private String payWayId;

    /** 审批内容 */
    private String approveComment;

    /** 出借金额 */
    private String lenderAmount;

    /** 账单日 */
    private Integer bizBillDay;

    /** 匹配日期 */
    private String matchDate;

    /** 是否进行了续投 0没有 1已续投 */
    private Integer hasContinue;

    /** 营业部 */
    private String salesDepartment;

    /** cluster */
    private String clusterName;

    /** 团队编号 */
    private String teamId;

    /** 团队 */
    private String teamName;

    /** 客户经理编号 */
    private String createUser;

    /** 客户经理 */
    private String custManager;

    /** 生效时间 */
    private String settlementDate;

    /** 续投的原理财申请ID */
    private Long parentId;

    /** 变更项 */
    private String changeProject;

    /** 变更内容 */
    private String changeContent;

    /** 原始内容 */
    private String originalContent;

    /** 变更时间 */
    private String createTime;
    
    /** 出借方式 */
    private String productIdView;
    
    private String perfectDegree;
    public ResultChangeVo(ResultChanger result, InfoChangeDto changeDto) {
        // dto转vo
        BeanUtils.copyProperties(result, this);
        // 状态
        setAccountStatus(Assert.equals(result.getDataStatus(), "C") ? "认证中" : "已认证");
        // 出借方式
        setProductId(changeDto.getProductId());
        // 出借金额
        setLenderAmount(AmountUtils.format(result.getLenderAmount(), ""));
        // 签单日期
        setSignDate(DateUtils.formatForDay(result.getSignDate(), ""));
        // 营业部
        setSalesDepartment(changeDto.getDepartment());
        // 大团
        setClusterName(changeDto.getClusterVo().getName());
        // 小团
        setTeamName(changeDto.getTeamVo().getName());
        // 客戶经理
        setCustManager(changeDto.getCustManager());
        // 获取生效时间
        setSettlementDate(DateUtils.formatForDay(result.getSettlementDate(), ""));
        // 设置申请单状态
        setCurrentStep(changeDto.getCurrentStep());
        //设置出借方式
        setProductIdView(changeDto.getProductName());
    }

    public ResultChangeVo(ResultChanger result) {
        setLenderCode(result.getLenderCode());
        setLenderCustCode(result.getLenderCustCode());
        setCustName(result.getCustName());
        // 将日志内容转化为LogJsonDto
        LogJsonDto logJsonDto = new Gson().fromJson(result.getContent(), LogJsonDto.class);
        if (Assert.checkParam(logJsonDto)) {
            setChangeProject(logJsonDto.getColumnNameChs());
            setChangeContent(logJsonDto.getUpdateValueChs());
            setOriginalContent(logJsonDto.getSourceValueChs());
        }
        setCreateTime(DateUtils.formatForFull(result.getCreateTime()));
        setPerfectDegree(Assert.checkParam(perfectDegree)?"-":perfectDegree);
    }

    /** 变更项 */
    public String getChangeProject() {
        return changeProject;
    }

    /** 变更项 */
    public void setChangeProject(String changeProject) {
        this.changeProject = changeProject;
    }

    /** 变更内容 */
    public String getChangeContent() {
        return changeContent;
    }

    /** 变更内容 */
    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    /** 原始内容 */
    public String getOriginalContent() {
        return originalContent;
    }

    /** 原始内容 */
    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    /** 创建时间 */
    public String getCreateTime() {
        return createTime;
    }

    /** 创建时间 */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /** 客户账户编号 */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /** 客户账户编号 */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /** 证件类型 */
    public String getIdType() {
        return idType;
    }

    /** 证件类型 */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /** 账户级别 */
    public String getAccountLevelId() {
        return accountLevelId;
    }

    /** 账户级别 */
    public void setAccountLevelId(String accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    /** 开户日期 */
    public String getOpenDate() {
        return openDate;
    }

    /** 开户日期 */
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    /** 性别 */
    public String getSex() {
        return sex;
    }

    /** 性别 */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /** 状态 */
    public String getDataStatus() {
        return dataStatus;
    }

    /** 状态 */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    /** 账户状态 */
    public String getAccountStatus() {
        return accountStatus;
    }

    /** 账户状态 */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /** 账户状态编号 */
    public Integer getAccountStatuCode() {
        return accountStatuCode;
    }

    /** 账户状态编号 */
    public void setAccountStatuCode(Integer accountStatuCode) {
        this.accountStatuCode = accountStatuCode;
    }

    /** 申请单编号 */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /** 申请单编号 */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /** 签单日期 */
    public String getSignDate() {
        return signDate;
    }

    /** 签单日期 */
    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    /** 当前环节 */
    public String getCurrentStep() {
        return currentStep;
    }

    /** 当前环节 */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /** 当前环节 标示 */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /** 当前环节 标示 */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /** 支付方式 */
    public String getPayWayId() {
        return payWayId;
    }

    /** 支付方式 */
    public void setPayWayId(String payWayId) {
        this.payWayId = payWayId;
    }

    /** 备注 */
    public String getApproveComment() {
        return approveComment;
    }

    /** 备注 */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    /** 出借金额 */
    public String getLenderAmount() {
        return lenderAmount;
    }

    /** 出借金额 */
    public void setLenderAmount(String lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    /** 账单日 */
    public Integer getBizBillDay() {
        return bizBillDay;
    }

    /** 账单日 */
    public void setBizBillDay(Integer bizBillDay) {
        this.bizBillDay = bizBillDay;
    }

    /** 匹配日 */
    public String getMatchDate() {
        return matchDate;
    }

    /** 匹配日 */
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    /** 是否进行了续投 0没有 1已续投 */
    public Integer getHasContinue() {
        return hasContinue;
    }

    /** 是否进行了续投 0没有 1已续投 */
    public void setHasContinue(Integer hasContinue) {
        this.hasContinue = hasContinue;
    }

    /** 营业部 */
    public String getSalesDepartment() {
        return salesDepartment;
    }

    /** 营业部 */
    public void setSalesDepartment(String salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    /** 大团 */
    public String getClusterName() {
        return clusterName;
    }

    /** 大团 */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /** 团队编号 */
    public String getTeamId() {
        return teamId;
    }

    /** 团队编号 */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /** 小团 */
    public String getTeamName() {
        return teamName;
    }

    /** 小团 */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /** 创建人 */
    public String getCreateUser() {
        return createUser;
    }

    /** 创建人 */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /** 客户经理 */
    public String getCustManager() {
        return custManager;
    }

    /** 客户经理 */
    public void setCustManager(String custManager) {
        this.custManager = custManager;
    }

    /** 生效时间 */
    public String getSettlementDate() {
        return settlementDate;
    }

    /** 生效时间 */
    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public String getPerfectDegree() {
		return perfectDegree;
	}

	public void setPerfectDegree(String perfectDegree) {
		this.perfectDegree = perfectDegree;
	}
	
	/**
	 * 
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */

	public void setProductIdView(String productIdView) {
		this.productIdView = productIdView;
	}

	public String getProductIdView() {
		return productIdView;
	}
    
    
}
