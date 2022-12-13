package com.dx.wms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.base.impl.BaseDaoImpl;
import com.dx.wms.bean.LenderApplyLog;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.IlenderLogDao;
import com.dx.wms.service.exception.UpdateException;

@Component
public class LenderLogDaoImpl extends BaseDaoImpl<LenderApplyLog> implements IlenderLogDao {

    /**
     * 日志组件
     */
    protected static final Logger LOG = LoggerFactory.getLogger(LenderLogDaoImpl.class);

    @Autowired
    protected PaginationDalClient dalClient;

    @Override
    public LenderApplyLog queryByParam(Long applyId, String step) {
        Assert.notNull("Apply id or step must not be null", applyId, step);
        LOG.info("Apply id is[{}],step is [{}]", applyId, step);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("applyId", applyId);
        paramMap.put("step", step);
        return dalClient.queryForObject("lenderLog.queryByStepAndApply", paramMap, LenderApplyLog.class);
    }

    @Override
    public LenderApplyLog queryByStep(Long applyId, String step) {
        Assert.notNull("Apply id or step must not be null", applyId, step);
        LOG.info("Apply id is[{}],step is [{}]", applyId, step);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("applyId", applyId);
        paramMap.put("step", step);
        return dalClient.queryForObject("lenderLog.queryByStep", paramMap, LenderApplyLog.class);
    }

    @Override
    public LenderApplyLog queryCurrent(Long applyId) {
        return dalClient.queryForObject("lenderLog.queryCurrent", MapUtils.getParamMap("applyId", applyId),
                LenderApplyLog.class);
    }

    @Override
    public LenderApplyLog queryCurrent(Long applyId, String step) {
        LOG.info("Current step key[{}],lender apply id[{}]", step, applyId);
        if (WMSConstants.INVESTMENT_FAIL.equals(step)) {
            return queryCurrent(applyId);
        }
        return queryByStep(applyId, step);
    }

    @Override
    public void save(LenderApplyLog current, LenderApplyLog next) throws UpdateException {
        LOG.info("Save current[{}],add[{}] ", current, next);
        if (Assert.checkParam(current)) {
            if (!update(current)) {
                throw new UpdateException("Current[{0}] update error", current.getLenderApplyId());
            }
        }
        if (Assert.checkParam(next)) {
            Assert.notNull(new UpdateException("Add[{0}] insert error", next.getLenderApplyId()), insert(next));
        }

    }

    @Override
    public LenderApplyLog queryLast(Long applyId) {
        return dalClient.queryForObject("lenderLog.queryLast", MapUtils.getParamMap("applyId", applyId),
                LenderApplyLog.class);
    }

    @Override
    public List<LenderApplyLog> query(Long accountId) {
        Assert.notNull("Account id must not be null", accountId);
        return dalClient.queryForList("lenderLog.queryAccount", MapUtils.getParamMap("accountId", accountId),
                LenderApplyLog.class);
    }
}
