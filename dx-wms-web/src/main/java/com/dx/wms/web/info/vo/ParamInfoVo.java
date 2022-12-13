/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WealthManagementInfoQueryVo.java
 * Author:   朱道灵
 * Date:     2015年7月26日 下午4:04:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.info.vo;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.info.ParamInfo;
import com.dx.wms.web.vo.ParamVo;

/**
 * 理财信息管理 数据查询 VO
 *
 * @author 朱道灵
 */
public class ParamInfoVo extends ParamVo {

    /**
     */
    private static final long serialVersionUID = -4939592164694289569L;

    /** 客户账户-编号 */
    private Long custAccountId;

    /** 出借编号 */
    private String lenderApplyId;

    /** 出借方式 */
    private Integer loanWay;

    /** 签单日期 */
    private String signDateBegin;

    /** 团队-编号 */
    private String signDateEnd;

    /** 状态 */
    private Integer currentStep;

    /** 出借金额区间 */
    private Integer lenderAmountArea;

    /** 出借方式 */
    private Long productId;

    /** 出借编号 */
    private String lenderCode;

    /** 生效日期起 */
    private String settlementDateBegin;

    /** 生效日期止 */
    private String settlementDateEnd;

    /** 客户经理 */
    private Integer custManager;

    /** 营业部 */
    private Long orgId;

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
     * @return the loanWay
     */
    public Integer getLoanWay() {
        return loanWay;
    }

    /**
     * @param loanWay the loanWay to set
     */
    public void setLoanWay(Integer loanWay) {
        this.loanWay = loanWay;
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
        this.signDateBegin = signDateBegin;
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
        this.signDateEnd = signDateEnd;
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

    public void put(ParamInfo param) {
        BeanUtils.copyProperties(this, param);
        if (!Assert.checkParam(param.getProductId())) {
            param.setProductId(null);
        }
        if (!Assert.checkParam(param.getCurrentStep())) {
            param.setCurrentStep(null);
        }
        if (!Assert.checkParam(param.getCustManager())) {
            param.setCustManager(null);
        }

        if (!Assert.checkParam(param.getOrgId())) {
            param.setOrgId(null);
        }
    }

}
