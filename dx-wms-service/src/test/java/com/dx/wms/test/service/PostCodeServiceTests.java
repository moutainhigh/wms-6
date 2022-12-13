package com.dx.wms.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.bean.PostCode;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.service.IPostCodeService;

public class PostCodeServiceTests extends BaseTest{
	
	@Autowired
	IPostCodeService iPostCodeService;
	
	@Test
	public void queryByOrgId(){
		PostCode postcode = iPostCodeService.queryByOrgId(259L);
		System.out.println(postcode.getOrgName()+":"+postcode.getPostCode());
	}
	
	@Test
	public void queryAll(){
		List<PostCode> list = iPostCodeService.queryAll();
		for(PostCode postCode:list){
			System.out.println(postCode.getOrgName()+":"+postCode.getPostCode());
		}
	}
}
