package com.dx.cmm.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 运算异常<br>
 * 运算异常
 *
 * @author tony
 */
public class OperateException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 6558442037257541709L;

    public OperateException(String msg) {
        super(msg);
    }

    public OperateException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
