/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ObjectIsNullException.java
 * Author:   王蕊
 * Date:     2015年7月15日 上午10:38:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.exception;

import com.dx.framework.exception.BaseException;

/**
 * 产品服务入参异常
 *
 * @author 王蕊
 */
public class ProductIPisErrorException extends BaseException {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 5488535661814746296L;

    private static final String CODE = "100101";

    private static final String LOG_MSG = "参数对象异常";

    /**
     * @param code
     * @param LOG_MSG
     */
    public ProductIPisErrorException() {
        super(CODE, LOG_MSG);
    }

    public ProductIPisErrorException(String logMsg) {
        super(CODE, logMsg);
    }
}
