package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.apply.dao.ICustFinanceDao;

@Service("financeBuilder")
public class FinanceBuilder extends EntityBuilder {

    @Autowired
    private ICustFinanceDao financeDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        base.setFinances(financeDao.queryByApply(id));
    }

}
