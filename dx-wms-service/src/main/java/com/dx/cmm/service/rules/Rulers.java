package com.dx.cmm.service.rules;

/**
 * 
 * 规则器
 *
 * @author tony
 */
public interface Rulers<P, R> {

    /**
     * 
     * 功能描述: <br>
     * 根据参数解析
     *
     * @param param
     * @return
     */
    R parse(P param);
}
