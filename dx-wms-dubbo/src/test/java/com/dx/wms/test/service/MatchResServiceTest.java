package com.dx.wms.test.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.match.IMatchResService;
import com.dx.cmm.service.match.MatchCache;
import com.dx.cmm.service.match.result.CreditResult;

public class MatchResServiceTest extends BaseTest{
	
	@Autowired
	private IMatchResService matchResService;
	
	@Test
	public void queryAll_test(){//全部匹配资源 操作缓存 --异常匹配详情
		List<MatchCache> result = matchResService.queryAll();
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryInvest_test(){//根据用户筛选投资  操作缓存  --投资列表
		//userID ,用户ID
		Set<com.dx.cmm.service.match.result.InvestResult>  result = matchResService.queryInvest(123L);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void queryCredit_test(){//根据用户筛选债权 matching:userId 操作缓存 --债权列表
		//userID ,用户ID
		Set<CreditResult> result = matchResService.queryCredit(123L);
		System.out.println("结果在此"+JSON.toJSON(result));
	}
	
	@Test
	public void destory_test(){ //根据用户销毁资源-- 操作缓存 --异常匹配销毁
		//userID ,用户ID
		matchResService.destory(123L);
		System.out.println("销毁成功");
	}
}
