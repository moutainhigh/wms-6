package com.dx.cmm.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.DateParamCalc;
import com.dx.cmm.service.calc.DateResultCalc;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.CreditViewResult;
import com.dx.cmm.service.view.TransViewResult;
import com.dx.cmm.service.view.excel.ExcTransResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApplyDto;

public class TransReportServiceImpl implements ITransReportService{
	
	private static final String INVEST = "transView.queryInvest";
	
	private static final String CREDITOR = "transView.queryCreditor";
	
	
    @Autowired
    protected PaginationDalClient dalClient;
    
	@Autowired
	private ILenderApplyService lenderApplyService;
	
	@Autowired
    Calc<DateParamCalc, DateResultCalc> dateCalc;
	
	@Override
	public PaginationResult<List<TransViewResult>> queryList(ProtocolParam param, Pagination page) {
		return set(dalClient.queryForList(INVEST, MapUtils.obj2Map(param) , TransViewResult.class , page));
	}

	@Override
	public List<TransViewResult> query(ProtocolParam param) {
		Pagination page = new Pagination();
		page.setCurrentPage(0);
		page.setPagesize(-1);
		List<TransViewResult> results = queryList(param,page).getR();
		for(TransViewResult result : results){
			result.setCreditors(getCreditor(result));
		}
		return results;
	}

	@Override
	public List<ExcTransResult> queryExc(ProtocolParam param) {
		
		return null;
	}
	
	private PaginationResult<List<TransViewResult>> set(PaginationResult<List<TransViewResult>> results){
		for(TransViewResult result : results.getR()){
			LenderApplyDto apply = lenderApplyService.query(result.getBizCode());
			result.set(apply);
		}
		return results;
	}
	
	private List<CreditViewResult> getCreditor(TransViewResult result){
		Map<String, Object> paramMap = MapUtils.getParamMap("poolId", result.getPoolId());
		paramMap.put("currentPeriod", result.getCurrentPeriod());
		List<CreditViewResult> creditors = dalClient.queryForList(CREDITOR, paramMap,CreditViewResult.class);
		Integer index = 1;
		for(CreditViewResult creditor : creditors){
			creditor.setIndex(index);
			creditor.setTransDateView(result.getTransDayView());
			creditor.setTransCreditorAmountView(AmountUtils.format(creditor.getTransCreditorAmount(), "0.00"));
			index ++;
		}
		return creditors;
	}

}
