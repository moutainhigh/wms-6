package com.dx.wms.test.start;

import org.testng.annotations.Test;

public class StartDubbo extends DubboTest {

    @Test
    public void start() {
        try {
            Thread.sleep(1000000000000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
