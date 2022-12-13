package com.dx.cmm.service.users;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;

abstract class UserAbs<T> implements User<T> {

    static final Logger LOG = LoggerFactory.getLogger("user.log");

    private static final String KEY = "match:user:";

    @Autowired
    private ICacheService<Long> cacheService;

    @Autowired
    IMatchUserDao matchUserDao;

    @Autowired
    IMatchUserRelationDao matchUserRelationDao;

    @Override
    public MatchUser query(MatchBizBase base) {
        MatchUser user = query(base.getIdCard());
        if (Assert.checkParam(user)) {
            return user;
        }
        user = new MatchUser(base);
        Long id = matchUserDao.insert(user);
        Assert.notNull("User insert error", id);
        user.setMatchUserId(id);
        return user;
    }

    @Override
    public MatchUser query(Long id) {
        return matchUserDao.query(id);
    }

    @Override
    public MatchUser query(String idCard) {
        return matchUserDao.query(idCard);
    }

    String key(Long userId) {
        return cacheService.initKey(KEY, userId);
    }

    List<Long> cache(Long userId) {
        return cacheService.getArray(key(userId), Long.class);
    }

    void set(Long userId, List<Long> results) {
        cacheService.set(key(userId), results);
    }

    void del(Long userId) {
        cacheService.del(key(userId));
    }
}
