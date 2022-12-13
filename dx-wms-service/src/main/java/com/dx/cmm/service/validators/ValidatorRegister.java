package com.dx.cmm.service.validators;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.exception.ParamException;

public abstract class ValidatorRegister implements Validator<Object> {

    @Autowired
    private ValidatorObserver<Validator<Object>, Object> validatorObserver;

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param msg
     * @return
     */
    public ParamException error(String msg) {
        return new ParamException(msg);
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param msg
     * @param objects
     * @return
     */
    public ParamException error(String msg, Object... args) {
        return new ParamException(msg, args);
    }

    @Override
    @PostConstruct
    public void join() {
        validatorObserver.regist(this);
    }

}
