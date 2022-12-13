package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.Result;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class ResultTests extends BaseTest {

    @Autowired
    private Result<CreditResults> creditResult;

    @Test
    public void query() {
        System.out.println(new Gson().toJson(creditResult.queryArray(8652L, DateUtils.parseForDay("2016-04-01"))));
    }

    @Test
    public void sum() {
        System.out.println(new Gson().toJson(creditResult.query(10L, DateUtils.parseForDay("2016-01-02"))));
    }
}
