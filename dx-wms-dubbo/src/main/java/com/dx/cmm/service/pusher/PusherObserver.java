package com.dx.cmm.service.pusher;

import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.base.DataObserver;

/**
 * 
 * 推送观察者
 *
 * @author tony
 */
public interface PusherObserver<S, P> extends DataObserver<S> {

    /**
     * 
     * 推送
     *
     * @param data
     */
    void push(P data) throws PushException;
}
