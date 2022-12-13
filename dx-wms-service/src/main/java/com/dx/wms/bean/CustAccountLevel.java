/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountLevel.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午4:30:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 客户账户级别表
 *
 * @author 王蕊
 */
@Entity(name = "t_cust_account_level")
public class CustAccountLevel implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 客户账户级别编号 */
    private Long custAccountLevelId;

    /** 客户开户编号 */
    private Long custAccountId;

    /** 理财客户编号-规则 */
    private String lenderCustCode;

    /** 账户级别编号 */
    private Long accountLevelId;

    /** 当前账户金额 */
    private BigDecimal accountCurrentAmount;

    /** 流向类型 */
    private Long flowCategory;

    /** 流向金额 */
    private BigDecimal flowAmount;

    /** 当前状态 */
    private Long isCurrent;

    /** 创建者 */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者 */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态 */
    private String dataStatus;
    
    /**
     * @return the custAccountLevelId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_account_level_id")
    public Long getCustAccountLevelId() {
        return custAccountLevelId;
    }

    /**
     * @param custAccountLevelId the custAccountLevelId to set
     */
    public void setCustAccountLevelId(Long custAccountLevelId) {
        this.custAccountLevelId = custAccountLevelId;
    }

    /**
     * @return the custAccountId
     */
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
     * @return the accountLevelId
     */
    @Column(name = "account_level_id")
    public Long getAccountLevelId() {
        return accountLevelId;
    }

    /**
     * @param accountLevelId the accountLevelId to set
     */
    public void setAccountLevelId(Long accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    /**
     * @return the accountCurrentAmount
     */
    @Column(name = "account_current_amount")
    public BigDecimal getAccountCurrentAmount() {
        return accountCurrentAmount;
    }

    /**
     * @param accountCurrentAmount the accountCurrentAmount to set
     */
    public void setAccountCurrentAmount(BigDecimal accountCurrentAmount) {
        this.accountCurrentAmount = accountCurrentAmount;
    }

    /**
     * @return the flowCategory
     */
    @Column(name = "flow_category")
    public Long getFlowCategory() {
        return flowCategory;
    }

    /**
     * @param flowCategory the flowCategory to set
     */
    public void setFlowCategory(Long flowCategory) {
        this.flowCategory = flowCategory;
    }

    /**
     * @return the flowAmount
     */
    @Column(name = "flow_amount")
    public BigDecimal getFlowAmount() {
        return flowAmount;
    }

    /**
     * @param flowAmount the flowAmount to set
     */
    public void setFlowAmount(BigDecimal flowAmount) {
        this.flowAmount = flowAmount;
    }

    /**
     * @return the isCurrent
     */
    @Column(name = "is_current")
    public Long getIsCurrent() {
        return isCurrent;
    }

    /**
     * @param isCurrent the isCurrent to set
     */
    public void setIsCurrent(Long isCurrent) {
        this.isCurrent = isCurrent;
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
    
}
