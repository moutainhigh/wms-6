package com.dx.wms.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.dx.common.service.utils.MapUtils;
import com.dx.wms.base.impl.BaseDaoImpl;
import com.dx.wms.bean.CustBase;
import com.dx.wms.dao.ICustBaseDao;

@Service
public class CustBaseDaoImpl extends BaseDaoImpl<CustBase> implements ICustBaseDao {

    @Override
    public CustBase query(String custCode) {
        Assert.notNull("Cust code must not be null", custCode);
        return dalClient.queryForObject("custBase.query", MapUtils.getParamMap("custCode", custCode), CustBase.class);
    }

}
