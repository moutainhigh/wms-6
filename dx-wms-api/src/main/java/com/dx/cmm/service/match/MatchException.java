package com.dx.cmm.service.match;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 匹配异常
 *
 * @author tony
 */
public class MatchException extends BaseException {

    /**
     */
    private static final long serialVersionUID = -1904923161653137273L;

    public MatchException(String msg) {
        super(msg);
    }

    public MatchException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }

}
