/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: RegionServiceTest.java
 * Author:   蔡登勇
 * Date:     2015年8月7日 下午2:45:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.framework.constant.service.IRegionNewService;
import com.dx.wms.common.test.BaseTest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RegionServiceTest extends BaseTest{
    @Autowired
    private IRegionNewService regionService;
    
    @Test
    public void test_1(){
//        System.out.println(regionService.getRcdAddress("370000","370300","370305"));
//        String rcdAddress ="";
//        boolean isDirectlyFlag=false;//是否是直辖市
//        LinkedList<DataItemBean> itemBeans = regionService.getRegionListByParentCode("999999");
//        if (itemBeans != null && itemBeans.size() > 0) {
//            for (DataItemBean itemBean : itemBeans) {
//                if (itemBean.getCode().equals("370000")) {
//                    rcdAddress = itemBean.getName();
//                    if(ArrayUtils.contains(RegionConstants.MUNICIPALITY_DIRECTLY_CODES, itemBean.getCode())){
//                        isDirectlyFlag=true;
//                    }
//                }
//            }
//        }
//        
//        LinkedList<DataItemBean> itemCitys = regionService.getRegionListByParentCode("370000");
//        if (itemCitys != null && itemCitys.size() > 0) {
//            for (DataItemBean itemBean : itemCitys) {
//                if (itemBean.getCode().equals("370300")&&!isDirectlyFlag) {
//                    rcdAddress = rcdAddress + "" + itemBean.getName();
//                }
//            }
//        }
//        LinkedList<DataItemBean> itemDistricts = regionService.getRegionListByParentCode("370300");
//        if (itemDistricts != null && itemDistricts.size() > 0) {
//            for (DataItemBean itemBean : itemDistricts) {
//                if (itemBean.getCode().equals("370305")) {
//                    rcdAddress = rcdAddress + "" + itemBean.getName();
//                }
//            }
//        }
//        System.out.println(rcdAddress);
    }
    
}
