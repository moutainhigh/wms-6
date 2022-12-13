package com.dx.cmm.service.view;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.service.IProductService;

@Service("fundReportView")
public class FundReportView extends ViewAbs<FundViewResult>{
	
	private static final String INVEST = "fundView.queryInvest";
	
	private static final String FUND = "fundView.queryFund";
	
	private static final String KEY = "match:view:fund:";
	
	@Autowired
    private ICacheService<FundViewResult> cacheService;
	
	@Autowired
	private IProductService productService;
	
	@Override
	public FundViewResult query(String lenderCode, Date reportDay) {
		if (!Assert.checkParam(lenderCode)) {
            LOG.error("Lender code must not be null");
            return new FundViewResult();
        }
        String key = cacheService.initKey(KEY, DateUtils.formatForDay(reportDay),":" , lenderCode);
        FundViewResult result = cacheService.getObject(key, FundViewResult.class);
        if (Assert.checkParam(result)) {
            return result;
        }
        Map<String, Object> param = MapUtils.getParamMap("lenderCode", lenderCode);
        param.put("reportDay", DateUtils.formatForDay(reportDay));
        result = dalClient.queryForObject(INVEST, param,FundViewResult.class);
        LOG.info("*******************************JSON result = {}",JSON.toJSON(result));
        Date lastReportDay = getLastReportDay(reportDay);
        Map<String, Object> fundParam = MapUtils.getParamMap("reportDay", DateUtils.formatForDay(lastReportDay));
        fundParam.put("poolId", result.getPoolId());
        InvestmentFund lastFund = dalClient.queryForObject(FUND, fundParam, InvestmentFund.class);
        set(result,lastFund);
        result.setReportPeriodBegin(getreportPeriodBegin(result.getReportDate()));
        result.set(productService.query("wms"));
        LOG.info("*******************************JSON result = {}",JSON.toJSON(result));
		return result;
	}

	private void set(FundViewResult result,InvestmentFund fund){
		result.setTotalAmount(result.getNextTransferTotalAmount().subtract(result.getAccountManageAmount().subtract(result.getIncome())));
		result.setRecycleAmount(result.getNextInterestTotalAmount().add(result.getNextPrincalTotalAmount()).subtract(result.getAccountManageAmount()));
		result.setLoanAmount(result.getNextInterestTotalAmount().add(result.getNextPrincalTotalAmount()).subtract(result.getAccountManageAmount()).subtract(result.getIncome()));
		result.setAccountManageRate(Assert.equals(result.getProductId(), 11L,12L) ? result.getAccountManageRate() : BigDecimal.ZERO);
		BigDecimal lastTotalAmount = Assert.equals(result.getCurrentPeriod(),1) ? BigDecimal.ZERO : Assert.equals(result.getCurrentPeriod(), 2) ? result.getInitTotalAmount() : (fund.getNextTransferTotalAmount().subtract(fund.getAccountManagementFee()).subtract(fund.getLenderIncomeAmount()));
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
		calendar.set(Calendar.MONTH, -1);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}

	@Override
	public FundViewResult query(String lenderCode, Boolean isEffect) {
		// TODO Auto-generated method stub
		return null;
	}

}
