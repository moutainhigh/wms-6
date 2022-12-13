package com.dx.wms.web.detail.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FileResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 313604498721819014L;
	
	/*
	 * 文件名Map
	 */
	private Map<String, String> files;
	
	/*
	 * 文件Id集合
	 */
	private List<String> fileIds;
	
	/*
	 * url集合
	 * 
	 */
	private List<Map<String, String>> urls;

	public Map<String, String> getFiles() {
		return files;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}

	public List<Map<String, String>> getUrls() {
		return urls;
	}

	public void setUrls(List<Map<String, String>> urls) {
		this.urls = urls;
	}

	public List<String> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<String> fileIds) {
		this.fileIds = fileIds;
	}
}
