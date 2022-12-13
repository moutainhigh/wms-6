package com.dx.cmm.service.match;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.match.param.ExpCreditParam;
import com.dx.cmm.service.match.param.ExpInvestParam;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.ExpInvestResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.StatResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("expMatch")
public class ExpMatch extends PartMatch<ExpInvestParam, ExpCreditParam, ExpInvestResult> {

    private static final String INVEST = "expMatch.queryInvest";

    @Override
    public PaginationResult<List<ExpInvestResult>> queryInvest(ExpInvestParam param, Pagination page) {
        param.init(userd(InvestResult.class));
        param.amount();
        return dalClient.queryForList(INVEST, MapUtils.obj2Map(param), ExpInvestResult.class, page);
    }

    @Override
    public PaginationResult<List<CreditResult>> queryCredit(ExpCreditParam param, Pagination page) {
        param.init(userd(CreditResult.class));
        param.setUserIds(users(param.getUserId()));
        param.amount();
        return dalClient.queryForList(CREDIT, MapUtils.obj2Map(param), CreditResult.class, page);
    }

    private void execute(InvestmentPool pool, Date reportDate) {
        StatResult stat = investResult.query(pool.getInvestmentPoolId(), reportDate);
        pool.repay(stat.getRepayTotal());
        pool.princal(stat.getCapitalTotal());
        pool.interest(stat.getIntTotal());
        pool.total();
    }

    private void save(Map<Long, InvestmentPool> investGroup, Long userId, Date reportDate) throws MatchException {
        try {
            for (Map.Entry<Long, InvestmentPool> entry : investGroup.entrySet()) {
                InvestmentPool pool = entry.getValue();
                pool.exp(userId);
                execute(pool, reportDate);
                InvestmentFund fund = investFund.query(pool.getInvestmentPoolId());
                fund.update(pool);
                investFund.save(fund);
                investPool.save(pool);
                investResult.sync(pool.getInvestmentPoolId(), pool.getCurrentPeriod(), BizBaseStatus.EXCEPTION,
                        BizBaseStatus.DELETE);
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
                Map<Long, InvestmentPool> investGroup = investPool
                        .group(investPool.queryArray(current(InvestResult.class, matches)));
                Map<Long, CreditorPool> creditGroup = creditPool
                        .group(creditPool.queryArray(current(CreditResult.class, matches)));
                // save match result and credit
                save(matches, userId, cache.getReportDate(), investGroup, creditGroup, 0);
                // save invest
                save(investGroup, userId, cache.getReportDate());
                // clear cache
                remove(userId);
                return true;
            }
        });
    }

    @Override
    public ExpInvestResult queryInvest(Long poolId) {
        if (!Assert.checkParam(poolId)) {
            LOG.error("Pool id must not be null");
            return new ExpInvestResult();
        }
        ExpInvestResult result = dalClient.queryForObject(INVEST, MapUtils.getParamMap("poolId", poolId),
                ExpInvestResult.class);
        result.setResults(investResult.queryArray(poolId, result.getCurrentPeriod(), BizBaseStatus.EXCEPTION));
        return result;
    }

}
