/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ILenderConditionDao.java
 * Author:   朱道灵
 * Date:     2015年8月12日 下午9:56:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dao;

import java.util.List;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.service.apply.entity.LenderCondition;

/**
 * 
 * 特殊情况Dao
 *
 * @author tony
 */
public interface ILenderConditionDao extends IBaseDao<LenderCondition> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param applyId
     * @return
     */
    List<LenderCondition> queryByParam(Long applyId);

    void del(Long id);

    void del(Long id, Integer category);

    void update(Long id, Integer category, String status);
}
