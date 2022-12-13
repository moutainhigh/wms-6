package com.dx.wms.service.manager;

/**
 * 
 * 初始器
 *
 * @author tony
 */
public interface Initializer<P> {

    /**
     * 
     * 初始化
     *
     * @param param
     * @return
     */
    String init(P param);
}
