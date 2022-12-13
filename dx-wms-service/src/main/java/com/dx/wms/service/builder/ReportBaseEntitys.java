package com.dx.wms.service.builder;

import java.util.List;

import com.dx.wms.dto.ReportBaseDto;
import com.dx.wms.dto.TemplateProcessDto;

public class ReportBaseEntitys<P,R> extends ReportBaseDto<P, R>{
	
	/**
	 */
	private static final long serialVersionUID = -8030326108235793287L;
	
	
	private List<TemplateProcessDto<P, R>> templateDtos;
	
	private List<String> pdfUrls;
	
	

	public List<TemplateProcessDto<P, R>> getTemplateDtos() {
		return templateDtos;
	}

	public void setTemplateDtos(List<TemplateProcessDto<P, R>> templateDtos) {
		this.templateDtos = templateDtos;
	}

	public List<String> getPdfUrls() {
		return pdfUrls;
	}

	public void setPdfUrls(List<String> pdfUrls) {
		this.pdfUrls = pdfUrls;
	}
	
}
