package com.dx.cmm.service.report;

import java.util.List;

import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cmm.service.view.excel.ExcEffectResult;

public interface IEffectReportService {
	
	public List<FirstViewResult> queryEffect(ProtocolParam param);

	public List<ExcEffectResult> queryExc(ProtocolParam param);
}
