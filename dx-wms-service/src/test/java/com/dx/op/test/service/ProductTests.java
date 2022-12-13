package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.common.service.utils.DateUtils;
import com.dx.op.service.intf.IProductService;
import com.dx.wms.common.test.BaseTest;

public class ProductTests extends BaseTest {

    @Autowired
    private IProductService productService;

    @Test
    public void wms() {
        productService.getProductByApp("ccs");
    }
    
    @Test
    public void rate(){
//        System.out.println(productService.getRateMonth(16L, DateUtils.parseForBegin("2016-03-15 00:00:00")));
//        System.out.println(productService.getRateYear(16L, DateUtils.parseForBegin("2016-03-15 00:00:00")));
    }

    
    public static void main(String[] args) {
        System.out.println(DateUtils.parseForBegin("2016-02-02 00:00:00").after(DateUtils.parseForDay("2016-03-16")));
    }
}
