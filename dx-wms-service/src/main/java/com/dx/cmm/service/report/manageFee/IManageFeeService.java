package com.dx.cmm.service.report.manageFee;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface IManageFeeService {
	
	/**
	 * 管理费收取明细查询
	 * */
	public PaginationResult<List<ManageFeeResult>> queryManageFee(ManageFeeParam param, Pagination page);
	
	public PaginationResult<List<ManageFeeResult>> queryAndAssembleManageFee(ManageFeeParam param, Pagination page);
}
