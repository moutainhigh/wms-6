package com.dx.cmm.service.match;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.match.comparator.CreditComparator;
import com.dx.cmm.service.match.comparator.InvestComparator;
import com.dx.cmm.service.match.comparator.MatchComparator;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.StatResult;
import com.dx.common.service.utils.Assert;

abstract class PartMatch<IP, CP, IR> extends MatchAbs<IP, CP, IR> {

    @Autowired
    Funds<InvestmentFund> investFund;

    @Override
    public void init(Long userId, Set<InvestResult> invests) throws MatchException {
        Integer port = 0;
        Date portDate = new Date();
        for (InvestResult invest : invests) {
            port = invest.getPortDay();
            portDate = invest.getPortDate();
            invest.setMatchUserIds(investUser.queryArray(invest.getUserId()));
        }
        super.init(userId, port, portDate, invests);
    }

    void save(Set<Match> matches, Long userId, Date reportDate, Map<Long, InvestmentPool> investGroup,
            Map<Long, CreditorPool> creditGroup, Integer step) throws MatchException {
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
                InvestmentPool invest = investGroup.get(match.getInvestPoolId());
                save(new MatchResult(userId, match, reportDate, invest.getCurrentPeriod() + step), rate, repay, capital,
                        interest);
                save(pool, userId, match);
                investUser.save(invest.getMatchUserId(), pool.getMatchUserId());
                creditBizBase.save(pool.getMatchBizBaseId(), BizBaseStatus.MATCH);
            }
        } catch (SaveException e) {
            throw error(e.getMessage());
        }
    }

    @Override
    public List<Match> auto(Long userId) {
        MatchCache cache = queryCache(userId);
        List<Match> matches = new ArrayList<Match>();
        List<InvestResult> invests = new ArrayList<InvestResult>(cache.getInvests());
        Collections.sort(invests, new InvestComparator());
        List<CreditResult> credits = new ArrayList<CreditResult>(cache.getCredits());
        Collections.sort(credits, new CreditComparator());
        for (InvestResult invest : invests) {
            BigDecimal undoAmount = invest.getUndoAmount();
            for (CreditResult credit : credits) {
                if (invest.getMatchUserIds().contains(credit.getUserId())) {
                    LOG.error("Invest[{}] has contains credit[{}]", invest.getLenderCode(), credit.getPoolId());
                    continue;
                }
                if (!Assert.checkParam(credit.getUndoAmount())) {
                    LOG.error("Credit[{}] has matched", credit.getPoolId());
                    continue;
                }
                if (!Assert.checkParam(undoAmount)) {
                    LOG.error("Invest[{}] has matched", invest.getLenderCode());
                    break;
                }
                BigDecimal matchAmount = undoAmount.compareTo(credit.getUndoAmount()) >= 0 ? credit.getUndoAmount()
                        : undoAmount;
                Match match = new Match();
                match.setInvestName(invest.getCustName());
                match.setInvestPoolId(invest.getPoolId());
                match.setLenderCode(invest.getLenderCode());
                match.setTotalAmount(invest.getUndoAmount());
                match.setCreditName(credit.getCustName());
                match.setCreditPoolId(credit.getPoolId());
                match.setMatchAmount(matchAmount);
                matches.add(match);
                undoAmount = undoAmount.subtract(matchAmount);
                credit.setUndoAmount(credit.getUndoAmount().subtract(matchAmount));
            }
        }
        Collections.sort(matches, new MatchComparator());
        return matches;
    }
}
