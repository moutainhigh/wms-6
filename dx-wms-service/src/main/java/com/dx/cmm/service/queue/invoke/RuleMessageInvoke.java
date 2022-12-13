package com.dx.cmm.service.queue.invoke;

import org.springframework.stereotype.Service;

import com.dx.framework.mq.invoke.IMessageInvoke;

@Service("ruleMessageInvoke")
public class RuleMessageInvoke implements IMessageInvoke {

    @Override
    public void invokeProcess(String msg) {
        System.out.println("ruleMessageInvoke");
    }

}
