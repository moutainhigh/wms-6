package com.dx.cmm.service.report;



import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.MonthParamCalc;
import com.dx.cmm.service.calc.ResultIntParamCalc;
import com.dx.cmm.service.report.dto.PastParamDto;
import com.dx.cmm.service.report.dto.PastProtocolViewResult;
import com.dx.cmm.service.report.dto.PastResult;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.view.CreditViewResult;
import com.dx.cmm.service.view.excel.ExcPastResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.exception.BaseException;
import com.dx.wms.service.IProductService;



public class PastViewServiceImpl implements IPastViewService{
	
	private static final String INVEST = "past.queryInvest";

    private static final String CREDIT = "past.queryCredit";

    private static final String KEY = "match:view:past:";

    private static final String PAST = "非首期债权转让及受让协议-";
    
    private static final String PAST_PLUS = "非首期债权转让及受让协议-";
	
	private static final String BLANK = " ";
    @Autowired
    private Calc<ResultIntParamCalc, BigDecimal> resultIntSuccessCalc;

    @Autowired
    private Calc<MonthParamCalc, Integer> monthCalc;

    
    @Autowired
    protected PaginationDalClient dalClient;

    @Autowired
    protected IProductService productService;
    
    static final Logger LOG = LoggerFactory.getLogger(PastProtocolViewResult.class);
    
	@Override
	public PastProtocolViewResult getPreData(String lenderCode,String createTimePre, String reportDayPre) {
		if (!Assert.checkParam(lenderCode)) {
            LOG.error("Lender code must not be null");
            return new PastProtocolViewResult();
        }
		Map<String,String> productMap = new HashMap<String,String>();
		try{
			productMap = productService.getProductByAppAndProductId("wms", -1L);
		}catch(Exception e){
			LOG.error("get past or pastPlus data try to get productMap failed");
			throw new BaseException("try to get productMap failed");
		}
		
		PastProtocolViewResult result = null;
//        LOG.info("Lender code[{}] ready to query for data", lenderCode);
        Map<String, String> queryInvestParam = new HashMap<String,String>();
        queryInvestParam.put("lenderCode", lenderCode);
        queryInvestParam.put("createTimePre",createTimePre);
        queryInvestParam.put("reportDayPre", reportDayPre);
        result = dalClient.queryForObject(INVEST, queryInvestParam,PastProtocolViewResult.class);
        result.matchTime();
        Map<String,String> queryCreditParam = new HashMap<String,String>();
        queryCreditParam.put("poolId", String.valueOf(result.getPoolId()));
        queryCreditParam.put("currentPeriod", String.valueOf(result.getCurrentPeriod()));
        queryCreditParam.put("createTimePre",createTimePre);
        List<CreditViewResult> results = dalClient.queryForList(CREDIT,
        		queryCreditParam, CreditViewResult.class);
        BigDecimal interest = BigDecimal.ZERO;
        BigDecimal capital = BigDecimal.ZERO;
        BigDecimal transTotalAmount = BigDecimal.ZERO;
        Integer index = 1;
        for (CreditViewResult credit : results) {
            interest = interest
                    .add(resultIntSuccessCalc.calc(new ResultIntParamCalc(new MatchResult(1, credit.getTransInterest()),
                            result.getInitMatchTime(), result.getBillDay())));
            capital = capital.add(credit.getTransCapital());
            transTotalAmount = transTotalAmount.add(credit.getTransAmount());
            CreditAttr attr = credit(credit.getAttr());
            credit.parse(index, attr);
            index++;
        }
        try{
        	result.parse(capital, interest, productMap, results,transTotalAmount);
        }catch(Exception er){
        	LOG.error("set-up data is fail*** lenderCode=[{}],createTime=[{}],reportDay=[{}]",lenderCode,createTimePre,reportDayPre);
        	throw new BaseException("set-up data is fail");
        }
        return result;
	}
	
	 private CreditAttr credit(String attr) {
	    return Assert.checkParam(attr) ? JSON.parseObject(attr, CreditAttr.class) : new CreditAttr();
	 }

	@Override
	public List<ExcPastResult> queryExc(PastParamDto param) {
		SimpleDateFormat getTime = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = param.getCreateTime();
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(getTime.parse(param.getReportDate()));
		} catch (ParseException e1) {
			LOG.error("queryExc() try to get reportDate has failed");
			throw new BaseException("queryExc() try to get reportDate from param has failed");
		}
		cal.add(GregorianCalendar.MONTH, -1);
		String reportDate = param.getReportDate();
		String reportDate4Exp = getTime.format(cal.getTime());;
		List<ExcPastResult> array = new ArrayList<ExcPastResult>();
		
