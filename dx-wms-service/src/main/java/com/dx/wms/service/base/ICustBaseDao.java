/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 客户基本信息dao接口
 * 
 * @author 王蕊
 *
 */
public interface ICustBaseDao extends IBaseDao<CustBase> {

    /**
     * 
     * 根据客户编号查询客户基本信息表的信息
     * 
     * @param code 客户编号
     * @return客户基本信息表全对象
     */
    CustBase queryByParam(String code);

    /**
     * 
     * 根据客户编号更改客户状态
     * 
     * @param custId 客户编号
     * @return客户基本信息表全对象
     */
    Boolean update(Long custId, String status);
    
    /**
     * 
     * 根据条件查询客户基本信息表全对象
     * 
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<ResultView>> queryForPage(ParamView param, Pagination page);

}
