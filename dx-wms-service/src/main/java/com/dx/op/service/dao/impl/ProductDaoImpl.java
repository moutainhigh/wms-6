package com.dx.op.service.dao.impl;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.exception.BaseException;
import com.dx.op.service.dao.IProductDao;
import com.dx.op.service.entity.Product;
import com.dx.wms.common.BaseDaoImpl;

/**
 * 产品实体类 dao层 接口实现
 *
 * @author 朱道灵
 */
@Service
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Override
    public List<Product> getProductByApp(String appCode) {
        if (StringUtils.isBlank(appCode)) {
            LOG.error("getProductByApp() appCode is null");
            throw new BaseException("appCode is null");
        }
        return dalClient.queryForList("product.getProductByApp", MapUtils.getParamMap("appCode", appCode),
                Product.class);
    }

    @Override
    public List<Product> getProductByAppAndProductId(String appCode, Long productId) {
        if (StringUtils.isBlank(appCode)) {
            LOG.error("getProductByApp() appCode is null");
            throw new BaseException("appCode is null");
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appCode", appCode);
        if (Assert.checkParam(productId)) {
            param.put("productId", productId);
        } else {
            param.put("productLevel", 1);
        }
        return dalClient.queryForList("product.getProductByAppAndProductId", param, Product.class);
    }

}
