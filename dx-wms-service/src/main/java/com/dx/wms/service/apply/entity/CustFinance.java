package com.dx.wms.service.apply.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.service.account.entity.BaseAccount;

/**
 * 
 * 客户金融表
 *
 * @author 王蕊
 */
@Entity(name = "t_cust_finance")
public class CustFinance extends BaseAccount {

    /**
     */
    private static final long serialVersionUID = -5032781047430179538L;

    /**
     * 客户金融-编号
     */
    private Long custFinanceId;

    /**
     * 理财申请-ID
     */
    private Long lenderApplyId;

    /**
     * 户名
     */
    private String accountName;

    /**
     * 开户银行
     */
    private String bankCategory;

    /**
     * 支行
     */
    private String subBank;

    /**
     * 账号
     */
    private String accountNum;

    /**
     * 账号类别
     */
    private Integer accountCategory;

    /**
     * 通讯地址-省区域-编码:{"NNNNNN"}
     */
    private String provinceRegionCode;

    /**
     * 通讯地址-市区域-编码:{"NNNNNN"}
     */
    private String cityRegionCode;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_finance_id")
    public Long getCustFinanceId() {
        return custFinanceId;
    }

    public void setCustFinanceId(Long custFinanceId) {
        this.custFinanceId = custFinanceId;
    }

    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "bank_category")
    public String getBankCategory() {
        return bankCategory;
    }

    public void setBankCategory(String bankCategory) {
        this.bankCategory = bankCategory;
    }

    @Column(name = "sub_bank")
    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    @Column(name = "account_num")
    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Column(name = "account_category")
    public Integer getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(Integer accountCategory) {
        this.accountCategory = accountCategory;
    }

    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    @Column(name = "province_region_code")
    public String getProvinceRegionCode() {
        return provinceRegionCode;
    }

    public void setProvinceRegionCode(String provinceRegionCode) {
        this.provinceRegionCode = provinceRegionCode;
    }

    @Column(name = "city_region_code")
    public String getCityRegionCode() {
        return cityRegionCode;
    }

    public void setCityRegionCode(String cityRegionCode) {
        this.cityRegionCode = cityRegionCode;
    }

    public CustFinance setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
        return this;
    }

}
