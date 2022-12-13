package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.account.dao.ICustLinkmanDao;

@Service("linkmanBuilder")
public class LinkmanBuilder extends EntityBuilder {

    @Autowired
    private ICustLinkmanDao linkmanDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        base.setLinkman(linkmanDao.queryByParam(id));
    }
}
