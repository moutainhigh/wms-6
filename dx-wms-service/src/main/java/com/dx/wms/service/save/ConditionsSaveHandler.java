package com.dx.wms.service.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.ILenderApplySaveService;
import com.dx.wms.service.saver.ParamSaver;
import com.dx.wms.service.saver.ResultSaver;

@Service("conditionsSaveHandler")
public class ConditionsSaveHandler extends SaveHandler<ParamSaver, HandlerDto, ResultSaver> {

    @Autowired
    private ILenderApplySaveService lenderApplySaveService;

    @Override
    public void handleSaveRequest(ParamSaver condition, HandlerDto dto, ResultSaver result) {
        lenderApplySaveService.saveConditions(condition.getConditions(), dto, result);
        if (Assert.checkParam(getSuccessor())) {
            getSuccessor().handleSaveRequest(condition, dto, result);
        }
    }
}
