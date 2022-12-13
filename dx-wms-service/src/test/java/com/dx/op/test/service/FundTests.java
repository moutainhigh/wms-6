package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.funds.Funds;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class FundTests extends BaseTest {

    @Autowired
    private Funds<CreditorFund> creditFund;

    @Test
    public void queryByPool() {
        System.out.println(new Gson().toJson(creditFund.query(1L, 6)));
    }
}
