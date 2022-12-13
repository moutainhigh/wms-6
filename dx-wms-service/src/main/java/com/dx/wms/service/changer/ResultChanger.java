package com.dx.wms.service.changer;

import java.math.BigDecimal;
import java.util.Date;

public class ResultChanger extends BaseChanger {

    /**
     */
    private static final long serialVersionUID = -1385854291925016943L;

    /** 证件类型 */
    private Integer idType;

    /** 账户级别编号 */
    private Integer accountLevelId;

    /** 开户日期 */
    private Date openDate;

    /** 性别 */
    private Integer sex;

    /** 状态 */
    private String dataStatus;

    /** 账户状态 */
    private String accountStatus;

    /** 签单日期 */
    private Date signDate;

    /** 状态 */
    private String currentStep;

    /** 状态key */
    private String currentStepKey;

    /** 前一环节-标示 */
    private String lastStepKey;

    /** 前一行为 */
    private Integer lastAction;

    /** 当前操作 */
    private Integer currentAction;

    /** 审批内容 */
    private String approveComment;

    /** 出借金额 */
    private BigDecimal lenderAmount;

    /** 支付方式 */
    private Integer payWayId;

    /** 营业部编号 */
    private Long orgId;

    /** 营业部 */
    private String salesDepartment;

    /** cluster */
    private String clusterName;

    /** 团队编号 */
    private Long teamId;

    /** 团队 */
    private String teamName;

    /** 客户经理编号 */
    private Long createUser;

    /** 客户经理 */
    private String custManager;

    /** 生效时间 */
    private Date settlementDate;

    /** 理财申请单状态 */
    private Long formStatus;

    /** 变更项 */
    private String changeProject;

    /** 变更内容 */
    private String changeContent;

    /** 原始内容 */
    private String originalContent;

    /** 变更时间 */
    private Date createTime;

    /** 证件类型 */
    private Integer idCategory;

    /** 内容 */
    private String content;

    /** 证件类型 */
    public Integer getIdCategory() {
        return idCategory;
    }

    /** 证件类型 */
    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
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

    /** 创建日期 */
    public Date getCreateTime() {
        return createTime;
    }

    /** 创建日期 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 内容 */
    public String getContent() {
        return content;
    }

    /** 内容 */
    public void setContent(String content) {
        this.content = content;
    }

    /** 证件类型 */
    public Integer getIdType() {
        return idType;
    }

    /** 证件类型 */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /** 账户级别 */
    public Integer getAccountLevelId() {
        return accountLevelId;
    }

    /** 账户级别 */
    public void setAccountLevelId(Integer accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    /** 开户日期 */
    public Date getOpenDate() {
        return openDate;
    }

    /** 开户日期 */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /** 性别 */
    public Integer getSex() {
        return sex;
    }

    /** 性别 */
    public void setSex(Integer sex) {
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

    /** 签单日期 */
    public Date getSignDate() {
        return signDate;
    }

    /** 签单日期 */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /** 申请单状态 */
    public String getCurrentStep() {
        return currentStep;
    }

    /** 申请单状态 */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /** 状态key */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /** 状态key */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /** 上一环节状态 */
    public String getLastStepKey() {
        return lastStepKey;
    }

    /** 上一环节状态 */
    public void setLastStepKey(String lastStepKey) {
        this.lastStepKey = lastStepKey;
    }

    /** 前一行为 */
    public Integer getLastAction() {
        return lastAction;
    }

    /** 前一行为 */
    public void setLastAction(Integer lastAction) {
        this.lastAction = lastAction;
    }

    /** 当前行为 */
    public Integer getCurrentAction() {
        return currentAction;
    }

    /** 当前行为 */
    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    /** 重新匹配备注 */
    public String getApproveComment() {
        return approveComment;
    }

    /** 重新匹配备注 */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    /** 出借金额 */
    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    /** 出借金额 */
    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    /** 支付方式 */
    public Integer getPayWayId() {
        return payWayId;
    }

    /** 支付方式 */
    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    /** 组织编号 */
    public Long getOrgId() {
        return orgId;
    }

    /** 组织编号 */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
    public Long getTeamId() {
        return teamId;
    }

    /** 团队编号 */
    public void setTeamId(Long teamId) {
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
    public Long getCreateUser() {
        return createUser;
    }

    /** 创建人 */
    public void setCreateUser(Long createUser) {
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
    public Date getSettlementDate() {
        return settlementDate;
    }

    /** 生效时间 */
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /** 申请单状态 */
    public Long getFormStatus() {
        return formStatus;
    }

    /** 申请单状态 */
    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

}
