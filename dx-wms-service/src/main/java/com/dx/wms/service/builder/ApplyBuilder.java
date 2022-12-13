package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;

@Service("applyBuilder")
public class ApplyBuilder extends EntityBuilder {

    @Autowired
    private ILenderApplyDao applyDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        base.setApply(applyDao.queryById(LenderApply.class, id));
    }

}
