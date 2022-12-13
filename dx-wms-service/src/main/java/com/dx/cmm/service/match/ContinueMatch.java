package com.dx.cmm.service.match;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.match.param.ContinueCreditParam;
import com.dx.cmm.service.match.param.ContinueInvestParam;
import com.dx.cmm.service.match.result.ContinueInvestResult;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 续投匹配
 *
 * @author tony
 */
@Service("continueMatch")
public class ContinueMatch extends AllMatch<ContinueInvestParam, ContinueCreditParam, ContinueInvestResult> {

    private static final String INVEST = "continueMatch.queryInvest";

    @Override
    public PaginationResult<List<ContinueInvestResult>> queryInvest(ContinueInvestParam param, Pagination page) {
        param.init(userd(InvestResult.class));
        param.amount();
        return dalClient.queryForList(INVEST, MapUtils.obj2Map(param), ContinueInvestResult.class, page);
    }

    @Override
    public PaginationResult<List<CreditResult>> queryCredit(ContinueCreditParam param, Pagination page) {
        param.init(userd(CreditResult.class));
        param.setUserIds(users(param.getUserId()));
        param.amount();
        return dalClient.queryForList(CREDIT, MapUtils.obj2Map(param), CreditResult.class, page);
    }

    @Override
    public ContinueInvestResult queryInvest(Long poolId) {
        if (!Assert.checkParam(poolId)) {
            LOG.error("Pool id must not be null");
            return new ContinueInvestResult();
        }
        return dalClient.queryForObject(INVEST, MapUtils.getParamMap("poolId", poolId), ContinueInvestResult.class);
    }

}
