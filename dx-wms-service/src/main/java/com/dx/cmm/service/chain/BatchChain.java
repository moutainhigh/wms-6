package com.dx.cmm.service.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;

abstract class BatchChain extends Chain<Integer> {

    @Autowired
    PaginationDalClient dalClient;

    static final Logger LOG = LoggerFactory.getLogger("chain.batch");
}
