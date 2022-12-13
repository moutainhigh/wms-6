package com.dx.cmm.service.funds;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class CreditorFundDaoImpl extends BaseDaoImpl<CreditorFund> implements ICreditorFundDao {

    @Override
    @Transactional
    public void save(CreditorFund fund) throws SaveException {
        Assert.notNull(new SaveException("no find fund", fund), fund);
        if (!update(query(fund.getCreditorPoolId()), false)) {
            throw new SaveException("fund credit id:{0} update error", fund.getCreditorPoolId());
        }
        Assert.notNull(new SaveException("fund credit id:{0} insert error", fund.getCreditorPoolId()), insert(fund));
    }

    @Override
    public CreditorFund query(Long poolId) {
        if (!Assert.checkParam(poolId)) {
            return new CreditorFund();
        }
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("isCurrent", Fund.IS_CURRENT);
        return dalClient.queryForObject("creditorFund.queryByParam", param, CreditorFund.class);
    }

    @Override
    public Boolean update(CreditorFund fund, Boolean isCurrent) {
        if (!Assert.checkParam(fund)) {
            return true;
        }
        fund.setIsCurrent(isCurrent ? Fund.IS_CURRENT : Fund.NO_CURRENT);
        return update(fund);
    }

    @Override
    public List<CreditorFund> queryArray(Long poolId) {
        return dalClient.queryForList("creditorFund.queryByPoolId", MapUtils.getParamMap("poolId", poolId),
                CreditorFund.class);
    }

    @Override
    public CreditorFund query(Long poolId, Integer currentPeriod) {
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("currentPeriod", currentPeriod);
        return dalClient.queryForObject("creditorFund.queryByParam", param, CreditorFund.class);
    }

    @Override
    public CreditorFund query(Long poolId, Date reportDay) {
        Map<String, Object> param = MapUtils.getParamMap("poolId", poolId);
        param.put("reportDay", reportDay);
        return dalClient.queryForObject("creditorFund.queryByParam", param, CreditorFund.class);
    }

}
