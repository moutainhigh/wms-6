package com.dx.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.scheduler.IDealDueDateService;
import com.dx.wms.service.scheduler.ILenderDestoryService;

public class DealDueTest extends BaseTest {

    @Autowired
    private IDealDueDateService dealDueDateService;

    @Autowired
    private ILenderDestoryService dueDate;

    @Autowired
    private ILenderDestoryService dealCancellationDataService;

    // 即将到期状态修改
    @Test
    public void test_1() {
        dealDueDateService.dealSoonDue();
    }

    @Test
    public void test_2() {
        dealDueDateService.dealDueDate();
        ;
    }

    @Test
    public void test_3() {
        dueDate.destoryContinue();
    }

    @Test
    public void test_4() {
        dealCancellationDataService.destory();
    }
}
