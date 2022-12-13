package com.dx.wms.dto;

import java.io.Serializable;
import java.util.List;

import freemarker.template.Template;

public class ReportBaseDto<P, R> implements Serializable{

	/**
	 */
	private static final long serialVersionUID = -25718325431378030L;
	
	/**
	 * 导出类型 1:首期协议
	 * 导出类型 2:到期协议
	 */
	private Integer reportType;
	
	/*
	 * 查询参数集
	 */
	private List<P> param;
	
	/*
	 * 结果集
	 */
	private List<R> result;
	
	/*
	 * 临时目录路径	
	 */
	private String path;
	
	/*
	 * 是否预览
	 */
	private boolean isView;
	
	/*
	 * 模版
	 */
	private Template template;
	
	/*
	 * 模版url(预览用)
	 */
	private String templatePath;
	
	/*
	 * 绝对路径存放--用于解析图片
	 */
	private String realAddress;

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public List<P> getParam() {
		return param;
	}

	public void setParam(List<P> param) {
		this.param = param;
	}

	public List<R> getResult() {
		return result;
	}

	public void setResult(List<R> result) {
		this.result = result;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRealAddress() {
		return realAddress;
	}

	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}
}
