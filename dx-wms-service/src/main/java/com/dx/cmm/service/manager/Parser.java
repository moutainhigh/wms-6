package com.dx.cmm.service.manager;

/**
 * 
 * 解析器
 *
 * @author tony
 */
public interface Parser<P, R> {

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
