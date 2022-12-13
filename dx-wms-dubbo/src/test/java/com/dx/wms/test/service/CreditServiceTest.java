package com.dx.wms.test.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.credit.CreditExpResult;
import com.dx.cmm.service.credit.CreditMatchResult;
import com.dx.cmm.service.credit.CreditPoolParam;
import com.dx.cmm.service.credit.CreditPoolResult;
import com.dx.cmm.service.credit.CreditStatDetailResult;
import com.dx.cmm.service.credit.CreditStatParam;
import com.dx.cmm.service.credit.CreditStatResult;
import com.dx.cmm.service.credit.ICreditService;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class CreditServiceTest extends BaseTest{
	
	@Autowired
	private ICreditService creditService;
	
	@Test
	public void queryStat_test(){//根据日期筛选---运营 债券统计表
		CreditStatParam param = new CreditStatParam();
		//上个月的当前日+5天
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.set(2016, 8, 10);
		//上个月的当前日
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.set(2016, 8, 1);
		//开始日期
		param.setCreateDateBegin(calendarBegin.getTime());
		//截止日期
		param.setCreateDateEnd(calendarEnd.getTime());
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<CreditStatResult>> result = creditService.queryStat(param, page);
		System.out.println("结果在此"+JSON.toJSON(result.getR()));
	}
	
	@Test
	public void queryPool_test(){//根据姓名、身份证、合同编号、还款日及日期筛选--运营 债权明细
		CreditPoolParam param = new CreditPoolParam();
		param.setRepayDay(1);
		//上一年上个月的当前日-5天
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.set(2015, 8, 1);
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.set(2016, 8, 10);
		//上一年上个月的当前日
		//开始日期
		param.setCreateDateBegin(calendarBegin.getTime());
		//截至日期
		param.setCreateDateEnd(calendarEnd.getTime());
		//合同编号
		param.setContractNo(null);
		//身份证
		param.setIdCard(null);
		//姓名
		param.setCustName(null);
//		param.setRepayDay(1);
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<CreditPoolResult>> result = creditService.queryPool(param, page);
		System.out.println("结果在此"+JSON.toJSON(result.getR()));
	}
	
	@Test
	public void queryLenderFirst_test(){//根据出借编号筛选 债权列表
		//出借编号
		List<CreditMatchResult> results = creditService.queryLenderFirst("L0533011609210001-001");
		System.out.println("结果在此"+JSON.toJSON(results));
	}
	
	@Test
	public void queryLender_test(){//根据出借编号及当前期限筛选(第几期) 
		//出借编号
		List<CreditMatchResult> results = creditService.queryLender("L0533011609210001-001",1);
		System.out.println("结果在此"+JSON.toJSON(results));
	}	
	
	@Test
	public void queryExp_test(){//根据端口筛选异常债权(1,16) --异常债权
		List<CreditExpResult> results = creditService.queryExp(16);
		System.out.println("结果在此"+JSON.toJSON(results));
	}
	
	@Test
	public void queryCurrent(){//根据还款日统计--运营 新增匹配
		List<CreditStatDetailResult> results = creditService.queryCurrent();
		System.out.println("结果在此"+JSON.toJSON(results));
	}
	
	@Test
	public void queryDetail_test(){//根据日期统计--运营 债权统计 详情
		Calendar calendar = Calendar.getInstance();
		//9月8号 (月份从0开始)
		calendar.set(2016, 8, 8);
		List<CreditStatDetailResult> results = creditService.queryDetail(calendar.getTime());
		System.out.println("结果在此"+JSON.toJSON(results));
	}
	
}
