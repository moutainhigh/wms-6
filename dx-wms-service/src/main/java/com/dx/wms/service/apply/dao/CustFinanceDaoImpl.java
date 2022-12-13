/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustFinanceDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午9:19:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;
import com.dx.wms.service.apply.entity.CustFinance;

/**
 * 客户金融表 dao层 接口实现
 *
 * @author 朱道灵
 */
@Component
public class CustFinanceDaoImpl extends BaseDaoImpl<CustFinance> implements ICustFinanceDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustFinanceDaoImpl.class);

    @Override
    public CustFinance queryByParam(Long custAccountId) {
        Assert.notNull("**queryByCustAccountId() custAccountId can not be null**", custAccountId);
        LOG.info("**queryByCustAccountId() custAccountId={}**", custAccountId);
        return dalClient.queryForObject("custFinance.queryByCustAccountId",
                MapUtils.getParamMap("custAccountId", custAccountId), CustFinance.class);
    }

    @Override
    public CustFinance queryByParam(Long accountId, Integer category) {
        Assert.notNull("Account id or category must not be null**", accountId, category);
        LOG.info("Account id is[{}],category is [{}]", accountId, category);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("custAccountId", accountId);
        param.put("accountCategory", category);
        return dalClient.queryForObject("custFinance.queryByCustAccountId", param, CustFinance.class);
    }

    @Override
    public List<CustFinance> queryByAccount(Long accountId) {
        Assert.notNull("Account id must not be null**", accountId);
        LOG.info("Account id is[{}]", accountId);
        return dalClient.queryForList("custFinance.getCustFinancesByCustAccountId",
                MapUtils.getParamMap("custAccountId", accountId), CustFinance.class);
    }

    @Override
    public List<CustFinance> queryByApply(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id[{}]", applyId);
        return dalClient.queryForList("custFinance.queryByApply", MapUtils.getParamMap("applyId", applyId),
                CustFinance.class);
    }

    @Override
    public Boolean updateAccountNameByAccountId(Long userId, Long custAccountId, String accountName) {
        Assert.notNull("**updateAccountNameByAccountId() userId can be not null**", userId);
        Assert.notNull("**updateAccountNameByAccountId() custAccountId can be not null**", custAccountId);
        Assert.notNull("**updateAccountNameByAccountId() accountName can be not null**", accountName);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("custAccountId", custAccountId);
        paramMap.put("accountName", accountName);
        paramMap.put("updateUser", userId);
        Integer updateNum = dalClient.execute("custFinance.updateAccountNameByCustAccountId", paramMap);
        return Assert.checkParam(updateNum) ? Boolean.TRUE : Boolean.FALSE;
    }
}
