package com.dx.cmm.service.results;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.invest.InvestAbs;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.result.InvestResults;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;

@Service("investResult")
public class InvestResult extends InvestAbs<InvestResults> implements Result<InvestResults> {

    @Override
    public List<MatchResult> queryArray(Long poolId, Date reportDay) {
        return matchResultDao.queryArray(poolId, InvestmentPool.class, reportDay);
    }

    @Override
    public List<MatchResult> queryArray(Long poolId, Integer currentPeriod) {
        return matchResultDao.queryArray(poolId, InvestmentPool.class, currentPeriod);
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
    public List<MatchResult> queryAll() {
        return matchResultDao.queryAll(MatchResult.class);
    }

    @Override
    public List<MatchResult> queryArray(String sqlId) {
        return matchResultDao.queryArray(sqlId);
    }

    @Override
    public StatResult query(Long poolId, Date reportDay) {
        return matchResultDao.sum(poolId, reportDay, InvestmentPool.class);
    }

    @Override
    public List<InvestResults> queryArray(Long poolId, Integer period, BizBaseStatus status) {
        String key = cacheService.initKey(MessageFormat.format("match:result:{0}:", status), poolId, ":", period);
        List<InvestResults> results = cacheService.getArray(key, InvestResults.class);
        if (Assert.checkParam(results)) {
            return results;
        }
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("period", period);
        param.put("status", status.getCode());
        results = dalClient.queryForList("matchResult.queryInvest", param, InvestResults.class);
        cacheService.set(key, results);
        return results;
    }

    @Override
    public void sync(Long poolId, Integer period, BizBaseStatus source, BizBaseStatus target) throws SaveException {
        String key = cacheService.initKey(MessageFormat.format("match:result:{0}:", source), poolId, ":", period);
        cacheService.del(key);
        matchResultDao.sync(poolId, InvestmentPool.class, source, target);
    }
}
