/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ReportManagementQueryVo.java
 * Author:   张祥韵
 * Date:     2015年11月19日 上午11:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;
/**
 * 报表信息管理查询QueryVo
 * 
 * @author zhangxiangyun
 */

public class FormParamVo {
	/** 出借方式 */
    private Long productId;
    /**出借金额 */
    private Integer lenderAmountArea;
    /**区域*/
    private Long areaOrgIds;
    /**分公司*/
    private Long branchOfficeIds;
    /**营业部*/
    private Long orgId;
    /**大团*/
    private Long cluster;
    /**团队*/
    private Long teamId;
    /** 账单日*/
    private Integer statementDate;
    /** 生效日期(始)*/
    private String settlementDateBeg;
    /** 生效日期(止)*/
    private String settlementDateEnd;
    /**客户姓名*/
    private String custName;
    /**用户姓名*/
    private Long createUser;
    /**销售客服查询组织Id*/
    private Long orgVoIdQuery;
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
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getCluster() {
		return cluster;
	}
	public void setCluster(Long cluster) {
		this.cluster = cluster;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public Integer getStatementDate() {
		return statementDate;
	}
	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}
	public String getSettlementDateBeg() {
		return settlementDateBeg;
	}
	public void setSettlementDateBeg(String settlementDateBeg) {
		this.settlementDateBeg = settlementDateBeg;
	}
	public String getSettlementDateEnd() {
		return settlementDateEnd;
	}
	public void setSettlementDateEnd(String settlementDateEnd) {
		this.settlementDateEnd = settlementDateEnd;
	}
	public Long getAreaOrgIds() {
		return areaOrgIds;
	}
	public void setAreaOrgIds(Long areaOrgIds) {
		this.areaOrgIds = areaOrgIds;
	}
	public Long getBranchOfficeIds() {
		return branchOfficeIds;
	}
	public void setBranchOfficeIds(Long branchOfficeIds) {
		this.branchOfficeIds = branchOfficeIds;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	public Long getOrgVoIdQuery() {
		return orgVoIdQuery;
	}
	public void setOrgVoIdQuery(Long orgVoIdQuery) {
		this.orgVoIdQuery = orgVoIdQuery;
	}
    
    
}
