package com.dx.cmm.service.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.credit.Credit;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.common.service.utils.Assert;

@Service("creditUser")
public class CreditUser extends UserAbs<CreditorPool> implements Credit<CreditorPool> {

    @Override
    public List<Long> queryArray(Long userId) {
        List<Long> results = cache(userId);
        if (Assert.checkParam(results)) {
            return results;
        }
        List<MatchUserRelation> users = matchUserRelationDao.queryArray(userId, CreditorPool.class);
        for (MatchUserRelation user : users) {
            results.add(user.getInvestmentUserId());
        }
        results.add(userId);
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
        LOG.info("Credit user[{}],invest user[{}]", one, another);
        if (!Assert.checkParam(matchUserRelationDao.insert(new MatchUserRelation(another, one)))) {
            throw new SaveException("Credit user[{0}] and invest user[{1}] match relation error", one, another);
        }
        del(one);
    }

}
