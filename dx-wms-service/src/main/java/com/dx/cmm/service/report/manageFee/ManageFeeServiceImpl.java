package com.dx.cmm.service.report.manageFee;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.service.IAMService;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.BankCategery;
import com.google.gson.Gson;

@Service
public class ManageFeeServiceImpl implements IManageFeeService{
	/**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ManageFeeServiceImpl.class);
    
    private static final String ZERO = "0.00";
    
    @Autowired
    private IManageFeeDao manageFeeDao;
    
    @Autowired
    private IAMService amService;
    
    @Override
	public PaginationResult<List<ManageFeeResult>> queryManageFee(
			ManageFeeParam param, Pagination page) {
        Assert.notNull("Param must not be null", param);
        LOG.info("Param[{}]", new Gson().toJson(param));
		return manageFeeDao.queryManageFee(param, page) ;
	}

	@Override
	public PaginationResult<List<ManageFeeResult>> queryAndAssembleManageFee(
			ManageFeeParam param, Pagination page) {
		if(!Assert.checkParam(param.getLenderCode()) && "-1".equals(param.getBillDay()) && !Assert.checkParam(param.getStatisticDate())){
			page.setTotalRows(0);
			return new PaginationResult<List<ManageFeeResult>>(new ArrayList<ManageFeeResult>(),page); 
		}
		PaginationResult<List<ManageFeeResult>> resultPage = queryManageFee(param,page);
		List<ManageFeeResult> results = new ArrayList<ManageFeeResult>();
		for(ManageFeeResult manageFeeResult : resultPage.getR()){
			manageFeeResult.setOrgName(Assert.checkParam(amService.queryOrgById(manageFeeResult.getOrgId()))?amService.queryOrgById(manageFeeResult.getOrgId()).getName():"-");
			manageFeeResult.setBankName(Assert.checkParam(manageFeeResult.getBankCategory())?BankCategery.getInfo(Integer.valueOf(manageFeeResult.getBankCategory()))+manageFeeResult.getBankName():"-");
			manageFeeResult.setAccountLevelName(Assert.checkParam(manageFeeResult.getAccountLevelName())?manageFeeResult.getAccountLevelName():"财富账户");
			manageFeeResult.setAccountManagementFeeView(AmountUtils.format(manageFeeResult.getAccountManagementFee(),ZERO));
			String repayDay = DateUtils.formatForDay(manageFeeResult.getReportDay());
			manageFeeResult.setBillDay(repayDay.substring(9).equals("1")?"1":"16");
			manageFeeResult.setStatisticDate(repayDay.substring(0, 7));
			results.add(manageFeeResult);
		}
		return new PaginationResult<List<ManageFeeResult>>(results,page);
	}
	
}
