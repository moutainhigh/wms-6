package com.dx.cmm.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 复制异常<br>
 * 复制异常
 *
 * @author tony
 */
public class CopyException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 8905261593010106891L;

    public CopyException(String msg) {
        super(msg);
    }

    public CopyException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
