package com.dx.wms.report.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.enums.ReportType;
import com.dx.wms.report.ReportObserver;
import com.dx.wms.service.builder.ReportBaseEntitys;

@Service
public class PdfReport<P, R> extends ReportObserver<P, R>{
	
	@Override
	public Boolean supports(ReportParamDto<P, R> param) {
		return ReportType.FIRST.getCode().equals(param.getReportType())||ReportType.EFFECTFIRST.getCode().equals(param.getReportType());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void report(ReportParamDto<P, R> param) {
		ReportBaseEntitys<P,R> entitys = new ReportBaseEntitys<>();
		entitys.setReportType(param.getReportType());
		entitys.setPath(param.getPath());
		entitys.setParam(param.getParam());
		entitys.setRealAddress(param.getRealAddress());
		reportWarpper.put(entitys);
		param.setResult((List<R>) entitys.getPdfUrls());
	}

	@Override
	protected void view(ReportParamDto<P, R> param) {
		ReportBaseEntitys<P,R> entitys = new ReportBaseEntitys<>();
		entitys.setReportType(param.getReportType());
		entitys.setParam(param.getParam());
		entitys.setView(param.isView());
		viewWarpper.put(entitys);
		param.setTemplate(entitys.getTemplate());
		param.setTemplatePath(entitys.getTemplatePath());
		param.setResult(entitys.getResult());
	}
}
