/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyResultVo.java
 * Author:   朱道灵
 * Date:     2015年7月31日 下午2:12:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.cla.web.vo;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.PayWay;
import com.dx.wms.service.apply.dto.ResultApplicant;
import com.dx.wms.web.vo.ResultVo;

/**
 * 申请结果Vo
 *
 * @author 朱道灵
 */
public class ApplyResultVo extends ResultVo {

    /**
     */
    private static final long serialVersionUID = -1023011193264141929L;

    /**
     * 客户出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 客户出借申请-编号
     */
    private Long custAccountId;

    /**
     * 客户 理财编号
     */
    private String lenderCode;

    /**
     * 签单日期
     */
    private String signDate;

    /**
     * 出借方式
     */
    private String productId;

    /**
     * 状态
     */
    private String currentStep;

    /**
     * 状态key
     */
    private String currentStepKey;

    /**
     * 支付方式
     */
    private String payWayId;

    /**
     * 审批内容
     */
    private String approveComment;

    /**
     * 出借金额
     */
    private String lenderAmount;

    /**
     * 账单日
     */
    private Integer bizBillDay;

    /**
     * 匹配日期
     */
    private String matchDate;

    /**
     * 是否进行了续投 0没有 1已续投
     */
    private Integer hasContinue;

    /**
     * 营业部编号
     */
    private String orgId;

    /** 营业部 */
    private String salesDepartment;

    /**
     * cluster
     */
    private String clusterName;

    /**
     * 团队编号
     */
    private String teamId;

    /**
     * 团队
     */
    private String teamName;

    /**
     * 客户经理编号
     */
    private String createUser;

    /**
     * 客户经理
     */
    private String custManager;

    /**
     * s生效时间
     */
    private String settlementDate;

    /**
     * 续投的原理财申请ID
     */
    private Long parentId;

    /**
     * @return the settlementDate
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * @param settlementDate the settlementDate to set
     */
    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * @return the orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the salesDepartment
     */
    public String getSalesDepartment() {
        return salesDepartment;
    }

    /**
     * @param salesDepartment the salesDepartment to set
     */
    public void setSalesDepartment(String salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    /**
     * @return the clusterName
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * @param clusterName the clusterName to set
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * @return the teamId
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the createUser
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the custManager
     */
    public String getCustManager() {
        return custManager;
    }

    /**
     * @param custManager the custManager to set
     */
    public void setCustManager(String custManager) {
        this.custManager = custManager;
    }

    /**
     * @return bizBillDay
     */
    public Integer getBizBillDay() {
        return bizBillDay;
    }

    /**
     * @param bizBillDay
     */
    public void setBizBillDay(Integer bizBillDay) {
        this.bizBillDay = bizBillDay;
    }

    /**
     * @return matchDate
     */
    public String getMatchDate() {
        return matchDate;
    }

    /**
     * @param matchDate
     */
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
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
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the signDate
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * @param signDate the signDate to set
     */
    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the custAccountId
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * @param custAccountId the custAccountId to set
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
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

    public String getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(String payWayId) {
        this.payWayId = payWayId;
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
    public String getLenderAmount() {
        return lenderAmount;
    }

    /**
     * @param lenderAmount the lenderAmount to set
     */
    public void setLenderAmount(String lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    /**
     * @return the hasContinue
     */
    public Integer getHasContinue() {
        return hasContinue;
    }

    /**
     * @param hasContinue the hasContinue to set
     */
    public void setHasContinue(Integer hasContinue) {
        this.hasContinue = hasContinue;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void put(ApplyResultVo vo, ResultApplicant dto) {
        BeanUtils.copyProperties(dto, vo);
        vo.setPayWayId(PayWay.getInfo(dto.getPayWayId(), false));
        if (Assert.checkParam(dto.getParentId())) {
            vo.setPayWayId("续投");
        }
        vo.setLenderAmount(AmountUtils.format(dto.getLenderAmount(), "-"));
        vo.setSignDate(DateUtils.formatForDay(dto.getSignDate(), "-"));
        if (!Assert.checkParam(dto.getLenderCode())) {
            vo.setLenderCode("");
        }
    }

}
