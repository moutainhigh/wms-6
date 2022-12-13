package com.dx.wms.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

/**
 * 
 * 基础实体
 *
 * @author tony
 */
public class BaseEntity implements Serializable {

    /**
     */
    private static final long serialVersionUID = -42605893577451549L;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 创建人
     */
    protected Long createUser;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 更新人
     */
    protected Long updateUser;

    /**
     * 数据状态
     */
    protected String dataStatus;

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateTime() {
        setUpdateTime(new Date());
    }

    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}
