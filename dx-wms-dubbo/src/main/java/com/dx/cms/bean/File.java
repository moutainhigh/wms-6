/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: File.java
 * Author:   朱道灵
 * Date:     2015年7月17日 上午11:45:17
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
 * 文件表
 * 
 * @author 朱道灵
 * 
 */
@Entity(name = "t_file")
public class File implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 文件-编号 主键 */
    private Long fileId;

    /** 文件类型-编号 */
    private Long fileTypeId;

    /** 文件-源名称 */
    private String fileSourceName;

    /** 文件-存储名称 */
    private String fileSaveName;

    /** 文件-大小-KB */
    private Long fileSize;

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
     * 文件-编号 主键 <br>
     *
     * @return the fileId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "file_id")
    public Long getFileId() {
        return fileId;
    }

    /**
     * 资源编号 主键<br>
     *
     * @param fileId the fileId to set.
     * 
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 文件类型-编号 <br>
     *
     * @return the fileTypeId
     */
    @Column(name = "file_type_id")
    public Long getFileTypeId() {
        return fileTypeId;
    }

    /**
     * 文件类型-编号<br>
     *
     * @param fileTypeId the fileTypeId to set.
     * 
     */
    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    /**
     * 文件-源名称 <br>
     *
     * @return the fileSourceName
     */
    @Column(name = "file_source_name")
    public String getFileSourceName() {
        return fileSourceName;
    }

    /**
     * 文件-源名称<br>
     *
     * @param fileSourceName the fileSourceName to set.
     * 
     */
    public void setFileSourceName(String fileSourceName) {
        this.fileSourceName = fileSourceName;
    }

    /**
     * 文件-存储名称 <br>
     *
     * @return the fileSaveName
     */
    @Column(name = "file_save_name")
    public String getFileSaveName() {
        return fileSaveName;
    }

    /**
     * 文件-存储名称<br>
     *
     * @param fileSaveName the fileSaveName to set.
     * 
     */
    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    /**
     * 文件-大小-KB<br>
     *
     * @return the fileSize
     */
    @Column(name = "file_size")
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 文件-大小-KB<br>
     *
     * @param fileSize the fileSize to set.
     * 
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
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
