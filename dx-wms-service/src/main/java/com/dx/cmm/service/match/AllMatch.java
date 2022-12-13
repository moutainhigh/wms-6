package com.dx.cmm.service.match;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.StatResult;
import com.dx.cmm.service.rules.Rulers;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.push.ILenderPushService;
import com.dx.wms.service.push.LenderPushException;

abstract class AllMatch<IP, CP, IR> extends MatchAbs<IP, CP, IR> {

    @Autowired
    private ILenderPushService lenderPushService;

    @Autowired
    Rulers<Date, Integer> billPortRuler;

    private void save(List<InvestmentPool> pools, Long userId, Integer port, Date reportDate) throws MatchException {
        try {
            for (InvestmentPool pool : pools) {
                validate(pool);
                pool.match(userId, port, reportDate);
                investPool.save(pool);
                PushDataDto data = new PushDataDto();
                data.match(userId, pool.getLenderCode(), port, new Date());
                lenderPushService.push(PushCode.MATCH_COMPLETE, data);
                investBizBase.save(pool.getMatchBizBaseId(), BizBaseStatus.MATCH);
            }
        } catch (LenderPushException | SaveException e) {
            throw error(e.getMessage());
        }

    }

    private void save(Set<Match> matches, Long userId, Date reportDate, Map<Long, InvestmentPool> investGroup,
            Map<Long, CreditorPool> creditGroup) throws MatchException {
        try {
            for (Match match : matches) {
                CreditorPool pool = creditGroup.get(match.getCreditPoolId());
                validate(pool);
                BigDecimal interestTotal = pool.interest();
                BigDecimal capitalTotal = pool.capital();
                BigDecimal repayTotal = pool.getInitEaBillAmount();
                BigDecimal rate = BigDecimal.ONE, repay = BigDecimal.ZERO, interest = BigDecimal.ZERO,
                        capital = BigDecimal.ZERO;
                if (Assert.equals(pool.getCurrentUndoAmount(), match.getMatchAmount())) {
                    StatResult stat = creditResult.query(match.getCreditPoolId(), reportDate);
                    rate = BigDecimal.ONE.subtract(stat.getCreditRate());
                    repay = repayTotal.subtract(stat.getRepayTotal());
                    interest = interestTotal.subtract(stat.getIntTotal());
                    capital = capitalTotal.subtract(stat.getCapitalTotal());
                } else {
                    rate = match.getMatchAmount().divide(pool.getCurrentTotalAmount(), 15, BigDecimal.ROUND_HALF_UP);
                    interest = interestTotal.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
                    repay = repayTotal.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
                    capital = repay.subtract(interest);
                }
                if (capital.compareTo(repay) >= 0) {
                    capital = repay;
                    interest = BigDecimal.ZERO;
                }
                save(new MatchResult(userId, match, reportDate, 1), rate, repay, capital, interest);
                save(pool, userId, match);
                investUser.save(investGroup.get(match.getInvestPoolId()).getMatchUserId(), pool.getMatchUserId());
                creditBizBase.save(pool.getMatchBizBaseId(), BizBaseStatus.MATCH);
            }
        } catch (SaveException e) {
            throw error(e.getMessage());
        }
    }

    @Override
    public synchronized void match(final Long userId, final Set<Match> matches) throws MatchException {
        // validate param
        validate(userId, matches);
        final MatchCache cache = queryCache(userId);
        validate(cache, matches);
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                List<InvestmentPool> pools = investPool.queryArray(current(InvestResult.class, matches));
                Map<Long, InvestmentPool> investGroup = investPool.group(pools);
                Map<Long, CreditorPool> creditGroup = creditPool
                        .group(creditPool.queryArray(current(CreditResult.class, matches)));
                // save match result and credit
                save(matches, userId, cache.getReportDate(), investGroup, creditGroup);
                // save invest
                save(pools, userId, cache.getPort(), cache.getReportDate());
                // clear cache
                remove(userId);
                return true;
            }
        });

    }

    @Override
    public void init(Long userId, Set<InvestResult> invests) throws MatchException {
        Integer port = billPortRuler.parse(new Date());
        for (InvestResult invest : invests) {
            invest.setMatchUserIds(investUser.queryArray(invest.getUserId()));
        }
        super.init(userId, port, investPorts.current(port), invests);
    }

    @Override
    public List<Match> auto(Long userId) {
        LOG.error("All match has no auto match");
        return null;
    }

}
