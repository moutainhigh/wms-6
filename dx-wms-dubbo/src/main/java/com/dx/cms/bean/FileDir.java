/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileCatalog.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午11:18:02
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
 * 内容管理-文件目录表
 *
 * @author 朱道灵
 */
@Entity(name = "t_file_dir")
public class FileDir implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 文件目录-编号 主键 */
    private Long fileDirId;

    /** 文件目录-名称 */
    private String fileDirName;

    /** 文件目录-标示 */
    private String fileDirKey;

    /** 文件目录-级别 :{0:"根目录"}' */
    private Long fileDirLevel;

    /** 上级文件目录-编号 */
    private Long upFileDirId;

    /** 文件目录-描述 */
    private String fileDirDesc;

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
     * 内容管理-文件目录表 主键<br>
     *
     * @return the fileDirId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "file_dir_id")
    public Long getFileDirId() {
        return fileDirId;
    }

    /**
     * 内容管理-文件目录表 主键<br>
     *
     * @param fileDirId the fileDirId to set.
     * 
     */
    public void setFileDirId(Long fileDirId) {
        this.fileDirId = fileDirId;
    }

    /**
     * 文件目录名称<br>
     *
     * @return the fileDirName
     */
    @Column(name = "file_dir_name")
    public String getFileDirName() {
        return fileDirName;
    }

    /**
     * 文件目录名称<br>
     *
     * @param fileDirId the fileDirId to set.
     * 
     */
    public void setFileDirName(String fileDirName) {
        this.fileDirName = fileDirName;
    }

    /**
     * 文件目录-标示<br>
     *
     * @return the fileDirKey
     */
    @Column(name = "file_dir_key")
    public String getFileDirKey() {
        return fileDirKey;
    }

    /**
     * 文件目录-标示<br>
     *
     * @param fileDirKey the fileDirKey to set.
     * 
     */
    public void setFileDirKey(String fileDirKey) {
        this.fileDirKey = fileDirKey;
    }

    /**
     * 文件目录-级别:{0:"根目录"}<br>
     *
     * @return the fileDirLevel
     */
    @Column(name = "file_dir_level")
    public Long getFileDirLevel() {
        return fileDirLevel;
    }

    /**
     * 文件目录-级别:{0:"根目录"}<br>
     *
     * @param fileDirLevel the fileDirLevel to set.
     * 
     */
    public void setFileDirLevel(Long fileDirLevel) {
        this.fileDirLevel = fileDirLevel;
    }

    /**
     * 上级文件目录-编号:{0:"根目录"}<br>
     *
     * @return the upFileDirId
     */
    @Column(name = "up_file_dir_id")
    public Long getUpFileDirId() {
        return upFileDirId;
    }

    /**
     * 上级文件目录-编号:{0:"根目录"}<br>
     *
     * @param upFileDirId the upFileDirId to set.
     * 
     */
    public void setUpFileDirId(Long upFileDirId) {
        this.upFileDirId = upFileDirId;
    }

    /**
     * 文件目录-描述<br>
     *
     * @return the fileDirDesc
     */
    @Column(name = "file_dir_desc")
    public String getFileDirDesc() {
        return fileDirDesc;
    }

    /**
     * 文件目录-描述<br>
     *
     * @param fileDirDesc the fileDirDesc to set.
     * 
     */
    public void setFileDirDesc(String fileDirDesc) {
        this.fileDirDesc = fileDirDesc;
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
