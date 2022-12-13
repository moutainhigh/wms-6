package com.dx.wms.service.saver;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.account.dao.ICustCommDao;
import com.dx.wms.service.account.dao.ICustLinkmanDao;
import com.dx.wms.service.account.dao.ICustProfessionDao;

public abstract class AccountSaver extends SaverRegister {

    @Autowired
    protected ICustCommDao commDao;

    @Autowired
    protected ICustLinkmanDao linkmanDao;

    @Autowired
    protected ICustProfessionDao professionDao;

    @Autowired
    protected ICustAccountDao accountDao;

    public Boolean supports(ParamSaver param) {
        return Assert.equals(param.getType(), SaverType.ACCOUNT);
    }
  
}
