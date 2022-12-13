package com.dx.wms.test.lender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.dto.PushDataDto;
import com.dx.wms.dto.PushResultDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.ILenderManagermentService;
import com.dx.wms.service.push.ILenderPushService;

public class LenderPushTest extends LenderTest {

    @Autowired
    private ILenderPushService lenderPushService;

    @Autowired
    private ILenderManagermentService lenderManagermentService;
    
    @Test
    public void test_1() {
        PushDataDto dto = new PushDataDto();
        dto.setLenderCode("L0533011610100001-001");
//        dto.setCreateUser(308L);
        dto.setDueDate(new Date());
        lenderPushService.push(PushCode.DUE_DATE, dto);
    }
    
//    @Test
//    public void test_7() {
//        List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
//        PushDataDto pushDataDto1 = new PushDataDto();
//        pushDataDto1.setBizId(13019L);
//        pushDataDto1.setBizCode("L0533011605100003-001");
//        pushDataDto1.setResult(1);
//        pushDataDto1.setDataType(1);
//        pushDataDto1.setCreateUser(-1l);
//        pushDataDto1.setRemark("222222222");
//        pushDataDto1.setSettlementDate(new Date());
//        pushDataDtos.add(pushDataDto1);
//        Map<String, PushResultDto> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
//        System.out.println("~!!!!!!!!!!!!!!!!!!" + resultMap.get("L0533011605100003-001").getResult()
//                + resultMap.get("L0533011605100003-001").getRemark());
//    }
}
