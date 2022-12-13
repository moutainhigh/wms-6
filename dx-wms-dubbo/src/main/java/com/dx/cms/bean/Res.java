/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Resources.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午10:51:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 内容管理表
 * 
 * @author 朱道灵
 */
@Entity(name = "t_res")
public class Res implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 资源编号 主键 */
    private Long resId;

    /** 资源名称 */
    private String resName;

    /** 系统-编码 */
    private String appCode;

    /** 资源-标示 */
    private String resKey;

    /** 资源-描述 */
    private String resDesc;

    /** 创建者:{"-1":"系统"} */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者:{"-1":"系统"} */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态:{"A":"已生效","D":"已删除"}； */
    private String dataStatus;

    /**
     * 资源编号 主键<br>
     *
     * @return the resId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "res_id")
    public Long getResId() {
        return resId;
    }

    /**
     * 资源编号 主键<br>
     *
     * @param resId the resId to set.
     * 
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * 资源名称 <br>
     *
     * @return the resName
     */
    @Column(name = "res_name")
    public String getResName() {
        return resName;
    }

    /**
     * 资源名称 <br>
     *
     * @param resName the resName to set.
     * 
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * 系统编码 <br>
     *
     * @return the appCode
     */
    @Column(name = "app_code")
    public String getAppCode() {
        return appCode;
    }

    /**
     * 资源名称 <br>
     *
     * @param appCode the appCode to set.
     * 
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * 资源标示 <br>
     *
     * @return the resKey
     */
    @Column(name = "res_key")
    public String getResKey() {
        return resKey;
    }

    /**
     * 资源标示<br>
     *
     * @param resKey the resKey to set.
     * 
     */
    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    /**
     * 资源-描述 <br>
     *
     * @return the resDesc
     */
    @Column(name = "res_desc")
    public String getRes_desc() {
        return resDesc;
    }

    /**
     * 资源-描述<br>
     *
     * @param resDesc the resDesc to set.
     * 
     */
    public void setRes_desc(String res_desc) {
        this.resDesc = res_desc;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @return the createUser
     */
    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @param createUser the createUser to set.
     */

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @return the createTime
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @param createTime the createTime to set.
     */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"}<br>
     *
     * @return the updateUser
     */
    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"} <br>
     *
     * @param updateUser the updateUser to set.
     */

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 功能描述: updateTime 更新时间 <br>
     *
     * @return the updateTime
     */

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 功能描述: 更新时间 <br>
     *
     * @param updateTime the updateTime to set.
     */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}；<br>
     *
     * @return the dataStatus
     */
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}<br>
     *
     * @param dataStatus the dataStatus to set.
     */

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
