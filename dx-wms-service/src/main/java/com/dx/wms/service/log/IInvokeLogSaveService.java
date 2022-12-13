/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: IInvokeLogService.java
 * Author:   yangbao
 * Date:     2016年1月7日 上午12:28:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.log;

/**
 * 〈一句话功能简述〉保存调用日志
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IInvokeLogSaveService {
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param lenderApplyId 理财申请ID
     * @param invokeLogCode 流水号
     * @param userId 操作人
     * @return InvokeLog
     */
    InvokeLog save(Long lenderApplyId, String lenderCode, Long userId, Integer invokeResult);

}
