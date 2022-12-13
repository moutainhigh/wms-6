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
 * 客户账户编号为空
 * @author 王蕊
 */
public class CustAccountIdIsNullException extends BaseException {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 4748953441012134421L;

    private static final String CODE = "200002";

    private static final String LOG_MSG = "客户账户编号为空";
    
    /**
     * @param code
     * @param LOG_MSG
     */
    public CustAccountIdIsNullException() {
        super(CODE, LOG_MSG);
    }


}
