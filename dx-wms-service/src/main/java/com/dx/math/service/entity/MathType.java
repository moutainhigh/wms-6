/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MathType.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午7:03:49
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
 * 匹配规则类型 对象
 *
 * @author 朱道灵
 */
@Entity(name = "t_math_type")
public class MathType implements Serializable {

    /**
     * serialUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 匹配规则类型-编号 主键
     */
    private Long mathTypeId;

    /**
     * 匹配规则类型-名称
     */
    private String mathTypeName;

    /**
     * 匹配规则类型-标示
     */
    private String mathTypeKey;

    /**
     * 匹配规则类型-描述
     */
    private String mathTypeDesc;

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
     * @return the mathTypeId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "math_type_id")
    public Long getMathTypeId() {
        return mathTypeId;
    }

    /**
     * @param mathTypeId the mathTypeId to set
     */
    public void setMathTypeId(Long mathTypeId) {
        this.mathTypeId = mathTypeId;
    }

    /**
     * @return the mathTypeName
     */
    @Column(name = "math_type_name")
    public String getMathTypeName() {
        return mathTypeName;
    }

    /**
     * @param mathTypeName the mathTypeName to set
     */
    public void setMathTypeName(String mathTypeName) {
        this.mathTypeName = mathTypeName;
    }

    /**
     * @return the mathTypeKey
     */
    @Column(name = "math_type_key")
    public String getMathTypeKey() {
        return mathTypeKey;
    }

    /**
     * @param mathTypeKey the mathTypeKey to set
     */
    public void setMathTypeKey(String mathTypeKey) {
        this.mathTypeKey = mathTypeKey;
    }

    /**
     * @return the mathTypeDesc
     */
    @Column(name = "math_type_desc")
    public String getMathTypeDesc() {
        return mathTypeDesc;
    }

    /**
     * @param mathTypeDesc the mathTypeDesc to set
     */
    public void setMathTypeDesc(String mathTypeDesc) {
        this.mathTypeDesc = mathTypeDesc;
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
