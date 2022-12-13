/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: ExePoolResult.java
 * Author:   朱道灵
 * Date:     2016年5月11日 下午1:39:27
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.web.controller.invest;

import org.springframework.beans.BeanUtils;

/**
 * 每日匹配查询excel导出结果
 *
 * @author 朱道灵
 */
public class ExcOpenPoolResult {

	/**
     * 申请日视图
     */
    private String applyDateView;
    
    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 性别
     */
    private String sexView;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 出借方式
     */
    private String productName;

    /**
     * 出借金额
     */
    private String initTotalAmountView; 

    /**
     * 客户分类视图
     */
    private String custCategoryView;

    /**
     * 预计出借日期视图
     */
    private String lenderDateView;
    
    /**
     * 投资生效日
     */
    private String effectTimeView;

    /**
     * 支付方式视图
     */
    private String payWayView;

    /**
     * 划扣银行视图
     */
    private String buckleBankCategoryView;

    /**
     * 划扣帐户
     */
    private String buckleAccountNum;

    /**
     * 划扣姓名(账户名)
     */
    private String buckleAccountName;

    /**
     * 回款银行视图
     */
    private String returnBankCategoryView;

    /**
     * 回款帐户
     */
    private String returnAccountNum;

    /**
     * 回款姓名（账户名）
     */
    private String returnAccountName;

    /**
     * 客户地址
     */
    private String custAddress;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 团队主管视图
     */
    private String teamView;

    /**
     * 客户经理视图
     */
    private String managerView;

    /**
     * 区域
     */
    private String area;

    /**
     * 营业部视图
     */
    private String orgIdView;

    /**
     * 接受文件方式视图
     */
    private String msgWayView;

    /**
     * email
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 账单日视图
     */
    private Integer billDay;

    /**
     * 日期
     */
    private String initMatchTimeView;
    
    
    public ExcOpenPoolResult(){
        
    }
    
    public ExcOpenPoolResult(OpenPoolResult Pool){
        BeanUtils.copyProperties(Pool, this);
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

    public String getSexView() {
        return sexView;
    }

    public void setSexView(String sexView) {
        this.sexView = sexView;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public String getApplyDateView() {
        return applyDateView;
    }

    public void setApplyDateView(String applyDateView) {
        this.applyDateView = applyDateView;
    }

    public String getCustCategoryView() {
        return custCategoryView;
    }

    public void setCustCategoryView(String custCategoryView) {
        this.custCategoryView = custCategoryView;
    }

    public String getLenderDateView() {
        return lenderDateView;
    }

    public void setLenderDateView(String lenderDateView) {
        this.lenderDateView = lenderDateView;
    }

    public String getPayWayView() {
        return payWayView;
    }

    public void setPayWayView(String payWayView) {
        this.payWayView = payWayView;
    }

    public String getBuckleBankCategoryView() {
        return buckleBankCategoryView;
    }

    public void setBuckleBankCategoryView(String buckleBankCategoryView) {
        this.buckleBankCategoryView = buckleBankCategoryView;
    }

    public String getBuckleAccountNum() {
        return buckleAccountNum;
    }

    public void setBuckleAccountNum(String buckleAccountNum) {
        this.buckleAccountNum = buckleAccountNum;
    }

    public String getBuckleAccountName() {
        return buckleAccountName;
    }

    public void setBuckleAccountName(String buckleAccountName) {
        this.buckleAccountName = buckleAccountName;
    }

    public String getReturnBankCategoryView() {
        return returnBankCategoryView;
    }

    public void setReturnBankCategoryView(String returnBankCategoryView) {
        this.returnBankCategoryView = returnBankCategoryView;
    }

    public String getReturnAccountNum() {
        return returnAccountNum;
    }

    public void setReturnAccountNum(String returnAccountNum) {
        this.returnAccountNum = returnAccountNum;
    }

    public String getReturnAccountName() {
        return returnAccountName;
    }

    public void setReturnAccountName(String returnAccountName) {
        this.returnAccountName = returnAccountName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTeamView() {
        return teamView;
    }

    public void setTeamView(String teamView) {
        this.teamView = teamView;
    }

    public String getManagerView() {
        return managerView;
    }

    public void setManagerView(String managerView) {
        this.managerView = managerView;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOrgIdView() {
        return orgIdView;
    }

    public void setOrgIdView(String orgIdView) {
        this.orgIdView = orgIdView;
    }

    public String getMsgWayView() {
        return msgWayView;
    }

    public void setMsgWayView(String msgWayView) {
        this.msgWayView = msgWayView;
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

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public String getInitMatchTimeView() {
        return initMatchTimeView;
    }

    public void setInitMatchTimeView(String initMatchTimeView) {
        this.initMatchTimeView = initMatchTimeView;
    }

	public String getEffectTimeView() {
		return effectTimeView;
	}

	public void setEffectTimeView(String effectTimeView) {
		this.effectTimeView = effectTimeView;
	}

}
