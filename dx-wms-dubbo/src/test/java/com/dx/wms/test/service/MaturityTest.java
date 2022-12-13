package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.report.IMaturityService;
import com.dx.cmm.service.report.dto.MaturityParamDto;
import com.dx.cmm.service.report.dto.MaturityResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;


public class MaturityTest extends BaseTest{
	@Autowired
	IMaturityService maturityReportService;
	
	
	@Test
	public void testQueryMaturityList(){
		MaturityParamDto dto = new MaturityParamDto();
		Pagination page = new Pagination();
		page.setPagesize(20);
		PaginationResult<List<MaturityResult>> results = maturityReportService.queryMaturityList(dto, page);
		List<MaturityResult> output = new ArrayList<MaturityResult>();
		for(MaturityResult r : results.getR()){
			output.add(r);
		}
		System.out.println("结果是"+JSON.toJSON(output));
	}
}
