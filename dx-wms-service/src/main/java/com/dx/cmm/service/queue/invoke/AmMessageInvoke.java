package com.dx.cmm.service.queue.invoke;

import org.springframework.stereotype.Service;

import com.dx.framework.mq.invoke.IMessageInvoke;

@Service("amMessageInvoke")
public class AmMessageInvoke implements IMessageInvoke {

    @Override
    public void invokeProcess(String msg) {
        System.out.println("amMessageInvoke");
    }

}
