package com.dx.cmm.service.chain;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

public class ChainExecption extends BaseException {

    /**
     */
    private static final long serialVersionUID = -2914023934416211738L;

    public ChainExecption(String msg) {
        super(msg);
    }

    public ChainExecption(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
