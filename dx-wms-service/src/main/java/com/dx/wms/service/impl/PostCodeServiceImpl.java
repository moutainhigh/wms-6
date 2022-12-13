package com.dx.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.service.IAMService;
import com.dx.common.service.utils.Assert;
import com.dx.wms.bean.PostCode;
import com.dx.wms.dao.IPostCodeDao;
import com.dx.wms.service.IPostCodeService;
@Service
public class PostCodeServiceImpl implements IPostCodeService {
	
	/**
     * 权限服务
     */
    @Autowired
    private IAMService amService;
	
	/**
	 *pos Dao 
	 */
	@Autowired
	IPostCodeDao iPostCodeDao;
	
	@Override
	public PostCode queryByOrgId(Long orgId) {
		Assert.notNull("**queryByOrgId() 营业部ID不能为空**", orgId);
		return iPostCodeDao.queryById(amService.queryOrgById(orgId).getCode());
	}

	@Override
	public List<PostCode> queryAll() {
		return iPostCodeDao.queryAll();
	}

}
