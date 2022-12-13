package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.tasks.Task;
import com.dx.wms.common.test.BaseTest;

public class TaskTests<T> extends BaseTest {

    @Autowired
    private Task<T> backCalcTask;

    @Test
    public void backCalcTask() {
        backCalcTask.execute();
    }

    @Autowired
    private Task<T> accountFundTask;

    @Test
    public void accountFundTask() {
        accountFundTask.execute();
    }

    @Autowired
    private Task<T> investJoinTask;

    @Test
    public void investJoinTask() {
        investJoinTask.execute();
    }

}
