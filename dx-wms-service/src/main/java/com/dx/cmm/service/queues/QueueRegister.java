package com.dx.cmm.service.queues;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.intf.IMatchBizBaseService;
import com.dx.cmm.service.rules.RulerObserver;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.op.service.intf.IProductService;

abstract class QueueRegister implements Queue {

    static final Logger LOG = LoggerFactory.getLogger(QueueRegister.class);

    @Autowired
    private QueueObserver queue;

    @Autowired
    PaginationDalClient dalClient;

    @Autowired
    IProductService productService;

    @Autowired
    RulerObserver ruler;

    @Autowired
    IMatchBizBaseService matchBizBaseService;

    @Override
    @PostConstruct
    public void join() {
        queue.regist(this);
    }

    @Override
    public List<Map<String, Object>> stat() {
        return null;
    }

    @Override
    public PaginationResult<List<Map<String, Object>>> stat(Pagination page) {
        return null;
    }

}
