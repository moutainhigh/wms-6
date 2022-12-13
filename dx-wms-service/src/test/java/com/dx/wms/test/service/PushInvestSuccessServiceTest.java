package com.dx.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.scheduler.IPushInvestSuccessService;

public class PushInvestSuccessServiceTest extends BaseTest {

    /**
     * 推送到账日期数据服务
     */
    @Autowired
    private IPushInvestSuccessService pushInvestSuccessService;

    @Test
    public void test_1() {
        pushInvestSuccessService.push();
    }
}
