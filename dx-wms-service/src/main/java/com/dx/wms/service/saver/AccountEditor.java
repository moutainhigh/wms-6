package com.dx.wms.service.saver;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;

@Service
public class AccountEditor extends AccountSaver {

    @Override
    public Boolean supports(ParamSaver param) {
        return Assert.equals(param.getAction(), SaverAction.EDIT) && super.supports(param);
    }

    @Override
    public void wrapper(ParamSaver param, ResultSaver result) {
        super.wrapper(param, result);
        accountWrapper.put(param.getId(), result);
    }

}
