/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchRuleDetailDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午9:56:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class MatchRuleDetailDaoImpl extends BaseDaoImpl<MatchRuleDetail> implements IMatchRuleDetailDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(MatchRuleDetailDaoImpl.class);

    private static final String MATCH_RULE_DETAIL_KEY = "CMM:MatchRule:queryDetailById:";

    @Autowired
    private ICacheService<MatchRuleDetail> cacheService;

    @Override
    public MatchRuleDetail queryById(Long id) {
        LOG.info("queryById() id:{}", id);
        String key = cacheService.initKey(MATCH_RULE_DETAIL_KEY, id);
        MatchRuleDetail result = cacheService.getObject(key, MatchRuleDetail.class);
        return Assert.checkParam(result) ? result : queryByDB(id, key);
    }

    private MatchRuleDetail queryByDB(Long id, String key) {
        MatchRuleDetail result = super.queryById(MatchRuleDetail.class, id);
        cacheService.set(key, result);
        return result;
    }
}
