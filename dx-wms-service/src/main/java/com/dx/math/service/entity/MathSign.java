/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MathSign.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午4:51:29
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
 * 债权匹配管理-符号-编号对象<br>
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_sign")
public class MathSign implements Serializable {

    /**
     * serialUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 符号-编号 主键
     */
    private Long mathSignId;

    /**
     * 符号类型-编号
     */
    private Long mathSignTypeId;

    /**
     * 符号-名称
     */
    private String mathSignName;

    /**
     * 符号-标示
     */
    private String mathSignKey;

    /**
     * 符号-描述
     */
    private String mathSignDesc;

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
     * @return the mathSignId
     */

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_sign_id")
    public Long getMathSignId() {
        return mathSignId;
    }

    /**
     * @param mathSignId the mathSignId to set
     */
    public void setMathSignId(Long mathSignId) {
        this.mathSignId = mathSignId;
    }

    /**
     * @return the mathSignTypeId
     */
    @Column(name = "match_sign_type_id")
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
     * @return the mathSignName
     */
    @Column(name = "match_sign_name")
    public String getMathSignName() {
        return mathSignName;
    }

    /**
     * @param mathSignName the mathSignName to set
     */
    public void setMathSignName(String mathSignName) {
        this.mathSignName = mathSignName;
    }

    /**
     * @return the mathSignKey
     */
    @Column(name = "match_sign_key")
    public String getMathSignKey() {
        return mathSignKey;
    }

    /**
     * @param mathSignKey the mathSignKey to set
     */
    public void setMathSignKey(String mathSignKey) {
        this.mathSignKey = mathSignKey;
    }

    /**
     * @return the mathSignDesc
     */
    @Column(name = "match_sign_desc")
    public String getMathSignDesc() {
        return mathSignDesc;
    }

    /**
     * @param mathSignDesc the mathSignDesc to set
     */
    public void setMathSignDesc(String mathSignDesc) {
        this.mathSignDesc = mathSignDesc;
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
