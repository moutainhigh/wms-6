/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IMathSignTypeDao.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午5:22:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.math.service.dao;

import com.dx.math.service.entity.MathSignType;
import com.dx.wms.common.IBaseDao;

/**
 * 债权匹配管理-符号类型对象 dao层 接口
 *
 * @author 朱道灵
 */
public interface IMathSignTypeDao extends IBaseDao<MathSignType> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param signKey
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    MathSignType getBySignKey(String signKey);
}
