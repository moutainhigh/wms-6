package com.dx.op.service.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.op.service.intf.IProductService;

public abstract class ProductAbs<T> implements Product<T> {

    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(ProductAbs.class);

    @Autowired
    protected IProductService productService;

    @Override
    public Boolean isFix(T pool) {
        return false;
    }
}
