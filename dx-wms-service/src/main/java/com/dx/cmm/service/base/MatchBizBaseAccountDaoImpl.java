package com.dx.cmm.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class MatchBizBaseAccountDaoImpl extends BaseDaoImpl<MatchBizBaseAccount> implements IMatchBizBaseAccountDao {

    @Override
    public List<MatchBizBaseAccount> query(Long baseId) {
        Assert.notNull(baseId);
        return dalClient.queryForList("matchBizBaseAccount.queryByBaseId", MapUtils.getParamMap("baseId", baseId),
                MatchBizBaseAccount.class);
    }
}
