package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.account.dao.ICustProfessionDao;

@Service("professionBuilder")
public class ProfessionBuilder extends EntityBuilder {
    @Autowired
    private ICustProfessionDao professionDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        base.setProfession(professionDao.queryByParam(id));
    }
}
