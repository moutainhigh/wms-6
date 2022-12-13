package com.dx.cmm.service.funds;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.invest.InvestAbs;
import com.dx.common.service.utils.Assert;

@Service("investFund")
public class InvestFund extends InvestAbs<InvestmentFund> implements Funds<InvestmentFund> {

    @Override
    public void save(InvestmentFund fund) throws SaveException {
        if (Assert.checkParam(fund.getInvestmentFundId())) {
            if (!investmentFundDao.update(fund)) {
                throw new SaveException("Update fund id[{0}] pool id[{1}] error", fund.getInvestmentFundId(),
                        fund.getInvestmentPoolId());
            }
            return;
        }
        investmentFundDao.save(fund);
    }

    @Override
    public List<InvestmentFund> queryArray(Long poolId) {
        return investmentFundDao.queryArray(poolId);
    }

    @Override
    public List<InvestmentFund> queryArray(String sqlId) {
        return investmentFundDao.queryArray(sqlId);
    }

    @Override
    public List<InvestmentFund> queryAll() {
        return investmentFundDao.queryAll(InvestmentFund.class);
    }

    @Override
    public InvestmentFund query(Long poolId, Integer period) {
        return investmentFundDao.query(poolId, period);
    }

    @Override
    public InvestmentFund query(Long poolId) {
        return investmentFundDao.query(poolId);
    }

    @Override
    public InvestmentFund query(Long poolId, Date reportDay) {
        return null;
    }

    @Override
    public Integer current(Long poolId) {
        InvestmentFund fund = query(poolId);
        return Assert.checkParam(fund) ? fund.getCurrentPeriod() : 0;
    }

    @Override
    public void exe(Long id) throws SaveException {
        if (!Assert.checkParam(id)) {
            throw new SaveException("Id must not be null");
        }
        InvestmentFund fund = investmentFundDao.queryById(InvestmentFund.class, id);
        if (!Assert.checkParam(fund)) {
            throw new SaveException("Fund[id] not found", id);
        }
        fund.exe();
        save(fund);
    }

}
