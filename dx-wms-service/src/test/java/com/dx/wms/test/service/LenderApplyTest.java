package com.dx.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.ccs.service.IAMService;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.apply.IApplyService;

public class LenderApplyTest extends BaseTest {
    @Autowired
    private IApplyService lenderApplyService;
    /**
     * AM接口服务
     */
    @Autowired
    private IAMService amService;
    @Test
    public void test_7() {
        lenderApplyService.destory(12881L, "1");
        
    }
}
