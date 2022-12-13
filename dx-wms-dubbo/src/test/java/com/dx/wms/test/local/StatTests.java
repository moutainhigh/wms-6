package com.dx.wms.test.local;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.credit.ICreditService;
import com.google.gson.Gson;

public class StatTests extends BaseTest {

    @Autowired
    private ICreditService creditService;

    @Test
    public void stat() {
        Long times = 1462723200000L;
        System.out.println(new Gson().toJson(creditService.queryDetail(new Date(times))));
    }
}
