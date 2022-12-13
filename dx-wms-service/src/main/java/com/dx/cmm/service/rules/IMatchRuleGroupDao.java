/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IMatchGroupDao.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午9:46:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.rules;

import java.util.List;

import com.dx.cmm.enums.RuleCategory;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 匹配规则分组Dao
 *
 * @author tony
 */
public interface IMatchRuleGroupDao extends IBaseDao<MatchRuleGroup> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param queryDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MatchRuleGroup> queryListByParam(ParamRuler queryDto);

    /**
     * 
     * 功能描述: <br>
     * 根据规则表示筛选
     *
     * @param key
     * @return
     */
    MatchRuleGroup query(String key);

    /**
     * 
     * 功能描述: <br>
     * 根据规则表示筛选
     *
     * @param key
     * @return
     */
    List<MatchRuleGroup> queryArray(String key);

    /**
     * 
     * 功能描述: <br>
     * 根据规则标示及类型筛选
     *
     * @param key
     * @param category
     * @return
     */
    List<MatchRuleGroup> queryArray(String key, RuleCategory category);
}
