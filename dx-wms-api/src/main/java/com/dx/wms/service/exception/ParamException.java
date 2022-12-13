package com.dx.wms.service.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 参数异常<br>
 * 参数异常
 *
 * @author tony
 */
public class ParamException extends BaseException {

    /**
     */
    private static final long serialVersionUID = -6779570242958523796L;
    
    public ParamException(String msg) {
        super(msg);
    }

    public ParamException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
