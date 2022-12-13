package com.dx.cmm.service.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.invest.Invest;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;

@Service("investUser")
public class InvestUser extends UserAbs<InvestmentPool> implements Invest<InvestmentPool> {

    @Override
    public List<Long> queryArray(Long userId) {
        List<Long> results = cache(userId);
        if (Assert.checkParam(results)) {
            return results;
        }
        List<MatchUserRelation> users = matchUserRelationDao.queryArray(userId, InvestmentPool.class);
        if (Assert.checkParam(users)) {
            results = new ArrayList<Long>();
            for (MatchUserRelation user : users) {
                results.add(user.getCreditorUserId());
            }
            results.add(userId);
        }
        if (Assert.checkParam(results)) {
            set(userId, results);
        }
        return results;
    }

    @Override
    public void save(Long one, Long another) throws SaveException {
        if (!Assert.checkParam(one) || !Assert.checkParam(another)) {
            throw new SaveException("User must not be null");
        }
        LOG.info("Invest user[{}],credit user[{}]", one, another);
        if (!Assert.checkParam(matchUserRelationDao.insert(new MatchUserRelation(one, another)))) {
            throw new SaveException("Invest user[{0}] and credit user[{1}] match relation error", one, another);
        }
        del(one);
    }

}
