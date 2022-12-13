package com.dx.wms.service.changer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;

public abstract class ChangerRegister implements Changer<ParamChanger, ResultChanger, ItemChanger> {

    @Autowired
    private ChangerObserver<Changer<ParamChanger, ResultChanger, ItemChanger>, ParamChanger, ResultChanger, ItemChanger> observer;

    @Autowired
    public PaginationDalClient dalClient;

    @Override
    @PostConstruct
    public void join() {
        observer.regist(this);
    }

}
