package com.dx.cmm.service.match;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.ports.InvestPort;
import com.dx.cmm.service.ports.Ports;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.result.InvestResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;
import com.dx.cmm.service.users.User;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.client.support.PaginationDalClient;

abstract class MatchAbs<IP, CP, IR> implements IMatchService<IP, CP, IR> {

    private static final String PATTERN = "matching:*";

    private static final String KEY = "matching:";

    static final String CREDIT = "creditMatch.queryCredit";

    @Autowired
    private ICacheService<MatchCache> cacheService;

    static final Logger LOG = LoggerFactory.getLogger("match.log");

    @Autowired
    User<InvestmentPool> investUser;

    @Autowired
    PaginationDalClient dalClient;

    @Autowired
    Ports<InvestPort> investPorts;

    @Autowired
    Result<CreditResults> creditResult;

    @Autowired
    Result<InvestResults> investResult;

    @Autowired
    Pools<CreditorPool> creditPool;

    @Autowired
    Pools<InvestmentPool> investPool;

    @Autowired
    BizBase<CreditorPool> creditBizBase;

    @Autowired
    BizBase<InvestmentPool> investBizBase;

    private void remove(Long userId, Set<Match> matches) {
        MatchCache cache = queryCache(userId);
        Iterator<Match> matchIter = cache.getMatches().iterator();
        while (matchIter.hasNext()) {
            Match source = matchIter.next();
            for (Match target : matches) {
                if (source.equals(target)) {
                    matchIter.remove();
                    break;
                }
            }
        }
    }

    private void removeInvest(Long userId, Set<InvestResult> invests) {
        MatchCache cache = queryCache(userId);
        Iterator<InvestResult> investIter = cache.getInvests().iterator();
        while (investIter.hasNext()) {
            InvestResult source = investIter.next();
            for (InvestResult target : invests) {
                if (source.equals(target)) {
                    investIter.remove();
                    break;
                }
            }
        }
        Iterator<Match> matchIter = cache.getMatches().iterator();
        while (matchIter.hasNext()) {
            Match match = matchIter.next();
            for (InvestResult target : invests) {
                if (match.getInvestPoolId().equals(target.getPoolId())) {
                    matchIter.remove();
                    break;
                }
            }
        }
        cacheService.set(key(userId), cache);
    }

    private void removeCredit(Long userId, Set<CreditResult> credits) {
        MatchCache cache = queryCache(userId);
        Iterator<CreditResult> creditIter = cache.getCredits().iterator();
        while (creditIter.hasNext()) {
            CreditResult source = creditIter.next();
            for (CreditResult target : credits) {
                if (source.equals(target)) {
                    creditIter.remove();
                    break;
                }
            }
        }
        Iterator<Match> matchIter = cache.getMatches().iterator();
        while (matchIter.hasNext()) {
            Match match = matchIter.next();
            for (CreditResult target : credits) {
                if (match.getCreditPoolId().equals(target.getPoolId())) {
                    matchIter.remove();
                    break;
                }
            }
        }
        cacheService.set(key(userId), cache);
    }

    private void validate(Set<CreditResult> credits) throws MatchException {
        for (Long id : userd(CreditResult.class)) {
            for (CreditResult credit : credits) {
                if (Assert.equals(id, credit.getPoolId())) {
                    throw error("债权-客户姓名[{0}]已占用", credit.getCustName());
                }
            }
        }
        for (CreditResult credit : credits) {
            CreditorPool pool = creditPool.query(credit.getPoolId());
            if (!Assert.equals(credit.getUndoAmount(), pool.getCurrentUndoAmount())) {
                throw error("债权-客户姓名[{0}]剩余债权已更新，请刷新.", credit.getCustName());
            }
        }
    }

    private void validate(MatchCache cache) throws MatchException {
        if (!Assert.checkParam(cache)) {
            throw error("缓存为空");
        }
        if (!Assert.checkParam(cache.getCredits())) {
            throw error("债权列表为空");
        }
        if (!Assert.checkParam(cache.getInvests())) {
            throw error("投资列表为空");
        }
    }

    void save(CreditorPool pool, Long userId, Match match) {
        pool.match(userId, match.getMatchAmount());
        creditPool.save(pool);
    }

