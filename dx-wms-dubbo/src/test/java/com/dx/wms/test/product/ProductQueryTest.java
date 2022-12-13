package com.dx.wms.test.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.dto.ProductDto;
import com.dx.wms.dto.ProductQueryDto;
import com.dx.wms.service.IProductService;
import com.dx.wms.service.IRefundTimeService;
import com.dx.wms.test.file.FileQueryTest;
import com.google.gson.Gson;

public class ProductQueryTest extends ProductTest{
	
	/**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(ProductQueryTest.class);
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IRefundTimeService refundTimeService;
	
	
	//根据应用Code 父产品Id查询所属的产品列表
	@Test
	public void testGetProductByAppAndProductId(){
		Map<String, String> pMap=productService.getProductByAppAndProductId("wms", -1l);
		LOG.info("***testGetProductByAppAndProductId={}***", new Gson().toJson(pMap));
	}
	
	//根据应用筛选
	@Test
	public void testQuery(){
		Map<Long, String> p2Map=productService.query("wms");
		LOG.info("***testQuery={}***", new Gson().toJson(p2Map));
	}
	
	    //查询信息
		@Test
		public void testQueryAll(){
			Map<Long, String> p2Map=productService.queryAll();
			LOG.info("***testQueryAll={}***", new Gson().toJson(p2Map));
		}
	
		//根据应用筛选
				@Test
				public void getRefundTimeAndRepaymentDay(){
					Map<String, Object> p2Map=refundTimeService.getRefundTimeAndRepaymentDay();
					LOG.info("***testQueryAll={}***", new Gson().toJson(p2Map));
				}
				//查询信息
				@Test
				public void queryByProductId(){
					ProductDto p2Map=productService.queryByProductId("ccs",30l);
					LOG.info("***testQueryAll={}***", new Gson().toJson(p2Map));
				}
				
				//根据应用Code 查询所属的产品列表
				@Test
				public void queryByApp(){
					List<ProductDto> p2Map=productService.queryByApp("wms");
					LOG.info("***testQueryAll={}***", new Gson().toJson(p2Map));
				}
				
				//根据QueryDto查询所属的产品列表
				@Test
				public void queryByDtos(){
					ProductQueryDto productQueryDto = new ProductQueryDto();
					productQueryDto.setAppCode("wms");
					productQueryDto.setProductId(12l);
					productQueryDto.setAmount(new BigDecimal("50000"));
					List<ProductDto> p2Map=productService.queryByDtos(productQueryDto);
					LOG.info("***testQueryAll={}***", new Gson().toJson(p2Map));
				}		
				
				

}
