package com.dx.cmm.service.pools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.credit.CreditAbs;
import com.dx.common.service.utils.Assert;

@Service("creditPool")
public class CreditPool extends CreditAbs<CreditorPool> implements Pools<CreditorPool> {

    @Override
    public Boolean exists(MatchBizBase base) {
        return Assert.checkParam(query(base));
    }

    @Override
    public CreditorPool query(MatchBizBase base) {
        return creditorPoolDao.query(base.getMatchBizBaseId());
    }

    @Override
    public void save(CreditorPool pool) throws SaveException {
        if (Assert.checkParam(pool.getCreditorPoolId())) {
            if (!creditorPoolDao.update(pool)) {
                throw new SaveException("Pool id[{0}] update error", pool.getCreditorPoolId());
            }
            return;
        }
        pool.setCreditorPoolId(creditorPoolDao.insert(pool));
        Assert.notNull(new SaveException("Biz id[{0}] create error", pool.getMatchBizBaseId()),
                pool.getCreditorPoolId());
    }

    @Override
    public CreditorPool query(Long poolId) {
        return creditorPoolDao.queryById(CreditorPool.class, poolId);
    }

    @Override
    public List<CreditorPool> queryArray(Integer port, MatchStatus... status) {
        return creditorPoolDao.queryArray(port, status);
    }

    @Override
    public List<CreditorPool> queryAll() {
        return creditorPoolDao.queryAll(CreditorPool.class);
    }

    @Override
    public List<CreditorPool> queryArray(Set<Long> ids) {
        return creditorPoolDao.queryArray(ids);
    }

    @Override
    public Map<Long, CreditorPool> group(List<CreditorPool> pools) {
        Map<Long, CreditorPool> group = new HashMap<Long, CreditorPool>();
        if (Assert.checkParam(pools)) {
            for (CreditorPool pool : pools) {
                group.put(pool.getCreditorPoolId(), pool);
            }
        }
        return group;
    }

	@Override
	public List<CreditorPool> queryArray(Integer port, Long productId,
			MatchStatus... status) {
		return new ArrayList<CreditorPool>();
	}

}
