package com.dx.wms.test.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.invest.IInvestService;
import com.dx.cmm.service.invest.InvestPoolParam;
import com.dx.cmm.service.invest.InvestResult;
import com.dx.cmm.service.invest.InvestStatParam;
import com.dx.cmm.service.invest.InvestStatResult;
import com.dx.cmm.service.invest.InvestUpdateParam;
import com.dx.cmm.service.invest.InvestUpdateResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class InvestServiceTest extends BaseTest{

	@Autowired
	private IInvestService investService;
	
	@Test
	public void query_test(){//根据参数查询账户级别信息  .
		InvestResult result = investService.query("L0532041509060001-00123");
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryStat_test(){//根据统计条件筛选(初始匹配日期起始)--运营 每日匹配统计
		InvestStatParam param = new InvestStatParam();
		Calendar initMatchDateBegin = Calendar.getInstance();
		initMatchDateBegin.set(2016,9,1);
		//首次匹配日期-起 --上个月今日
		param.setInitMatchDateBegin(initMatchDateBegin.getTime());
		//首次匹配日期-止 -- 今日
		initMatchDateBegin.set(2016,9,10);
		param.setInitMatchDateEnd(initMatchDateBegin.getTime());
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<InvestStatResult>> result = investService.queryStat(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryPool_test(){//根据身份证、出借编号及首次匹配日期筛选  --运营 每日匹配详情
		InvestPoolParam param = new InvestPoolParam();
		Calendar initMatchDateBegin = Calendar.getInstance();
		initMatchDateBegin.set(2016,8,1);
		//首次匹配日期-起 --上一年上个月日-5天
		param.setInitMatchDateBegin(initMatchDateBegin.getTime());
		//首次匹配日期-止 -- 今日
		initMatchDateBegin.set(2016,9,1);
		param.setInitMatchDateEnd(initMatchDateBegin.getTime());
		//身份证
//		param.setIdCard("370602195008071885");
		//出借编号
//		param.setLenderCode("L0535011509060002-001");
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<InvestResult>> result = investService.queryPool(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryMatching_test(){//根据身份证、出借编号及首次匹配日期筛选  --运营 匹配生效详情
		InvestPoolParam param = new InvestPoolParam();
		Calendar initMatchDateBegin = Calendar.getInstance();
		initMatchDateBegin.set(2016,8,1);
		//首次匹配日期-起 --上一年上个月日-5天
		param.setInitMatchDateBegin(initMatchDateBegin.getTime());
		//首次匹配日期-止 -- 今日
		initMatchDateBegin.set(2016,9,1);
		param.setInitMatchDateEnd(initMatchDateBegin.getTime());
		//身份证
//		param.setIdCard("370602195008071885");
		//出借编号
//		param.setLenderCode("L0535011509060002-001");
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<InvestResult>> result = investService.queryMatching(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryProduct_test(){//根据产品信息筛选(11,12) 	产品变更 (运营)
		InvestUpdateParam param = new InvestUpdateParam();
		//姓名
//		param.setCustName("王巧玲");
		//出借编号
//		param.setLenderCode("L0024021509060002-001");
		//分页信息
		Pagination page = new Pagination();
		page.setPagesize(-1);
		PaginationResult<List<InvestUpdateResult>> result = investService.queryProduct(param, page);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void updateProduct_test(){//根据资金池编号变更产品(达信宝 月利营变更)
		//资金池编号
		investService.updateProduct(5882L);
		System.out.println("产品变更成功");
	}
}
