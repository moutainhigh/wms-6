package com.dx.cms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileValidationDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<FileDto> fileDtoes = new ArrayList<FileDto>();
	FileDto uploadFile = new FileDto();
	Set<String> fileNames = new HashSet<String>();
	String actionCode;
	public List<FileDto> getFileDtoes() {
		return fileDtoes;
	}
	public void setFileDtoes(List<FileDto> fileDtoes) {
		this.fileDtoes = fileDtoes;
	}
	public FileDto getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(FileDto uploadFile) {
		this.uploadFile = uploadFile;
	}
	public Set<String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(Set<String> fileNames) {
		this.fileNames = fileNames;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
	

}
