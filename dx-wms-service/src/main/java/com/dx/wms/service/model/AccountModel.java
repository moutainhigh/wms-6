package com.dx.wms.service.model;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.CustCategery;
import com.dx.wms.enums.CustSource;
import com.dx.wms.enums.Education;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.MaritalStatus;
import com.dx.wms.enums.MsgWay;
import com.dx.wms.enums.Profession;
import com.dx.wms.enums.RecoveryMode;
import com.dx.wms.enums.Sex;

@Service
public class AccountModel extends ModelRegister {

    @Override
    public ModelMap init(ParamModel param, ModelMap map) {
        super.init(param, map);
        map.addAttribute(SEX, Sex.getMap()).addAttribute(EDUCATION, Education.getMap())
                .addAttribute(ID_TYPE, IdType.getMap()).addAttribute(MARITAL_STATUS, MaritalStatus.getMap())
                .addAttribute(PROFESSION, Profession.getMap()).addAttribute(MSG_WAY, MsgWay.getMap())
                .addAttribute(CUST_SOURCE, CustSource.getMap()).addAttribute(CUST_CATEGORY, CustCategery.getMap())
                .addAttribute(AREAS, regionService.getMapByParentCode(WMSConstants.ROOT))
                .addAttribute(RECOVERY_MODE, RecoveryMode.getMap()).addAttribute(RESKEY, ResKey.WMS_OPEN.getInfo());
        return map;
    }

    @Override
    public Boolean supports(ParamModel param) {
        return Assert.equals(param.getType(), ModelType.ACCOUNT);
    }

}
