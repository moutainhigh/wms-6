package com.dx.wms.service.validators;

import org.springframework.validation.Validator;

import com.dx.cmm.exception.ParamException;

public abstract class BaseValidator implements Validator {

    public ParamException error(String msg) {
        return new ParamException(msg);
    }

    public ParamException error(String msg, Object... objects) {
        return new ParamException(msg, objects);
    }
}
