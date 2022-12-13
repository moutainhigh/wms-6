package com.dx.op.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;
import com.dx.framework.exception.BaseException;
import com.dx.wms.common.test.BaseTest;

public class PusherTests extends BaseTest {
    
    @Autowired
    private IMatchPushService pushService;

    @Test
    public void investSuccess() {
        List<PushData> datas = new ArrayList<PushData>();
        PushData pushDataDto = new PushData("1231", new Date());
        datas.add(pushDataDto);
        try {
            pushService.push(datas, MatchPushCode.INVEST_SUCCESS);
        } catch (BaseException e) {

        }
    }
}
