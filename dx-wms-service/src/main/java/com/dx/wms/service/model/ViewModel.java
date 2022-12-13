package com.dx.wms.service.model;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.enums.CustSource;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.Sex;

@Service
public class ViewModel extends ModelRegister {

    @Override
    public ModelMap init(ParamModel param, ModelMap map) {
        super.init(param, map);
        map.addAttribute(SEX, Sex.getMap()).addAttribute(ID_TYPE, IdType.getMap()).addAttribute(CUST_SOURCE,
                CustSource.getMap());
        return map;
    }

    @Override
    public Boolean supports(ParamModel param) {
        return Assert.equals(param.getType(), ModelType.VIEW);
    }

}
