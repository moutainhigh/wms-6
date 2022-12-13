package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.account.entity.CustAccount;

@Service("accountBuilder")
public class AccountBuilder extends EntityBuilder {

    @Autowired
    private ICustAccountDao accountDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        //根据id查询客户信息
        base.setAccount(accountDao.queryById(CustAccount.class, id));
    }

}
