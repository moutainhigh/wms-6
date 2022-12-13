/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyQueryDto.java
 * Author:   朱道灵
 * Date:     2015年7月31日 下午2:46:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.wms.common.BaseAttrDto;
import com.dx.wms.enums.ApplyBiz;

/**
 * 参数申请
 *
 * @author 朱道灵
 */
public class ParamApplicant extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 272150965983510040L;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 签单日期起
     */
    private String signDateBegin;

    /**
     * 签单日期止
     */
    private String signDateEnd;

    /**
     * 客户经理
     */
    private Long createUser;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 申请单状态
     */
    private String currentStep;

    /**
     * 申请单状态编号
     */
    private Integer currentStepCode;

    /**
     * 变更日志的主键编号
     */
    private Long pkId;

    /**
     * 1申请 2到期
     */
    private Integer type;
    /**
     * 到期日
     */
    private Date borderDate;

    /**
     * 理财业务类型
     */
    private ApplyBiz biz;
    /**
     * 分页信息
     */
    private Pagination pagination;

    public ParamApplicant() {

    }

    public ParamApplicant(String biz) {
        setBiz(ApplyBiz.getEunm(biz));
    }

    /**
     * 变更日志主键编号
     */
    public Long getPkId() {
        return pkId;
    }

    /**
     * 变更日志主键编号
     */
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    /**
     * 当前行为编码
     */
    public Integer getCurrentStepCode() {
        return currentStepCode;
    }

    /**
     * 当前行为编码
     */
    public void setCurrentStepCode(Integer currentStepCode) {
        this.currentStepCode = currentStepCode;
    }

    /**
     * 营业部编号
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 营业部编号
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 申请单状态
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * 申请单状态
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * 出借方式
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 出借方式
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 创建者
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建者
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 签单日期起
     */
    public String getSignDateBegin() {
        return signDateBegin;
    }

    /**
     * 签单日期起
     */
    public void setSignDateBegin(String signDateBegin) {
        if (StringUtils.isBlank(signDateBegin)) {
            this.signDateBegin = signDateBegin;
        } else {
            this.signDateBegin = signDateBegin + " 00:00:00";
        }
    }

    /**
     * 签单日期止
     */
    public String getSignDateEnd() {
        return signDateEnd;
    }

    /**
     * 签单日期止
     */
    public void setSignDateEnd(String signDateEnd) {
        if (StringUtils.isBlank(signDateEnd)) {
            this.signDateEnd = signDateEnd;
        } else {
            this.signDateEnd = signDateEnd + " 23:59:59";
        }
    }

    /**
     * 出借编号
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * 出借编号
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**
     * 出借金额区间
     */
    public Integer getLenderAmountArea() {
        return lenderAmountArea;
    }

    /**
     * 出借金额区间
     */
    public void setLenderAmountArea(Integer lenderAmountArea) {
        this.lenderAmountArea = lenderAmountArea;
    }

    /**
     * 1申请 2到期
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1申请 2到期
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 到日期
     */
    public Date getBorderDate() {
        return borderDate;
    }

    /**
     * 到日期
     */
    public void setBorderDate(Date borderDate) {
        this.borderDate = borderDate;
    }

    /**
     * 分页
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 分页
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * @return the biz
     */
    public ApplyBiz getBiz() {
        return biz;
    }

    /**
     * @param biz the biz to set
     */
    public void setBiz(ApplyBiz biz) {
        this.biz = biz;
    }

}
