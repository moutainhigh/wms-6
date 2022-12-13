package com.dx.cmm.service.report.manageFee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Component
public class ManageFeeDaoImpl implements IManageFeeDao {
    
	@Autowired
    private PaginationDalClient dalClient;
    
    @Override
	public PaginationResult<List<ManageFeeResult>> queryManageFee(
			ManageFeeParam param, Pagination page) {
        Assert.notNull("Param must not be null", param);
        if("1".equals(param.getBillDay())){
        	param.setBillDay("01");
        }
		return dalClient.queryForList("matchBizBase.queryManageFee", MapUtils.obj2Map(param), ManageFeeResult.class, page) ;
	}
}
