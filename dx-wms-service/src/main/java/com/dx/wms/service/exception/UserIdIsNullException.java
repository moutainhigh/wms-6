/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: UserIdIsNullException.java
 * Author:   王蕊
 * Date:     2015年7月15日 上午11:11:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.exception;

import com.dx.framework.exception.BaseException;

/**
 * 异常：用户编号为空
 *
 * @author 王蕊
 */
public class UserIdIsNullException extends BaseException {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 1490953787469680345L;

    private static final String CODE = "200001";

    private static final String LOG_MSG = "操作用户 UserId 为空";

    /**
     * @param code
     * @param LOG_MSG
     */
    public UserIdIsNullException() {
        super(CODE, LOG_MSG);
    }

}
