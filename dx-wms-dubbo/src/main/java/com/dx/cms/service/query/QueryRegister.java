package com.dx.cms.service.query;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cms.dto.Condition;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;

abstract class QueryRegister implements FileQuery {

    @Autowired
    private FileQueryGateway router;

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(QueryRegister.class);
    
    static final String SQL = "contentManagement.queryArray";

    @Autowired
    PaginationDalClient dalClient;

    @Override
    @PostConstruct
    public void join() {
        router.regist(this);
    }

    Map<String, Object> param(Condition param) {
        return MapUtils.obj2Map(param);
    }
}
