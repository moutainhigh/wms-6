package com.dx.cmm.service.restorer;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

public class RepairException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 489952061167182903L;

    public RepairException(String msg) {
        super(msg);
    }

    public RepairException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
