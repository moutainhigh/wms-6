/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MathSignType.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午5:06:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.math.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 债权匹配管理-符号类型对象
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_sign_type")
public class MathSignType implements Serializable {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 符号类型-编号 主键
     */
    private Long mathSignTypeId;

    /**
     * 符号类型-名称
     */
    private String mathSignTypeName;

    /**
     * 符号类型-标示
     */
    private String mathSignTypeKey;

    /**
     * 符号类型-描述
     */
    private String mathSignTypeDesc;

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
     * @return the mathSignTypeId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "math_sign_type_id")
    public Long getMathSignTypeId() {
        return mathSignTypeId;
    }

    /**
     * @param mathSignTypeId the mathSignTypeId to set
     */
    public void setMathSignTypeId(Long mathSignTypeId) {
        this.mathSignTypeId = mathSignTypeId;
    }

    /**
     * @return the mathSignTypeName
     */
    @Column(name = "math_sign_type_name")
    public String getMathSignTypeName() {
        return mathSignTypeName;
    }

    /**
     * @param mathSignTypeName the mathSignTypeName to set
     */
    public void setMathSignTypeName(String mathSignTypeName) {
        this.mathSignTypeName = mathSignTypeName;
    }

    /**
     * @return the mathSignTypeKey
     */
    @Column(name = "math_sign_type_key")
    public String getMathSignTypeKey() {
        return mathSignTypeKey;
    }

    /**
     * @param mathSignTypeKey the mathSignTypeKey to set
     */
    public void setMathSignTypeKey(String mathSignTypeKey) {
        this.mathSignTypeKey = mathSignTypeKey;
    }

    /**
     * @return the mathSignTypeDesc
     */
    @Column(name = "math_sign_type_Desc")
    public String getMathSignTypeDesc() {
        return mathSignTypeDesc;
    }

    /**
     * @param mathSignTypeDesc the mathSignTypeDesc to set
     */
    public void setMathSignTypeDesc(String mathSignTypeDesc) {
        this.mathSignTypeDesc = mathSignTypeDesc;
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

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}
