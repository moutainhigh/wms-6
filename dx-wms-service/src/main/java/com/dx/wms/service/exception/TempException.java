package com.dx.wms.service.exception;

import com.dx.framework.exception.BaseException;

public class TempException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1309850478834325254L;

	private final static String CODE = "100000";

	private final static String MSG = "举例异常";

	public TempException() {
		super(CODE, MSG);
	}
}
