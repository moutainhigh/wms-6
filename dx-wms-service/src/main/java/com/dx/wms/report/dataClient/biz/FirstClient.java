package com.dx.wms.report.dataClient.biz;



import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.enums.ReportType;
import com.dx.wms.report.dataClient.DataClientObserver;

@Service
public class FirstClient<P, R> extends DataClientObserver<P, R>{
	

	@Override
	public Boolean supports(ReportParamDto<P, R> param) {
		return ReportType.FIRST.getCode().equals(param.getReportType())  ;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void execute(ReportParamDto<P, R> param) {
		Assert.notNull("**execute() param is can not be null",param);
		Assert.notNull("**execute() request param is can not be null",param.getParam());
		LOG.info("**execute() param={}",param);
		param.setResult((List<R>) getFirstView(param,Boolean.FALSE));
	}
	
}
