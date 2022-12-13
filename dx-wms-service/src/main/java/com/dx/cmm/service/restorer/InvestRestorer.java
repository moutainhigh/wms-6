package com.dx.cmm.service.restorer;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.IInvestmentFundDao;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.IInvestmentPoolDao;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.IMatchResultDao;
import com.dx.cmm.service.results.MatchResult;
import com.dx.framework.dal.transaction.annotation.Transactional;

@Service("investRestorer")
public class InvestRestorer extends RestorerAbs<InvestmentPool> {

    @Autowired
    private IInvestmentFundDao investmentFundDao;

    @Autowired
    private IMatchResultDao matchResultDao;

    @Autowired
    private IInvestmentPoolDao investmentPoolDao;

    @Override
    @Transactional
    public void repair(InvestmentPool pool) throws RepairException {
        InvestmentFund fund = investmentFundDao.query(pool.getInvestmentPoolId());
        List<MatchResult> results = matchResultDao.queryArray(pool.getInvestmentPoolId(), InvestmentPool.class,
                fund.getCurrentPeriod());
        fund.setCurrentPeriod(pool.getCurrentPeriod());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(pool.getInitBillDate());
        calendar.add(Calendar.MONTH, fund.getCurrentPeriod() - 1);
        fund.setReportDay(calendar.getTime());
        for (MatchResult result : results) {
            result.setCurrentPeriod(pool.getCurrentPeriod());
            result.setReportDate(calendar.getTime());
            if (!matchResultDao.update(result)) {
                throw new RepairException("Pool id[{}],result id[{}] update error", pool.getInvestmentPoolId(),
                        result.getMatchResultId());
            }
        }
        if (!investmentFundDao.update(fund)) {
            throw new RepairException("Pool id[{}],fund id[{}] update error", pool.getInvestmentPoolId(),
                    fund.getInvestmentFundId());
        }

        if (!investmentPoolDao.update(pool)) {
            throw new RepairException("Pool id[{}] update error", pool.getInvestmentPoolId());
        }
    }

}
