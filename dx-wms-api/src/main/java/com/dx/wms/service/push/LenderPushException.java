package com.dx.wms.service.push;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

public class LenderPushException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 5844598664077074341L;

    public LenderPushException(String msg) {
        super(msg);
    }

    public LenderPushException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
