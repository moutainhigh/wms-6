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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 文件解析 影像信息数据保存dto
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ContentDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<FileDto> uploadFiles;

    private Map<String, FileDirRelationDto> uploadFileDirs;

    private FileDto uploadFile;

    private FileDirRelationDto uploadFileDir;

    // 文件原名,文件保存名
    private Map<String, String> fileSaveNames;
    
    private FileQueryDto fileQueryDto;
    
    private FileValidationDto fileValidationDto = new FileValidationDto();
    

    public List<FileDto> getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(List<FileDto> uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    public Map<String, FileDirRelationDto> getUploadFileDirs() {
        return uploadFileDirs;
    }

    public void setUploadFileDirs(Map<String, FileDirRelationDto> uploadFileDirs) {
        this.uploadFileDirs = uploadFileDirs;
    }

    public FileDto getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(FileDto uploadFile) {
        this.uploadFile = uploadFile;
    }

    public FileDirRelationDto getUploadFileDir() {
        return uploadFileDir;
    }

    public void setUploadFileDir(FileDirRelationDto uploadFileDir) {
        this.uploadFileDir = uploadFileDir;
    }

    public Map<String, String> getFileSaveNames() {
        return fileSaveNames;
    }

    public void setFileSaveNames(Map<String, String> fileSaveNames) {
        this.fileSaveNames = fileSaveNames;
    }

	public FileQueryDto getFileQueryDto() {
		return fileQueryDto;
	}

	public void setFileQueryDto(FileQueryDto fileQueryDto) {
		this.fileQueryDto = fileQueryDto;
	}

	public FileValidationDto getFileValidationDto() {
		return fileValidationDto;
	}

	public void setFileValidationDto(FileValidationDto fileValidationDto) {
		this.fileValidationDto = fileValidationDto;
	}

    
    

}
