package com.dx.wms.service.saver;

import com.dx.common.service.utils.Assert;

public abstract class ApplySaver extends SaverRegister {

    public Boolean supports(ParamSaver param) {
        return Assert.equals(param.getType(), SaverType.APPLY);
    }

    public void wrapper(ParamSaver param, ResultSaver result) {
        super.wrapper(param, result);
    }
}
