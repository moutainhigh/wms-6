package com.dx.wms.dao;

import java.util.Date;
import java.util.Map;

import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.log.InvokeLog;

public interface LenderManagermentDao {
    /**
     * 业务流程审核结果 日志记录 质检，投资审核，匹配，债权确认，出资 日志记录
     *
     * @param currentStepKey 当前环节
     * @param userId 当前用户
     * @param lenderApplyId 业务主键
     * @param approveComment 审核备注
     * @param currentAction 审核结果
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> addLenderApplyProcessLog(String currentStepKey, Long userId, Long lenderApplyId,
            String approveComment, Integer currentAction);

    /**
     * 
     * 功能描述: 根据调用日志流水号 查询日志 〈功能详细描述〉
     *
     * @param InvokeLogCode 调用日志Code
     * @return
     */
    InvokeLog queryByInvokeLogCode(String invokeLogCode);

    /**
     * 
     * 功能描述: 根据调理财申请编号 查询日志 〈功能详细描述〉
     *
     * @param InvokeLogCode 调用日志Code
     * @return
     */
    InvokeLog queryByLenderApplyId(Long lenderApplyId);

    /**
     * 
     * 功能描述: 根据调用CODE 修改调用数据状态 〈功能详细描述〉
     *
     * @param lenderCode 理财申请CODE
     * @param dataStatus 调用日志状态
     * @return
     */
    int setInvokeLogStatusByCode(String lenderCode, String dataStatus);

    /**
     * 
     * 功能描述: 根据理财编号修改到账日期 〈功能详细描述〉
     *
     * @return
     */
    int setSettlementDateById(Long lenderApplyId, Date settlementDate, Long updateUser);

    /**
     * 
     * 功能描述: 根据理财申请ID查询到 对应的客户基础表和客户开户表，修改状态为认证状态，使此时数据不再能修改
     *
     * @param lenderApplyId
     * @return
     */
    void updateStatus(Long lenderApplyId);

    /**
     * 
     * 功能描述: 修改到账日时 同时修改 等待投资确认日志的updateUser 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param updateUser
     * @return
     */
    int updateLenderLogUpdateUser(Long lenderApplyId, Long updateUser);

    /**
     * 
     * 功能描述: 根据理财编号修改 理财申请单的状态以及到期日 〈功能详细描述〉
     *
     * @param lenderCode 理财编号
     * @param dueDate 到期日
     * @return
     */
    int updateLendersDueDate(String lenderCode, Date dueDate);
    
    /**
     * 
     * 功能描述: 根据理财申请ID修改申请单状态
     *
     * @param lenderApplyId
     * @param formStatus
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean updateLenderApplyFormStatus(Long lenderApplyId,Long formStatus);
    
    /**
     * 
     * 功能描述: 根据理财申请ID查询理财申请表
     *
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApply getLenderApplyById(Long lenderApplyId);
    
    /**
     * 
     * 功能描述:根据理财申请单 ID 修改 理财申请单状态
     * 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param dataStatus
     * @return
     */
    int updateLenderApplyDataStatus(Long lenderApplyId,String dataStatus);
}
