package com.dx.wms.service.apply;

import com.dx.wms.service.apply.entity.LenderApply;

public interface ILenderApplyQuery {
	
	LenderApply queryByLenderCode(String lenderCode);
}
