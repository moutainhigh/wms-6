/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchRuleGroupDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午9:59:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.rules;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.RuleCategory;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;
import com.google.gson.Gson;

@Service
public class MatchRuleGroupDaoImpl extends BaseDaoImpl<MatchRuleGroup> implements IMatchRuleGroupDao {

    private static final String BASE_KEY = "matchRule:";

    @Override
    public List<MatchRuleGroup> queryListByParam(ParamRuler queryDto) {
        LOG.info("queryListByParam() matchRuleQueryDto:{}", new Gson().toJson(queryDto));
        Assert.notNull("ruleKey or ruleCategory is null", queryDto.getRuleKey(), queryDto.getRuleCategory());
        String key = cacheService.initKey(BASE_KEY, queryDto.getRuleKey(), ":",
                RuleCategory.getEunm(queryDto.getRuleCategory()), ":",
                Assert.checkParam(queryDto.getGroupId()) ? queryDto.getGroupId() : "");
        List<MatchRuleGroup> results = cacheService.getArray(key, MatchRuleGroup.class);
        return Assert.checkParam(results) ? results : queryByDB(queryDto, key);

    }

    private List<MatchRuleGroup> queryByDB(ParamRuler queryDto, String key) {
        List<MatchRuleGroup> results = dalClient.queryForList("matchRuleGroup.queryArray", MapUtils.obj2Map(queryDto),
                MatchRuleGroup.class);
        cacheService.set(key, results);
        return results;
    }

    @Override
    public List<MatchRuleGroup> queryArray(String key) {
        Assert.notNull(new IllegalArgumentException("Key must not be null"), key);
        return null;
    }

    @Override
    public List<MatchRuleGroup> queryArray(String key, RuleCategory category) {
        Assert.notNull(new IllegalArgumentException("Key or category must not be null"), key, category);
        return null;
    }

    @Override
    public MatchRuleGroup query(String key) {
        Assert.notNull("Key must not be null", key);
        LOG.debug("Key is [{}]", key);
        String cacheKey = cacheService.initKey(BASE_KEY, key);
        LOG.debug("Cache key is [{}]", cacheKey);
        MatchRuleGroup group = cacheService.getObject(cacheKey, MatchRuleGroup.class);
        if (!Assert.checkParam(group)) {
            group = dalClient.queryForObject("matchRuleGroup.query", MapUtils.getParamMap("key", key),
                    MatchRuleGroup.class);
            cacheService.set(cacheKey, group);
        }
        return group;
    }
}
