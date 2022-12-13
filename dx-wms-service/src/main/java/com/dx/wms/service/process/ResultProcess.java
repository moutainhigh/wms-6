package com.dx.wms.service.process;

import java.math.BigDecimal;
import java.sql.Date;

import com.dx.wms.common.BaseAttrDto;

/**
 * 业务明细质检 数据返回结果Dto
 * 
 * @author yangbao
 *
 */
public class ResultProcess extends BaseAttrDto {

    /** 
     */
    private static final long serialVersionUID = -1809490343158782019L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 身份证类型
     */
    private Integer idType;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生效日期
     */
    private Date settlementDate;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 账单日
     */
    private Integer statementDate;
    
    /**
     * 到期日
     */
    private Date dueDate;

    /**
     * 匹配日
     */
    private Date matchDate;

    /**
     * 支付方式
     */
    private Integer payWayId;

    /**
     * 理财申请单状态
     */
    private Long formStatus;

    /**
     * 出借申请编号
     */
    private Long lenderApplyId;

    /**
     * 客户账号编号
     */
    private Long custAccountId;

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
     * 父ID
     */
    private Long parentId;
    
    /**
     * 1已续投;0未续投(或者null)
     */
    private String dueStatus;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

	public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    public Long getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * @return the dueStatus
     */
    public String getDueStatus() {
        return dueStatus;
    }

    /**
     * @param dueStatus the dueStatus to set
     */
    public void setDueStatus(String dueStatus) {
        this.dueStatus = dueStatus;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
