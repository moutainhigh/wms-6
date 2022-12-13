/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileType.java
 * Author:   朱道灵
 * Date:     2015年7月17日 下午2:21:26
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
 * 文件类型表
 *
 * @author 朱道灵
 */
@Entity(name = "t_file_type")
public class FileType implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 文件类型-编号主键 */
    private Long fileTypeId;

    /** 文件类型-名称 */
    private String fileTypeName;

    /** 文件类型-标示 */
    private String fileTypeKey;

    /** 文件类型-描述 */
    private String fileDesc;

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
     * 文件类型-编号 主键 ；<br>
     *
     * @return the fileTypeId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "file_type_id")
    public Long getFileTypeId() {
        return fileTypeId;
    }

    /**
     * 文件类型-编号 主键 ；<br>
     *
     * @param fileTypeId the fileTypeId to set.
     * 
     */
    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    /**
     * 文件类型-名称；；<br>
     *
     * @return the fileTypeName;
     */
    @Column(name = "file_type_name")
    public String getFileTypeName() {
        return fileTypeName;
    }

    /**
     * 文件类型-名称；<br>
     *
     * @param fileTypeName; the fileTypeName to set.
     * 
     */
    public void setFileTypeName(String fileTypeName) {
        this.fileTypeName = fileTypeName;
    }

    /**
     * 文件类型-标示； <br>
     *
     * @return the fileTypeKey
     */
    @Column(name = "file_type_key")
    public String getFileTypeKey() {
        return fileTypeKey;
    }

    /**
     * 文件类型-标示；<br>
     *
     * @param fileTypeKey the fileTypeKey to set.
     * 
     */
    public void setFileTypeKey(String fileTypeKey) {
        this.fileTypeKey = fileTypeKey;
    }

    /**
     * 文件类型-描述； <br>
     *
     * @return the file_desc
     */
    @Column(name = "file_desc")
    public String getFile_desc() {
        return fileDesc;
    }

    /**
     * 文件类型-描述；<br>
     *
     * @param fileDesc the fileDesc to set.
     * 
     */
    public void setFile_desc(String fileDesc) {
        this.fileDesc = fileDesc;
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
