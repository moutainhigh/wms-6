package com.dx.wms.service.manager;

/**
 * 
 * 注册器<br>
 * 注册器
 *
 * @author tony
 */
public interface Register<S> {

    /**
     * 
     * 注册服务
     *
     * @param service
     */
    void regist(S service);
}
