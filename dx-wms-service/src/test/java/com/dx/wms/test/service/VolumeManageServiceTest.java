package com.dx.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.scheduler.ILenderDestoryService;

public class VolumeManageServiceTest extends BaseTest {
    @Autowired
    private ILenderDestoryService dealCancellationDataService;

    @Test
    public void test_1() {
        dealCancellationDataService.destoryContinue();
    }
    
    
}
