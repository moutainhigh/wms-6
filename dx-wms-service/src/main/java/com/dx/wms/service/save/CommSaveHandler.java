package com.dx.wms.service.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.ICustAccountService;
import com.dx.wms.service.saver.ParamSaver;
import com.dx.wms.service.saver.ResultSaver;

@Service("commSaveHandler")
public class CommSaveHandler extends SaveHandler<ParamSaver, HandlerDto, ResultSaver> {

    @Autowired
    private ICustAccountService custAccountService;

    @Override
    public void handleSaveRequest(ParamSaver condition, HandlerDto dto, ResultSaver result) {
        custAccountService.saveComm(condition.getComm(), dto, result);
        if (Assert.checkParam(getSuccessor())) {
            getSuccessor().handleSaveRequest(condition, dto, result);
        }
    }

}
