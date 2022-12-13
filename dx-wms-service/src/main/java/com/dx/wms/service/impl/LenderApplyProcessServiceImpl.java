/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyProcessServiceImpl.java
 * Author:   黄健
 * Date:     2015年9月17日 下午1:24:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.CurrentStepKey;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.ILenderApplyProcessService;
import com.dx.wms.service.log.LenderApplyLog;

/**
 * 理财申请 处理环节 接口实现类
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class LenderApplyProcessServiceImpl implements ILenderApplyProcessService {

    @Autowired
    private PaginationDalClient dalClient;


    /**
     * 通用接口服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderApplyProcessServiceImpl.class);

    @Override
    public Map<String, Object> getNextStep(Long userId, String currentStepKey, Integer currentAction, Long lenderApplyId) {
        LOG.info("** getCurrentStepAndUser() currentStepKey:{},currentAction:{},lenderApplyId:{}", currentStepKey,
                currentAction, lenderApplyId);
        Assert.notNull("** getCurrentStepAndUser() currentStepKey,currentAction,lenderApplyId", currentStepKey,
                currentAction, lenderApplyId);
        switch (currentStepKey) {
            case WMSConstants.DRAFT:
                return executeDraft(userId);
            case WMSConstants.QUALITY_CHECK:
                return executeQuality(currentAction, lenderApplyId, userId);
            case WMSConstants.INVESTMENT_CHECK:
                return executeInvestment(currentAction, lenderApplyId);
            case WMSConstants.RESUBMIT:
                return executeResubmit(userId);
            case WMSConstants.MATCH:
                return executeMatch();
            case WMSConstants.CREDITOR_CONFIRM:
                return execute(currentAction);
            case WMSConstants.CONTRIBUTIVE_CONFIRM:
                return executeContributiveConfirm(currentAction, lenderApplyId);
            case WMSConstants.INVESTMENT_CONFIRM:
                return executeInvestmentConfirm();
            case WMSConstants.INVESTMENT_FAIL:
                return executeFail(userId);
            default:
                return new HashMap<String, Object>();
        }
    }

    /**
     * 草稿
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeDraft(Long userId) {
        return dealInfo(WMSConstants.QUALITY_CHECK, userId, null);
    }

    /**
     * 理财申请重新提交
     *
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeResubmit(Long userId) {
        return dealInfo(WMSConstants.QUALITY_CHECK, getToUserId(userId), null);
    }

    /**
     * 投资确认
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeInvestmentConfirm() {
        return dealInfo(WMSConstants.INVESTMENT_SUCCESS, -1L, 1);
    }

    /**
     * 质检操作
     * 
     * @param currentAction
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeQuality(Integer currentAction, Long lenderApplyId, Long userId) {
        return 1 == currentAction ? dealInfo(WMSConstants.INVESTMENT_CHECK, -1L, null) : dealInfo(
                WMSConstants.RESUBMIT, queryQualityRecordById(lenderApplyId).getFromUser(), null);
    }

    /**
     * 投资审核
     *
     * @param currentAction
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeInvestment(Integer currentAction, Long lenderApplyId) {
        return 1 == currentAction ? dealInfo(WMSConstants.MATCH, -1L, null) : dealInfo(WMSConstants.RESUBMIT,
                queryQualityRecordById(lenderApplyId).getFromUser(), null);
    }

    /**
     * 匹配
     *
     * @param currentAction
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeMatch() {
        return dealInfo(WMSConstants.CREDITOR_CONFIRM, -1L, null);
    }

    /**
     * 出资确认
     *
     * @param currentAction
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeContributiveConfirm(Integer currentAction, Long lenderApplyId) {
        return 1 == currentAction ? dealInfo(WMSConstants.INVESTMENT_CONFIRM, -1L, null) : dealInfo(
                WMSConstants.CREDITOR_CONFIRM, -1L, null);
    }

    /**
     * 投资失效
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeFail(Long userId) {
        return dealInfo(WMSConstants.INVESTMENT_FAIL, userId, 2);
    }

    /**
     * 债权确认
     *
     * @param currentAction
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> execute(Integer currentAction) {
        return 1 == currentAction ? dealInfo(WMSConstants.CONTRIBUTIVE_CONFIRM, -1L, null) : dealInfo(
                WMSConstants.MATCH, -1L, null);
    }

    private Map<String, Object> dealInfo(String nextStep, Long toUser, Integer nextStepAction) {
        Map<String, Object> result = new HashMap<>();
        result.put(WMSConstants.NEXT_STEP, nextStep);
        result.put(WMSConstants.TO_USER, toUser);
        result.put(WMSConstants.NEXT_STEP_NAME, CurrentStepKey.getInfo((String) result.get(WMSConstants.NEXT_STEP)));
        result.put(WMSConstants.NEXT_STEP_ACTION, nextStepAction);
        return result;
    }

    private LenderApplyLog queryQualityRecordById(Long lenderApplyId) {
        Assert.notNull("** queryQualityRecordById() 理财主键不能为空", lenderApplyId);
        LOG.info("** queryQualityRecordById() lenderApplyId:{}", lenderApplyId);
        LenderApplyLog applog = dalClient.queryForObject("lenderApplyLog.queryCustManageByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), LenderApplyLog.class);
        Assert.notNull("** queryQualityRecordById() 该单理财申请没有质检的日志", applog);
        return applog;
    }

    /**
     * 查询销售客服
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Long getToUserId(Long userId) {
        Assert.notNull("**getToUserId() 当前登陆用户主键不能为空", userId);
        LOG.info("** start ** getToUserId() param userId:{}", userId);
        String zhCode = commonService.getOrgInfo(userId).getCode().substring(0, 7) + "ZH";
        if (StringUtils.isBlank(zhCode) || zhCode.length() < 7) {
            throw new BaseException("userId为" + userId + "的用户所在部门的orgCode配置错误");
        }
        List<UserVo> users = commonService.queryUsersByCode(zhCode);
        Assert.notNull("** getToUserId() users is empty", users);
        for (UserVo vo : users) {
            if (commonService.hasRoleExist(commonService.findRolesByUserId(vo.getUserId()), RoleConstant.XSKF)) {
                LOG.info("** end ** getToUserId() ** userId:{}", vo.getUserId());
                return vo.getUserId();
            }
        }
        LOG.info("** end ** getToUserId() ** userId=-1L");
        return -1L;
    }

}
