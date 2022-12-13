/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustCommDaoImpl.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午8:03:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.exception.SaveException;

/**
 * 客户通讯表 dao 层 接口 实现
 *
 * @author 王蕊
 */
@Component
public class CustCommDaoImpl extends BaseDaoImpl<CustComm> implements ICustCommDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustCommDaoImpl.class);

    @Override
    public CustComm queryByParam(Long accountId) {
        Assert.notNull("Account id must not be null", accountId);
        LOG.info("Account id is[{}]", accountId);
        return dalClient.queryForObject("custComm.queryByAccountId", MapUtils.getParamMap("accountId", accountId),
                CustComm.class);
    }

    @Override
    public CustComm save(CustComm entity) throws SaveException {
        Assert.notNull(new SaveException("Comn must not be null"), entity);
        Assert.notNull(new SaveException("Account id must not be null"), entity.getCustAccountId());
        if (Assert.checkParam(entity.getCustCommId())) {
            if (!update(entity)) {
                throw new SaveException("Account id[{0}],id[{1}] update error", entity.getCustAccountId(),
                        entity.getCustCommId());
            }
            return entity;
        } else {
            Long id = insert(entity);
            Assert.notNull(new SaveException("Account id[{0}] create error", entity.getCustAccountId()), id);
            return entity.setCustCommId(id);
        }
    }
}
