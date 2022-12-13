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
 * 匹配业务保存入参异常
 *
 * @author 蔡登勇
 */
public class MatchBizIPIsErrorException extends BaseException {

    /**
     * serial UID
     */
    private static final long serialVersionUID = -7591432888371022613L;

    private static final String CODE = "100201";

    private static final String LOG_MSG = "匹配业务基础数据入参有误";

    /**
     * @param code
     * @param LOG_MSG
     */
    public MatchBizIPIsErrorException() {
        super(CODE, LOG_MSG);
    }

    public MatchBizIPIsErrorException(String logMsg) {
        super(CODE, logMsg);
    }
}
