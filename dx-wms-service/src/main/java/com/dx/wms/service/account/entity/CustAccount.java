/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccount.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午3:00:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Trans2PinYin;
import com.dx.wms.common.BaseEntity;
import com.dx.wms.service.base.CustBase;

/**
 * 理财管理-客户账户表
 * 
 * @author 王蕊
 */
@Entity(name = "t_cust_account")
public class CustAccount extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -461578001845815705L;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 理财-客户-编码
     */
    private String lenderCustCode;

    /**
     * 客户编号
     */
    private String custCode;

    /**
     * 客户-姓名
     */
    private String custName;

    /**
     * 客户-姓名-拼音
     */
    private String custNameSpell;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 常用语言
     */
    private Integer commonLanguage;

    /**
     * 婚姻状况
     */
    private Integer maritalStatus;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 最高学历
     */
    private Integer education;

    /**
     * 接受文件方式
     */
    private Integer msgWay;

    /**
     * 客户来源
     */
    private Integer custSource;

    /**
     * 客户来源-其他
     */
    private String custSourceOther;

    /**
     * 开户日期
     */
    private Date openDate;

    /**
     * 客户分类
     */
    private Integer custCategory;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 团队编号
     */
    private Long teamId;

    /**
     * 开户日期
     */
    private Date accountTime;

    public CustAccount() {

    }

    public CustAccount(CustBase base) {
        BeanUtils.copyProperties(base, this);
        setCustNameSpell();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_account_id")
    public Long getCustAccountId() {
        return custAccountId;
    }

    public CustAccount setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
        return this;
    }

    @Column(name = "lender_cust_code")
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public CustAccount setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
        return this;
    }

    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Column(name = "cust_name_spell")
    public String getCustNameSpell() {
        return custNameSpell;
    }

    public CustAccount setCustNameSpell(String custNameSpell) {
        this.custNameSpell = custNameSpell;
        return this;
    }

    public CustAccount setCustNameSpell() {
        return setCustNameSpell(Trans2PinYin.getPinYin(getCustName()));
    }

    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "common_language")
    public Integer getCommonLanguage() {
        return commonLanguage;
    }

    public void setCommonLanguage(Integer commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    @Column(name = "marital_status")
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Column(name = "id_type")
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "education")
    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    @Column(name = "msg_way")
    public Integer getMsgWay() {
        return msgWay;
    }

    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    @Column(name = "cust_source")
    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    @Column(name = "cust_source_other")
    public String getCustSourceOther() {
        return custSourceOther;
    }

    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    @Column(name = "open_date")
    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Column(name = "cust_category")
    public Integer getCustCategory() {
        return custCategory;
    }

    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
    }

    @Column(name = "org_id")
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Column(name = "team_id")
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Column(name = "cust_code")
    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    @Column(name = "account_time")
    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }
}
