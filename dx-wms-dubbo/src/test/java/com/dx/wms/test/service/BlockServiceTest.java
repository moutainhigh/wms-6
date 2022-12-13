package com.dx.wms.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.block.BlockInterestResult;
import com.dx.cmm.service.block.IBlockService;

public class BlockServiceTest extends BaseTest{

	@Autowired 
	private IBlockService blockService;
	
	@Test
	public void queryInterest_test(){//异常利息详情
		List<BlockInterestResult> result = blockService.queryInterest();
		System.out.println("结果在此"+JSON.toJSON(result));
	}
}
