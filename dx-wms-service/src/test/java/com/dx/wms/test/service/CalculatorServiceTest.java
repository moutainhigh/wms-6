/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CalculatorServiceTest.java
 * Author:   蔡登勇
 * Date:     2015年7月30日 下午7:28:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.test.service;

import java.math.BigDecimal;
import java.util.List;

import org.testng.annotations.Test;

import com.dx.common.dto.CalculateResultDto;
import com.dx.common.dto.CurrentRepaymentDto;
import com.dx.common.service.utils.CalculatorUtils;
import com.dx.framework.dal.util.DalUtils;
import com.dx.wms.common.test.BaseTest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CalculatorServiceTest extends BaseTest{
    
    
    
    @Test
    public void getCurrentRepayment(){
        
        CurrentRepaymentDto currentRepaymentDto = new CurrentRepaymentDto();
        currentRepaymentDto = CalculatorUtils.getCurrentRepayment(new BigDecimal(50000), 36, 1);
        try {
            System.out.println(DalUtils.convertBeanToMap(currentRepaymentDto));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void test_1(){
       
        List<CalculateResultDto> cds = CalculatorUtils.trail(new BigDecimal(50000), 36, new BigDecimal("0.01"), null);
        for(CalculateResultDto c:cds){
            System.out.println(c.getEachDate()+"--"+c.getEachAmount());
        }
    }

}
