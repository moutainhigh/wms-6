package com.dx.cmm.service.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.framework.dal.client.support.PaginationDalClient;

public abstract class Router<T> {

    @Autowired
    protected PaginationDalClient dalClient;

    @Autowired
    protected ICacheService<T> cacheService;

}
