package com.dx.cmm.service.manager;

import com.dx.cmm.exception.OperateException;

/**
 * 
 * 运算器
 *
 * @author tony
 */
public interface Operator<P> {

    /**
     * 
     * 功能描述: <br>
     * 运算
     *
     * @param param
     */
    void operate(P param) throws OperateException;

}
