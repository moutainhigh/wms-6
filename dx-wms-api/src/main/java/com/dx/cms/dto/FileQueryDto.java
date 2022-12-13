package com.dx.cms.dto;

import java.io.File;
import java.io.Serializable;

public class FileQueryDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String appCode;

    private String resKey;

    private String password;

    private File file;

    private Long lenderCustId;

    private Long lenderId;

    private String orgName;

    private Long userId;

    private String lenderCustCode;

    private String lenderCode;

    private String destPath;
    
    private String tempPath;
    
    private Boolean isWin;
    
    private FileValidationDto fileValidationDto;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getLenderCustId() {
        return lenderCustId;
    }

    public void setLenderCustId(Long lenderCustId) {
        this.lenderCustId = lenderCustId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Long getLenderId() {
        return lenderId;
    }

    public void setLenderId(Long lenderId) {
        this.lenderId = lenderId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public Boolean getIsWin() {
		return isWin;
	}

	public void setIsWin(Boolean isWin) {
		this.isWin = isWin;
	}

	public FileValidationDto getFileValidationDto() {
		return fileValidationDto;
	}

	public void setFileValidationDto(FileValidationDto fileValidationDto) {
		this.fileValidationDto = fileValidationDto;
	}
    

}
