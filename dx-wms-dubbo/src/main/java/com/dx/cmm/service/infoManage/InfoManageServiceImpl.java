package com.dx.cmm.service.infoManage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.infoManage.dto.InfoManageParamDto;
import com.dx.cmm.service.infoManage.dto.InfoManageResultDto;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

public class InfoManageServiceImpl implements InfoManageService{
	
	@Autowired
    protected PaginationDalClient dalClient;
	
	private static final String INFO_LIST = "infoManage.queryForPage";
	
	protected static final Logger LOGS = LoggerFactory.getLogger(InfoManageServiceImpl.class);

	@Override
	public PaginationResult<List<InfoManageResultDto>> queryList(InfoManageParamDto param, Pagination page) {
		LOGS.info("InfoManage query param is [{}]", new Gson().toJson(MapUtils.obj2Map(param)));
		LOGS.info("InfoManage query Pagination is [{}]", new Gson().toJson(MapUtils.obj2Map(page)));
		return dalClient.queryForList(INFO_LIST, MapUtils.obj2Map(param), InfoManageResultDto.class, page);
	}
	
}
