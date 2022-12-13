/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyDao.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午6:58:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dao;

import java.util.Date;
import java.util.List;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.dto.PushRecordDto;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.exception.SaveException;
import com.dx.wms.service.exception.UpdateException;

/**
 * 出借申请表Dao
 *
 * @author 朱道灵
 */
public interface ILenderApplyDao extends IBaseDao<LenderApply> {

    /**
     * 
     * 功能描述: 根据parentId查询 原始申请单
     *
     * @param parentId
     * @return
     */
    LenderApply queryByParent(Long parentId);

    /**
     * 
     * 通过理财客户Id查询出借申请单列表
     *
     * @param accountId 理财客户Id
     * @return 出借申请单列表
     */
    List<LenderApply> queryByCustAccountId(Long accountId);
    
    /**
     * 
     * 通过理财客户Id查询出借申请单列表
     *
     * @param accountId 理财客户Id
     * @return 出借申请单列表
     */
    List<LenderApply> queryByCustAccount(Long accountId);

    /**
     * 
     * 通过理财客户编号查询出借申请单列表
     *
     * @param lenderCustCode 财客户编号
     * @return 出借申请单列表
     */
    List<LenderApply> queryByLenderCustCode(String lenderCustCode);

    /**
     * 
     * 功能描述: 查询债权确认环境 需要推送给财务系统的数据
     *
     * @param lenderApplyId
     * @return
     * 
     */
    PushRecordDto queryPushRecord(Long lenderApplyId);

    /**
     * 
     * 功能描述: 根据流程实例ID查询对应的理财申请单
     *
     * @param procInsIds
     * @return
     */
    List<LenderApply> queryByProcess(List<String> procInsIds);

    /**
     * 
     * 功能描述: 查询某状态的 理财申请单 〈功能详细描述〉
     *
     * @param formStatus
     * @return
     */
    List<LenderApply> queryByStatus(Long formStatus);

    /**
     * 
     * 功能描述: 查询某状态的 理财申请单
     *
     * @param formStatus
     * @return
     */
    List<LenderApply> queryByStatus(List<Long> formStatus, LenderApply lenderApply);

    /**
     * 
     * 功能描述: 查询所有续投的理财申请单
     *
     * @return
     */
    List<LenderApply> queryContinue();

    /**
     * 
     * 功能描述: 根据理财编号和原理财编号查询 理财申请单
     *
     * @param lenderApplyId
     * @param parentId
     * @return
     */
    List<LenderApply> getLenderByIdAndParentId(Long lenderApplyId, Long parentId);

    /**
     * 
     * 更新出借编号
     *
     * @param id
     * @param code
     * 
     */
    void updateForCode(Long id, String code) throws UpdateException;

    /**
     * 
     * 更新账单日
     *
     * @param id
     * @param stateDate
     * @param matchDate
     */
    void updateForState(Long id, Integer stateDate, Date matchDate) throws UpdateException;

    /**
     * 
     * 更新申请单状态
     *
     * @param id
     * @param status
     */
    void updateForStatus(Long id, Long status) throws UpdateException;

    /**
     * 
     * 更新流程实例
     *
     * @param id
     * @param procId
     */
    void updateForProcess(Long id, String procId) throws UpdateException;

    /**
     * 
     * 更新数据状态
     *
     * @param id
     * @param status
     */
    void updateForStatus(Long id, String status) throws UpdateException;

    /**
     * 
     * 更新到账日
     *
     * @param id
     * @param settleDate
     */
    void updateForSettle(Long id, Date settleDate) throws UpdateException;

    /**
     * 
     * 保存
     *
     * @param entity
     * @return
     * @throws SaveException
     */
    LenderApply save(LenderApply entity) throws SaveException;
    
    /**
     * 
     * 功能描述: 根据理财编号查询理财申请单
     * 〈功能详细描述〉
     *
     * @param lenderCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApply getLenderApplyByCode(String lenderCode);


    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param dueStatus
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateDueApplyStatus(Long lenderApplyId, String dueStatus);

    /**
     * 
     * 功能描述: 根据理财申请id 修改状态
     * 〈功能详细描述〉
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
