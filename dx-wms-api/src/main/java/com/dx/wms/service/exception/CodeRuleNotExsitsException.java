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
 * 异常:编号规则不存在
 *
 * @author 蔡登勇
 */
public class CodeRuleNotExsitsException extends BaseException {

    /**
     * serial UID
     */
    private static final long serialVersionUID = -7591432888371022613L;

    private static final String CODE = "100302";

    private static final String LOG_MSG = "未配置对应的编号规则，请检查请求参数";

    /**
     * @param code
     * @param LOG_MSG
     */
    public CodeRuleNotExsitsException() {
        super(CODE, LOG_MSG);
    }

    public CodeRuleNotExsitsException(String logMsg) {
        super(CODE, logMsg);
    }
}
