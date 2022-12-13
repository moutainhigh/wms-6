package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.saver.ParamSaver;
import com.dx.wms.service.saver.SaverObserver;
import com.google.gson.Gson;

public class SaveTests extends BaseTest {

    @Autowired
    private SaverObserver saver;

    @Test
    public void testsQuery() {
        Long id = 31L;
        ParamSaver param = new ParamSaver("account", "create", id);
        System.out.println(new Gson().toJson(saver.query(param)));
    }
    

}
