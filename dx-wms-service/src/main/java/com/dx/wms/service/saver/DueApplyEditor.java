package com.dx.wms.service.saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.wrapper.Wrapper;

@Service
public class DueApplyEditor extends DueSaver {
    @Autowired
    private Wrapper<BaseEntitys> applyWrapper;

    @Override
    public Boolean supports(ParamSaver param) {
        return Assert.equals(param.getAction(), SaverAction.EDIT) && super.supports(param);
    }

    @Override
    public void wrapper(ParamSaver param, ResultSaver result) {
        super.wrapper(param, result);
        applyWrapper.put(param.getId(), result);
    }
}
