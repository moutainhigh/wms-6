package com.dx.wms.service.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

public class LenderLogException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 426485420790326748L;

    public LenderLogException(String msg) {
        super(msg);
    }

    public LenderLogException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
