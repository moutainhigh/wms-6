package com.dx.cmm.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 保存异常
 *
 * @author tony
 */
public class SaveException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 6558442037257541709L;

    public SaveException(String msg) {
        super(msg);
    }

    public SaveException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
