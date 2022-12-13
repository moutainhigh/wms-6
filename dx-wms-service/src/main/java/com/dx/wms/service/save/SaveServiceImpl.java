package com.dx.wms.service.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.wms.service.saver.ParamSaver;
import com.dx.wms.service.saver.ResultSaver;

@Service
public class SaveServiceImpl implements ISaveService {

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> accountSaveHandler;

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> commSaveHandler;

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> linkmanSaveHandler;

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> professionSaveHandler;

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> applySaveHandler;

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> financesSaveHandler;

    @Autowired
    private SaveHandler<ParamSaver, HandlerDto, ResultSaver> conditionsSaveHandler;

    @Override
    @Transactional
    public void save(String biz, ParamSaver param, HandlerDto dto, ResultSaver saver) {
        if (Assert.equals(biz, "account")) {
            saveAccount(param, dto, saver);
        } else if (Assert.equals(biz, "apply")) {
            saveApply(param, dto, saver);
        }
    }

    private void saveAccount(ParamSaver param, HandlerDto dto, ResultSaver saver) {
        switch (param.getIndexId()) {
            case 1:
                break;
            case 2:
                accountSaveHandler.setSuccessor(professionSaveHandler);
                accountSaveHandler.handleSaveRequest(param, dto, saver);
                break;
            case 3:
                commSaveHandler.setSuccessor(linkmanSaveHandler);
                commSaveHandler.handleSaveRequest(param, dto, saver);
                break;
        }
    }

    private void saveApply(ParamSaver param, HandlerDto dto, ResultSaver saver) {
        switch (param.getIndexId()) {
            case 1:
                break;
            case 2:
                applySaveHandler.setSuccessor(financesSaveHandler);
                financesSaveHandler.setSuccessor(conditionsSaveHandler);
                applySaveHandler.handleSaveRequest(param, dto, saver);
                break;
        }
    }

}
