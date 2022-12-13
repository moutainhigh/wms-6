package com.dx.cmm.service.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class MatchUserRelationDaoImpl extends BaseDaoImpl<MatchUserRelation> implements IMatchUserRelationDao {

    private static final String USER_SQL = "matchUserRelation.query";

    @Override
    public List<MatchUserRelation> queryArray(Long userId, Class<?> type) {
        Assert.notNull("User id must not be null", userId);
        if (!type.equals(InvestmentPool.class) && !type.equals(CreditorPool.class)) {
            throw new ParamException("Type must between invest or credit");
        }
        return dalClient.queryForList(USER_SQL,
                MapUtils.getParamMap(type.equals(InvestmentPool.class) ? "investUser" : "creditUser", userId),
                MatchUserRelation.class);
    }

}
