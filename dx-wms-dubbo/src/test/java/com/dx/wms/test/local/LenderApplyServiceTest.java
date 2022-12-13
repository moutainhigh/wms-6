package com.dx.wms.test.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.dto.QueryResultDto;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.ILenderLogService;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApplyBase;
import com.dx.wms.service.apply.LenderApplyDto;
import com.dx.wms.service.push.ILenderPushService;
import com.dx.wms.test.lender.LenderQueryTest;
import com.google.gson.Gson;

public class LenderApplyServiceTest extends BaseTest {
	
	/**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(LenderApplyServiceTest.class);

    @Autowired
    private ILenderApplyService lenderApplyService;

//    @Test
//    public void queryTest() {
//        LenderApplyDto dto = lenderApplyService.query("L0532021507100002-001");
//        System.out.println(new Gson().toJson(dto));
//
//    }
    
    @Test
    public void queryTest2() {
        lenderApplyService.syncProduct("L0532021507100002-001", 11l);
    }
    
    @Test
    public void queryTest3() {
        lenderApplyService.queryBackBank(11l);
    }

    @Autowired
    private ILenderPushService lenderPushService;

    @Test
    public void fail() {
        PushDataDto dto = new PushDataDto();
        dto.giveUp(538L, "L0533011604280001-011");
        lenderPushService.push(PushCode.GIVE_UP, dto);
    }

    @Autowired
    private ILenderLogService lenderLogService;

    @Test
    public void match() {
    	System.out.println(1);
        lenderLogService.add("a", 1L, 1L, "a", 1);
    }
    
  //根据出借编号筛选
    @Test
    public void query(){
    	LenderApplyDto lenderApplyDto=lenderApplyService.query("L05351505070001-001");
    	LOG.info("***query={}***", new Gson().toJson(lenderApplyDto));
    }
    
    //根据出借编号同步出借方式
    @Test
    public void syncProduct(){
    	lenderApplyService.syncProduct("DXF1505351000105",10002l);
    }
    
  //查询回款银行信息
    @Test
    public void queryBackBank(){
    	LenderApplyBase lenderApplyBase= lenderApplyService.queryBackBank(10002l);
    	LOG.info("***queryBackBank={}***", new Gson().toJson(lenderApplyBase));
    }
}
