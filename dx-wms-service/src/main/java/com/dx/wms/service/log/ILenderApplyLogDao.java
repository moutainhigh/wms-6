/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: ILenderApplyLogDao.java
 * Author:   michelle
 * Date:     2015年8月1日 下午5:08:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.log;

import java.util.List;

import com.dx.wms.common.IBaseDao;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author michelle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ILenderApplyLogDao extends IBaseDao<LenderApplyLog> {

    /**
     * 
     * 功能描述: <br>
     * 根据申请编号获取最新日志
     *
     * @param applyId
     * @return
     */
    LenderApplyLog queryByParam(Long applyId);

    /**
     * 功能描述: <br>
     * 根据申请编号和环节获取日志
     *
     * @param applyId
     * @param step
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApplyLog queryByParam(Long applyId, String step);

    /**
     * 
     * 功能描述: <br>
     * 根据到账日是否存在查询日志
     *
     * @param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<LenderApplyLog> queryListByParam(Boolean hasAccount);

    /**
     * 
     * 功能描述: <br>
     * 根据申请编号获取日志
     *
     * @param applyId
     * @return
     */
    List<LenderApplyLog> queryByApply(Long applyId);

    List<LenderApplyLog> queryByApply(Long applyId, String step);
}
