/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountLevelDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午9:56:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.dao.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.op.service.dao.IAccountLevelDao;
import com.dx.op.service.entity.AccountLevel;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class AccountLevelDaoImpl extends BaseDaoImpl<AccountLevel> implements IAccountLevelDao {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(AccountLevelDaoImpl.class);

    private static final String LEVEL_KEY = "accountLevel:";
    @Autowired
    private ICacheService<AccountLevel> cacheService;

    @Override
    public AccountLevel queryByParam(String name) {
        Assert.notNull("account name is null", name);
        String key = cacheService.initKey(LEVEL_KEY, name);
        AccountLevel level = cacheService.getObject(key, AccountLevel.class);
        return Assert.checkParam(level) ? level : queryForDB(name, key);

    }

    private AccountLevel queryForDB(String name, String key) {
        AccountLevel level = queryByDB(MapUtils.getParamMap("name", name));
        cacheService.set(key, level);
        return level;
    }

    @Override
    public AccountLevel queryByParam(String name, BigDecimal rate) {
        Assert.notNull("param is null", name, rate);
        String key = cacheService.initKey(LEVEL_KEY, name);
        AccountLevel level = cacheService.getObject(key, AccountLevel.class);
        return Assert.checkParam(level) ? level : queryForDB(name, rate, key);

    }

    private AccountLevel queryForDB(String name, BigDecimal rate, String key) {
        Map<String, Object> param = MapUtils.getParamMap("name", name);
        param.put("rate", rate);
        AccountLevel level = queryByDB(param);
        cacheService.set(key, level);
        return level;
    }

    private AccountLevel queryByDB(Map<String, Object> param) {
        LOG.info("queryByDB() param:{}", param);
        return dalClient.queryForObject("accountLevel.queryByDB", param, AccountLevel.class);
    }

}
