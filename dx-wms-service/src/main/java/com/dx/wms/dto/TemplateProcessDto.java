package com.dx.wms.dto;


public class TemplateProcessDto<P, R> extends ReportBaseDto<P, R>{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * pdf文件名
	 */
	private String pdfName;
	
	/*
	 * pdf生成文件夹路径
	 */
	private String pdfPath;
	
	/*
	 * 填充后的模版内容
	 */
	private String htmlContent;
	
	/*
	 * pdf生成路径
	 */
	private String pdfFilePath;
	
	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}


	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}

}
