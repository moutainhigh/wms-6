package com.dx.report.web.vo;

import java.math.BigDecimal;

public class ReportResultVo {
	
	private Integer index;
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
    private String productName;
    
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
    private String custCategory;
    
    /** 预计出借日期 */
    private String expectLenderDate;
    
    /** 生效时间*/
    private String settlementDate;
    
    /** 账单日*/
    private Integer statementDate;
    
    /** 支付方式-编号 */
    private String payWayName;
    
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
    
    /** 通讯地址 */
    private String address;
    
    /** 通讯地址-邮政编码 */
    private String zipCode;
    
    /** 营业部 */
    private String orgName;
    
    /** 团队编号 */
    private String teamName;
    
    /** 团队经理 */
    private String teamUserName;
    
    /** 客户经理 */
    private String createUser;
    
    /** 接受文件方式 */
    private String msgWay;
    
    /**大团名字*/
    private String clusterName;
    
    /**邮箱*/
    private String email;
    
    /**手机*/
    private String mobile;
    
    /**分公司*/
    private String branchOfficeName;
    
    /**区域*/
    private String areaName;
    
    /**匹配时间*/
    private String matchDate;

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	

	public BigDecimal getLenderAmount() {
		return lenderAmount;
	}

	public void setLenderAmount(BigDecimal lenderAmount) {
		this.lenderAmount = lenderAmount;
	}

	public String getCustCategory() {
		return custCategory;
	}

	public void setCustCategory(String custCategory) {
		this.custCategory = custCategory;
	}

	public String getExpectLenderDate() {
		return expectLenderDate;
	}

	public void setExpectLenderDate(String expectLenderDate) {
		this.expectLenderDate = expectLenderDate;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Integer getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Integer statementDate) {
		this.statementDate = statementDate;
	}

	

	public String getPayWayName() {
		return payWayName;
	}

	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getMsgWay() {
		return msgWay;
	}

	public void setMsgWay(String msgWay) {
		this.msgWay = msgWay;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getBranchOfficeName() {
		return branchOfficeName;
	}

	public void setBranchOfficeName(String branchOfficeName) {
		this.branchOfficeName = branchOfficeName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getTeamUserName() {
		return teamUserName;
	}

	public void setTeamUserName(String teamUserName) {
		this.teamUserName = teamUserName;
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

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	
	

    
    

}
