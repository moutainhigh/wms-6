package com.dx.wms.test.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.trans.IMatchTransService;
import com.dx.cmm.service.trans.TransStatDetailResult;
import com.dx.cmm.service.trans.TransStatParam;
import com.dx.cmm.service.trans.TransStatResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class MatchTransServiceTest extends BaseTest{

	@Autowired
	private IMatchTransService matchTransService;
	
	@Test
	public void queryStat_test(){
		TransStatParam param = new TransStatParam();
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.set(2016,8,5);
		param.setCreateDateBegin(calendarBegin.getTime());
		//截止日期 当日
		calendarBegin.set(2016,9,5);
		param.setCreateDateEnd(calendarBegin.getTime());
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<TransStatResult>> result = matchTransService.queryStat(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryDetail_test(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016,8,6);
		//日期 --上月天数加6
		List<TransStatDetailResult> results = matchTransService.queryDetail(calendar.getTime());
		System.out.println("结果在此"+JSON.toJSON(results));
	}
}