		Pagination page = new Pagination();
		page.setCurrentPage(0);
		page.setPagesize(-1);
		PaginationResult<List<PastResult>> resultCodes = 
				dalClient.queryForList("past.queryPastList", MapUtils.obj2Map(param), PastResult.class, page);
		
		try{
			for(PastResult code : resultCodes.getR()){
				Map<String, String> queryInvestParam = new HashMap<String,String>();
				ExcPastResult excelResults = new ExcPastResult();
		        queryInvestParam.put("lenderCode", code.getLenderCode());
		        queryInvestParam.put("createTimePre",createTime);
		        queryInvestParam.put("reportDayPre", reportDate);
		        PastProtocolViewResult investResult = dalClient.queryForObject(INVEST, queryInvestParam,PastProtocolViewResult.class);
		        if (!Assert.checkParam(investResult)) {
		            LOG.error("queryExc() queryInvest is null lenderCode=[{}],createTimePre=[{}],reportDayPre=[{}]",
		            		code.getLenderCode(),createTime,reportDate);
		        }
				excelResults.setCustName(investResult.getCustName());
				excelResults.setIdCard(investResult.getIdCard());
				excelResults.setCustAddress(investResult.getCustAddress());
				excelResults.setZipCode(investResult.getZipCode());
				excelResults.setLenderCode(investResult.getLenderCode());
				excelResults.setBillDay(investResult.getBillDay());
				excelResults.setReportDay(reportDate4Exp);
				
				Map<String,String> queryCreditParam = new HashMap<String,String>();
		        queryCreditParam.put("poolId", String.valueOf(investResult.getPoolId()));
		        queryCreditParam.put("currentPeriod", String.valueOf(investResult.getCurrentPeriod()));
		        queryCreditParam.put("createTimePre",createTime);
		        List<CreditViewResult> creditResults = dalClient.queryForList(CREDIT,
		        		queryCreditParam, CreditViewResult.class);
		        BigDecimal interest = BigDecimal.ZERO;
		        BigDecimal capital = BigDecimal.ZERO;
				for(CreditViewResult credit: creditResults){
					ExcPastResult excel = new ExcPastResult();
					BeanUtils.copyProperties(excelResults, excel);
					interest = interest
		                    .add(resultIntSuccessCalc.calc(new ResultIntParamCalc(new MatchResult(1, credit.getTransInterest()),
		                    		investResult.getInitMatchTime(), investResult.getBillDay())));
		            capital = capital.add(credit.getTransCapital());
		            CreditAttr attr = credit(credit.getAttr());
		            credit.parse(attr);
		            
		            excel.setLendName(credit.getCustName());
					excel.setLendIdCard(credit.getIdCard());
					excel.setTransferTotalAmountView(credit.getTransAmountView());
					excel.setPayGiveAmountView(credit.getPayAmountView());
					excel.setLendJob(credit.getProfession());
					excel.setLendUsing(credit.getPurpose());
					excel.setReturnDate(credit.getRepayDateView());
					excel.setPeriod(String.valueOf(credit.getInitPeriod()));
					excel.setLeftPeriod(String.valueOf(credit.getRemainPeriod()));
					excel.setYieldRate(credit.getRateYearView());
					excel.setInitTotalAmountView(credit.getInitTotalAmountView());
					array.add(excel);
				}
			}
		}catch(Exception e){
			LOG.error("queryExc() exception is [{}].param is [{}]",e,JSON.toJSONString(param));
		}
		
