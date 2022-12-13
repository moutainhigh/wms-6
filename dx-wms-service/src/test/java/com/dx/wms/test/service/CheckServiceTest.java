package com.dx.wms.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.checker.Checker;
import com.dx.wms.service.checker.ParamChecker;

public class CheckServiceTest extends BaseTest {

	@Autowired
	private Checker checker;

	@Test
	public void test_1() {
		ParamChecker p = new ParamChecker();
		p.setIdCard("16012522281381");
		Assert.assertFalse(checker.check(p));
	}
}
