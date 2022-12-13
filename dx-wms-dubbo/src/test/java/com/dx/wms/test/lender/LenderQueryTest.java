package com.dx.wms.test.lender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.dto.QueryResultDto;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.dto.LenderQueryDto;
import com.dx.wms.dto.LenderResultDto;
import com.dx.wms.service.ILenderQueryService;
import com.dx.wms.test.product.ProductQueryTest;
import com.google.gson.Gson;

public class LenderQueryTest extends LenderTest {
	
	/**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(LenderQueryTest.class);

    @Autowired
    private ILenderQueryService lenderQueryService;

    //@Test
    public void test_1() {
        QueryResultDto result = lenderQueryService.queryLenderCode("L0532021507100002-001");
        System.out.println("!!!!!!!!!!!!!!" + new Gson().toJson(result));
    }
    
    //@Test
    public void test_3() {
        QueryResultDto result = lenderQueryService.queryApplyId(10242l);
        System.out.println("!!!!!!!!!!!!!!" + new Gson().toJson(result));
    }
    
    //根据状态查询数据，姓名和证件号为可选条件
    @Test
    public void testQueryResultByDueDate() {
    	LenderQueryDto queryDto = new LenderQueryDto();
//    	Date d1 = DateUtils.parseForDay("2016-11-3");
    	queryDto.setCustName("闫萌萌");
//    	queryDto.setDueDateBegin(d1);
    	Date d2 = DateUtils.parseForDay("2016-11-3");
    	queryDto.setDueDateEnd(d2);
    	Pagination paginationResult = new Pagination();
    	queryDto.setPagination(paginationResult);
    	PaginationResult<List<LenderResultDto>> result = lenderQueryService.queryResultByDueDate(queryDto);
    	LOG.info("***testQueryResultByDueDate={}***", new Gson().toJson(result.getR()));
    }
    //根据状态查询申请金额，姓名和证件号为可选条件
    @Test
    public void testQueryAmountsByDueDate(){
    	LenderQueryDto lQueryDto = new LenderQueryDto();
    	lQueryDto.setDueDateBegin(new Date());
    	lQueryDto.setDueDateEnd(new Date());
    	List<Long> lo = new ArrayList<Long>();
    	lo.add(12l);
    	lQueryDto.setFormStatus(lo);
    	LOG.info("***testQueryAmountsByDueDate={}***", new Gson().toJson(lenderQueryService.queryAmountsByDueDate(lQueryDto)));
    }
    
    //根据借款id查询信息
    @Test
    public void queryLenderCode(){
    	QueryResultDto queryResultDto=lenderQueryService.queryLenderCode("L05351505070001-01111");
    	LOG.info("***queryLenderCode={}***", new Gson().toJson(queryResultDto));
    }
    
    //查询回款银行信息
    @Test
    public void queryApplyId(){
    	QueryResultDto queryResultDto=lenderQueryService.queryApplyId(70001l);
    	LOG.info("***queryApplyId={}***", new Gson().toJson(queryResultDto));
    }
    
}