		return array;
	}

	@Override
	public List<PastProtocolViewResult> getPdfData(PastParamDto param) {
		if (!Assert.checkParam(param)) {
            LOG.error("getPdfData() param must not be null");
            return new ArrayList<PastProtocolViewResult>();
        }
		String createTime = param.getCreateTime();
		String reportDate = param.getReportDate();
		List<PastProtocolViewResult> results = new ArrayList<PastProtocolViewResult>();
		if("query".equals(param.getIsQuery())){
			Pagination page = new Pagination();
			page.setCurrentPage(0);
    		page.setPagesize(-1);
			PaginationResult<List<PastResult>> resultCodes = null;
			
			try{
				resultCodes=dalClient.queryForList("past.queryPastList", MapUtils.obj2Map(param), PastResult.class, page);
			}catch(Exception e){
				LOG.error("getPdfData() query lenderCode has error*** param is [{}]", JSON.toJSONString(param));
				throw new BaseException("getPdfData() query lenderCode has error",e);
			}
					
			for(PastResult code : resultCodes.getR()){
				String lenderCode = code.getLenderCode();
				
				PastProtocolViewResult one = new PastProtocolViewResult();
				try{
					one= getPreData(lenderCode,createTime,reportDate);
				}catch(Exception pe){
					LOG.error("getPdfData() query pdfData has error*** lenderCode=[{}], createTime=[{}], reportDate=[{}]",
							lenderCode,createTime,reportDate);
					throw new BaseException("getPdfData() query pdfData has error",pe);
				}
				
				StringBuffer fileNameBuffer = new StringBuffer();
				one.setFileName(fileNameBuffer.append(PAST).append(one.getReportDayView().replace("-", "")).append("期").
						append(BLANK).append(one.getCustName()).append(BLANK).append(one.getLenderCode()).toString());
				results.add(one);
			}
		}else{
			for(String lenderCode : param.getLenderCodes()){
				
				PastProtocolViewResult one = new PastProtocolViewResult();
				try{
					one= getPreData(lenderCode,createTime,reportDate);
				}catch(Exception pe){
					
					LOG.error("getPdfData() query pdfData has error*** lenderCode=[{}], createTime=[{}], reportDate=[{}]",
							lenderCode,createTime,reportDate);
					
					throw new BaseException("getPdfData() query pdfData has error",pe);
				}
				
				StringBuffer fileNameBuffer = new StringBuffer();
				one.setFileName(fileNameBuffer.append(PAST).append(one.getReportDayView().replace("-", "")).append("期").
						append(BLANK).append(one.getCustName()).append(BLANK).append(one.getLenderCode()).toString());
				results.add(one);
			}
		}
		
		return results;
	}

	@Override
	public List<PastProtocolViewResult> getPlusPdfData(PastParamDto param) {
		if (!Assert.checkParam(param)) {
            LOG.error("getPlusPdfData() param must not be null");
            return new ArrayList<PastProtocolViewResult>();
        }
		String createTime = param.getCreateTime();
		String reportDate = param.getReportDate();
		List<PastProtocolViewResult> results = new ArrayList<PastProtocolViewResult>();
		if("query".equals(param.getIsQuery())){
			Pagination page = new Pagination();
			page.setCurrentPage(0);
    		page.setPagesize(-1);
    		PaginationResult<List<PastResult>> resultCodes = null;
			
			try{
				resultCodes=dalClient.queryForList("past.queryPastList", MapUtils.obj2Map(param), PastResult.class, page);
			}catch(Exception e){
				LOG.error("getPludsPdfData() query lenderCode has error*** param is [{}]", JSON.toJSONString(param));
				throw new BaseException("getPlusPdfData() query lenderCode has error",e);
			}
			
			for(PastResult code : resultCodes.getR()){
				String lenderCode = code.getLenderCode();
				
				PastProtocolViewResult one = new PastProtocolViewResult();
				try{
					one= getPreData(lenderCode,createTime,reportDate);
				}catch(Exception pe){
					LOG.error("getPlusPdfData() query pdfData has error*** lenderCode=[{}], createTime=[{}], reportDate=[{}]",
							lenderCode,createTime,reportDate);
					throw new BaseException("getPlusPdfData() query pdfData has error",pe);
				}
				
				StringBuffer fileNameBuffer = new StringBuffer();
				one.setFileName(fileNameBuffer.append(PAST_PLUS).append(one.getReportDayView().replace("-", "")).append("期(补)").
						append(BLANK).append(one.getCustName()).append(BLANK).append(one.getLenderCode()).toString());
				results.add(one);
			}
		}else{
			for(String lenderCode : param.getLenderCodes()){
				PastProtocolViewResult one = new PastProtocolViewResult();
				
				try{
					one= getPreData(lenderCode,createTime,reportDate);
				}catch(Exception pe){
					LOG.error("getPlusPdfData() query pdfData has error*** lenderCode=[{}], createTime=[{}], reportDate=[{}]",
							lenderCode,createTime,reportDate);
					throw new BaseException("getPlusPdfData() query pdfData has error",pe);
				}
				
				StringBuffer fileNameBuffer = new StringBuffer();
				one.setFileName(fileNameBuffer.append(PAST_PLUS).append(one.getReportDayView().replace("-", "")).append("期(补)").
						append(BLANK).append(one.getCustName()).append(BLANK).append(one.getLenderCode()).toString());
				results.add(one);
			}
		}
		
		return results;
	}

}
