package com.dx.cmm.service.report;

import java.util.List;

import com.dx.cmm.service.report.dto.PastParamDto;
import com.dx.cmm.service.report.dto.PastProtocolViewResult;
import com.dx.cmm.service.view.excel.ExcPastResult;

public interface IPastViewService {
	PastProtocolViewResult getPreData(String lenderCode,String createTimePre,String reportDayPre);
	
	List<ExcPastResult> queryExc(PastParamDto param);
	
	List<PastProtocolViewResult> getPdfData(PastParamDto param);
	
	List<PastProtocolViewResult> getPlusPdfData(PastParamDto param);
}
