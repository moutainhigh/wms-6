package com.dx.wms.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.enums.PayWay;
import com.dx.wms.enums.RecoveryMode;
import com.dx.wms.service.ICommonService;

@Service
public class ApplyModel extends ModelRegister {

	/**
	 * 通用服务
	 */
	@Autowired
	ICommonService commonService;

	@Override
	public ModelMap init(ParamModel param, ModelMap map) {
		super.init(param, map);
		map.addAttribute(PRODUCTALL, commonService.getAllProduct(true))
				.addAttribute(PRODUCT, commonService.getProductByProductId()).addAttribute(PAY_WAY, PayWay.getMap())
				.addAttribute(RECOVERY_MODE, RecoveryMode.getMap())
				.addAttribute(AREAS, regionService.getMapByParentCode(WMSConstants.ROOT))
				.addAttribute(BANK_CATEGORY, BankCategery.getMap()).addAttribute(RESKEY, ResKey.WMS_APPLY.getInfo());
		return map;
	}

	@Override
	public Boolean supports(ParamModel param) {
		return Assert.equals(param.getType(), ModelType.APPLY) || Assert.equals(param.getType(), ModelType.DUEAPPLY);
	}

}
