package com.dx.wms.service.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.service.builder.ReportBaseEntitys;
import com.dx.wms.service.builder.ReportBuilder;
import com.dx.wms.utils.exection.ConvertException;

@Service("viewPdfWrapper")
public class ViewPdfWrapper<P, R> implements ReportWrapper<ReportBaseEntitys<P,R>>{
	
	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> dataReportBuilder;

	@Autowired
    private ReportBuilder<ReportBaseEntitys<P,R>> templateBuilder;
	
	@Override
	public void put(ReportBaseEntitys<P, R> t) throws ConvertException{
		dataReportBuilder.build(t);
		templateBuilder.build(t);
	}
}
