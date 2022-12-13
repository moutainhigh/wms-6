/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountDaoImpl.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午7:21:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.detail.DetailType;
import com.dx.wms.service.exception.ObjectNotFoundException;
import com.dx.wms.service.exception.SaveException;
import com.dx.wms.service.exception.UpdateException;

/**
 * 客户账户Dao层实现
 *
 * @author 王蕊
 */
@Component
public class CustAccountDaoImpl extends BaseDaoImpl<CustAccount> implements ICustAccountDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustAccountDaoImpl.class);

    @Override
    public Boolean update(Long id, String code, String status) throws UpdateException {
        Assert.notNull("Id must not be null", id);
        LOG.info("Id[{}] update", id);
        CustAccount entity = queryById(CustAccount.class, id);
        if (Assert.checkParam(code)) {
            LOG.info("Source code[{}],target code[{}] update", entity.getLenderCustCode(), code);
            entity.setLenderCustCode(code).setUpdateTime();
            entity.setAccountTime(new Date());
        }
        if (Assert.checkParam(status)) {
            LOG.info("Source status[{}],target status[{}] update", entity.getDataStatus(), status);
            entity.setDataStatus(status);
            entity.setUpdateTime();
        }
        return update(entity);
    }

    @Override
    public CustAccount queryByParam(Long id, DetailType detail) {
        Assert.notNull("Detail or id must not be null", detail, id);
        switch (detail) {
            case ACCOUNT:
                return queryById(CustAccount.class, id);
            case APPLY:
                return dalClient.queryForObject("custAccount.queryByApply", MapUtils.getParamMap("id", id),
                        CustAccount.class);
            default:
                throw new ObjectNotFoundException("Account {0} id[{1}] not found", detail.getInfo(), id);
        }
    }

    @Override
    public CustAccount save(CustAccount entity) throws SaveException {
        Assert.notNull(new SaveException("Entity must not be null"), entity);
        if (Assert.checkParam(entity.getCustAccountId())) {
            if (!update(entity)) {
                entity.setUpdateTime();
                throw new SaveException("Account id[{0}] update error", entity.getCustAccountId());
            }
            return entity;
        } else {
            Long id = insert(entity);
            Assert.notNull(new SaveException("Account cust name[{0}],id card[{1}],mobile[{1}] create error",
                    entity.getCustName(), entity.getIdCard(), entity.getMobile()), id);
            return entity.setCustAccountId(id);
        }
    }

    @Override
    public CustAccount queryByParam(String code) {
        Assert.notNull("Lender cust code must not be null", code);
        return dalClient.queryForObject("custAccount.queryCustAccount", MapUtils.getParamMap("lenderCustCode", code),
                CustAccount.class);
    }

	@Override
	public CustAccount queryByCode(String custCode) {
		 Assert.notNull("custAccount must not be null", custCode);
		 return dalClient.queryForObject("custAccount.queryCustAccount", MapUtils.getParamMap("custCode", custCode),
	                CustAccount.class);
	}
}
