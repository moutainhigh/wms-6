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
package com.dx.wms.service;

import com.dx.wms.service.exception.LenderLogException;

/**
 * 
 * 出借日志服务
 *
 * @author tony
 */
public interface ILenderLogService {

    /**
     * 投资失效
     *
     * @param userId 当前用户
     * @param lenderApplyId 业务主键
     * @param approveComment 审核备注
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void destory(Long userId, Long lenderApplyId, String approveComment, String endApproveComment)
            throws LenderLogException;

    /**
     * 业务流程审核结果 日志记录 质检，投资审核，匹配，债权确认，出资 日志记录
     *
     * @param currentStepKey 当前环节
     * @param userId 当前用户
     * @param applyId 业务主键
     * @param approveComment 审核备注
     * @param currentAction 审核结果
     * @return
     */
    void add(String currentStepKey, Long userId, Long applyId, String approveComment,
            Integer currentAction) throws LenderLogException;
}
