package com.dx.wms.service.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 更新异常
 *
 * @author tony
 */
public class UpdateException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 7883456862172689472L;

    public UpdateException(String msg) {
        super(msg);
    }

    public UpdateException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
