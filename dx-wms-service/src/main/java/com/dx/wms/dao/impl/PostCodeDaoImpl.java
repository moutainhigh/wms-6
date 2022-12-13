package com.dx.wms.dao.impl;

import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.bean.PostCode;
import com.dx.wms.dao.IPostCodeDao;
@Component
public class PostCodeDaoImpl implements IPostCodeDao {
	
	/**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;
	
	@Override
	public PostCode queryById(String orgCode) {
		Assert.notNull("**queryById() 营业部Code不能为空**", orgCode);
		return	dalClient.queryForObject("postCode.queryByOrgId", MapUtils.getParamMap("orgCode", orgCode),
				PostCode.class);
	}

	@Override
	public List<PostCode> queryAll() {
		return dalClient.queryForList("postCode.queryAll",null,PostCode.class);
	}

	@Override
	public PostCode queryById(Long orgId) {
		// TODO Auto-generated method stub
		return null;
	}
}
