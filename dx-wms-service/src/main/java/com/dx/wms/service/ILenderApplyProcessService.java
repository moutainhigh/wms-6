/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ILenderApplyProcessService.java
 * Author:   黄健
 * Date:     2015年9月17日 下午1:17:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service;

import java.util.Map;


/**
 * 理财申请  处理环节 接口
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ILenderApplyProcessService {

    /**
     * 理财申请 获取下一环节信息
     *
     * @param userId
     * @param currentStepKey    当前环节标示
     * @param currentAction     当前环节操作
     * @param lenderApplyId     理财申请主键
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> getNextStep(Long userId, String currentStepKey, Integer currentAction ,Long lenderApplyId);
    
    
}
