package com.dx.wms.service.saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.wrapper.Wrapper;

@Service
public class AccountCreator extends AccountSaver {

    @Autowired
    private Wrapper<BaseEntitys> baseWrapper;

    @Override
    public Boolean supports(ParamSaver param) {
        return Assert.equals(param.getAction(), SaverAction.CREATE) && super.supports(param);
    }

    @Override
    public void wrapper(ParamSaver param, ResultSaver result) {
        super.wrapper(param, result);
        baseWrapper.put(param.getId(), result);

    }

}
