package com.dx.op.service.dao;

/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductDetailDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午11:18:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.op.service.entity.ProductDetail;
import com.dx.wms.base.impl.BaseDaoImpl;
import com.dx.wms.dto.ProductDetailDto;

/**
 * 产品明细 dao层 接口实现
 *
 * @author 朱道灵
 */
@Component
public class ProductDetailDaoImpl extends BaseDaoImpl<ProductDetail> implements IProductDetailDao {

    @Override
    public List<ProductDetailDto> queryProductDetailDtosByProductId(Long productId, String flag) {
        Assert.notNull("**queryProductDetailDtosByProductId() productId can not be null**", productId);
        LOG.info("**queryProductDetailDtosByProductId() productId={}**", productId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("productId", productId);
        paramMap.put("flag", flag);
        return dalClient.queryForList("productDetail.queryProductDetailDtoByProductId", paramMap,
                ProductDetailDto.class);
    }

    @Override
    public ProductDetailDto queryProDetailDtoByProIdAndDetailKey(Long productId, String detailKey) {
        Assert.notNull("**queryProDetailDtoByProIdAndDetailKey() productId can not be null**", productId);
        Assert.notNull("**queryProDetailDtoByProIdAndDetailKey() detailKey can not be null**", detailKey);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("productId", productId);
        paramMap.put("detailKey", detailKey);
        LOG.info("**queryProDetailDtoByProIdAndDetailKey() paramMap={}**", paramMap);
        return dalClient.queryForObject("productDetail.queryProDetailDtoByProIdAndDetailKey", paramMap,
                ProductDetailDto.class);
    }

}
