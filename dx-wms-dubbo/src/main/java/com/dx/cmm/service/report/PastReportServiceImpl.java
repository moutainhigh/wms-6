package com.dx.cmm.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cmm.service.ViewAbs;
import com.dx.cmm.service.report.dto.PastParamDto;
import com.dx.cmm.service.report.dto.PastResult;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

public class PastReportServiceImpl extends ViewAbs implements IPastReportService{
	
	private final static String PAST_LIST = "past.queryPastList";
	
	private final static String PAST_BMA="past.queryCredit4List";

	
	protected static final Logger LOGS = LoggerFactory.getLogger(PastReportServiceImpl.class);
	

	@Override
	public PaginationResult<List<PastResult>> queryPastList(PastParamDto param,
			Pagination page) {
		LOGS.info("PastList query param is [{}]", new Gson().toJson(MapUtils.obj2Map(param)));
		LOGS.info("PastList query Pagination is [{}]", new Gson().toJson(MapUtils.obj2Map(page)));
		PaginationResult<List<PastResult>> results = dalClient.queryForList(PAST_LIST, MapUtils.obj2Map(param), PastResult.class, page);
		List<PastResult> pages = new ArrayList<PastResult>();
		
		for(PastResult result : results.getR()){
			Map<String, String> creditParam = new HashMap<String,String>();
			creditParam.put("createTimePre", param.getCreateTime());
			creditParam.put("poolId", String.valueOf(result.getPoolId()));
			creditParam.put("currentPeriod", String.valueOf(result.getCurrentPeriod()));
			List<BigDecimal> backMatchAmount = dalClient.queryForList(PAST_BMA,creditParam,BigDecimal.class);
			result.setBackMatchAmount(backMatchAmount.get(0));
			pages.add(result);
		}
		
		return new PaginationResult<List<PastResult>>(pages,results.getPagination());
	}

	
}
