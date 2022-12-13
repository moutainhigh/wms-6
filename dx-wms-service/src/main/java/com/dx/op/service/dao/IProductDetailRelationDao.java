/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IProductDetailRelationDao.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午11:24:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.dao;

import java.util.List;

import com.dx.op.service.entity.ProductDetailRelation;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IProductDetailRelationDao extends IBaseDao<ProductDetailRelation> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param productId
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ProductDetailRelation query(Long productId, String key);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param productId
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<ProductDetailRelation> queryArray(Long productId, String key);
}
