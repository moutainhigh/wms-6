package com.dx.cmm.service.view;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.service.IProductService;

public abstract class ViewAbs<T> implements IMatchViewService<T> {

    static final Logger LOG = LoggerFactory.getLogger(ViewAbs.class);


    @Autowired
    protected PaginationDalClient dalClient;

    @Autowired
    protected IProductService productService;

	@Override
	public T query(String lenderCode) {
		return null;
	}

	@Override
	public T query(String lenderCode, Date reportDay) {
		return null;
	}
	
}
