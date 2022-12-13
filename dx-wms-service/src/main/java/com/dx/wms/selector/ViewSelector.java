package com.dx.wms.selector;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;

@Service
public class ViewSelector extends SelectorRegister {

    @Override
    public Boolean supports(ParamSelector param) {
        return Assert.equals(param.getType(), SelectorType.VIEW);
    }
}
