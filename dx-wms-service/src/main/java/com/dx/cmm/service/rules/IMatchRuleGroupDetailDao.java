/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IMatchRuleGroupDetail.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午9:48:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.rules;

import java.util.List;

import com.dx.wms.common.IBaseDao;

/**
 * 债权匹配管理-匹配规则分组明细对象 dao层 接口 
 *
 * @author 朱道灵
 */
public interface IMatchRuleGroupDetailDao extends IBaseDao<MatchRuleGroupDetail>{
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param groupId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MatchRuleGroupDetail> queryByGroupId(Long groupId);
}
