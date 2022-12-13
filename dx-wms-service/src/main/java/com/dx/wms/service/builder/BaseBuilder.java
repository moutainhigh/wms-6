package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.Trans2Birthday;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.base.ICustBaseDao;

@Service("baseBuilder")
public class BaseBuilder extends EntityBuilder {

    @Autowired
    private ICustBaseDao baseDao;

    @Override
    public void build(Long id, BaseEntitys base) {
        //获取潜客信息 给开户
        CustAccount account = new CustAccount(baseDao.queryById(CustBase.class, id));
        if (Assert.checkParam(account.getIdCard()) && Assert.equals(account.getIdType(), 1)) {
            account.setBirthDate(DateUtils.parseForDay(Trans2Birthday.ageByIdCard(account.getIdCard())));
        }
        base.setAccount(account);
    }

}
