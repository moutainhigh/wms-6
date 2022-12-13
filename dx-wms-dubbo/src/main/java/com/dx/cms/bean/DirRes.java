/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: DirRes.java
 * Author:   朱道灵
 * Date:     2015年7月17日 下午2:40:56
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
 * 目录资源表
 *
 * @author 朱道灵
 */
@Entity(name = "t_dir_res")
public class DirRes implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 目录资源-编号 主键 */
    private Long dirResId;

    /** 资源-编号 */
    private Long resId;

    /** 目录-编号 */
    private Long dirId;

    /** 目录资源-顺位 */
    private Long dirResIndex;

    /** 目录资源-是否编辑:{1:"是",0:"否"} */
    private Integer isEdit;

    /** 目录资源-标示 */
    private Integer dirResKey;

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
     * 目录资源-编号 主键 ；<br>
     *
     * @return the dirResId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "file_dir_res_id")
    public Long getDirResId() {
        return dirResId;
    }

    /**
     * 目录资源-编号 主键 ；<br>
     *
     * @param dirResId the dirResId to set.
     * 
     */
    public void setDirRes(Long dirResId) {
        this.dirResId = dirResId;
    }

    /**
     * 资源-编号 <br>
     *
     * @return the resId
     */
    @Column(name = "res_id")
    public Long getResId() {
        return resId;
    }

    /**
     * 资源-编号；<br>
     *
     * @param resId the resId to set.
     * 
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * 目录-编号 <br>
     *
     * @return the dirId
     */
    @Column(name = "dir_id")
    public Long getDirId() {
        return dirId;
    }

    /**
     * 目录-编号；<br>
     *
     * @param dirId the dirId to set.
     * 
     */
    public void setDirId(Long dirId) {
        this.dirId = dirId;
    }

    /**
     * 目录资源-顺位<br>
     *
     * @return the dirResIndex
     */
    @Column(name = "dir_Res_Index")
    public Long getDirResIndex() {
        return dirResIndex;
    }

    /**
     * 目录资源-顺位<br>
     *
     * @param dirResIndex the dirResIndex to set.
     * 
     */
    public void setDirResIndex(Long dirResIndex) {
        this.dirResIndex = dirResIndex;
    }

    /**
     * 目录资源-是否编辑:{1:"是",0:"否"}
     *
     * @return the isEdit
     */
    @Column(name = "is_edit")
    public Integer getIsEdit() {
        return isEdit;
    }

    /**
     * 目录资源-是否编辑:{1:"是",0:"否"}
     *
     * @param isEdit the isEdit to set.
     * 
     */
    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    /**
     * 目录资源-标示
     *
     * @return the dirResKey
     */
    @Column(name = "dir_reskey")
    public Integer getDirResKey() {
        return dirResKey;
    }

    /**
     * 目录资源-标示
     *
     * @param dirResKey the dirResKey to set.
     * 
     */
    public void setDirResKey(Integer dirResKey) {
        this.dirResKey = dirResKey;
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