    @Override
    public void remove(Long userId, Set<Match> matches, Set<InvestResult> invests, Set<CreditResult> credits)
            throws MatchException {
        if (!cacheService.exists(key(userId))) {
            return;
        }
        // No choose , clear cache
        if (!Assert.checkParam(credits) && !Assert.checkParam(invests) && !Assert.checkParam(matches)) {
            cacheService.del(key(userId));
            return;
        }

        LOG.info("User remove chosen items");
        // If choose credit , clear chosen credits
        if (Assert.checkParam(credits)) {
            removeCredit(userId, credits);
        }
        // If choose invest , clear chosen invests
        if (Assert.checkParam(invests)) {
            removeInvest(userId, invests);
        }
        if (Assert.checkParam(matches)) {
            remove(userId, matches);
        }
    }

    @Override
    public void join(Long userId, Set<CreditResult> credits) throws MatchException {
        validate(credits);
        MatchCache cache = queryCache(userId);
        credits.addAll(cache.getCredits());
        cache.setCredits(credits);
        cacheService.set(key(userId), cache);
    }

    @Override
    public MatchCache queryCache(Long userId) {
        return cacheService.getObject(key(userId), MatchCache.class);
    }

    @Override
    public void save(Long userId, Set<Match> matches) throws MatchException {
        MatchCache cache = queryCache(userId);
        matches.addAll(cache.getMatches());
        cache.setMatches(matches);
        cacheService.set(key(userId), cache);
    }

    @Override
    public Long current(List<InvestResult> targets) {
        Set<String> keys = cacheService.keys(PATTERN);
        if (Assert.checkParam(keys)) {
            for (String key : keys) {
                MatchCache cache = cacheService.getObject(key, MatchCache.class);
                if (Assert.checkParam(cache)) {
                    for (InvestResult invest : cache.getInvests()) {
                        for (InvestResult target : targets) {
                            if (target.equals(invest)) {
                                return Long.valueOf(key.replace(KEY, ""));
                            }
                        }
                    }
                }
            }
        }
        return 0L;
    }

    @Override
    public Long current(Long poolId, Class<?> type) {
        Set<String> keys = cacheService.keys(PATTERN);
        if (Assert.checkParam(keys)) {
            for (String key : keys) {
                MatchCache cache = cacheService.getObject(key, MatchCache.class);
                if (Assert.checkParam(cache)) {
                    if (type.equals(CreditResult.class)) {
                        for (CreditResult credit : cache.getCredits()) {
                            if (Assert.equals(poolId, credit.getPoolId())) {
                                return Long.valueOf(key.replace(KEY, ""));
                            }
                        }
                    }
                    if (type.equals(InvestResult.class)) {
                        for (InvestResult invest : cache.getInvests()) {
                            if (Assert.equals(poolId, invest.getPoolId())) {
                                return Long.valueOf(key.replace(KEY, ""));
                            }
                        }
                    }
                }
            }
        }
        return 0L;
    }

    MatchException error(String msg) {
        LOG.error(msg);
        return new MatchException(msg);
    }

    MatchException error(String msg, Object... args) {
        return new MatchException(msg, args);
    }

    String key(Long userId) throws MatchException {
        if (!Assert.checkParam(userId)) {
            throw error("User id must not be null");
        }
        return cacheService.initKey(KEY, userId);
    }

    List<Long> users(Long userId) {
        return investUser.queryArray(userId);
    }

    Set<Long> current(Class<?> type, Set<Match> matches) {
        Set<Long> ids = new HashSet<Long>();
        for (Match match : matches) {
            if (type.equals(CreditResult.class)) {
                ids.add(match.getCreditPoolId());
            }
            if (type.equals(InvestResult.class)) {
                ids.add(match.getInvestPoolId());
            }
        }
        return ids;
    }

    List<Long> userd(Class<?> type) {
        List<Long> ids = new ArrayList<Long>();
        Set<String> keys = cacheService.keys(PATTERN);
        if (Assert.checkParam(keys)) {
            for (String key : keys) {
                MatchCache cache = cacheService.getObject(key, MatchCache.class);
                if (Assert.checkParam(cache)) {
                    if (type.equals(CreditResult.class)) {
                        for (CreditResult credit : cache.getCredits()) {
                            ids.add(credit.getPoolId());
                        }
                    }
                    if (type.equals(InvestResult.class)) {
                        for (InvestResult invest : cache.getInvests()) {
                            ids.add(invest.getPoolId());
                        }
                    }
                }
            }
        }
        return ids;
    }

    void remove(Long userId) {
        cacheService.del(key(userId));
    }

