/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: InputParamIsNullException.java
 * Author:   蔡登勇
 * Date:     2015年7月16日 下午3:10:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.exception;

import com.dx.framework.exception.BaseException;

/**
 * 入参为空异常
 *
 * @author 蔡登勇
 */
public class InputParamIsNullException extends BaseException {
    /**
     * serial UID
     */
    private static final long serialVersionUID = 1488535661814746296L;

    private static final String CODE = "000001";

    private static final String LOG_MSG = "入参为空";

    /**
     * @param code
     * @param LOG_MSG
     */
    public InputParamIsNullException() {
        super(CODE, LOG_MSG);
    }

    public InputParamIsNullException(String logMsg) {
        super(CODE, logMsg);
    }
}
