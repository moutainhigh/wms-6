package com.dx.cmm.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 推送异常<br>
 * 推送异常
 *
 * @author tony
 */
public class PushException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 6558442037257541709L;

    public PushException(String msg) {
        super(msg);
    }

    public PushException(String msg, Object... objects) {
        super(MessageFormat.format(msg, objects));
    }
}
