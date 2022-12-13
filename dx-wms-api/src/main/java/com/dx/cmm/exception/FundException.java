package com.dx.cmm.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 资金异常<br>
 * 资金异常
 *
 * @author tony
 */
public class FundException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 6558442037257541709L;

    public FundException(String msg) {
        super(msg);
    }

    public FundException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
