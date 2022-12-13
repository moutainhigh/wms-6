package com.dx.cmm.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class MatchBizBaseDaoImpl extends BaseDaoImpl<MatchBizBase> implements IMatchBizBaseDao {

    private static final String SQL_QUERY = "matchBizBase.query";

    @Override
    public MatchBizBase query(Long bizId, Class<?> type) {
        Assert.notNull("Biz id must not be null", bizId);
        Map<String, Object> paramMap = param(type);
        paramMap.put("bizId", bizId);
        return dalClient.queryForObject("matchBizBase.queryByBizId", paramMap, MatchBizBase.class);
    }

    @Override
    public MatchBizBase query(String bizCode) {
        Assert.notNull("Biz code must not be null", bizCode);
        return dalClient.queryForObject("matchBizBase.queryByBizCode", MapUtils.getParamMap("bizCode", bizCode),
                MatchBizBase.class);
    }

    @Override
    public List<MatchBizBase> queryArray(BizBaseStatus... status) {
        return dalClient.queryForList(SQL_QUERY, MapUtils.getParamMap("status", BizBaseStatus.getList(status)),
                MatchBizBase.class);
    }

    @Override
    public List<MatchBizBase> queryArray(Class<?> type, Boolean isExe, BizBaseStatus... status) {
        Map<String, Object> param = param(type);
        param.put("status", BizBaseStatus.getList(status));
        param.put("exe", isExe ? 1 : 0);
        return dalClient.queryForList(SQL_QUERY, param, MatchBizBase.class);
    }

    private Map<String, Object> param(Class<?> type) {
        if (!type.equals(InvestmentPool.class) && !type.equals(CreditorPool.class)) {
            throw new ParamException("Type must between invest or credit");
        }
        return MapUtils.getParamMap("category", type.equals(InvestmentPool.class) ? 2 : 1);
    }

    @Override
    public List<MatchBizBase> queryArray(Integer port, Boolean isExe, BizBaseStatus... status) {
        Map<String, Object> param = MapUtils.getParamMap("status", BizBaseStatus.getList(status));
        param.put("port", port);
        param.put("exe", isExe ? 1 : 0);
        return dalClient.queryForList(SQL_QUERY, param, MatchBizBase.class);
    }

}
