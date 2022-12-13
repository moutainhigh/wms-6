package com.dx.wms.service.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.service.builder.ReportBaseEntitys;
import com.dx.wms.service.builder.ReportBuilder;
import com.dx.wms.utils.exection.ConvertException;

@Service("reportPdfWrapper")
public class ReportPdfWrapper<P, R> implements ReportWrapper<ReportBaseEntitys<P,R>>{
	
	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> dataReportBuilder;

	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> templateBuilder;
	
	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> fillDataBuilder;
	
	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> pdfBuilder;
	
	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> signatureBuilder;

	@Override
	public void put(ReportBaseEntitys<P, R> t) throws ConvertException{
		dataReportBuilder.build(t);
		templateBuilder.build(t);
		fillDataBuilder.build(t);
		pdfBuilder.build(t);
		signatureBuilder.build(t);
	}
}
