package com.dx.cmm.service.match;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.ViewAbs;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.common.service.utils.Assert;

public class MatchResGateway extends ViewAbs implements IMatchResService {

    private static final String PATTERN = "matching:*";

    private static final String KEY = "matching:";

    @Autowired
    private ICacheService<MatchCache> cacheService;

    @Override
    public List<MatchCache> queryAll() {
        List<MatchCache> caches = new ArrayList<MatchCache>();
        Set<String> keys = cacheService.keys(PATTERN);
        for (String key : keys) {
            caches.add(cacheService.getObject(key, MatchCache.class));
        }
        return caches;
    }

    @Override
    public Set<InvestResult> queryInvest(Long userId) {
        if (!Assert.checkParam(userId)) {
            return new HashSet<InvestResult>();
        }
        String key = key(userId);
        if (cacheService.exists(key)) {
            return cacheService.getObject(key, MatchCache.class).getInvests();
        }
        return new HashSet<InvestResult>();
    }

    @Override
    public Set<CreditResult> queryCredit(Long userId) {
        if (!Assert.checkParam(userId)) {
            return new HashSet<CreditResult>();
        }
        String key = key(userId);
        if (cacheService.exists(key)) {
            return cacheService.getObject(key, MatchCache.class).getCredits();
        }
        return new HashSet<CreditResult>();
    }

    @Override
    public void destory(Long userId) throws MatchException {
        if (!Assert.checkParam(userId)) {
            throw new MatchException("User id must not be null");
        }
        String key = key(userId);
        if (cacheService.exists(key)) {
            cacheService.del(key);
            return;
        }
        throw new MatchException("Key[{0}] not found", userId);
    }

    private String key(Long userId) {
        return cacheService.initKey(KEY, userId);
    }
    
 
   
}
