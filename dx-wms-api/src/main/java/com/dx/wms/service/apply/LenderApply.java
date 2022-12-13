/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApply.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午6:38:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LenderApply implements Serializable {

    /**
     */
    private static final long serialVersionUID = -6251813511279038087L;

    /** 出借申请编号 主键 */
    private Long lenderApplyId;

    /** 出借编号-规则 */
    private String lenderCode;

    /** 客户账户-编号 */
    private Long custAccountId;

    /** 理财-客户-编码-规则 */
    private String lenderCustCode;

    /** 合同编号 */
    private String contractCode;

    /** 出借方式 */
    private Long productId;

    /** 预计出借日期-起 */
    private Date expectLenderDateBegin;

    /** 预计出借日期-止 */
    private Date expectLenderDateEnd;

    /** 支付方式-编号 */
    private Long payWayId;

    /** 出借金额 */
    private BigDecimal lenderAmount;

    /** 客户金融-编号 */
    private Long custFinanceId;

    /** 签单日期 */
    private Date signDate;

    /** 创建者 */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者 */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态 */
    private String dataStatus;

    /** 营业部编号 */
    private Long orgId;
    /** 团队编号 */
    private Long teamId;

    /** 到账日 */
    private Date settlementDate;

    /** 账单日 */
    private Integer statementDate;

    /** 匹配日期 */
    private Date matchDate;

    /** 签约手机 */
    private String signMobile;

    /** 理财申请单状态 */
    private Long formStatus;

    /** 续投原理财ID */
    private Long parentId;

    /** 到期日 */
    private Date dueDate;

    /** 流程实例ID */
    private String procInsId;

    /**
     * 回收方式
     */
    private Integer recovery;

    /**
     * 1已续投;0未续投(或者null)
     */
    private String dueStatus;

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

	public Long getCustAccountId() {
		return custAccountId;
	}

	public void setCustAccountId(Long custAccountId) {
		this.custAccountId = custAccountId;
	}

	public String getLenderCustCode() {
		return lenderCustCode;
	}

	public void setLenderCustCode(String lenderCustCode) {
		this.lenderCustCode = lenderCustCode;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getExpectLenderDateBegin() {
		return expectLenderDateBegin;
	}

	public void setExpectLenderDateBegin(Date expectLenderDateBegin) {
		this.expectLenderDateBegin = expectLenderDateBegin;
	}

	public Date getExpectLenderDateEnd() {
		return expectLenderDateEnd;
	}

	public void setExpectLenderDateEnd(Date expectLenderDateEnd) {
		this.expectLenderDateEnd = expectLenderDateEnd;
	}

	public Long getPayWayId() {
		return payWayId;
	}

	public void setPayWayId(Long payWayId) {
		this.payWayId = payWayId;
	}

	public BigDecimal getLenderAmount() {
		return lenderAmount;
	}

	public void setLenderAmount(BigDecimal lenderAmount) {
		this.lenderAmount = lenderAmount;
	}

	public Long getCustFinanceId() {
		return custFinanceId;
	}

	public void setCustFinanceId(Long custFinanceId) {
		this.custFinanceId = custFinanceId;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Integer getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public String getSignMobile() {
		return signMobile;
	}

	public void setSignMobile(String signMobile) {
		this.signMobile = signMobile;
	}

	public Long getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(Long formStatus) {
		this.formStatus = formStatus;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getProcInsId() {
		return procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	public Integer getRecovery() {
		return recovery;
	}

	public void setRecovery(Integer recovery) {
		this.recovery = recovery;
	}

	public String getDueStatus() {
		return dueStatus;
	}

	public void setDueStatus(String dueStatus) {
		this.dueStatus = dueStatus;
	}

}
