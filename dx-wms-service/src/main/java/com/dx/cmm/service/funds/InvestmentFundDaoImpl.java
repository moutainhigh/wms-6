package com.dx.cmm.service.funds;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class InvestmentFundDaoImpl extends BaseDaoImpl<InvestmentFund> implements IInvestmentFundDao {

    @Override
    public InvestmentFund query(Long poolId) {
        Assert.notNull("Pool id must not be null", poolId);
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("isCurrent", Fund.IS_CURRENT);
        return dalClient.queryForObject("investmentFund.queryByParam", param, InvestmentFund.class);
    }

    @Override
    public Boolean save(InvestmentFund fund) {
        Assert.notNull("Fund must not be null", fund);
        if (!update(query(fund.getInvestmentPoolId()), false)) {
            return false;
        }
        return Assert.checkParam(insert(fund));
    }

    @Override
    public Boolean update(InvestmentFund fund, Boolean isCurrent) {
        if (!Assert.checkParam(fund)) {
            return true;
        }
        fund.setIsCurrent(isCurrent ? Fund.IS_CURRENT : Fund.NO_CURRENT);
        return super.update(fund);
    }

    @Override
    public List<InvestmentFund> queryArray(String sqlId) {
        return dalClient.queryForList(sqlId, null, InvestmentFund.class);
    }

    @Override
    public InvestmentFund query(Long poolId, Integer period) {
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("currentPeriod", period);
        return dalClient.queryForObject("investmentFund.queryByParam", param, InvestmentFund.class);
    }

    @Override
    public List<InvestmentFund> queryArray(Long poolId) {
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        return dalClient.queryForList("investmentFund.queryByParam", param, InvestmentFund.class);
    }

}
