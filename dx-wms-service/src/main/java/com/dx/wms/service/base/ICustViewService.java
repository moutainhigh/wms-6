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

import com.dx.cmm.exception.SaveException;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 视图服务
 *
 * @author tony
 */
public interface ICustViewService {

    /**
     * 
     * 保存视图
     *
     * @param base
     * @param userId
     * @throws SaveException
     */
    void save(CustBase base, Long userId) throws SaveException;

    /**
     * 
     * 根据编号查询视图
     *
     * @param id
     * @return
     */
    CustBase queryById(Long id);

    /**
     * 
     * 根据条件查询客户基本信息表全对象
     * 
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<ResultView>> queryForPage(ParamView param, Pagination page);

    /**
     * 
     * 根据客户编号查询客户基本信息表的信息
     * 
     * @param custCode
     * @return客户基本信息表全对象
     */
    CustViewDto queryByCustCode(String custCode);

}
