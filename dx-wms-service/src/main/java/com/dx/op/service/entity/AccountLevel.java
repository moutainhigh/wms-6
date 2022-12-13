/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountLevel.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午3:37:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 运营管理-账户级别表<br>
 * 运营管理-账户级别表
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity(name = "t_account_level")
public class AccountLevel implements Serializable {

    /**
     */
    private static final long serialVersionUID = -1277310784254371308L;

    /**
     * 运营管理-账户级别编号
     */
    private Long accountLevelId;

    /**
     * 运营管理-账户级别名称
     */
    private String accountLevelName;

    /**
     * 运营管理-账户标准
     */
    private String accountStandard;

    /**
     * 运营管理-收费对象
     */
    private String tollObject;

    /**
     * 运营管理-收费时间
     */
    private String tollTime;

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
     * 数据状态:{"A":"已生效","D":"已删除"}
     */
    private String dataStatus;

    /**
     * @return the accountLevelId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
     * @return the accountLevelName
     */
    @Column(name = "account_level_name")
    public String getAccountLevelName() {
        return accountLevelName;
    }

    /**
     * @param accountLevelName the accountLevelName to set
     */
    public void setAccountLevelName(String accountLevelName) {
        this.accountLevelName = accountLevelName;
    }

    /**
     * @return the accountStandard
     */
    @Column(name = "account_standard")
    public String getAccountStandard() {
        return accountStandard;
    }

    /**
     * @param accountStandard the accountStandard to set
     */
    public void setAccountStandard(String accountStandard) {
        this.accountStandard = accountStandard;
    }

    /**
     * @return the tollObject
     */
    @Column(name = "toll_object")
    public String getTollObject() {
        return tollObject;
    }

    /**
     * @param tollObject the tollObject to set
     */
    public void setTollObject(String tollObject) {
        this.tollObject = tollObject;
    }


    /**
     * @return the tollTime
     */
    @Column(name = "toll_time")
    public String getTollTime() {
        return tollTime;
    }

    /**
     * @param tollTime the tollTime to set
     */
    public void setTollTime(String tollTime) {
        this.tollTime = tollTime;
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
