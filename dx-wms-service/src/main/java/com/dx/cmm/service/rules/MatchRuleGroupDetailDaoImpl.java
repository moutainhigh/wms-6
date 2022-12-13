/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchRuleGroupDetailDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午10:01:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.rules;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

/**
 * 债权匹配管理-匹配规则分组明细对象 dao层 接口 实现
 *
 * @author 朱道灵
 */
@Service
public class MatchRuleGroupDetailDaoImpl extends BaseDaoImpl<MatchRuleGroupDetail> implements IMatchRuleGroupDetailDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(MatchRuleGroupDetailDaoImpl.class);

    private static final String MATCH_RULE_GROUP_DETAIL_LIST_KEY = "CMM:MatchRule:queryListByGroupId:";
    @Autowired
    private ICacheService<MatchRuleGroupDetail> cacheService;

    @Override
    public List<MatchRuleGroupDetail> queryByGroupId(Long groupId) {
        LOG.info("queryListByGroupId() groupId:{}", groupId);
        Assert.notNull("groupId is null", groupId);
        String key = cacheService.initKey(MATCH_RULE_GROUP_DETAIL_LIST_KEY, groupId);
        List<MatchRuleGroupDetail> results = cacheService.getArray(key, MatchRuleGroupDetail.class);
        return Assert.checkParam(results) ? results : queryByDB(groupId, key);
    }

    private List<MatchRuleGroupDetail> queryByDB(Long groupId, String key) {
        List<MatchRuleGroupDetail> results = dalClient.queryForList("matchRuleGroupDetail.queryListByGroupId",
                MapUtils.getParamMap("groupId", groupId), MatchRuleGroupDetail.class);
        cacheService.set(key, results);
        return results;
    }
}
