package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.dx.framework.mq.send.IMessageSender;
import com.dx.wms.common.test.BaseTest;

public class QueueSenderTests extends BaseTest {

    @Autowired
    private IMessageSender messageSender;

    @Test
    public void sendMessage() {
        messageSender.sendMessage("abc");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/wms-core.xml");

    }

}
