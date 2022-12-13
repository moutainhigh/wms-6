/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IProductDao.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午11:06:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.dao;

import java.util.List;

import com.dx.op.service.entity.Product;
import com.dx.wms.common.IBaseDao;

/**
 *  产品 实体Dao层接口
 *
 * @author 朱道灵
 */
public interface IProductDao extends IBaseDao<Product> {
    /**
     * 
     * 功能描述: 根据应用Code 查询所属的产品列表
     *
     * @param appCode 应用Code
     * @return  产品列表map
     */
    List<Product> getProductByApp(String appCode);
    
    /**
     * 
     * 功能描述: 根据应用Code 父产品Id查询所属的产品列表
     *
     * @param appCode 应用Code
     * @param productId 父产品Id  传-1代表查询1级产品
     * @return 产品列表map
     */
    List<Product> getProductByAppAndProductId(String appCode, Long productId);
    
    
}
