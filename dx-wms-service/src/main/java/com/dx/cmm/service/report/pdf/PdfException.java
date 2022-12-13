package com.dx.cmm.service.report.pdf;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;
/**
 * 
 * pdf异常
 *
 * @author tony
 */
public class PdfException extends BaseException{

    /**
     */
    private static final long serialVersionUID = -2788329904675173235L;

    public PdfException(String msg) {
        super(msg);
    }

    public PdfException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }
}
