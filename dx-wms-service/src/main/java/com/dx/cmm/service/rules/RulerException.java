package com.dx.cmm.service.rules;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

public class RulerException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 4153491971393799464L;

    public RulerException(String msg) {
        super(msg);
    }

    public RulerException(String pattern, Object... args) {
        super(MessageFormat.format(pattern, args));
    }

}
