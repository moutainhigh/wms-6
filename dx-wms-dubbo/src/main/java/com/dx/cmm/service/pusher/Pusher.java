package com.dx.cmm.service.pusher;

import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.base.DataService;

/**
 * 
 * 推送器
 *
 * @author tony
 */
public interface Pusher<T> extends DataService<T> {

    /**
     * 
     * 数据推送
     *
     * @param param
     * 
     */
    void push(T param) throws PushException;
}
