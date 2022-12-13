package com.dx.wms.service;

import java.util.List;

import com.dx.wms.bean.PostCode;

public interface IPostCodeService {
	/**
	 * 
	 * 功能描述: 根据 营业部ID查询出对应营业部的固定pos终端信息
	 * 〈功能详细描述〉
	 *
	 * @param orgId
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	PostCode queryByOrgId(Long orgId);
	
	/**
	 * 
	 * 功能描述: 查询所有的营业部固定pos终端信息
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	List<PostCode> queryAll();
}
