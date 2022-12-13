package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.infoManage.InfoManageService;
import com.dx.cmm.service.infoManage.dto.InfoManageParamDto;
import com.dx.cmm.service.infoManage.dto.InfoManageResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class InfoManageServiceTest extends BaseTest{
	@Autowired
	InfoManageService infoManage;
	
	@Test
	public void queryList(){
		Pagination page = new Pagination();
		page.setPagesize(20);
		InfoManageParamDto param = new InfoManageParamDto();
		PaginationResult<List<InfoManageResultDto>> results = infoManage.queryList(param, page);
		
		List<InfoManageResultDto> dtos = new ArrayList<InfoManageResultDto>();
		
		for(InfoManageResultDto dto : results.getR()){
			dtos.add(dto);
		}
		System.out.println("条数"+dtos.size());
		System.out.println("结果是"+JSON.toJSON(dtos));
	}
}
