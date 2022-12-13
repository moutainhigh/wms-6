/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRuleNotExsitsException.java
 * Author:   蔡登勇
 * Date:     2015年7月16日 下午3:22:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.exception;

import com.dx.framework.exception.BaseException;

/**
 * 计算机入参异常
 *
 * @author 蔡登勇
 */
public class CalculatorIPIsErrorException extends BaseException {

    /**
     */
    private static final long serialVersionUID = 5329579984962601827L;

    private static final String CODE = "100401";

    private static final String LOG_MSG = "计算机入参异常";

    /**
     * @param code
     * @param LOG_MSG
     */
    public CalculatorIPIsErrorException() {
        super(CODE, LOG_MSG);
    }

    public CalculatorIPIsErrorException(String logMsg) {
        super(CODE, logMsg);
    }
}
