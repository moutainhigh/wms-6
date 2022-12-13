/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileDirRelation.java
 * Author:   朱道灵
 * Date:     2015年7月17日 下午12:05:45
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
 * 文件目录关系表
 *
 * @author 朱道灵
 */

@Entity(name = "t_file_dir_relation")
public class FileDirRelation implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 文件目录关系-编号 主键 */
    private Long fileDirRelationId;

    /** 文件目录-编号 */
    private Long fileDirId;

    /** 文件-编号 */
    private Long fileId;

    /** 文件-存储路径{"/dir1/"} */
    private String fileSaveDir;

    /** 文件-别名 */
    private String fileNickname;

    /** 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"} */
    private String appCode;

    /** 开放-编码 */
    private String openCode;

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
     * 文件目录关系-编号 主键 ；<br>
     *
     * @return the fileDirRelationId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "file_dir_relation_id")
    public Long getFileDirRelationId() {
        return fileDirRelationId;
    }

    /**
     * 文件目录关系-编号 主键 ；<br>
     *
     * @param fileDirRelationId the fileDirRelationId to set.
     * 
     */
    public void setFileDirRelationId(Long fileDirRelationId) {
        this.fileDirRelationId = fileDirRelationId;
    }

    /**
     * 文件目录-编号 <br>
     *
     * @return the fileDirId;
     */
    @Column(name = "file_dir_id")
    public Long getFileDirId() {
        return fileDirId;
    }

    /**
     * 文件目录-编号；<br>
     *
     * @param fileDirId the fileDirId to set.
     * 
     */
    public void setFileDirId(Long fileDirId) {
        this.fileDirId = fileDirId;
    }

    /**
     * 文件-编号<br>
     *
     * @return the fileId;
     */
    @Column(name = "file_id")
    public Long getFileId() {
        return fileId;
    }

    /**
     * 文件-编号；<br>
     *
     * @param fileId the fileId to set.
     * 
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 文件-存储路径{"/dir1/"}
     *
     * @return fileSaveDir
     */
    @Column(name = "file_save_dir")
    public String getFileSaveDir() {
        return fileSaveDir;
    }

    /**
     * 文件-存储路径{"/dir1/"}
     *
     * @param fileSaveDir the fileSaveDir to set.
     * 
     */
    public void setFileSaveDir(String fileSaveDir) {
        this.fileSaveDir = fileSaveDir;
    }

    /**
     * 文件-别名
     *
     * @return fileNickname
     */
    @Column(name = "file_nickname")
    public String getFileNickname() {
        return fileNickname;
    }

    /**
     * 文件-别名
     *
     * @param fileNickname the fileNickname to set.
     * 
     */
    public void setFileNickname(String fileNickname) {
        this.fileNickname = fileNickname;
    }

    /**
     * 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"}
     *
     * @return appCode
     */
    @Column(name = "app_code")
    public String getAppCode() {
        return appCode;
    }

    /**
     * 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"}
     *
     * @param appCode the appCode to set.
     * 
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * 开放-编码
     *
     * @return appCode
     */
    @Column(name = "open_code")
    public String getOpenCode() {
        return openCode;
    }

    /**
     * 开放-编码
     *
     * @param openCode the openCode to set.
     * 
     */
    public void setOpenCode(String openCode) {
        this.openCode = openCode;
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
