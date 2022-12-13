package com.dx.cmm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;

public abstract class ViewAbs {

    protected static final Logger LOG = LoggerFactory.getLogger(ViewAbs.class);

    @Autowired
    protected PaginationDalClient dalClient;

}
