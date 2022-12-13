package com.dx.cmm.service.entitys;

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

    protected static final Long SYS = -1L;

    protected static final String INIT = "A";

    protected static final String DEL = "D";

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 数据状态
     */
    private String dataStatus;

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public BaseEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public BaseEntity setCreateTime() {
        return setCreateTime(new Date());
    }

    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    public BaseEntity setCreateUser(Long createUser) {
        this.createUser = createUser;
        return this;
    }

    public BaseEntity setCreateUser() {
        return setCreateUser(SYS);
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public BaseEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public BaseEntity setUpdateTime() {
        return setUpdateTime(new Date());
    }

    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    public BaseEntity setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    public BaseEntity setUpdateUser() {
        return setUpdateUser(SYS);
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public BaseEntity setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
        return this;
    }

    public BaseEntity setDataStatus() {
        return setDataStatus(INIT);
    }

    protected void insert() {
        setCreateUser().setCreateTime().setUpdateUser().setUpdateTime().setDataStatus();
    }
}
