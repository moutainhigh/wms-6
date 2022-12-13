/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: RefundTimeServiceTest.java
 * Author:   蔡登勇
 * Date:     2015年8月17日 下午8:23:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.common.service.utils.DateUtils;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.IRefundTimeService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 */
public class RefundTimeServiceTest extends BaseTest{
    @Autowired
    private IRefundTimeService refundTimeService;
    
    @Test
    public void test_01(){
        System.out.println(DateUtils.parseForDay((String)refundTimeService.getRefundTimeAndRepaymentDay().get("refundTime")));
        System.out.println(refundTimeService.getRefundTimeAndRepaymentDay().get("repaymentDay"));
    }
}
