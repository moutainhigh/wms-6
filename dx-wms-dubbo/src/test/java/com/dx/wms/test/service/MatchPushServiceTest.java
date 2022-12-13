package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;

public class MatchPushServiceTest extends BaseTest{
	
	@Autowired
	private IMatchPushService matchPushService;
	
	@Test//推送数据到匹配
	public void push_test_1(){ //投资申请变更,投资账户变更,重新匹配,投资失败,投资生效/执委会审核
		PushData pushData1 = new PushData();
		//出借编号
//		pushData1.setBizCustCode("L0533011610100001");
		pushData1.setBizCode("L0533011610120001-001");
//		BizBase base = new BizBase();
//		base.setBizContractCode("DXF2342342123399");
//		base.setActionUser(308L);
//		pushData1.setBizBase(base);
		pushData1.setValidDate(new Date());
		matchPushService.push(MatchPushCode.INVEST_SUCCESS, pushData1);
		System.out.println("推送成功");
	}
	
	@Test
	public void push_test_2(){
//		List<PushData> datas = new ArrayList<PushData>();
//		PushData pushData1 = new PushData();
//		//出借编号
//		pushData1.setBizCode("L0533011610100001-001");
//		Set<Long> creditIds = new HashSet<>();
//		creditIds.add(17089L);
//		pushData1.setCreditIds(creditIds);
//		datas.add(pushData1);
//		matchPushService.push(datas,MatchPushCode.MATCH_REPEAT);
//		System.out.println("推送成功");
		System.out.println(new Date(1476263827017L));
	}
}
