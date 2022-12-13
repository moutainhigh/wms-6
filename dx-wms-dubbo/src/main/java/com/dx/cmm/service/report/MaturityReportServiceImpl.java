package com.dx.cmm.service.report;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.report.dto.MaturityParamDto;
import com.dx.cmm.service.report.dto.MaturityResult;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;


public class MaturityReportServiceImpl implements IMaturityService{
	@Autowired
    protected PaginationDalClient dalClient;
	
	protected static final Logger LOGS = LoggerFactory.getLogger(MaturityReportServiceImpl.class);
	
	public static final String MATURITY_LIST="maturity.queryMaturityList";

	@Override
	public PaginationResult<List<MaturityResult>> queryMaturityList(MaturityParamDto param, Pagination page) {
		LOGS.info("Maturity query param is [{}]", new Gson().toJson(MapUtils.obj2Map(param)));
		LOGS.info("Maturity query Pagination is [{}]", new Gson().toJson(MapUtils.obj2Map(page)));
		return dalClient.queryForList(MATURITY_LIST, MapUtils.obj2Map(param), MaturityResult.class, page);
	}

}