    BigDecimal matchAmounts(Set<Match> matches) {
        BigDecimal result = BigDecimal.ZERO;
        for (Match match : matches) {
            result = result.add(match.getMatchAmount());
        }
        return result;
    }

    void validate(Long userId, Set<Match> matches) throws MatchException {
        if (!Assert.checkParam(userId)) {
            throw error("操作人不能为空");
        }
        if (!Assert.checkParam(matches)) {
            throw error("匹配结果不能为空");
        }
        for (Match match : matches) {
            if (!Assert.checkParam(match.getMatchAmount())) {
                throw error("匹配金额[{0}]必须大于0", match.getMatchAmount());
            }
            if (match.getMatchAmount().compareTo(match.getTotalAmount()) > 0) {
                throw error("匹配金额[{0}]剩余债权价值[{1}]", match.getMatchAmount(), match.getTotalAmount());
            }
        }
    }

    Map<Long, BigDecimal> group(Set<Match> matches, Class<?> type) {
        Map<Long, BigDecimal> results = new HashMap<Long, BigDecimal>();
        for (Match match : matches) {
            BigDecimal matchAmount = match.getMatchAmount();
            if (type.equals(InvestResult.class)) {
                if (results.containsKey(match.getInvestPoolId())) {
                    matchAmount = matchAmount.add(results.get(match.getInvestPoolId()));
                }
                results.put(match.getInvestPoolId(), matchAmount);
            }
            if (type.equals(CreditResult.class)) {
                if (results.containsKey(match.getCreditPoolId())) {
                    matchAmount = matchAmount.add(results.get(match.getCreditPoolId()));
                }
                results.put(match.getCreditPoolId(), matchAmount);
            }
        }
        return results;
    }

    void validate(InvestmentPool pool) throws MatchException {
        if (!Assert.checkParam(pool)) {
            throw error("投资[{0}]不存在", pool.getInvestmentPoolId());
        }
        if (!Assert.checkParam(pool.getCurrentUndoAmount())) {
            throw error("投资[{0}]未匹配金额[{1}]不足", pool.getInvestmentPoolId(), pool.getCurrentUndoAmount());
        }
    }

    void validate(CreditorPool pool) throws MatchException {
        if (!Assert.checkParam(pool)) {
            throw error("债权不存在");
        }
        if (!Assert.checkParam(pool.getCurrentUndoAmount())) {
            throw error("债权[{0}]剩余债权价值[{1}]不足", pool.getCreditorPoolId(), pool.getCurrentUndoAmount());
        }
    }

    void validate(MatchCache cache, Set<Match> matches) throws MatchException {
        validate(cache);
        Map<Long, BigDecimal> tmp = group(matches, InvestResult.class);
        if (!Assert.equals(tmp.size(), cache.getInvests().size())) {
            throw error("Match size not equals");
        }
        for (InvestResult invest : cache.getInvests()) {
            if (!tmp.containsKey(invest.getPoolId())) {
                throw error("投资-出借编号[{0}]未匹配", invest.getLenderCode());
            }
            if (!Assert.equals(invest.getUndoAmount(), tmp.get(invest.getPoolId()))) {
                throw error("投资-出借编号[{0}]匹配金额[{1}]未匹配金额[{2}]不符", invest.getLenderCode(), invest.getUndoAmount(),
                        tmp.get(invest.getPoolId()));
            }
        }
        tmp.clear();
        tmp = group(matches, CreditResult.class);
        for (CreditResult credit : cache.getCredits()) {
            if (tmp.containsKey(credit.getPoolId())
                    && (tmp.get(credit.getPoolId()).compareTo(credit.getUndoAmount()) > 0)) {
                throw error("债权-身份证[{0}]匹配金额[{1}]大于剩余债权价值[{2}]", credit.getIdCard(), tmp.get(credit.getPoolId()),
                        credit.getUndoAmount());
            }
        }

    }

    void init(Long userId, Integer port, Date reportDate, Set<InvestResult> invests) throws MatchException {
        cacheService.set(key(userId), new MatchCache(userId, port, reportDate, invests));
    }

    void save(MatchResult result, BigDecimal rate, BigDecimal repay, BigDecimal capital, BigDecimal interest) {
        result.setCreditorRate(rate);
        result.setTransferEaAmount(repay);
        result.setTransferEaCapitalAmount(capital);
        result.setTransferEaInterestAmount(interest);
        creditResult.save(result);
    }

}
