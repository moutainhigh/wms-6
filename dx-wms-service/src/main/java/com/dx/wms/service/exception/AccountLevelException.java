/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountIdIsNullException.java
 * Author:   王蕊
 * Date:     2015年7月29日 上午11:30:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.exception;

import com.dx.framework.exception.BaseException;

/**
 * 账户金额获取服务费
 * @author 王蕊
 */
public class AccountLevelException extends BaseException {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 4748953441012134421L;

    private static final String CODE = "200002";

    private static final String LOG_MSG = "账户金额获取服务费异常";
    
    /**
     * @param code
     * @param LOG_MSG
     */
    public AccountLevelException() {
        super(CODE, LOG_MSG);
    }
    public AccountLevelException(String logMsg) {
        super(CODE, logMsg);
    }

}
