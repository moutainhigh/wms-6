package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.service.ILenderManagermentService;

public class PushDueDataTest extends BaseTest {
    @Autowired
    private ILenderManagermentService lenderManagermentService;

    @Test
    public void test_1() {
        List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
        PushDataDto pushDataDto1 = new PushDataDto();
        pushDataDto1.setBizId(187l);
        pushDataDtos.add(pushDataDto1);
        //lenderManagermentService.pushDueDataLenders(pushDataDtos, PushCode.GIVE_UP);

    }
}
