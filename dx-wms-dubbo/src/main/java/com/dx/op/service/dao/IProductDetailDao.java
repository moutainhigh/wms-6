/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IProductDetailDao.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午11:24:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.dao;

import java.util.List;

import com.dx.op.service.entity.ProductDetail;
import com.dx.wms.base.IBaseDao;
import com.dx.wms.dto.ProductDetailDto;

/**
 * 产品明细  实体类dao层接口  
 *
 * @author 朱道灵
 */
public interface IProductDetailDao extends IBaseDao<ProductDetail>{

    /**
     * 
     * 功能描述: 通过产品Id查询产品明细信息列表
     *
     * @param productId 产品Id
     * @return 产品明细信息列表
     */
    public List<ProductDetailDto> queryProductDetailDtosByProductId(Long productId,String flag);
    
    /**
     * 
     * 功能描述: 通过产品Id 明细Key查询产品明细信息
     *
     * @param productId 产品Id
     * @param key 明细Key
     * @return 产品明细信息
     */
    public ProductDetailDto queryProDetailDtoByProIdAndDetailKey(Long productId,String detailKey);
}
