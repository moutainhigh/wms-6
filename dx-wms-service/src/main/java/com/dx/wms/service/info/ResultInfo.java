/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WealthManagementInfoResultDto.java
 * Author:   朱道灵
 * Date:     2015年7月26日 下午3:45:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.info;

import java.math.BigDecimal;
import java.util.Date;

import com.dx.wms.common.BaseAttrDto;

/**
 * 信息结果
 *
 * @author 朱道灵
 */
public class ResultInfo extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 5553440484783229290L;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式-编号
     */
    private Long productId;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 团队-编号
     */
    private Long teamId;

    /**
     * 营业部-编号
     */
    private Long orgId;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 客户经理-编号
     */
    private Long managerId;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 到账日
     */
    private Date settleDate;
    
    /**
     * 账单日
     */
    private Integer statementDate;
    
    /**
     * 到期日
     */
    private Date dueDate;
    
    /**
     * 理财申请单状态
     */
    private Long formStatus;

    /**
     * 原理财申请编号
     */
    private Long parrentId;

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

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

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public Integer getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

    public Long getParrentId() {
        return parrentId;
    }

    public void setParrentId(Long parrentId) {
        this.parrentId = parrentId;
    }

}
