package com.dx.cmm.service.calc;

import com.dx.cmm.service.manager.Biz;

/**
 * 
 * 计算器
 *
 * @author tony
 */
public interface Calc<T, R> extends Biz<T> {

    /**
     * 
     * 功能描述: <br>
     * 运算
     *
     * @param param
     * @return
     */
    R calc(T param) throws CalcException;

}
