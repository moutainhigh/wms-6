package com.dx.wms.service;

import java.util.List;

import com.dx.fms.service.dto.DealRecordDTO;
import com.dx.wms.dto.DealDetailDto;
import com.dx.wms.dto.LenderPushDataDto;
import com.dx.wms.service.push.LenderPushException;

/**
 * 
 * 〈一句话功能简述〉推送数据服务 〈功能详细描述〉
 *
 * @author 王蕊
 */
public interface IPushDataService {
    /**
     * 
     * 功能描述:根据理财申请编号 查询需要推送的数据 推送给财务系统 〈功能详细描述〉
     *
     * @param LenderApplyId
     * @return
     */
    void pushFinance(Long userId, LenderPushDataDto push) throws LenderPushException;

    /**
     * 
     * 功能描述: 根据理财申请编号 查询数据 〈功能详细描述〉
     *
     * @param lenderApplyId 理财申请编号
     * @param userId
     * @return
     */
    List<DealDetailDto> getDealDetailDtoList(Long lenderApplyId, Long userId);

    /**
     * 
     * 功能描述: 查询需要推送给理财的数据 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param invokeLogCode
     * @param userId
     * @param fileIds
     * @return
     */
    DealRecordDTO getPushRecordById(Long lenderApplyId, Long userId, Integer bizType);

    /**
     * 
     * 功能描述: 推送财务系统 客户信息 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @param userId
     * @return
     */
    Boolean pushDealDataByLenderApplyId(Long lenderApplyId, Long userId);
}
