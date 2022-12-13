package com.dx.wms.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.back.BackTransParam;
import com.dx.cmm.service.back.BackTransResult;
import com.dx.cmm.service.back.BackUsualParam;
import com.dx.cmm.service.back.BackUsualResult;
import com.dx.cmm.service.back.IMatchBackService;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class MatchBackServiceTest extends BaseTest{

	@Autowired
	private IMatchBackService matchBackService;
	
	@Test
	public void queryUsual_test(){ //往期回款
		BackUsualParam param = new BackUsualParam();
		//账单日
		param.setBillDay(1);
		//出借编号
		param.setLenderCode("L0532011509060001-001");
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<BackUsualResult>> result = matchBackService.queryUsual(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryTrans_test(){ //到期回款
		BackTransParam param = new BackTransParam();
		//出借编号
		param.setLenderCode("L0451011606140001-001");
		//账单日
		param.setBillDay(1);
		//产品编号
		param.setProductId(16L);
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<BackTransResult>> result = matchBackService.queryTrans(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
}
