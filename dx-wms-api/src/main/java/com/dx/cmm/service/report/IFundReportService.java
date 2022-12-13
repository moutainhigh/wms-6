package com.dx.cmm.service.report;

import java.util.List;

import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.FundViewResult;
import com.dx.cmm.service.view.excel.ExcFundResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface IFundReportService {

	public PaginationResult<List<FundViewResult>> queryFundList(ProtocolParam param , Pagination page);
	
	public List<FundViewResult> queryFund(ProtocolParam param);
	
	public List<ExcFundResult> queryExc(ProtocolParam param);
	
}
