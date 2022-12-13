package com.dx.cmm.service.results;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.credit.CreditAbs;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.result.CreditResults;
import com.dx.common.service.utils.Assert;

@Service("creditResult")
public class CreditResult extends CreditAbs<CreditResults> implements Result<CreditResults> {

    @Override
    public List<MatchResult> queryArray(Long poolId, Date reportDay) {
        return matchResultDao.queryArray(poolId, CreditorPool.class, reportDay);
    }

    @Override
    public void save(MatchResult result) throws SaveException {
        if (!Assert.checkParam(result.getMatchResultId())) {
            Assert.notNull("Result insert error", matchResultDao.insert(result));
            return;
        }
        if (!matchResultDao.update(result)) {
            throw new SaveException("Result id[{0}]update error", result.getMatchResultId());
        }
    }

    @Override
    public List<MatchResult> queryArray(Long poolId, Integer currentPeriod) {
        return null;
    }

    @Override
    public List<MatchResult> queryAll() {
        return matchResultDao.queryAll(MatchResult.class);
    }

    @Override
    public List<MatchResult> queryArray(String sqlId) {
        return matchResultDao.queryArray(sqlId);
    }

    @Override
    public StatResult query(Long poolId, Date reportDay) {
        return matchResultDao.sum(poolId, reportDay, CreditorPool.class);
    }

    @Override
    public List<CreditResults> queryArray(Long poolId, Integer period, BizBaseStatus status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sync(Long poolId, Integer period, BizBaseStatus source, BizBaseStatus target) throws SaveException {
        matchResultDao.sync(poolId, CreditorPool.class, source, target);
    }

}
