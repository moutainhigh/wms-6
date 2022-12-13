package com.dx.cmm.service.match;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.match.param.RepeatCreditParam;
import com.dx.cmm.service.match.param.RepeatInvestParam;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.match.result.RepeatInvestResult;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.push.ILenderPushService;
import com.dx.wms.service.push.LenderPushException;

/**
 * 
 * 重新匹配
 *
 * @author tony
 */
@Service("repeatMatch")
public class RepeatMatch extends PartMatch<RepeatInvestParam, RepeatCreditParam, RepeatInvestResult> {

    private static final String INVEST = "repeatMatch.queryInvest";
    
    
    private static final String KEY = "match:view:first:";
    
    @Autowired
    private ICacheService<MatchCache> cacheService;

    @Autowired
    private ILenderPushService lenderPushService;

    @Override
    public PaginationResult<List<RepeatInvestResult>> queryInvest(RepeatInvestParam param, Pagination page) {
        param.init(userd(InvestResult.class));
        param.amount();
        return dalClient.queryForList(INVEST, MapUtils.obj2Map(param), RepeatInvestResult.class, page);
    }

    @Override
    public PaginationResult<List<CreditResult>> queryCredit(RepeatCreditParam param, Pagination page) {
        param.init(userd(CreditResult.class));
        param.setUserIds(users(param.getUserId()));
        param.amount();
        return dalClient.queryForList(CREDIT, MapUtils.obj2Map(param), CreditResult.class, page);
    }

    private void save(List<InvestmentPool> pools, Long userId) throws MatchException {
        try {
            for (InvestmentPool pool : pools) {
                validate(pool);
                pool.repeat(userId);
                investPool.save(pool);
                PushDataDto data = new PushDataDto();
                data.match(userId, pool.getLenderCode(), pool.getBillDay(), pool.getInitMatchTime());
                investResult.sync(pool.getInvestmentPoolId(), pool.getCurrentPeriod(), BizBaseStatus.REPEAT,
                        BizBaseStatus.DELETE);
                investBizBase.save(pool.getMatchBizBaseId(), BizBaseStatus.MATCH);
                lenderPushService.push(PushCode.MATCH_COMPLETE, data);
            }
        } catch (LenderPushException | SaveException e) {
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
                save(matches, userId, cache.getReportDate(), investGroup, creditGroup, 0);
                // save invest
                save(pools, userId);
                // clear cache
                remove(userId);
                //删除对应协议预览缓存
                for(InvestmentPool pool : pools){
                	 String key = cacheService.initKey(KEY, pool.getLenderCode());
                     if(cacheService.exists(key)){
                     	cacheService.del(key);
                     }
                }
                return true;
            }
        });

    }

    @Override
    public RepeatInvestResult queryInvest(Long poolId) {
        if (!Assert.checkParam(poolId)) {
            LOG.error("Pool id must not be null");
            return new RepeatInvestResult();
        }
        RepeatInvestResult result = dalClient.queryForObject(INVEST, MapUtils.getParamMap("poolId", poolId),
                RepeatInvestResult.class);
        result.setResults(investResult.queryArray(poolId, 1, BizBaseStatus.REPEAT));
        return result;
    }

}
