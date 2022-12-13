package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.detail.DetailObserver;
import com.dx.wms.service.detail.DetailType;
import com.dx.wms.service.detail.ParamDetail;
import com.google.gson.Gson;

public class DetailTests extends BaseTest {

    @Autowired
    private DetailObserver detailObserver;

    @Test
    public void detailAccount() {
        Long id = 28L;
        System.out.println(new Gson().toJson(detailObserver.query(new ParamDetail(DetailType.ACCOUNT, id))));
    }

    @Test
    public void detailApply() {
        Long id = 68L;
        System.out.println(new Gson().toJson(detailObserver.query(new ParamDetail(DetailType.APPLY, id))));
    }
}
