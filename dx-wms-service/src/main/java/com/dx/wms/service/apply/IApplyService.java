/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: ILenderApplyService.java
 * Author:   蔡登勇
 * Date:     2015年7月27日 下午8:33:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply;

import java.util.List;

import com.dx.wms.dto.PushRecordDto;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.exception.UpdateException;
import com.dx.wms.service.process.ParamProcess;
import com.dx.wms.service.process.ResultProcess;

/**
 * 出借申请单服务
 *
 * @author 蔡登勇
 */
public interface IApplyService {

    /**
     * 
     * 功能描述: 根据流程实例ID查询对应的理财申请单
     *
     * @param ProcInsId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<LenderApply> getLenderApplyByProcInsId(List<String> procInsIds);

    /**
     * 
     * 功能描述: 根据parentId查询 原始申请单 〈功能详细描述〉
     *
     * @param parentId
     * @return
     */
    LenderApply getLenderApplyByParentId(Long parentId);

    /**
     * 
     * 功能描述: 查询某状态的 理财申请单 〈功能详细描述〉
     *
     * @param formStatus
     * @return
     */
    List<LenderApply> getLenderApplyByFormStatus(Long formStatus);

    /**
     * 
     * 功能描述: 查询所有续投的理财申请单 〈功能详细描述〉
     *
     * @return
     */
    List<LenderApply> getAllParentIdLenderApply();

    /**
     * 
     * 功能描述: 根据理财编号和原理财编号查询 理财申请单 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param parentId
     * @return
     */
    List<LenderApply> getLenderByIdAndParentId(Long lenderApplyId, Long parentId);

    PushRecordDto getPushRecordById(Long lenderApplyId);

    /**
     * 
     * 通过理财客户Id查询出借申请单列表
     *
     * @param custAccountId 理财客户Id
     * @return 出借申请单列表
     */
    List<LenderApply> queryByCustAccountId(Long custAccountId);

    /**
     * 
     * 通过理财客户Id查询出借申请单列表
     *
     * @param custAccountId 理财客户Id
     * @return 出借申请单列表
     */
    List<LenderApply> queryByCustAccount(Long custAccountId);

    /**
     * 
     * 功能描述:根据理财申请单 ID 修改 理财申请单状态 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param dataStatus
     * @return
     */
    void updateForStatus(Long lenderApplyId, String dataStatus) throws UpdateException;

    /**
     * 
     * 功能描述: 根据lenderApplyId查询 计算出到账日 〈功能详细描述〉
     *
     * @param parentId
     * @param settlementDate
     * @return
     */
    void update(Long lenderApplyId) throws UpdateException;

    /**
     * 
     * 功能描述: 根据理财申请编号 修改 理财申请规则编号 〈功能详细描述〉
     *
     * @param id
     * @param code
     * @return
     */
    void updateForCode(Long id, String code) throws UpdateException;

    /**
     * 
     * 功能描述: 根据理财申请ID修改申请单状态
     *
     * @param id
     * @param status
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateStatus(Long id, Long status) throws UpdateException;

    /**
     * 
     * 功能描述: 根据理财申请ID修改流程实例ID
     *
     * @param lenderApplyId
     * @param procId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateForProcess(Long lenderApplyId, String procId) throws UpdateException;

    List<ResultProcess> get(ParamProcess param);

    /**
     * 
     * 功能描述: 根据理财编号查询理财申请单 〈功能详细描述〉
     *
     * @param lenderCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApply queryByLenderCode(String lenderCode);

    /**
     * 
     * 功能描述: 修改单子的续投状态<br>
     * 〈功能详细描述〉
     *
     * @param applyId
     * @param dueStatus
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void destory(Long applyId, String dueStatus);

    /**
     * 
     * 功能描述: 根据理财申请id 修改状态 〈功能详细描述〉
     *
     * @param ids
     * @param formStatus
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateFormStatusByIds(List<Long> ids, Long formStatus);
    
    /**
     * 
     * 功能描述: 根据申请id查询出申请单
     * 〈功能详细描述〉
     *
     * @param ids
     * @return
     */
    List<LenderApply> queryApplyByIds(List<Long> ids);
}
