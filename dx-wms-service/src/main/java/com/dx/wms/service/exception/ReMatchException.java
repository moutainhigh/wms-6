/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountIdIsNullException.java
 * Author:   王蕊
 * Date:     2015年7月29日 上午11:30:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.exception;

import java.text.MessageFormat;

import com.dx.framework.exception.BaseException;

/**
 * 客户账户编号为空
 * @author 王蕊
 */
public class ReMatchException extends BaseException {

	 /**
     */
    private static final long serialVersionUID = -7703223219472655931L;

    public ReMatchException(String msg) {
        super(msg);
    }

    public ReMatchException(String msg, Object... args) {
        super(MessageFormat.format(msg, args));
    }



}
