package com.dx.cmm.service.manager;

/**
 * 
 * 执行者
 *
 * @author tony
 */
public interface Executor<P> {
    /**
     * 
     * 执行
     *
     * @param param
     */
    void execute(P param);
}
