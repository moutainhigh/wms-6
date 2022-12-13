package com.dx.cms.service.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;

abstract class ActionRouter<T, R> implements FileAction<T, R> {

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(ActionRouter.class);

    @Autowired
    PaginationDalClient dalClient;
    
}
