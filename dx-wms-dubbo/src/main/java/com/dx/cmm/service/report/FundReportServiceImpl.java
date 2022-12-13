package com.dx.cmm.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.FundViewResult;
import com.dx.cmm.service.view.excel.ExcFundResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.IProductService;

public class FundReportServiceImpl  implements IFundReportService {

	private static final Logger LOG = LoggerFactory.getLogger(FundReportServiceImpl.class);

	private static final String INVEST = "fundView.queryInvest";
	
	private static final String FUND = "fundView.queryFund";
	
	private static final String WMS = "wms";
	
    @Autowired
    protected PaginationDalClient dalClient;
    
	@Autowired
	private IProductService productService;
	
	@Override
	public List<FundViewResult> queryFund(ProtocolParam param) {
		Assert.notNull("queryFund()** param is null",param);
		Pagination page = new Pagination();
		page.setCurrentPage(0);
		page.setPagesize(-1);
		return queryFundList(param,page).getR();
	}


	@Override
	public PaginationResult<List<FundViewResult>> queryFundList(ProtocolParam param, Pagination page) {
		Map<String, Object> params = new HashMap<>();
		params.put("reportDay", Assert.checkParam(param.getReportDay()) ? DateUtils.formatForDay(param.getReportDay()) : "");
		params.put("lenderCode", Assert.checkParam( param.getLenderCode()) ?  param.getLenderCode() : "");
		params.put("lenderCustCode", Assert.checkParam(param.getLenderCustCode()) ? param.getLenderCustCode() : "");
		if(Assert.checkParam(param.getLenderCodes())){
			params.put("lenderCodes", param.getLenderCodes()) ;
		}
		PaginationResult<List<FundViewResult>>  results = dalClient.queryForList(INVEST, params,FundViewResult.class,page);
		set(results);
		return results;
	}
	

	@Override
	public List<ExcFundResult> queryExc(ProtocolParam param) {
		List<FundViewResult> viewResults = queryFund(param);
		List<ExcFundResult> excFundResults = new ArrayList<>();
		for(FundViewResult viewResult : viewResults){
			ExcFundResult result = new ExcFundResult();
			BeanUtils.copyProperties(viewResult, result);
			result.setRealTotalAmountView(result.getTotalAmountView());
			excFundResults.add(result);
		}
		return Assert.checkParam(excFundResults) ? excFundResults : new ArrayList<ExcFundResult>();
	}
	
	private void set(PaginationResult<List<FundViewResult>> results){
		Map<Long, String> product = productService.query(WMS);
		for(FundViewResult result : results.getR()){
			Date lastReportDay = getLastReportDay(result.getReportDate());
	        Map<String, Object> fundParam = MapUtils.getParamMap("reportDay", DateUtils.formatForDay(lastReportDay));
	        fundParam.put("poolId", result.getPoolId());
	        InvestmentFund lastFund = dalClient.queryForObject(FUND, fundParam, InvestmentFund.class);
	        set(result,lastFund);
	        result.setReportPeriodBegin(result.getInitLoanDay().after(lastReportDay) ? result.getInitLoanDay() : getreportPeriodBegin(result.getReportDate()));
	        result.set(product); 
	        result.setAccountLevel(Assert.checkParam(result.getAccountLevel()) ? result.getAccountLevel() : "财富账户");
		}
	}
	
	private void set(FundViewResult result,InvestmentFund fund){
		result.setTotalAmount(result.getNextTransferTotalAmount().subtract(result.getAccountManageAmount()).subtract(result.getIncome()));
		if (result.getProductId()==34L && result.getCurrentPeriod()== 1) {
			result.setRecycleAmount(result.getNextInterestTotalAmount().add(result.getNextPrincalTotalAmount()));
		}else{
			result.setRecycleAmount(result.getNextInterestTotalAmount().add(result.getNextPrincalTotalAmount()).subtract(result.getAccountManageAmount()));
		}
		result.setLoanAmount(result.getNextInterestTotalAmount().add(result.getNextPrincalTotalAmount()).subtract(result.getAccountManageAmount()).subtract(result.getIncome()));
		result.setAccountManageRate(Assert.equals(result.getProductId(), 11L,12L) ? result.getAccountManageRate() : BigDecimal.ZERO);
		BigDecimal lastTotalAmount = Assert.equals(result.getCurrentPeriod(),1) ? BigDecimal.ZERO : fund.getNextTransferTotalAmount().subtract(fund.getAccountManagementFee()).subtract(fund.getLenderIncomeAmount());
		result.setLastTotalAmount(lastTotalAmount);
	}


	private Date getLastReportDay(Date reportDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reportDay);
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}
	
	private Date getreportPeriodBegin(Date reportDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reportDay);
		calendar.add(Calendar.MONTH, -1);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

}
