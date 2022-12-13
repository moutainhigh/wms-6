package com.dx.op.service.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.op.service.dao.IAccountLevelLogDao;
import com.dx.op.service.entity.AccountLevelLog;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class AccountLevelLogDaoImpl extends BaseDaoImpl<AccountLevelLog> implements IAccountLevelLogDao {

    private static final Integer TRUE = 1;

    private static final Integer FALSE = 0;

    @Override
    public void save(AccountLevelLog log) throws SaveException {
        Assert.notNull(new SaveException("no find log"), log);
        Assert.notNull(new SaveException("log cust code:{0} insert error", log.getCustCode()), insert(log));
    }

    @Override
    public AccountLevelLog queryByParam(String custCode, Boolean isCurrent) {
        Assert.notNull("param is null", custCode, isCurrent);
        Map<String, Object> param = MapUtils.getParamMap("custCode", custCode);
        param.put("isCurrent", isCurrent ? TRUE : FALSE);
        return dalClient.queryForObject("accountLevelLog.queryByParam", param, AccountLevelLog.class);
    }

    @Override
    public Boolean update(AccountLevelLog log, Boolean isCurrent) {
        if (!Assert.checkParam(log)) {
            return true;
        }
        log.put();
        return super.update(log);
    }

    @Override
    public void update() throws SaveException {
        Assert.notNull(new SaveException("update log error"), dalClient.execute("accountLevelLog.batchUpdate", null));
    }

}
