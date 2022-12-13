/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ContentDto.java
 * Author:   黄健
 * Date:     2015年8月24日 下午4:35:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.dto;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件解析 影像信息数据保存dto
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -9130532736570211466L;

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

    private String saveName;

    private String savePath;

    private String fullName;

    private String type;

    private String name;

    private Long size;

    private File file;

    
    public FileDto(String fileName,String dirs) {
        this.name = fileName;
        this.type=dirs;
    }
    public FileDto(){
    	
    }
    
    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public String getFileSourceName() {
        return fileSourceName;
    }

    public void setFileSourceName(String fileSourceName) {
        this.fileSourceName = fileSourceName;
    }

    public String getFileSaveName() {
        return fileSaveName;
    }

    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
