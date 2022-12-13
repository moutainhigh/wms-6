package com.dx.cmm.service.interest;

import java.util.List;

import com.dx.cmm.service.ViewAbs;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public class InterestGateway extends ViewAbs implements InterestService{
	
	private final static String INTEREST = "interest.queryInterest";
	
	private final static Long L002 = 12L;
	
	private final static Long L007 = 34L;
	
	@Override
	public PaginationResult<List<InterestResult>> queryInterest(InterestParam param, Pagination page) {
		 if(Assert.checkParam(param.getProductId()) && !Assert.equals(param.getProductId(),L002,L007)){
			 LOG.error("productId is error");
			 return new PaginationResult<List<InterestResult>>();
		 }
		return dalClient.queryForList(INTEREST, MapUtils.obj2Map(param),InterestResult.class,page);
	}

}
