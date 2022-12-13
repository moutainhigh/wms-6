/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyQueryVo.java
 * Author:   朱道灵
 * Date:     2015年7月31日 下午2:08:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.cla.web.vo;

import com.dx.wms.web.vo.ParamVo;

/**
 * 客户申请管理 数据库查询VO
 * 
 * @author 朱道灵
 */
public class ApplyParamVo extends ParamVo {

    /**
     */
    private static final long serialVersionUID = -8337690401811376530L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 申请单状态
     */
    private String currentStep;

    /**
     * 签单日期-起
     */
    private String signDateBegin;

    /**
     * 签单日期-止
     */
    private String signDateEnd;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 申请单状态编号
     */
    private String currentStepCode;

    /**
     * 变更日志的主键编号
     */
    private String pkId;

    /**
     * 1申请 2到期
     */
    private Integer type;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getLenderAmountArea() {
        return lenderAmountArea;
    }

    public void setLenderAmountArea(Integer lenderAmountArea) {
        this.lenderAmountArea = lenderAmountArea;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public String getSignDateBegin() {
        return signDateBegin;
    }

    public void setSignDateBegin(String signDateBegin) {
        this.signDateBegin = signDateBegin;
    }

    public String getSignDateEnd() {
        return signDateEnd;
    }

    public void setSignDateEnd(String signDateEnd) {
        this.signDateEnd = signDateEnd;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getCurrentStepCode() {
        return currentStepCode;
    }

    public void setCurrentStepCode(String currentStepCode) {
        this.currentStepCode = currentStepCode;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
