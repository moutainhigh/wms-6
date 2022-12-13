/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustProfessionDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午8:57:06
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
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.exception.SaveException;

/**
 * 客户职业表 dao层 接口实现
 *
 * @author 朱道灵
 */
@Component
public class CustProfessionDaoImpl extends BaseDaoImpl<CustProfession> implements ICustProfessionDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustProfessionDaoImpl.class);

    @Override
    public CustProfession queryByParam(Long accountId) {
        Assert.notNull("Account id must not be null", accountId);
        LOG.info("Account id is[{}]", accountId);
        return dalClient.queryForObject("custProfession.queryByAccountId", MapUtils.getParamMap("accountId", accountId),
                CustProfession.class);

    }

    @Override
    public CustProfession save(CustProfession entity) throws SaveException {
        Assert.notNull(new SaveException("Profession must not be null"), entity);
        Assert.notNull(new SaveException("Account id must not be null"), entity.getCustAccountId());
        if (Assert.checkParam(entity.getCustProfessionId())) {
            if (!update(entity)) {
                throw new SaveException("Account id[{0}],id[{1}] update error", entity.getCustAccountId(),
                        entity.getCustProfessionId());
            }
            return entity;
        } else {
            Long id = insert(entity);
            Assert.notNull(new SaveException("Account id[{0}] create error", entity.getCustAccountId()), id);
            return entity.setCustProfessionId(id);
        }
    }

}
