package com.dx.wms.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.wms.bean.PostCode;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.dao.IPostCodeDao;
import com.dx.wms.service.ICommonService;
import com.sun.mail.handlers.image_gif;

public class PostCodeTests extends BaseTest{
	
	@Autowired
	IPostCodeDao iPostCodeDao;
	
    @Autowired
    private ICommonService commonService;

	@Test
	public void queryByOrgId(){
		PostCode postCode = iPostCodeDao.queryById("L053301");
		System.out.println(postCode.getOrgName()+":"+postCode.getPostCode());
	}
	
	@Test 
	public void queryAll(){
		List<PostCode> list = iPostCodeDao.queryAll();
		for(PostCode postCode:list){
			System.out.println(postCode.getOrgName()+":"+postCode.getPostCode());
		}
	}
	
	@Test
	public void testService(){
		System.out.println(commonService.getPostCode(259L).getPostCode());
	}
}
