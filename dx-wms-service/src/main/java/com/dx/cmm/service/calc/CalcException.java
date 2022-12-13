package com.dx.cmm.service.calc;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

public class CalcException extends BaseException {

    /**
     */
    private static final long serialVersionUID = -4659659706345176234L;

    public CalcException(String msg) {
        super(msg);
    }

    public CalcException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
