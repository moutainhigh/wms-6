/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WealthManagementInfoQueryDto.java
 * Author:   朱道灵
 * Date:     2015年7月26日 下午3:37:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.info;

import org.apache.commons.lang3.StringUtils;

import com.dx.wms.common.BaseAttrDto;

/**
 * 理财信息管理 数据库查询 DTO
 *
 * @author 朱道灵
 */
public class ParamInfo extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = -4040928103023764892L;

    /**
     * 出借编号
     */
    private String lenderApplyId;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 签单日期 起
     */
    private String signDateBegin;

    /**
     * 签单日期 止
     */
    private String signDateEnd;

    /**
     * 出借方式
     */
    private String loanWay;

    /**
     * 状态
     */
    private Integer currentStep;

    /**
     * 创建者
     */
    private Long createUser;

    /**
     * 组织编号
     */
    private Long teamId;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 生效日期起
     */
    private String settlementDateBegin;

    /**
     * 生效日期止
     */
    private String settlementDateEnd;

    /**
     * 客户经理
     */
    private Integer custManager;

    /**
     * 用户Id
     */
    private Long userId;

    public ParamInfo() {

    }

    public ParamInfo(Long userId) {
        setUserId(userId);
    }

    /**
     * @return the lenderApplyId
     */
    public String getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(String lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return the signDateBegin
     */
    public String getSignDateBegin() {
        return signDateBegin;
    }

    /**
     * @param signDateBegin the signDateBegin to set
     */
    public void setSignDateBegin(String signDateBegin) {
        if (StringUtils.isBlank(signDateBegin)) {
            this.signDateBegin = signDateBegin;
        } else {
            this.signDateBegin = signDateBegin + " 00:00:00";
        }
    }

    /**
     * @return the signDateEnd
     */
    public String getSignDateEnd() {
        return signDateEnd;
    }

    /**
     * @param signDateEnd the signDateEnd to set
     */
    public void setSignDateEnd(String signDateEnd) {
        if (StringUtils.isBlank(signDateEnd)) {
            this.signDateEnd = signDateEnd;
        } else {
            this.signDateEnd = signDateEnd + "23:59:59";
        }
    }

    /**
     * @return the loanWay
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * @param loanWay the loanWay to set
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay;
    }

    /**
     * @return the currentStep
     */
    public Integer getCurrentStep() {
        return currentStep;
    }

    /**
     * @param currentStep the currentStep to set
     */
    public void setCurrentStep(Integer currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * @return the createUser
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the teamId
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
     * @return the lenderAmountArea
     */
    public Integer getLenderAmountArea() {
        return lenderAmountArea;
    }

    /**
     * @param lenderAmountArea the lenderAmountArea to set
     */
    public void setLenderAmountArea(Integer lenderAmountArea) {
        this.lenderAmountArea = lenderAmountArea;
    }

    /**
     * @return the settlementDateBegin
     */
    public String getSettlementDateBegin() {
        return settlementDateBegin;
    }

    /**
     * @param settlementDateBegin the settlementDateBegin to set
     */
    public void setSettlementDateBegin(String settlementDateBegin) {
        this.settlementDateBegin = settlementDateBegin;
    }

    /**
     * @return the settlementDateEnd
     */
    public String getSettlementDateEnd() {
        return settlementDateEnd;
    }

    /**
     * @param settlementDateEnd the settlementDateEnd to set
     */
    public void setSettlementDateEnd(String settlementDateEnd) {
        this.settlementDateEnd = settlementDateEnd;
    }

    /**
     * @return the custManager
     */
    public Integer getCustManager() {
        return custManager;
    }

    /**
     * @param custManager the custManager to set
     */
    public void setCustManager(Integer custManager) {
        this.custManager = custManager;
    }

    /**
     * @return the orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
