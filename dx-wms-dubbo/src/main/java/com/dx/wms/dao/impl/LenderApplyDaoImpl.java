/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午7:00:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.base.impl.BaseDaoImpl;
import com.dx.wms.bean.CustAccount;
import com.dx.wms.bean.CustBase;
import com.dx.wms.bean.LenderApply;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.ICustAccountDao;
import com.dx.wms.dao.ICustBaseDao;
import com.dx.wms.dao.ILenderApplyDao;
import com.dx.wms.dao.IlenderLogDao;
import com.dx.wms.service.exception.UpdateException;

/**
 * 出借申请表 dao层 接口实现
 *
 * @author 朱道灵
 */
@Service
public class LenderApplyDaoImpl extends BaseDaoImpl<LenderApply> implements ILenderApplyDao {

    @Autowired
    private ICustAccountDao custAccountDao;

    @Autowired
    private ICustBaseDao custBaseDao;

    @Autowired
    private IlenderLogDao lenderLogDao;

    @Override
    public List<LenderApply> queryAccountId(Long accountId) {
        Assert.notNull("Account id must not be null", accountId);
        return dalClient.queryForList("lenderApply.queryByCustAccountId",
                MapUtils.getParamMap("custAccontId", accountId), LenderApply.class);

    }

    @Override
    public List<LenderApply> queryByLenderCustCode(String lenderCustCode) {
        Assert.notNull("Lender cust code must not be null", lenderCustCode);
        return dalClient.queryForList("lenderApply.queryByLenderCustCode",
                MapUtils.getParamMap("lenderCustCode", lenderCustCode), LenderApply.class);
    }

    @Override
    public LenderApply query(String lenderCode) {
        Assert.notNull("Lender code must not be null", lenderCode);
        return dalClient.queryForObject("lenderApply.getLenderApplyByCode",
                MapUtils.getParamMap("lenderCode", lenderCode), LenderApply.class);
    }

    @Override
    public void sync(Long applyId, String status) throws UpdateException {
        Assert.notNull(new UpdateException("Apply id or status must not be null"), applyId, status);
        Map<String, Object> param = MapUtils.getParamMap("applyId", applyId);
        param.put("dueStatus", status);
        Assert.notNull(new UpdateException("Apply[{0}] sync due error", applyId),
                dalClient.execute("lenderApply.syncStatus", param));
    }

    @Override
    public void sync(Long applyId, Long status) throws UpdateException {
        Assert.notNull(new UpdateException("Apply id or status must not be null"), applyId, status);
        Map<String, Object> param = MapUtils.getParamMap("applyId", applyId);
        param.put("formStatus", status);
        Assert.notNull(new UpdateException("Apply[{0}] sync form error", applyId),
                dalClient.execute("lenderApply.syncStatus", param));
    }

    @Override
    public void sync(LenderApply apply, Long status) throws UpdateException {
        Assert.notNull(new UpdateException("Apply must not be null"), apply);
        if (Assert.checkParam(status)) {
            apply.setFormStatus(status);
            apply.setUpdateTime(new Date());
            if (!update(apply)) {
                LOG.error("Apply[{0}] sync form error", apply.getLenderApplyId());
                throw new UpdateException("Apply[{0}] sync form error", apply.getLenderApplyId());
            }
        }
        CustAccount account = custAccountDao.queryById(CustAccount.class, apply.getCustAccountId());
        Assert.notNull(new UpdateException("Account[{0}] not found", apply.getCustAccountId()), account);
        CustBase base = custBaseDao.query(account.getCustCode());
        Assert.notNull(new UpdateException("Base[{0}] not found", account.getCustCode()), base);
        if (!Assert.equals(base.getDataStatus(), account.getDataStatus())) {
            LOG.error("Base[{}] status[{}] and account[{}] status[{}] not equals", base.getCustId(),
                    base.getDataStatus(), account.getCustAccountId(), account.getDataStatus());
            throw new UpdateException("Base[{0}] status[{1}] and account[{2}] status[{3}] not equals", base.getCustId(),
                    base.getDataStatus(), account.getCustAccountId(), account.getDataStatus());
        }
        if (Assert.equals(base.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)
                && Assert.equals(account.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)) {
            LOG.info("Base[{}] status[{}] and account[{}] status[{}] all checked", base.getCustId(),
                    base.getDataStatus(), account.getCustAccountId(), account.getDataStatus());
            return;
        }
        account.status(lenderLogDao.query(account.getCustAccountId()));
        if (!custAccountDao.update(account)) {
            LOG.error("Account[{}] status[{}] sync error", account.getCustAccountId(), account.getDataStatus());
            throw new UpdateException("Account[{0}] status[{1}] sync error", account.getCustAccountId(),
                    account.getDataStatus());
        }
        base.status(account);
        if (!custBaseDao.update(base)) {
            LOG.error("Base[{}] status[{}] sync error", base.getCustId(), base.getDataStatus());
            throw new UpdateException("Base[{0}] status[{1}] sync error", base.getCustId(), base.getDataStatus());
        }
    }

}
