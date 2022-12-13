/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ILenderApplyLogService.java
 * Author:   黄健
 * Date:     2015年7月31日 下午9:09:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.log;

import java.util.List;

/**
 * 出借申请日志 service接口
 *
 * @author huangjian
 */
public interface ILenderApplyLogService {

    /**
     * 根据出借主键来查询该条出借记录的所有日志
     *
     * @param applyId 出借主键
     * @return 该条出借记录的所有日志
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<LogResultDto> queryByParam(Long applyId);

    /**
     * 查询某单理财申请 最早的质检记录
     *
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApplyLog queryQualityRecordById(Long lenderApplyId);

    /**
     * 
     * 功能描述: 根据客户经理查询下一步销售客服的ID 〈功能详细描述〉
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Long getToUserId(Long userId, String toRole);

    /**
     * 
     * 功能描述: 根据理财申请编号和当前环节 查询出最新的该状态的日志 〈功能详细描述〉
     *
     * @param applyId
     * @param step
     * @return
     */
    LenderApplyLog queryByParam(Long applyId, String step);

    /**
     * 查询所有日志的创建时间
     *
     * @return List<LenderApplyLogDto>
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<ApplyLog> queryCreateTime();

}
