package com.dx.cmm.service.report;

import java.util.List;

import com.dx.cmm.service.report.dto.MaturityParamDto;
import com.dx.cmm.service.report.dto.MaturityResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface IMaturityService {
	PaginationResult<List<MaturityResult>> queryMaturityList(MaturityParamDto param, Pagination page);
}
