package com.dx.wms.service.saver;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.common.service.utils.Assert;
import com.dx.rule.service.ICodeRuleService;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.exception.SaveException;
import com.dx.wms.service.wrapper.Wrapper;

public abstract class SaverRegister implements Saver {

    @Autowired
    private SaverObserver saver;

    @Autowired
    protected ICodeRuleService code;

    @Autowired
    protected Wrapper<BaseEntitys> accountWrapper;
    
    @Override
    @PostConstruct
    public void join() {
        saver.regist(this);
    }

    @Override
    public String init(ParamSaver param) {
        return "/save/save";
    }

    protected void check(ParamSaver param) {
        Assert.notNull("Param must not be null", param);
        Assert.notNull("Id must not be null", param.getId());
    }

    protected SaveException error(String msg, Object... args) {
        throw new SaveException(msg, args);
    }

    protected void view(ParamSaver param, ResultSaver result) {
        result.setWidth(param).setTitle(param);
    }

    public void wrapper(ParamSaver param, ResultSaver result) {
        check(param);
        view(param, result);
    }
}
