package com.dx.cmm.service.funds;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.credit.CreditAbs;
import com.dx.common.service.utils.Assert;

@Service("creditFund")
public class CreditFund extends CreditAbs<CreditorFund> implements Funds<CreditorFund> {

    @Override
    public void save(CreditorFund fund) throws SaveException {
        creditorFundDao.save(fund);
    }

    @Override
    public List<CreditorFund> queryArray(Long poolId) {
        return creditorFundDao.queryArray(poolId);
    }

    @Override
    public List<CreditorFund> queryArray(String sqlId) {
        return null;
    }

    @Override
    public List<CreditorFund> queryAll() {
        return creditorFundDao.queryAll(CreditorFund.class);
    }

    @Override
    public CreditorFund query(Long poolId, Integer period) {
        return creditorFundDao.query(poolId, period);
    }

    @Override
    public CreditorFund query(Long poolId) {
        return creditorFundDao.query(poolId);
    }

    @Override
    public CreditorFund query(Long poolId, Date reportDay) {
        return creditorFundDao.query(poolId, reportDay);
    }

    @Override
    public Integer current(Long poolId) {
        CreditorFund fund = query(poolId);
        return Assert.checkParam(fund) && Assert.checkParam(fund.getCurrentPeriod()) ? fund.getCurrentPeriod() : 0;
    }

    @Override
    public void exe(Long id) throws SaveException {
        // TODO Auto-generated method stub
        
    }

}
