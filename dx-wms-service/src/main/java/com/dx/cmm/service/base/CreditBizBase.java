package com.dx.cmm.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.credit.CreditAbs;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

@Service("creditBizBase")
public class CreditBizBase extends CreditAbs<CreditorPool> implements BizBase<CreditorPool> {

    @Override
    public MatchBizBase query(Long bizId) {
        return matchBizBaseDao.query(bizId, CreditorPool.class);
    }

    @Override
    public List<MatchBizBase> queryArray(Boolean isExe, BizBaseStatus... status) {
        return matchBizBaseDao.queryArray(CreditorPool.class, isExe, status);
    }

    @Override
    public MatchBizBase query(String bizCode) {
        return matchBizBaseDao.query(bizCode);
    }

    @Override
    public void save(MatchBizBase base) throws SaveException {
        if (!Assert.checkParam(base)) {
            LOG.error("Base not found");
            throw new SaveException("Base not found");
        }
        base.exe();
        if (!matchBizBaseDao.update(base)) {
            LOG.error("Base[{}] update error", new Gson().toJson(base));
            throw new SaveException("Base[{0}] update error", new Gson().toJson(base));
        }
    }

    @Override
    public void save(Long id, BizBaseStatus status) throws SaveException {
        Assert.notNull("Param must not be null", id, status);
        MatchBizBase base = matchBizBaseDao.queryById(MatchBizBase.class, id);
        if (!Assert.checkParam(base)) {
            LOG.error("Base[{}] not found", id);
            throw new SaveException("Base[{0}] not found", id);
        }
        if (Assert.checkParam(base.getDataStatus(), status.getCode())) {
            LOG.info("Base[{}] is [{}]", id, status);
        }
        base.exe(status);
        save(base);

    }

    @Override
    public List<MatchBizBase> queryArray(Integer port, Boolean isExe, BizBaseStatus... status) {
        return matchBizBaseDao.queryArray(port, isExe, status);
    }

}
