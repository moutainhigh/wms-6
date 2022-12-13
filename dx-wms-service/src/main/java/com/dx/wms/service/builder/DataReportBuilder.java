package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.report.dataClient.DataClientRouters;
import com.dx.wms.utils.exection.ConvertException;

@Service("dataReportBuilder")
public class DataReportBuilder<P, R> extends ReportEntityBuilder<R, P>{
	
	@Autowired
	private DataClientRouters router;
	
	@Override
	public void build(ReportBaseEntitys<P, R> t) throws ConvertException{
		ReportParamDto<P, R> param = new ReportParamDto<P, R>();
		param.setParam(t.getParam());
		param.setReportType(t.getReportType());
		param.setView(t.isView());
		router.execute(param);
		t.setResult(param.getResult());
	}

}
