package com.dx.op.test.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.common.service.utils.DateUtils;
import com.dx.dcs.api.dto.MissionRequestParam;
import com.dx.dcs.service.IMissionRequestService;
import com.dx.wms.common.test.BaseTest;

public class CacheTests extends BaseTest {

	@Autowired
	private IMissionRequestService missionRequestService;

	@Test
	public void query() throws IOException {
		MissionRequestParam param = new MissionRequestParam();
		param.setAppKey("wms");
		param.setOrgId(308L);
		param.setUserId(298L);
		param.setMissionKey("fundProtocol");
		param.setClassName("com.dx.cmm.service.report.dto.ProtocolParam");
		ProtocolParam parmas = new ProtocolParam();
		parmas.setReportDay(DateUtils.parseForDay("2016-12-16"));
		param.setParamValue(JSON.toJSONString(parmas));
		missionRequestService.request(param);
	}


}
