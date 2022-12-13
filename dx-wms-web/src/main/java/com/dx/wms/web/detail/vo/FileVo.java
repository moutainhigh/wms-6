package com.dx.wms.web.detail.vo;

import java.io.Serializable;

import com.dx.cms.dto.FileResultDto;

public class FileVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2121835430038152136L;

    /**
     * 文件-存储名称
     */
    private String saveName;

    /**
     * 文件-源名称
     */
    private String sourceName;

    /**
     * 文件-存储路径
     */
    private String dir;

    /**
     * 文件类型-标示
     */
    private String typeKey;

    /**
     * 文件类型-标示
     */
    private String type;
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
     * 文件-大小
     */
    private String fileSize;


    /**
     * 文件状态
     */
    private String dataStatus;
    
    /**
     * 文件夹状态 
     */
    private String dirDateStatus;

    public FileVo() {

    }

    public FileVo(FileResultDto base) {
        setSaveName(base.getFileSaveName());
        setSourceName(base.getFileSourceName());
        setType(base.getFileTypeKey());
        setDir(base.getFileSaveDir());
        setFileSize(base.getFileSize());
        setFileDirId(base.getFileDirId());
        setFileDirRelationId(base.getFileDirRelationId());
        setFileId(base.getFileId());
        setAppCode(base.getAppCode());
        setOpenCode(base.getOpenCode());
        setFileTypeId(base.getFileTypeId());
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public Long getFileDirId() {
		return fileDirId;
	}

	public void setFileDirId(Long fileDirId) {
		this.fileDirId = fileDirId;
	}

	public Long getFileDirRelationId() {
		return fileDirRelationId;
	}

	public void setFileDirRelationId(Long fileDirRelationId) {
		this.fileDirRelationId = fileDirRelationId;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public Long getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(Long fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getDirDateStatus() {
		return dirDateStatus;
	}

	public void setDirDateStatus(String dirDateStatus) {
		this.dirDateStatus = dirDateStatus;
	}
    
    

}
