/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchBizBaseAccount.java
 * Author:   朱道灵
 * Date:     2015年7月27日 下午3:04:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 债券匹配管理-匹配业务基础账户实体
 * 
 * @author tony
 */
@Entity(name = "t_match_biz_base_account")
public class MatchBizBaseAccount implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4044671308816523193L;

    /**
     * 匹配业务基础账户-编号 主键
     */
    private Long matchBizBaseAccountId;

    /**
     * 匹配业务基础-编号
     */
    private Long matchBizBaseId;

    /**
     * 匹配业务基础账户-户名
     */
    private String baseAccountName;

    /**
     * 匹配业务基础账户-开户行
     */
    private String baseAccountBank;

    /**
     * 匹配业务基础账户-开户行支行
     */
    private String baseAccountBankSub;

    /**
     * 匹配业务基础账户-账号
     */
    private String baseAccount;

    /**
     * 账号类别:{1:"汇款",2:"回款",3:"支付",4:"其他"}
     */
    private Integer baseAccountCategory;

    /**
     * 创建者:{"-1":"系统"}
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者:{"-1":"系统"}
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据状态
     */
    private String dataStatus;

    public MatchBizBaseAccount() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_biz_base_account_id")
    public Long getMatchBizBaseAccountId() {
        return matchBizBaseAccountId;
    }

    public void setMatchBizBaseAccountId(Long matchBizBaseAccountId) {
        this.matchBizBaseAccountId = matchBizBaseAccountId;
    }

    @Column(name = "match_biz_base_id")
    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    @Column(name = "base_account_name")
    public String getBaseAccountName() {
        return baseAccountName;
    }

    public void setBaseAccountName(String baseAccountName) {
        this.baseAccountName = baseAccountName;
    }

    @Column(name = "base_account_bank")
    public String getBaseAccountBank() {
        return baseAccountBank;
    }

    public void setBaseAccountBank(String baseAccountBank) {
        this.baseAccountBank = baseAccountBank;
    }

    @Column(name = "base_account_bank_sub")
    public String getBaseAccountBankSub() {
        return baseAccountBankSub;
    }

    public void setBaseAccountBankSub(String baseAccountBankSub) {
        this.baseAccountBankSub = baseAccountBankSub;
    }

    @Column(name = "base_account")
    public String getBaseAccount() {
        return baseAccount;
    }

    public void setBaseAccount(String baseAccount) {
        this.baseAccount = baseAccount;
    }

    @Column(name = "base_account_category")
    public Integer getBaseAccountCategory() {
        return baseAccountCategory;
    }

    public void setBaseAccountCategory(Integer baseAccountCategory) {
        this.baseAccountCategory = baseAccountCategory;
    }

    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public MatchBizBaseAccount setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public MatchBizBaseAccount setUpdateTime() {
        return setUpdateTime(new Date());
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
