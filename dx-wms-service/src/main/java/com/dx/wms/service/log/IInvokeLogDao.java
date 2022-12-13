package com.dx.wms.service.log;

import com.dx.wms.common.IBaseDao;

public interface IInvokeLogDao extends IBaseDao<InvokeLog> {
    
    /**
     * 
     * 功能描述: 根据调用日志流水号 查询日志
     * 〈功能详细描述〉
     *
     * @param InvokeLogCode 调用日志Code
     * @return
     */
    InvokeLog queryByInvokeLogCode(String invokeLogCode);
    
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
    InvokeLog queryAllByLenderApplyId(long lenderApplyId);
    
    /**
     * 
     * 功能描述: 根据调用CODE 修改调用数据状态
     * 〈功能详细描述〉
     *
     * @param invokeLogCode 调用日志CODE
     * @param dataStatus 调用日志状态
     * @return
     */
    int setInvokeLogStatusByCode(String invokeLogCode , String dataStatus);
    
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
