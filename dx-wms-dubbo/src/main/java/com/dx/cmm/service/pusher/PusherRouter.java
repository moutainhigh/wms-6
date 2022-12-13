package com.dx.cmm.service.pusher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.base.ObserverUtils;

@Service
public class PusherRouter<P> implements PusherObserver<Pusher<P>, P> {

    private List<Pusher<P>> pushers = new ArrayList<Pusher<P>>();

    @Override
    public void regist(Pusher<P> pusher) {
        pushers.add(pusher);
    }

    @Override
    public void push(P param) throws PushException {
        for (Pusher<P> pusher : pushers) {
            if (pusher.supports(param)) {
                synchronized (pusher) {
                    pusher.push(param);
                    return;
                }
            }
        }
        throw ObserverUtils.error();
    }

}
