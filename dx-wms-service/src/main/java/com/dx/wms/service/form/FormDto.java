/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRuleVersionDetailDto.java
 * Author:   张祥韵
 * Date:     2015年11月6日 下午16:29:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 报表信息管理 数据返回结果Dto
 * 
 * @author 张祥韵
 *
 */
public class FormDto implements Serializable{
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 签单日期
	 * */
	private Date signDate;
	
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
    
    /** 
   	 * 总投资数
   	 **/
    private Integer investment;
       
       /** 
        * 总金额
        **/
    private BigDecimal allLenderAmount;
    
    /** 客户分类 */
    private Integer custCategory;
    
    /** 预计出借日期开始 */
    private Date expectLenderDateBegin;
    
    /** 预计出借日期结束 */
    private Date expectLenderDateEnd;
    
    /** 生效时间*/
    private Date settlementDate;
    
    /** 账单日*/
    private Integer statementDate;
    
    /** 支付方式-编号 */
    private Integer payWayId;
    
    /** 划扣开户银行 */
    private Integer giveBankCategory;
    
    /** 划扣开户银行账号 */
    private String giveAccountNum;
    /** 划扣开户银行支行 */
    private String giveSubBank;
    /** 划扣开户银行省 */
    private String giveProvinceRegionCode;
    /** 划扣开户银行市 */
    private String giveCityRegionCode;
    
    /** 回款开户银行 */
    private Integer getBankCategory;
    
    /** 回款开户银行账号 */
    private String getAccountNum;
    /** 回款开户银行支行 */
    private String getSubBank;
    /** 回款开户银行省 */
    private String getProvinceRegionCode;
    /** 回款开户银行市 */
    private String getCityRegionCode;
    /** 户名 */
    private String accountName;
    
    /** 通讯地址-市区域-编码:{"NNNNNN"} */
    private String cityRegionCode;
    
    /** 通讯地址-省区域-编码:{"NNNNNN"} */
    private String provinceRegionCode;
    
    /** 通讯地址-区区域-编码:{"NNNNNN"} */
    private String districtRegionCode;
    
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
    
    /**邮箱*/
    private String email;
    
    /**手机*/
    private String mobile;
    
    /**匹配时间*/
    private Date matchDate;
    /**
     * @return the signDate
     */
	public Date getSignDate() {
		return signDate;
	}
	/**
     * @param signDate the signDate to set
     */
	public void setSignDate(Date signDate) {
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
	public Date getExpectLenderDateBegin() {
		return expectLenderDateBegin;
	}
	/**
     * @param expectLenderDateBegin the expectLenderDateBegin to set
     */
	public void setExpectLenderDateBegin(Date expectLenderDateBegin) {
		this.expectLenderDateBegin = expectLenderDateBegin;
	}
	/**
     * @return the settlementDate
     */
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
	public Integer getPayWayId() {
		return payWayId;
	}
	/**
     * @param payWayId the payWayId to set
     */
	public void setPayWayId(Integer payWayId) {
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
	public Integer getGiveBankCategory() {
		return giveBankCategory;
	}
	public void setGiveBankCategory(Integer giveBankCategory) {
		this.giveBankCategory = giveBankCategory;
	}
	public String getGiveAccountNum() {
		return giveAccountNum;
	}
	public void setGiveAccountNum(String giveAccountNum) {
		this.giveAccountNum = giveAccountNum;
	}
	public Integer getGetBankCategory() {
		return getBankCategory;
	}
	public void setGetBankCategory(Integer getBankCategory) {
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
	public String getDistrictRegionCode() {
		return districtRegionCode;
	}
	public void setDistrictRegionCode(String districtRegionCode) {
		this.districtRegionCode = districtRegionCode;
	}
	public String getCityRegionCode() {
		return cityRegionCode;
	}
	public void setCityRegionCode(String cityRegionCode) {
		this.cityRegionCode = cityRegionCode;
	}
	public Date getExpectLenderDateEnd() {
		return expectLenderDateEnd;
	}
	public void setExpectLenderDateEnd(Date expectLenderDateEnd) {
		this.expectLenderDateEnd = expectLenderDateEnd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getInvestment() {
		return investment;
	}
	public void setInvestment(Integer investment) {
		this.investment = investment;
	}
	public BigDecimal getAllLenderAmount() {
		return allLenderAmount;
	}
	public void setAllLenderAmount(BigDecimal allLenderAmount) {
		this.allLenderAmount = allLenderAmount;
	}
	public String getGiveSubBank() {
		return giveSubBank;
	}
	public void setGiveSubBank(String giveSubBank) {
		this.giveSubBank = giveSubBank;
	}
	public String getGiveProvinceRegionCode() {
		return giveProvinceRegionCode;
	}
	public void setGiveProvinceRegionCode(String giveProvinceRegionCode) {
		this.giveProvinceRegionCode = giveProvinceRegionCode;
	}
	public String getGiveCityRegionCode() {
		return giveCityRegionCode;
	}
	public void setGiveCityRegionCode(String giveCityRegionCode) {
		this.giveCityRegionCode = giveCityRegionCode;
	}
	public String getGetSubBank() {
		return getSubBank;
	}
	public void setGetSubBank(String getSubBank) {
		this.getSubBank = getSubBank;
	}
	public String getGetProvinceRegionCode() {
		return getProvinceRegionCode;
	}
	public void setGetProvinceRegionCode(String getProvinceRegionCode) {
		this.getProvinceRegionCode = getProvinceRegionCode;
	}
	public String getGetCityRegionCode() {
		return getCityRegionCode;
	}
	public void setGetCityRegionCode(String getCityRegionCode) {
		this.getCityRegionCode = getCityRegionCode;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
    
    
}
