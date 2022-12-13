package com.dx.wms.service;

import java.util.List;
import java.util.Map;

import com.dx.cms.dto.Condition;
import com.dx.wms.dto.LenderPushDataDto;
import com.dx.wms.service.process.ParamProcess;
import com.dx.wms.service.push.LenderPushException;

public interface IWorkFlowService {
    /**
     * 
     * 功能描述: 提交质检 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param userId
     * @param conditionsDto
     * @return
     */
    Boolean submitToSalesService(Long lenderApplyId, Long userId, Condition conditionsDto);

    /**
     * 
     * 功能描述: 提交质检或者投资审核
     *
     * @param businessQualityDto
     * @param userId
     * @return
     */
    Boolean flow(ParamProcess queryDto, Long userId);

    /**
     * 
     * 功能描述: 查询用户受理的全部任务的实例ID 〈功能详细描述〉
     *
     * @param userId
     * @param taskKey
     * @return
     */
    List<String> getProIns(Long userId, String taskKey);

    /**
     * 
     * 功能描述: 确认推送数据给扣款 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param userId
     * @return
     */
    void confirmPush(LenderPushDataDto lenderPushDataDto, Long userId) throws LenderPushException;

    /**
     * 
     * 功能描述: 重新匹配 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param userId
     * @return
     */
    Map<String, Object> reMatch(LenderPushDataDto lenderPushDataDto, Long userId);

    /**
     * 
     * 功能描述: 客户放弃 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param userId
     * @return
     */
    void giveUp(String lenderCode, Long userId);

}
