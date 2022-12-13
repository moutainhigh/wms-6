/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccount.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午3:00:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 理财管理-客户账户表
 * 
 * @author 王蕊
 */
@Entity(name = "t_cust_account")
public class CustAccount implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** 客户账户-编号 */
    private Long custAccountId;

    /** 理财-客户-编码 */
    private String lenderCustCode;

    /** 客户编号 */
    private String custCode;

    /** 客户-姓名 */
    private String custName;

    /** 客户-姓名-拼音 */
    private String custNameSpell;

    /** 性别 */
    private Integer sex;

    /** 国籍 */
    private String nationality;

    /** 常用语言 */
    private Integer commonLanguage;

    /** 婚姻状况 */
    private Integer maritalStatus;

    /** 证件类型 */
    private Integer idType;

    /** 证件号码 */
    private String idCard;

    /** 出生日期 */
    private Date birthDate;

    /** 移动电话 */
    private String mobile;

    /** 最高学历 */
    private Integer education;

    /** 接受文件方式 */
    private Integer msgWay;

    /** 客户来源 */
    private Integer custSource;

    /** 客户来源-其他 */
    private String custSourceOther;

    /** 开户日期 */
    private Date openDate;

    /** 客户分类 */
    private Integer custCategory;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private Long createUser;

    /** 更新时间 */
    private Date updateTime;

    /** 更新人 */
    private Long updateUser;

    /** 数据状态 */
    private String dataStatus;

    /** 营业部编号 */
    private Long orgId;
    /** 团队编号 */
    private Long teamId;

    /**
     * @return the custAccountId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_account_id")
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * @param custAccountId the custAccountId to set
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * @return the lenderCustCode
     */
    @Column(name = "lender_cust_code")
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**
     * @param lenderCustCode the lenderCustCode to set
     */
    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    /**
     * @return the custName
     */
    @Column(name = "cust_name")
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
     * @return the custNameSpell
     */
    @Column(name = "cust_name_spell")
    public String getCustNameSpell() {
        return custNameSpell;
    }

    /**
     * @param custNameSpell the custNameSpell to set
     */
    public void setCustNameSpell(String custNameSpell) {
        this.custNameSpell = custNameSpell;
    }

    /**
     * @return the sex
     */
    @Column(name = "sex")
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
     * @return the nationality
     */
    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the commonLanguage
     */
    @Column(name = "common_language")
    public Integer getCommonLanguage() {
        return commonLanguage;
    }

    /**
     * @param commonLanguage the commonLanguage to set
     */
    public void setCommonLanguage(Integer commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    /**
     * @return the maritalStatus
     */
    @Column(name = "marital_status")
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the idType
     */
    @Column(name = "id_type")
    public Integer getIdType() {
        return idType;
    }

    /**
     * @param idType the idType to set
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * @return the idCard
     */
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the birthDate
     */
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the mobile
     */
    @Column(name = "mobile")
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
     * @return the education
     */
    @Column(name = "education")
    public Integer getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(Integer education) {
        this.education = education;
    }

    /**
     * @return the msgWay
     */
    @Column(name = "msg_way")
    public Integer getMsgWay() {
        return msgWay;
    }

    /**
     * @param msgWay the msgWay to set
     */
    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    /**
     * @return the custSource
     */
    @Column(name = "cust_source")
    public Integer getCustSource() {
        return custSource;
    }

    /**
     * @param custSource the custSource to set
     */
    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    /**
     * @return the custSourceOther
     */
    @Column(name = "cust_source_other")
    public String getCustSourceOther() {
        return custSourceOther;
    }

    /**
     * @param custSourceOther the custSourceOther to set
     */
    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    /**
     * @return the openDate
     */
    @Column(name = "open_date")
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * @param openDate the openDate to set
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /**
     * @return the custCategory
     */
    @Column(name = "cust_category")
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
     * @return the createTime
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the createUser
     */
    @Column(name = "create_user")
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
     * @return the updateTime
     */
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the updateUser
     */
    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return the dataStatus
     */
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * @param dataStatus the dataStatus to set
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
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

    /**
     * @return the custCode
     */
    @Column(name = "cust_code")
    public String getCustCode() {
        return custCode;
    }

    /**
     * @param custCode the custCode to set
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    private int group(List<LenderApplyLog> logs) {
        if (!Assert.checkParam(getLenderCustCode())) {
            return WMSConstants.UNAUTHERIZED;
        }
        if (!Assert.checkParam(logs)) {
            return WMSConstants.UNAUTHERIZED;
        }
        Boolean flag = false, resubmitFlag = false;
        for (LenderApplyLog log : logs) {
            if (Assert.equals(log.getCurrentStepKey(), WMSConstants.INVESTMENT_SUCCESS)) {
                return WMSConstants.CHECK_SUCCEED;
            }
            if (log.getCurrentStepKey().equals(WMSConstants.QUALITY_CHECK)
                    || log.getCurrentStepKey().equals(WMSConstants.INVESTMENT_CHECK)
                    || log.getCurrentStepKey().equals(WMSConstants.MATCH)
                    || log.getCurrentStepKey().equals(WMSConstants.CREDITOR_CONFIRM)
                    || log.getCurrentStepKey().equals(WMSConstants.CONTRIBUTIVE_CONFIRM)
                    || log.getCurrentStepKey().equals(WMSConstants.INVESTMENT_CONFIRM)) {
                flag = true;
                continue;
            }
            if (Assert.equals(log.getCurrentStepKey(), WMSConstants.RESUBMIT)) {
                resubmitFlag = true;
                continue;
            }

        }
        if (flag) {
            return WMSConstants.CHECKING;
        }
        if (resubmitFlag) {
            return WMSConstants.CHECK_FAILED;
        }
        return WMSConstants.UNAUTHERIZED;
    }

    public void status(List<LenderApplyLog> logs) {
        Integer status = group(logs);
        switch (status) {
            case WMSConstants.CHECKING:
                setDataStatus(WMSConstants.ACCOUNT_CHECKING);
                break;
            case WMSConstants.EDIT_CHECK_FAILED:
            case WMSConstants.CHECK_FAILED:
                setDataStatus(WMSConstants.ACCOUNT_CHECK_FAIL);
                break;
            case WMSConstants.CHECK_SUCCEED:
                setDataStatus(WMSConstants.ACCOUNT_CHECK_SUCCEED);
                break;
            default:
                setDataStatus(WMSConstants.ACCOUNT_UNAUTHERIZED);
                break;
        }
        setUpdateTime(new Date());
    }

}
