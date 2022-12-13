package com.dx.cmm.service.interest;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface InterestService {
	
	/**
	 * 
	 * 	根据出借编号,报告日,产品ID获得对应产品的月回收利息
	 * 
	 * @param param
	 * @param page
	 * @return
	 */
	PaginationResult<List<InterestResult>> queryInterest(InterestParam param, Pagination page);
}
