package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.apply.dao.ILenderConditionDao;

@Service("conditionBuilder")
public class ConditionBuilder extends EntityBuilder {

    @Autowired
    private ILenderConditionDao conditionDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        base.setConditions(conditionDao.queryByParam(id));
    }

}
