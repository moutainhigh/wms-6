/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: ExePoolResult.java
 * Author:   朱道灵
 * Date:     2016年5月11日 下午1:39:27
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.report.web.controller;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.web.controller.invest.OpenPoolResult;

/**
 * 每日匹配查询excel导出结果
 *
 * @author 朱道灵
 */
public class ExcPoolResult {

	/**
     * 申请日视图
     */
    private String signDateView;
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
    private String lenderAmountView;

    

    /**
     * 客户分类视图
     */
    private String custCategoryView;

    /**
     * 预计出借日期视图
     */
    private String lenderDateView;

    /**
     * 支付方式视图
     */
    private String payWayView;

    /**
     * 划扣银行视图
     */
    private String payBankView;

    /**
     * 划扣帐户
     */
    private String payAccountNum;

    /**
     * 划扣姓名(账户名)
     */
    private String payAccountName;

    /**
     * 回款银行视图
     */
    private String backBankView;

    /**
     * 回款帐户
     */
    private String backAccountNum;

    /**
     * 回款姓名（账户名）
     */
    private String backAccountName;

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
    private String billDayView;

    /**
     * 日期
     */
    private String dateView;
    
    
    public ExcPoolResult(){
        
    }

    public ExcPoolResult(OpenPoolResult pool){
        BeanUtils.copyProperties(pool, this);
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

    public String getLenderAmountView() {
        return lenderAmountView;
    }

    public void setLenderAmountView(String lenderAmountView) {
        this.lenderAmountView = lenderAmountView;
    }

    public String getSignDateView() {
        return signDateView;
    }

    public void setSignDateView(String signDateView) {
        this.signDateView = signDateView;
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

    public String getPayBankView() {
        return payBankView;
    }

    public void setPayBankView(String payBankView) {
        this.payBankView = payBankView;
    }

    public String getPayAccountNum() {
        return payAccountNum;
    }

    public void setPayAccountNum(String payAccountNum) {
        this.payAccountNum = payAccountNum;
    }

    public String getPayAccountName() {
        return payAccountName;
    }

    public void setPayAccountName(String payAccountName) {
        this.payAccountName = payAccountName;
    }

    public String getBackBankView() {
        return backBankView;
    }

    public void setBackBankView(String backBankView) {
        this.backBankView = backBankView;
    }

    public String getBackAccountNum() {
        return backAccountNum;
    }

    public void setBackAccountNum(String backAccountNum) {
        this.backAccountNum = backAccountNum;
    }

    public String getBackAccountName() {
        return backAccountName;
    }

    public void setBackAccountName(String backAccountName) {
        this.backAccountName = backAccountName;
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

    public String getBillDayView() {
        return billDayView;
    }

    public void setBillDayView(String billDayView) {
        this.billDayView = billDayView;
    }

    public String getDateView() {
        return dateView;
    }

    public void setDateView(String dateView) {
        this.dateView = dateView;
    }

}
