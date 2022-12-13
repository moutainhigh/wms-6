package com.dx.cmm.service.report;

import java.util.List;

import com.dx.cmm.service.report.dto.PastParamDto;
import com.dx.cmm.service.report.dto.PastResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface IPastReportService {
	
	PaginationResult<List<PastResult>> queryPastList(PastParamDto param, Pagination page);
	
}
