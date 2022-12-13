package com.dx.wms.test.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.service.IRefundTimeService;
import com.google.gson.Gson;

public class RefundTimeTest extends BaseTest {

    @Autowired
    private IRefundTimeService refundTimeService;

    @Test
    public void getRefundTimeAndRepaymentDay() {
        Map<String, Object> results = new HashMap<String, Object>();
        results = refundTimeService.getRefundTimeAndRepaymentDay();
        System.out.println(new Gson().toJson(results));
    }

}
