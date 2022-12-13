package com.dx.cmm.service.invest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.ViewAbs;
import com.dx.cmm.service.dao.IMatchBizBaseDao;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.exception.UpdateException;

public class InvestGatway extends ViewAbs implements IInvestService {
	
	private static final String INVEST = "firstView.queryInvestPool";

    private static final String CREDIT = "firstView.queryCredit";

    private static final String KEY = "match:view:first:";
	
	private static final String STAT_SQL = "investView.queryStat";
	
    @Autowired
    private ILenderApplyService lenderApplyService;

    @Autowired
    private IMatchBizBaseDao matchBizBaseDao;

    @Override
    public InvestResult query(String lenderCode) {
        if (!Assert.checkParam(lenderCode)) {
            LOG.error("Apply id must not be null");
            return new InvestResult();
        }
        return dalClient.queryForObject("investView.query", MapUtils.getParamMap("lenderCode", lenderCode),
                InvestResult.class);
    }

    @Override
    public PaginationResult<List<InvestResult>> queryPool(InvestPoolParam param, Pagination page) {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            return new PaginationResult<List<InvestResult>>();
        }
        return dalClient.queryForList("investView.queryPool", MapUtils.obj2Map(param), InvestResult.class, page);
    }

    @Override
    public PaginationResult<List<InvestStatResult>> queryStat(InvestStatParam param, Pagination page) {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            return new PaginationResult<List<InvestStatResult>>();
        }
        return dalClient.queryForList(STAT_SQL, MapUtils.obj2Map(param), InvestStatResult.class, page);
    }

    @Override
    public void updateProduct(final Long poolId) throws UpdateException {
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                MatchBizBase base = matchBizBaseDao.query(poolId);
                Assert.notNull("Base must not be null", base);
                base.setBizProductId(Assert.equals(base.getBizProductId(), 11L) ? 12L : 11L);
                if (!matchBizBaseDao.update(base)) {
                    throw new UpdateException("Biz code[{0}] update error", base.getBizCode());
                }
                Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
                param.put("productId", base.getBizProductId());
                Assert.notNull("Update invest error", dalClient.execute("investView.updateProduct", param));
                lenderApplyService.syncProduct(base.getBizCode(), base.getBizProductId());
                return true;
            }
        });

    }

    @Override
    public PaginationResult<List<InvestUpdateResult>> queryProduct(InvestUpdateParam param, Pagination page) {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            return new PaginationResult<List<InvestUpdateResult>>();
        }
        return dalClient.queryForList("investView.queryProduct", MapUtils.obj2Map(param), InvestUpdateResult.class, page);
    }

	@Override
	public PaginationResult<List<InvestResult>> queryMatching(InvestPoolParam param, Pagination page) {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            return new PaginationResult<List<InvestResult>>();
        }
        return dalClient.queryForList("investView.queryMatching", MapUtils.obj2Map(param), InvestResult.class, page);
    }

}
