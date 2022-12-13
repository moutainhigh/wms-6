package com.dx.cmm.service.match;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.match.param.AddCreditParam;
import com.dx.cmm.service.match.param.AddInvestParam;
import com.dx.cmm.service.match.result.AddInvestResult;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 新增匹配
 *
 * @author tony
 */
@Service("addMatch")
public class AddMatch extends AllMatch<AddInvestParam, AddCreditParam, AddInvestResult> {

    private static final String INVEST = "addMatch.queryInvest";

    @Override
    public PaginationResult<List<AddInvestResult>> queryInvest(AddInvestParam param, Pagination page) {
        param.init(userd(InvestResult.class));
        param.amount();
        return dalClient.queryForList(INVEST, MapUtils.obj2Map(param), AddInvestResult.class, page);
    }

    @Override
    public PaginationResult<List<CreditResult>> queryCredit(AddCreditParam param, Pagination page) {
        param.init(userd(CreditResult.class));
        param.setUserIds(users(param.getUserId()));
        param.amount();
        return dalClient.queryForList(CREDIT, MapUtils.obj2Map(param), CreditResult.class, page);
    }

    @Override
    public AddInvestResult queryInvest(Long poolId) {
        if (!Assert.checkParam(poolId)) {
            LOG.error("Pool id must not be null");
            return new AddInvestResult();
        }
        return dalClient.queryForObject(INVEST, MapUtils.getParamMap("poolId", poolId), AddInvestResult.class);
    }

}
