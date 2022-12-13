package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.account.dao.ICustCommDao;

@Service("commBuilder")
public class CommBuilder extends EntityBuilder {
    @Autowired
    private ICustCommDao commDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        base.setComm(commDao.queryByParam(id));
    }
}
