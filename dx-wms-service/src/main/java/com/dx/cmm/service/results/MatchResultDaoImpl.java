package com.dx.cmm.service.results;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.ParamException;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.dto.TransferTotalDto;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class MatchResultDaoImpl extends BaseDaoImpl<MatchResult> implements IMatchResultDao {

    private static final String SUM = "matchResult.sum";

    @Override
    public TransferTotalDto getTotalIncome(Long poolId, Integer period) {
        Assert.notNull("param is null", poolId, period);
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("period", period);
        return dalClient.queryForObject("matchResult.getTotalIncome", param, TransferTotalDto.class);
    }

    private Map<String, Object> param(Long poolId, Class<?> type) {
        if (!type.equals(InvestmentPool.class) && !type.equals(CreditorPool.class)) {
            throw new ParamException("Type must between invest or credit");
        }
        return MapUtils.getParamMap(type.equals(InvestmentPool.class) ? "investPoolId" : "creditPoolId", poolId);
    }

    @Override
    public List<MatchResult> queryArray(Long poolId, Class<?> type, Date reportDay) {
        Assert.notNull("Pool id or report day must not be null", poolId, reportDay);
        Map<String, Object> param = param(poolId, type);
        param.put("reportDay", DateUtils.formatForDay(reportDay));
        return dalClient.queryForList("matchResult.queryArray", param, MatchResult.class);
    }

    @Override
    public List<MatchResult> queryArray(Long poolId, Class<?> type, Integer period) {
        Assert.notNull("Pool id or period must not be null must not be null", poolId, period);
        Map<String, Object> param = param(poolId, type);
        param.put("period", period);
        return dalClient.queryForList("matchResult.queryArray", param, MatchResult.class);
    }

    @Override
    public List<MatchResult> queryArray(Long poolId, Class<?> type) {
        Assert.notNull("Pool id must not be null", poolId);
        return dalClient.queryForList("matchResult.queryArray", param(poolId, type), MatchResult.class);
    }

    @Override
    public void remain(List<MatchResult> results) {
        for (MatchResult result : results) {
            if (!Assert.checkParam(result.getMatchResultId())) {
                Assert.notNull("insert result exception", insert(result));
            }
        }
    }

    @Override
    public List<MatchResult> queryError() {
        return dalClient.queryForList("matchResult.queryError", null, MatchResult.class);
    }

    @Override
    public List<MatchResult> queryArray(String sqlId) {
        return dalClient.queryForList(sqlId, null, MatchResult.class);
    }

    @Override
    public StatResult sum(Long poolId, Date reportDate, Class<?> type) {
        Assert.notNull("Pool id or report date must not be null", poolId, reportDate);
        Map<String, Object> param = param(poolId, type);
        param.put("reportDate", reportDate);
        StatResult stat = dalClient.queryForObject(SUM, param, StatResult.class);
        return Assert.checkParam(stat) ? stat : new StatResult();
    }

    @Override
    public void sync(Long poolId, Class<?> type, BizBaseStatus source, BizBaseStatus target) throws SaveException {
        Assert.notNull("Pool id or source or target must not be null", poolId, source, target);
        Map<String, Object> param = param(poolId, type);
        param.put("source", source.getCode());
        param.put("target", target.getCode());
        Assert.notNull("Sync result error", dalClient.execute("matchResult.sync", param));
    }

}
