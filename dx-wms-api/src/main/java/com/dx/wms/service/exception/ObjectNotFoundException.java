package com.dx.wms.service.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 对象未找到异常
 *
 * @author tony
 */
public class ObjectNotFoundException extends BaseException {

    /**
     */
    private static final long serialVersionUID = -1389097794313619431L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
