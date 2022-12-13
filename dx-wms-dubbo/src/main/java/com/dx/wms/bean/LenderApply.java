/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApply.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午6:38:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 出借申请表 实体类
 *
 * @author 朱道灵
 */
@Entity(name = "t_lender_apply")
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

    /**
     * @return the lenderApplyId
     */

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    @Column(name = "lender_code")
    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    @Column(name = "cust_account_id")
    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    @Column(name = "lender_cust_code")
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "expect_lender_date_begin")
    public Date getExpectLenderDateBegin() {
        return expectLenderDateBegin;
    }

    public void setExpectLenderDateBegin(Date expectLenderDateBegin) {
        this.expectLenderDateBegin = expectLenderDateBegin;
    }

    @Column(name = "expect_lender_date_end")
    public Date getExpectLenderDateEnd() {
        return expectLenderDateEnd;
    }

    public void setExpectLenderDateEnd(Date expectLenderDateEnd) {
        this.expectLenderDateEnd = expectLenderDateEnd;
    }

    @Column(name = "pay_way_id")
    public Long getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Long payWayId) {
        this.payWayId = payWayId;
    }

    @Column(name = "lender_amount")
    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    @Column(name = "cust_finance_id")
    public Long getCustFinanceId() {
        return custFinanceId;
    }

    public void setCustFinanceId(Long custFinanceId) {
        this.custFinanceId = custFinanceId;
    }

    @Column(name = "sign_date")
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Column(name = "org_id")
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Column(name = "team_id")
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the contractCode
     */
    @Column(name = "contract_code")
    public String getContractCode() {
        return contractCode;
    }

    /**
     * @param contractCode the contractCode to set
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * @return the settlementDate
     */
    @Column(name = "settlement_date")
    public Date getSettlementDate() {
        return settlementDate;
    }

    /**
     * @param settlementDate the settlementDate to set
     */
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * @return the signMobile
     */
    @Column(name = "sign_mobile")
    public String getSignMobile() {
        return signMobile;
    }

    /**
     * @param signMobile the signMobile to set
     */
    public void setSignMobile(String signMobile) {
        this.signMobile = signMobile;
    }

    /**
     * @return the flagId
     */
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the dueDate
     */
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the formStatus
     */
    @Column(name = "form_status")
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
     * @return the procInsId
     */
    @Column(name = "proc_ins_id")
    public String getProcInsId() {
        return procInsId;
    }

    /**
     * @param procInsId the procInsId to set
     */
    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    /**
     * @return the matchDate
     */
    @Column(name = "match_date")
    public Date getMatchDate() {
        return matchDate;
    }

    /**
     * @param matchDate the matchDate to set
     */
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    /**
     * @return the statementDate
     */
    @Column(name = "statement_date")
    public Integer getStatementDate() {
        return statementDate;
    }

    /**
     * @param statementDate the statementDate to set
     */
    public void setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
    }

    /**
     * @return the recovery
     */
    @Column(name = "recovery")
    public Integer getRecovery() {
        return recovery;
    }

    /**
     * @param recovery the recovery to set
     */
    public void setRecovery(Integer recovery) {
        this.recovery = recovery;
    }

    /**
     * @return the dueStatus
     */
    @Column(name = "due_status")
    public String getDueStatus() {
        return dueStatus;
    }

    /**
     * @param dueStatus the dueStatus to set
     */
    public void setDueStatus(String dueStatus) {
        this.dueStatus = dueStatus;
    }

    public void due(Date dueDate) {
        setDueDate(dueDate);
        setUpdateTime(new Date());
    }

    public void match(Integer statementDate, Date matchDate) {
        setStatementDate(statementDate);
        setMatchDate(matchDate);
        setFormStatus(15L);
        setUpdateTime(new Date());
    }
}
