package com.dx.wms.service.log;

/**
 * 
 * 〈一句话功能简述〉调用日志记录服务
 * 〈功能详细描述〉
 *
 * @author 王蕊 
 */
public interface IInvokeLogService {
    
    /**
     * 
     * 功能描述: 根据申请编号 取最新的调用日志
     * 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @return
     */
    InvokeLog getInvokeLogByLenderId(Long lenderApplyId);
    /**
     * 
     * 功能描述: 根据理财申请编号ID查询 调用日志
     * 〈功能详细描述〉
     *
     * @param lenderApplyId 理财申请编号
     * @return
     */
    InvokeLog queryByLenderApplyId(long lenderApplyId);
    /**
     * 
     * 功能描述: 根据理财申请编号ID查询 调用日志
     * 〈功能详细描述〉
     *
     * @param lenderApplyId 理财申请编号
     * @return
     */
    InvokeLog queryFailByLenderApplyId(long lenderApplyId);

}
