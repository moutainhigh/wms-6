package com.dx.wms.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.dto.ProductDto;
import com.dx.wms.dto.ProductQueryDto;
import com.dx.wms.service.IProductService;
import com.google.gson.Gson;

public class ProductTest extends BaseTest {

    @Autowired
    private IProductService productService;

    @Test
    public void codeTest() {
        Map<String, String> results = new HashMap<String, String>();
        results = productService.getProductByAppAndProductId("ccs", 1l);
        System.out.println(new Gson().toJson(results));
    }

    @Test
    public void queryApp() {
        Map<Long, String> results = new HashMap<Long, String>();
        results = productService.query("ccs");
        System.out.println(new Gson().toJson(results));
    }

    @Test
    public void queryAll() {
        Map<Long, String> results = new HashMap<Long, String>();
        results = productService.queryAll();
        System.out.println(new Gson().toJson(results));
    }

    @Test
    public void queryByProductId() {
        ProductDto dto = new ProductDto();
        dto = productService.queryByProductId("ccs", 2l);
        System.out.println(new Gson().toJson(dto));
    }

    @Test
    public void queryByApp() {
        List<ProductDto> dtos = new ArrayList<ProductDto>();
        dtos = productService.queryByApp("ccs");
        for (ProductDto product : dtos) {
            System.out.println(new Gson().toJson(product));
        }
    }

    @Test
    public void queryByDtos() {
        List<ProductDto> dtos = new ArrayList<ProductDto>();
        ProductQueryDto queryDto = new ProductQueryDto();
        queryDto.setAppCode("ccs");
        queryDto.setProductId(2l);
        queryDto.setAmount(new BigDecimal(30000l));
        dtos = productService.queryByDtos(queryDto);
        for (ProductDto product : dtos) {
            System.out.println(new Gson().toJson(product));
        }
    }
}
