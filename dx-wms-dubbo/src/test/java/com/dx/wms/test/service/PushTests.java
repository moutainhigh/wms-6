package com.dx.wms.test.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;

public class PushTests extends BaseTest {
    @Autowired
    private IMatchPushService matchPushService;

    @Test
    public void push() {
        BizBase base = new BizBase(458L, "DXC1500281000180");
        base.setBizContractCode("DXC1500281000180");
        base.setCustName("呵呵哒");
        base.setIdCard("128873771287617836");
        base.setCustAddress("山东省济南市历下区1阿是大神可敬的卡的可千万的期望可敬的回去酷网记得喊情况久违的");
        base.setZipCode("111111");
        base.setMobile("13012663817");
        base.setBizTotalAmount(new BigDecimal("14019.54"));
        base.setBizAmount(new BigDecimal("1086.33"));
        base.setBizProductId(2L);
        base.setBizPeriod(12);
        PushData data = new PushData("DXC1500281000180", base);
        matchPushService.push(MatchPushCode.CREDIT_JOIN, data);
    }

}
