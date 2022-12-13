/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRuleVersionDetailDto.java
 * Author:   张祥韵
 * Date:     2015年11月6日 下午16:29:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;

import java.util.Date;
import java.util.List;
/**
 * 报表信息管理 数据查询Dto
 * 
 * @author 张祥韵
 *
 */
public class FormParamDto {
	/** 出借方式 */
    private Long productId;
    /**出借金额 */
    private Integer lenderAmountArea;
    /**区域*/
    private List<Long> areaOrgIds;
    /**分公司*/
    private List<Long> branchOfficeIds;
    /**营业部*/
    private Long orgId;
    /**大团*/
    private List<Long> teamIds;
    /**团队*/
    private Long teamId;
    /** 账单日*/
    private Integer statementDate;
    /** 生效日期(始)*/
    private Date settlementDateBeg;
    /** 生效日期(止)*/
    private Date settlementDateEnd;
    
    
    private Long lenderApplyId;
    
    /**用户ID*/
    private Long createUser;
    
    /**客户姓名*/
    private String custName;
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
	
	public List<Long> getTeamIds() {
		return teamIds;
	}
	public void setTeamIds(List<Long> teamIds) {
		this.teamIds = teamIds;
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
	public Date getSettlementDateBeg() {
		return settlementDateBeg;
	}
	public void setSettlementDateBeg(Date settlementDateBeg) {
		this.settlementDateBeg = settlementDateBeg;
	}
	public Date getSettlementDateEnd() {
		return settlementDateEnd;
	}
	public void setSettlementDateEnd(Date settlementDateEnd) {
		this.settlementDateEnd = settlementDateEnd;
	}
	public List<Long> getAreaOrgIds() {
		return areaOrgIds;
	}
	public void setAreaOrgIds(List<Long> areaOrgIds) {
		this.areaOrgIds = areaOrgIds;
	}
	public List<Long> getBranchOfficeIds() {
		return branchOfficeIds;
	}
	public void setBranchOfficeIds(List<Long> branchOfficeIds) {
		this.branchOfficeIds = branchOfficeIds;
	}
	public Long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getLenderApplyId() {
		return lenderApplyId;
	}
	public void setLenderApplyId(Long lenderApplyId) {
		this.lenderApplyId = lenderApplyId;
	}
	
    
    
}
