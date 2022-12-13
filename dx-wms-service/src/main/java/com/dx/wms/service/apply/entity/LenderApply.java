package com.dx.wms.service.apply.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.service.account.entity.BaseAccount;

/**
 * 出借申请表
 *
 * @author 朱道灵
 */
@Entity(name = "t_lender_apply")
public class LenderApply extends BaseAccount {

    /**
     */
    private static final long serialVersionUID = -4924338264502098092L;

    /**
     * 出借申请编号 主键
     */
    private Long lenderApplyId;

    /**
     * 出借编号-规则
     */
    private String lenderCode;

    /**
     * 理财-客户-编码-规则
     */
    private String lenderCustCode;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 预计出借日期-起
     */
    private Date expectLenderDateBegin;

    /**
     * 预计出借日期-止
     */
    private Date expectLenderDateEnd;

    /**
     * 支付方式-编号
     */
    private Long payWayId;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 客户金融-编号
     */
    private Long custFinanceId;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 团队编号
     */
    private Long teamId;

    /**
     * 到账日
     */
    private Date settlementDate;

    /**
     * 账单日
     */
    private Integer statementDate;

    /**
     * 匹配日期
     */
    private Date matchDate;

    /**
     * 签约手机
     */
    private String signMobile;

    /**
     * 理财申请单状态
     */
    private Long formStatus;

    /**
     * 续投原理财ID
     */
    private Long parentId;

    /**
     * 到期日
     */
    private Date dueDate;

    /**
     * 流程实例ID
     */
    private String procInsId;

    /**
     * 回收方式
     */
    private Integer recovery;
    /**
     * 1已续投;0未续投(或者null)
     */
    private String dueStatus;

    public LenderApply() {

    }

    public LenderApply(Long accountId, String custCode) {
        setCustAccountId(accountId);
        setLenderCustCode(custCode);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public LenderApply setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
        return this;
    }

    @Column(name = "lender_code")
    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
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

    @Column(name = "contract_code")
    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    @Column(name = "settlement_date")
    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Column(name = "sign_mobile")
    public String getSignMobile() {
        return signMobile;
    }

    public void setSignMobile(String signMobile) {
        this.signMobile = signMobile;
    }

    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Column(name = "form_status")
    public Long getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

    @Column(name = "proc_ins_id")
    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    @Column(name = "match_date")
    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    @Column(name = "statement_date")
    public Integer getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
    }

    @Column(name = "recovery")
    public Integer getRecovery() {
        return recovery;
    }

    public void setRecovery(Integer recovery) {
        this.recovery = recovery;
    }

    public LenderApply setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
        return this;
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
}
