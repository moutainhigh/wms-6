package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cmm.service.view.IMatchViewService;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class ViewTests extends BaseTest {

    @Autowired
    private IMatchViewService<FirstViewResult> firstTransView;

    @Test
    public void firstTransView() {
        System.out.println(new Gson().toJson(firstTransView.query("L0533011605110004-001")));
    }
}
