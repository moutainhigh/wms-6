package com.dx.wms.test.service;

import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.validators.CustAccountValidator;
import com.dx.wms.service.validators.ValidatorUtils;

public class ValidatorTests extends BaseTest {
    @Test
    public void push() {
        CustAccount ca =new CustAccount();
        ca.setCustAccountId(12l);
        ca.setCustName("回家");
        ca.setCustNameSpell("hjk");
        ca.setSex(1);
        ValidatorUtils.validate(new CustAccountValidator(), ca);
    }
}
