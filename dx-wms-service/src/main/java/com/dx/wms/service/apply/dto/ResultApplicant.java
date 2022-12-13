/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyResultDto.java
 * Author:   朱道灵
 * Date:     2015年7月31日 下午2:54:32
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.dx.wms.common.BaseAttrDto;

/**
 * 结果申请
 *
 * @author 朱道灵
 */
public class ResultApplicant extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = -2698942459445560657L;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 客户出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 客户 理财编号
     */
    private String lenderCode;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 开户日期
     */
    private Date openDate;

    /**
     * 证件类型
     */
    private Integer idCategory;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 状态
     */
    private String currentStep;

    /**
     * 状态key
     */
    private String currentStepKey;

    /**
     * 前一环节-标示
     */
    private String lastStepKey;

    /**
     * 前一行为
     */
    private Integer lastAction;

    /**
     * 当前操作
     */
    private Integer currentAction;

    /**
     * 审批内容
     */
    private String approveComment;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 支付方式
     */
    private Integer payWayId;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 营业部
     */
    private String salesDepartment;

    /**
     * cluster
     */
    private String clusterName;

    /**
     * 团队编号
     */
    private Long teamId;

    /**
     * 团队
     */
    private String teamName;

    /**
     * 客户经理编号
     */
    private Long createUser;

    /**
     * 客户经理
     */
    private String custManager;

    /**
     * 生效时间
     */
    private Date settlementDate;

    /**
     * 理财申请单状态
     */
    private Long formStatus;

    private Long parentId;

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(String salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCustManager() {
        return custManager;
    }

    public void setCustManager(String custManager) {
        this.custManager = custManager;
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the lenderCode
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * @param lenderCode the lenderCode to set
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**
     * @return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return the currentStep
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * @param currentStep the currentStep to set
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * @return the lenderApplyId
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return the currentStepKey
     */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /**
     * @param currentStepKey the currentStepKey to set
     */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    public Integer getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    public String getLastStepKey() {
        return lastStepKey;
    }

    public void setLastStepKey(String lastStepKey) {
        this.lastStepKey = lastStepKey;
    }

    public Integer getLastAction() {
        return lastAction;
    }

    public void setLastAction(Integer lastAction) {
        this.lastAction = lastAction;
    }

    public Integer getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    /**
     * @return the approveComment
     */
    public String getApproveComment() {
        return approveComment;
    }

    /**
     * @param approveComment the approveComment to set
     */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    /**
     * @return the lenderAmount
     */
    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    /**
     * @param lenderAmount the lenderAmount to set
     */
    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    /**
     * @return the formStatus
     */
    public Long getFormStatus() {
        return formStatus;
    }

    /**
     * @param formStatus the formStatus to set
     */
    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
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

}
