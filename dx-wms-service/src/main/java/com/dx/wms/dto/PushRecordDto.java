package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PushRecordDto implements Serializable{

    /**
     */
    private static final long serialVersionUID = -4028874691299129266L;
    
    /** payWay 1,"汇款" 2,"委托划扣"3,"直接划扣" */
    private Integer payWayId;

    /** custName 客户姓名 */
    private String custName;

    /** certType 证件类型(1:身份证) */
    private Integer certType;

    /** certNo 证件号码 */
    private String certNo;

    /** mobileNo 手机号 */
    private String mobileNo;

    /** tradeAmount 交易金额 */
    private BigDecimal tradeAmount;

    /** bank 开户银行 */
    private Integer bankCategory;

    /** subBank 支行 */
    private String subBank;

    /** bankAccount 银行账号 */
    private String bankAccount;
    
    private String provinceRegionCode;
    
    private String cityRegionCode;
    
    private String lenderCode;
    
    /** signMobileNo 签约手机号 */
    private String signMobile;
    
    private Long parentId;
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
     * @return the bankCategory
     */
    public Integer getBankCategory() {
        return bankCategory;
    }

    /**
     * @param bankCategory the bankCategory to set
     */
    public void setBankCategory(Integer bankCategory) {
        this.bankCategory = bankCategory;
    }

    /**
     * @return the subBank
     */
    public String getSubBank() {
        return subBank;
    }

    /**
     * @param subBank the subBank to set
     */
    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    /**
     * @return the certType
     */
    public Integer getCertType() {
        return certType;
    }

    /**
     * @param certType the certType to set
     */
    public void setCertType(Integer certType) {
        this.certType = certType;
    }

    /**
     * @return the certNo
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * @param certNo the certNo to set
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the tradeAmount
     */
    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    /**
     * @param tradeAmount the tradeAmount to set
     */
    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * @return the bankAccount
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * @param bankAccount the bankAccount to set
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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
     * @return the cityRegionCode
     */
    public String getCityRegionCode() {
        return cityRegionCode;
    }

    /**
     * @param cityRegionCode the cityRegionCode to set
     */
    public void setCityRegionCode(String cityRegionCode) {
        this.cityRegionCode = cityRegionCode;
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
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSignMobile() {
        return signMobile;
    }

    public void setSignMobile(String signMobile) {
        this.signMobile = signMobile;
    }

}
