package com.dx.wms.service.saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;

@Service
public class DueApplyCreator extends DueSaver {

    @Autowired
    private ILenderApplyDao applyDao;

    @Override
    public Boolean supports(ParamSaver param) {
        return Assert.equals(param.getAction(), SaverAction.CREATE) && super.supports(param);
    }

    @Override
    public void wrapper(ParamSaver param, ResultSaver result) {
        super.wrapper(param, result);
        Long initApplyId = param.getId();
        result.setInitApplyId(initApplyId);
        LenderApply apply = applyDao.queryById(LenderApply.class, initApplyId);
        Long custAccountId = apply.getCustAccountId();
        Assert.notNull("custAccountId must not be null", custAccountId);
        accountWrapper.put(custAccountId, result);
    }
}
