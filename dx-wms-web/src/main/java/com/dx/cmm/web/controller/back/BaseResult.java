/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BaseResult.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午1:47:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.web.controller.back;

import java.io.Serializable;
import java.util.Map;

/**
 * 回款结果查询Vo
 *
 * @author 朱道灵
 */
public class BaseResult implements Serializable{

    /**
     */
    private static final long serialVersionUID = -4134204168675485710L;
    
    /**
     * 资金池编号
     */
    private Long poolId;
    
    /**
     * 主要业务id
     */
    private Long fundId;
      
    /**
     * 客户姓名
     */
    private String custName;
    
    /**
     * 身份证号
     */
    private String idCard;
    
    /**
     * 证件类型
     */
    private Integer idType;
    
    /**
     * 手机号
     */
    private String mobile;
    
    /**
     * 出借编号
     */
    private String lenderCode;
    
    /**
     * 出借方式
     */
    private Long productId;
    
    /**
     * 账单日
     */
    private Integer billDay;
    
    /**
     * 账单日视图
     */
    private String billDayView;
    
    /**
     * 出借方式视图
     */
    private String productName;
    
    /**
     * 回款银行
     */
    private Integer backBank;

    /**
     * 回款银行视图
     */
    private String backBankView;

    /**
     * 回款支行
     */
    private String backSubBank;

    /**
     * 回款帐户
     */
    private String backAccountNum;

    /**
     * 回款姓名（账户名）
     */
    private String backAccountName;
    
    /**
     * 城市编码
     */
    private String cityCode;
    
    /**
     * 省编码
     */
    private String provinceRegionCode;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void product(final Map<Long, String> product) {
        setProductName(product.get(getProductId()));
    }

    
    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public String getBillDayView() {
        return billDayView;
    }

    public void setBillDayView(String billDayView) {
        this.billDayView = billDayView;
    }

    public Integer getBackBank() {
        return backBank;
    }

    public void setBackBank(Integer backBank) {
        this.backBank = backBank;
    }

    public String getBackBankView() {
        return backBankView;
    }

    public void setBackBankView(String backBankView) {
        this.backBankView = backBankView;
    }

    public String getBackSubBank() {
        return backSubBank;
    }

    public void setBackSubBank(String backSubBank) {
        this.backSubBank = backSubBank;
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

    /**
     * @return the poolId
     */
    public Long getPoolId() {
        return poolId;
    }

    /**
     * @param poolId the poolId to set
     */
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    /**
     * @return the fundId
     */
    public Long getFundId() {
        return fundId;
    }

    /**
     * @param fundId the fundId to set
     */
    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the provinceRegionCode
     */
    public String getProvinceRegionCode() {
        return provinceRegionCode;
    }

    /**
     * @param provinceRegionCode the provinceRegionCode to set
     */
    public void setProvinceRegionCode(String provinceRegionCode) {
        this.provinceRegionCode = provinceRegionCode;
    }

    /**
     * @return the cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode the cityCode to set
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return the idType
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     * @param idType the idType to set
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    
}
