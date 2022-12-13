package com.dx.wms.test.lender;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.ILenderLogService;

public class LenderLogTest extends LenderTest {

    @Autowired
    private ILenderLogService lenderLogService;

    //添加业务流程审核结果
    @Test
    public void testAdd() {
        lenderLogService.add("qualityCheck",393l, 15866l, "", 1);
    }
    
  //根据参数删除日志信息
    @Test
    public void testDestory() {
        lenderLogService.destory(538l, 15868l, "", "客户放弃成功");
    }
}
