/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRuleVersionDetailDto.java
 * Author:   张祥韵
 * Date:     2015年11月6日 下午16:29:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.report.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 报表信息管理 数据返回结果Dto
 * 
 * @author 张祥韵
 *
 */
public class ReportVo implements Serializable{
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 签单日期
	 * */
	private String signDate;
	
	/**
	 * 出借编号
	 * */
	private String lenderCode;
	
	/**
	 * 客户姓名
	 * */
	private String custName;
	
	/**
	 * 性别
	 * */
	private Integer sex;
	
	/** 证件号码 */
    private String idCard;
	
	/** 
	 * 出借方式
	 **/
    private Long productId;
    
    /** 
     * 出借金额
     **/
    private BigDecimal lenderAmount;
    
    /** 客户分类 */
    private Integer custCategory;
    
    /** 预计出借日期 */
    private String expectLenderDateBegin;
    
    /** 生效时间*/
    private String settlementDate;
    
    /** 账单日*/
    private Integer statementDate;
    
    /** 支付方式-编号 */
    private Long payWayId;
    
    /** 划扣开户银行 */
    private String giveBankCategory;
    
    /** 划扣开户银行账号 */
    private String giveAccountNum;
    
    /** 回款开户银行 */
    private String getBankCategory;
    
    /** 回款开户银行账号 */
    private String getAccountNum;
    
    /** 户名 */
    private String accountName;
    
    /** 通讯地址-省区域-编码:{"NNNNNN"} */
    private String provinceRegionCode;
    
    /** 通讯地址-街道信息 */
    private String streetInfo;
    
    /** 通讯地址-邮政编码 */
    private String zipCode;
    
    /** 营业部编号 */
    private Long orgId;
    
    /** 团队编号 */
    private Long teamId;
    
    /** 客户经理 */
    private Long createUser;
    
    /** 接受文件方式 */
    private Integer msgWay;
    
    /**大团名字*/
    private String clusterName;
    
    /**
     * @return the signDate
     */
	public String getSignDate() {
		return signDate;
	}
	/**
     * @param signDate the signDate to set
     */
	public void setSignDate(String signDate) {
		this.signDate = signDate;
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
     * @return the custName
     */
	public String getCustName() {
		return custName;
	}
	/**
     * @param custName the custName to set
     */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
     * @return the sex
     */
	public Integer getSex() {
		return sex;
	}
	/**
     * @param sex the sex to set
     */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
     * @return the productId
     */
	public Long getProductId() {
		return productId;
	}
	/**
     * @param productId the productId to set
     */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
     * @return the lenderAmount
     */
	public BigDecimal getLenderAmount() {
		return lenderAmount;
	}
	/**
     * @param lenderAmount the lenderAmount to set
     */
	public void setLenderAmount(BigDecimal lenderAmount) {
		this.lenderAmount = lenderAmount;
	}
	/**
     * @return the custCategory
     */
	public Integer getCustCategory() {
		return custCategory;
	}
	/**
     * @param custCategory the custCategory to set
     */
	public void setCustCategory(Integer custCategory) {
		this.custCategory = custCategory;
	}
	/**
     * @return the expectLenderDateBegin
     */
	public String getExpectLenderDateBegin() {
		return expectLenderDateBegin;
	}
	/**
     * @param expectLenderDateBegin the expectLenderDateBegin to set
     */
	public void setExpectLenderDateBegin(String expectLenderDateBegin) {
		this.expectLenderDateBegin = expectLenderDateBegin;
	}
	/**
     * @return the settlementDate
     */
	public String getSettlementDate() {
		return settlementDate;
	}
	/**
     * @param settlementDate the settlementDate to set
     */
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	/**
     * @return the statementDate
     */
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
     * @return the payWayId
     */
	public Long getPayWayId() {
		return payWayId;
	}
	/**
     * @param payWayId the payWayId to set
     */
	public void setPayWayId(Long payWayId) {
		this.payWayId = payWayId;
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
	/**
     * @return the teamId
     */
	public Long getTeamId() {
		return teamId;
	}
	/**
     * @param teamId the teamId to set
     */
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	/**
     * @return the createUser
     */
	public Long getCreateUser() {
		return createUser;
	}
	/**
     * @param createUser the createUser to set
     */
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	/**
     * @return the msgWay
     */
	public Integer getMsgWay() {
		return msgWay;
	}
	/**
     * @param msgWay the msgWay to set
     */
	public void setMsgWay(Integer msgWay) {
		this.msgWay = msgWay;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getGiveBankCategory() {
		return giveBankCategory;
	}
	public void setGiveBankCategory(String giveBankCategory) {
		this.giveBankCategory = giveBankCategory;
	}
	public String getGiveAccountNum() {
		return giveAccountNum;
	}
	public void setGiveAccountNum(String giveAccountNum) {
		this.giveAccountNum = giveAccountNum;
	}
	public String getGetBankCategory() {
		return getBankCategory;
	}
	public void setGetBankCategory(String getBankCategory) {
		this.getBankCategory = getBankCategory;
	}
	public String getGetAccountNum() {
		return getAccountNum;
	}
	public void setGetAccountNum(String getAccountNum) {
		this.getAccountNum = getAccountNum;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getProvinceRegionCode() {
		return provinceRegionCode;
	}
	public void setProvinceRegionCode(String provinceRegionCode) {
		this.provinceRegionCode = provinceRegionCode;
	}
	public String getStreetInfo() {
		return streetInfo;
	}
	public void setStreetInfo(String streetInfo) {
		this.streetInfo = streetInfo;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
    
    
}
