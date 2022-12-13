package com.dx.op.service.dao.impl;

/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: PrductDetailRelationDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午11:21:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.op.service.dao.IProductDetailRelationDao;
import com.dx.op.service.entity.ProductDetailRelation;
import com.dx.wms.common.BaseDaoImpl;

/**
 * 产品明细关系 dao层接口实现
 *
 * @author 朱道灵
 */
@Service
public class PrductDetailRelationDaoImpl extends BaseDaoImpl<ProductDetailRelation> implements
        IProductDetailRelationDao {

    private static final String BASE_KEY = "productDetail:";

    @Autowired
    private ICacheService<ProductDetailRelation> cacheService;

    @Override
    public ProductDetailRelation query(Long productId, String key) {
        Assert.notNull("param is null", productId, key);
        String cacheKey = getKey(key, productId);
        ProductDetailRelation detail = cacheService.getObject(cacheKey, ProductDetailRelation.class);
        return Assert.checkParam(detail) ? detail : queryForDB(productId, key, cacheKey);
    }

    private ProductDetailRelation queryForDB(Long productId, String key, String cacheKey) {
        ProductDetailRelation detail = dalClient.queryForObject("productDetailRelation.queryByParam",
                getParam(key, productId), ProductDetailRelation.class);
        cacheService.set(cacheKey, detail);
        return detail;
    }

    @Override
    public List<ProductDetailRelation> queryArray(Long productId, String key) {
        Assert.notNull("param is null", productId, key);
        String cacheKey = getKey(key, productId);
        List<ProductDetailRelation> details = cacheService.getArray(cacheKey, ProductDetailRelation.class);
        return Assert.checkParam(details) ? details : queryForDB_(productId, key, cacheKey);
    }

    private List<ProductDetailRelation> queryForDB_(Long productId, String key, String cacheKey) {
        List<ProductDetailRelation> details = dalClient.queryForList("productDetailRelation.queryByParam",
                getParam(key, productId), ProductDetailRelation.class);
        cacheService.set(cacheKey, details);
        return details;
    }

    private Map<String, Object> getParam(String key, Long productId) {
        Map<String, Object> param = MapUtils.getParamMap("key", key);
        param.put("productId", productId);
        return param;
    }

    private String getKey(String key, Long productId) {
        return cacheService.initKey(BASE_KEY, key, ":", productId);
    }

}
