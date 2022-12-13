package com.dx.op.service.dao;

/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午11:16:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.op.service.entity.Product;
import com.dx.wms.base.impl.BaseDaoImpl;

/**
 * 产品实体类 dao层 接口实现
 *
 * @author 朱道灵
 */
@Service
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao {

    @Override
    public List<Product> getProductByApp(String appCode) {
        Assert.notNull("**getProductByApp() appCode can not be null**", appCode);
        LOG.info("**getProductByApp() appCode={}**", appCode);
        return dalClient.queryForList("product.getProductByApp", MapUtils.getParamMap("appCode", appCode),
                Product.class);
    }

    @Override
    public List<Product> getProductByAppAndProductId(String appCode, Long productId) {
        Assert.notNull("**getProductByAppAndProductId() appCode can not be null**", appCode);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appCode", appCode);
        if (Assert.checkParam(productId)) {
            param.put("productId", productId);
        } else {
            param.put("productLevel", 1);
        }
        LOG.info("**getProductByAppAndProductId() param={}**", param);
        return dalClient.queryForList("product.getProductByAppAndUpProductId", param, Product.class);
    }
    
    
    
    @Override
	public List<Product> getAllProductByApp(String appCode) {
    	Assert.notNull("**getProductByAppAndProductId() appCode can not be null**", appCode);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appCode", appCode);
        return dalClient.queryForList("product.getAllProductByApp", param, Product.class);
	}

	@Override
    public Product getProductByProductCode(String productCode) {
        Assert.notNull("productCode is null", productCode);
        LOG.info("**getProductByProductCode() productCode={}**", productCode);
        return dalClient.queryForObject("product.getProductByProductCode",
                MapUtils.getParamMap("productCode", productCode), Product.class);
    }

    @Override
    public Boolean validate(String appCode, Long productId) {
        Product product = queryById(Product.class, productId);
        return Assert.equals(product.getAppCode(), appCode);
    }

	@Override
	public List<Product> getUsualProduct(String appCode) {
		Assert.notNull("**getUsualProduct() appCode can not be null**", appCode);
		return dalClient.queryForList("product.getUsualProduct", MapUtils.getParamMap("appCode", appCode), Product.class);
	}

	@Override
	public List<Product> getTransProduct(String appCode) {
		Assert.notNull("**getTransProduct() appCode can not be null**", appCode);
		return dalClient.queryForList("product.getTransProduct", MapUtils.getParamMap("appCode", appCode), Product.class);
	}
	
}
