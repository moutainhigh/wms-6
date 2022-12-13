package com.dx.op.test.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.service.validators.Validator;
import com.dx.cmm.service.validators.ValidatorObserver;
import com.dx.wms.common.test.BaseTest;

public class ValidatorTests extends BaseTest {

    @Autowired
    private ValidatorObserver<Validator<Object>, Object> validatorObserver;

    @Test
    public void invest() {
        BizBase base = new BizBase();
        base.setBizId(10672L);
        base.setBizAmount(new BigDecimal("10000"));
        base.setBizCode("L0535011509060002-001");
        validatorObserver.validate(new PushData("L0535011509060002-001"));
    }
}
