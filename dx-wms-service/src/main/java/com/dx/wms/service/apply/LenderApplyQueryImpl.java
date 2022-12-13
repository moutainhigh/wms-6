package com.dx.wms.service.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;

@Service
public class LenderApplyQueryImpl implements ILenderApplyQuery{
	
    @Autowired
    private ILenderApplyDao applyDao;
	
	@Override
	public LenderApply queryByLenderCode(String lenderCode) {
		Assert.notNull("lenderCode is can not be null",lenderCode);
		return applyDao.getLenderApplyByCode(lenderCode);
	}

}
