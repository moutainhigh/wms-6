package com.dx.cmm.service.report;

import java.util.List;

import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.TransViewResult;
import com.dx.cmm.service.view.excel.ExcTransResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface ITransReportService {

	public PaginationResult<List<TransViewResult>> queryList(ProtocolParam param , Pagination page);
	
	public List<TransViewResult> query(ProtocolParam param);
	
	public List<ExcTransResult> queryExc(ProtocolParam param);
}
