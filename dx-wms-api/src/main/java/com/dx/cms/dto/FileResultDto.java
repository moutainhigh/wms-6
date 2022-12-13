/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileStoreFilesResultDto.java
 * Author:   黄健
 * Date:     2015年7月17日 下午3:52:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.dto;

import java.io.Serializable;

/**
 * 内容管理 文件集dto
 *
 * @author huangjian
 */
public class FileResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4073687610230122783L;

    /**
     * 文件目录-编号
     */
    private Long fileDirId;

    /**
     * 文件目录关系-编号
     */
    private Long fileDirRelationId;

    /**
     * 文件-编号
     */
    private Long fileId;

    /**
     * 文件-存储路径
     */
    private String fileSaveDir;

    /**
     * 系统-编码
     */
    private String appCode;

    /**
     * 开放-编码
     */
    private String openCode;

    /**
     * 文件类型-编号
     */
    private Long fileTypeId;

    /**
     * 文件-源名称
     */
    private String fileSourceName;

    /**
     * 文件-存储名称
     */
    private String fileSaveName;

    /**
     * 文件-大小
     */
    private String fileSize;

    /**
     * 文件类型-标示
     */
    private String fileTypeKey;

    /**
     * 文件状态
     */
    private String dataStatus;
    
    /**
     * 文件夹状态 
     */
    private String dirDateStatus;

    /**
     * @return 文件状态 A：生效 D：已删除
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * @param dataStatus 文件状态 A：生效 D：已删除
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * @return 文件目录-编号
     */
    public Long getFileDirId() {
        return fileDirId;
    }

    /**
     * @param fileDirId 文件目录-编号
     */
    public void setFileDirId(Long fileDirId) {
        this.fileDirId = fileDirId;
    }

    /**
     * @return 文件目录关系-编号
     */
    public Long getFileDirRelationId() {
        return fileDirRelationId;
    }

    /**
     * @param fileDirRelationId 文件目录关系-编号
     */
    public void setFileDirRelationId(Long fileDirRelationId) {
        this.fileDirRelationId = fileDirRelationId;
    }

    /**
     * @return 文件-编号
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId 文件-编号
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * @return 文件-存储路径
     */
    public String getFileSaveDir() {
        return fileSaveDir;
    }

    /**
     * @param fileSaveDir 文件-存储路径
     */
    public void setFileSaveDir(String fileSaveDir) {
        this.fileSaveDir = fileSaveDir;
    }

    /**
     * @return 系统-编码
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * @param appCode 系统-编码
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return 开放-编码
     */
    public String getOpenCode() {
        return openCode;
    }

    /**
     * @param openCode 开放-编码
     */
    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    /**
     * @return 文件类型-编号
     */
    public Long getFileTypeId() {
        return fileTypeId;
    }

    /**
     * @param fileTypeId 文件类型-编号
     */
    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    /**
     * @return 文件-源名称
     */
    public String getFileSourceName() {
        return fileSourceName;
    }

    /**
     * @param fileSourceName 文件-源名称
     */
    public void setFileSourceName(String fileSourceName) {
        this.fileSourceName = fileSourceName;
    }

    /**
     * @return 文件-存储名称
     */
    public String getFileSaveName() {
        return fileSaveName;
    }

    /**
     * @param fileSaveName 文件-存储名称
     */
    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    /**
     * @return 文件-大小
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize 文件-大小
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return 文件类型-标示
     */
    public String getFileTypeKey() {
        return fileTypeKey;
    }

    /**
     * @param fileTypeKey 文件类型-标示
     */
    public void setFileTypeKey(String fileTypeKey) {
        this.fileTypeKey = fileTypeKey;
    }

	public String getDirDateStatus() {
		return dirDateStatus;
	}

	public void setDirDateStatus(String dirDateStatus) {
		this.dirDateStatus = dirDateStatus;
	}
    
    

}
