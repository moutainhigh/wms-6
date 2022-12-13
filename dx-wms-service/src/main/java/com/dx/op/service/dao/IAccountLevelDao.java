/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IAccountLevelDao.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午9:55:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.dao;

import java.math.BigDecimal;

import com.dx.op.service.entity.AccountLevel;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IAccountLevelDao extends IBaseDao<AccountLevel> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param name
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AccountLevel queryByParam(String name);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param name
     * @param rate
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AccountLevel queryByParam(String name, BigDecimal rate);
}
