/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyLogServiceImpl.java
 * Author:   黄健
 * Date:     2015年7月31日 下午9:13:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.RoleVo;
import com.dx.ccs.vo.UserVo;
import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.dto.QueryResultDto;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.framework.exception.BaseException;
import com.dx.wms.bean.LenderApplyLog;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.IlenderLogDao;
import com.dx.wms.dto.LenderLogDto;
import com.dx.wms.enums.CurrentStepKey;
import com.dx.wms.enums.Period;
import com.dx.wms.service.ILenderLogService;
import com.dx.wms.service.ILenderQueryService;
import com.dx.wms.service.exception.LenderLogException;
import com.google.gson.Gson;

/**
 * 理财申请日志 记录
 *
 * @author huangjian
 */
public class LenderLogServiceImpl implements ILenderLogService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderLogServiceImpl.class);

    @Autowired
    private PaginationDalClient dalClient;

    @Autowired
    private IAMService amService;

    /**
     * 匹配推送服务
     */
    @Autowired
    private IMatchPushService matchPushService;

    @Autowired
    private ILenderQueryService lenderQueryService;

    @Autowired
    private IlenderLogDao lenderLogDao;

    @Override
    public void destory(final Long userId, final Long applyId, final String comment, final String endApproveComment)
            throws LenderLogException {
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                Assert.notNull("Apply id must not be null", applyId);
                if (!Assert.checkParam(userId)) {
                    throw new LenderLogException("User id must not be null");
                }
                LenderApplyLog current = lenderLogDao.queryCurrent(applyId);
                Assert.notNull(new LenderLogException("Apply[{0}] not found log", applyId), current);
                if (Assert.equals(current.getCurrentStepKey(), CurrentStepKey.CONTRIBUTIVE_CONFIRM.getCode())
                        || Assert.equals(current.getCurrentStepKey(), CurrentStepKey.INVESTMENT_CONFIRM.getCode())) {
                    throw new LenderLogException("Apply[{0}] current step must not give up", applyId);
                }
                current.update(userId, 2, comment);
                current.setDataStatus("D");
                LenderApplyLog next = new LenderApplyLog(userId, applyId);
                next.add(CurrentStepKey.INVESTMENT_GIVEUP.getInfo(), CurrentStepKey.INVESTMENT_GIVEUP.getCode(), userId,
                        2, current.getCurrentStepKey(), 2);
                next.setApproveComment(endApproveComment);
                lenderLogDao.save(current, next);
                return true;
            }
        });

    }

    @Override
    public void add(final String step, final Long userId, final Long applyId, final String approve,
            final Integer action) throws LenderLogException {
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                Assert.notNull(new LenderLogException("Step or apply id or action must not be null"), step, applyId,
                        action);
                LOG.info("Step[{}],apply id[{}],approve[{}],action[{}],userId[{}]", step, applyId, approve, action,
                        userId);
                Assert.notEquals(new LenderLogException("Action must not be validate"), action, 1, 2);
                // 获取当前日志
                LenderApplyLog current = lenderLogDao.queryCurrent(applyId, step);
                Assert.notNull(new LenderLogException("Apply[{0}] step[{1}] log not found", applyId, step), current);
                current.update(userId, action, approve);
                LenderApplyLog next = next(userId, step, action, applyId);
                if (WMSConstants.INVESTMENT_FAIL.equalsIgnoreCase(step)) {
                    next.setApproveComment(CurrentStepKey.getInfo(WMSConstants.INVESTMENT_FAIL));
                }
                lenderLogDao.save(current, next);
                // 投资审核同意 需要推送数据给匹配
                if (WMSConstants.INVESTMENT_CHECK.equalsIgnoreCase(step) && Assert.equals(1, action)) {
                    push(applyId, userId);
                }
                return true;
            }
        });
    }

    private LenderApplyLog next(Long user, String step, Integer action, Long applyId) throws LenderLogException {
        LenderLogDto next = new LenderLogDto();
        switch (step) {
            case WMSConstants.DRAFT:
                next = draft(user);
                break;
            case WMSConstants.QUALITY_CHECK:
                next = quality(action, applyId, user);
                break;
            case WMSConstants.INVESTMENT_CHECK:
                next = investment(action, applyId);
                break;
            case WMSConstants.RESUBMIT:
                next = resubmit(user);
                break;
            case WMSConstants.MATCH:
                next = match();
                break;
            case WMSConstants.CREDITOR_CONFIRM:
                next = creditConfirm(action);
                break;
            case WMSConstants.CONTRIBUTIVE_CONFIRM:
                next = contributiveConfirm(action, applyId);
                break;
            case WMSConstants.INVESTMENT_CONFIRM:
                next = investmentConfirm();
                break;
            case WMSConstants.INVESTMENT_FAIL:
                next = fail(user);
                break;
            default:
                throw new LenderLogException("Current step[{0}] not found", step);
        }
        LenderApplyLog add = new LenderApplyLog(user, applyId);
        add.add(next.getNextStepName(), next.getNextStep(), next.getToUser(), action, step, next.getNextStepAction());
        return add;
    }

    private void push(Long applyId, Long userId) throws LenderLogException {
        QueryResultDto result = lenderQueryService.queryApplyId(applyId);
        Assert.notNull(new LenderLogException("Result[{0}] must not be null", applyId), result);
        LOG.info("result[{}]", new Gson().toJson(result));
        matchPushService.push(
                Assert.checkParam(result.getParentId()) ? MatchPushCode.INVEST_CONTINUE : MatchPushCode.INVEST_JOIN,
                data(result, userId));
    }

    private PushData data(QueryResultDto dto, Long userId) {
        BizBase base = new BizBase(dto.getLenderApplyId(), dto.getLenderCustCode());
        base.setBizContractCode(dto.getContractCode());
        base.setCustName(dto.getCustName());
        base.setBizCode(dto.getLenderCode());
        base.setCustCode(dto.getCustCode());
        base.setIdCard(dto.getIdCard());
        base.setBizTotalAmount(dto.getLenderAmount());
        base.setBizProductId(dto.getProductId());
        base.setBizDateBegin(dto.getExpectLenderDateBegin());
        base.setBizDateEnd(dto.getExpectLenderDateEnd());
        base.setCustCategory(dto.getCustCategory());
        base.setOrgId(dto.getOrgId());
        base.setActionUser(userId);
        base.setSignDate(dto.getSignDate());
        base.setApplyDate(dto.getCreateTime());
        base.setBizPeriod(Integer.valueOf(Period.getInfo(dto.getProductId())));
        InvestAttr attr = new InvestAttr(dto.getPayWay(), dto.getMsgWayView());
        base.setInvestAttr(attr);
        base.setCustAddress(dto.getCustAddress());
        base.setZipCode(dto.getZipCode());
        base.setEmail(dto.getEmail());
        base.setMobile(dto.getMobile());
        base.setCustSource(dto.getCustSource());
        PushData data = new PushData(dto.getLenderCode(), base);
        if (Assert.checkParam(dto.getParentId())) {
            data.setIsContinue(true);
        }
        return data;
    }

    private LenderLogDto draft(Long userId) {
        return dealInfo(WMSConstants.QUALITY_CHECK, userId, null);
    }

    private LenderLogDto match() {
        return dealInfo(WMSConstants.CREDITOR_CONFIRM, -1L, null);
    }

    private LenderLogDto fail(Long userId) {
        return dealInfo(WMSConstants.INVESTMENT_FAIL, userId, 2);
    }

    private LenderLogDto contributiveConfirm(Integer currentAction, Long lenderApplyId) {
        return Assert.equals(currentAction, 1) ? dealInfo(WMSConstants.INVESTMENT_CONFIRM, -1L, null)
                : dealInfo(WMSConstants.CREDITOR_CONFIRM, -1L, null);
    }

    private LenderLogDto investmentConfirm() {
        return dealInfo(WMSConstants.INVESTMENT_SUCCESS, -1L, 1);
    }

    private LenderLogDto quality(Integer currentAction, Long applyId, Long userId) throws LenderLogException {
        LenderApplyLog log = lenderLogDao.queryLast(applyId);
        Assert.notNull(new LenderLogException("Apply[{0}] quality not found log", applyId), log);
        return Assert.equals(currentAction, 1) ? dealInfo(WMSConstants.INVESTMENT_CHECK, -1L, null)
                : dealInfo(WMSConstants.RESUBMIT, log.getFromUser(), null);
    }

    private LenderLogDto investment(Integer currentAction, Long applyId) throws LenderLogException {
        LenderApplyLog log = lenderLogDao.queryLast(applyId);
        Assert.notNull(new LenderLogException("Apply[{0}] quality not found log", applyId), log);
        return Assert.equals(currentAction, 1) ? dealInfo(WMSConstants.MATCH, -1L, null)
                : dealInfo(WMSConstants.RESUBMIT, log.getFromUser(), null);
    }

    private LenderLogDto resubmit(Long userId) {
        return dealInfo(WMSConstants.QUALITY_CHECK, getToUserId(userId), null);
    }

    private LenderLogDto creditConfirm(Integer currentAction) {
        return Assert.equals(currentAction, 1) ? dealInfo(WMSConstants.CONTRIBUTIVE_CONFIRM, -1L, null)
                : dealInfo(WMSConstants.MATCH, -1L, null);
    }

    private LenderLogDto dealInfo(String nextStep, Long toUser, Integer nextStepAction) {
        LenderLogDto dto = new LenderLogDto();
        dto.setNextStep(nextStep);
        dto.setToUser(toUser);
        dto.setNextStepName(CurrentStepKey.getInfo(nextStep));
        dto.setNextStepAction(nextStepAction);
        return dto;
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
        String zhCode = amService.queryOrgByUserId(userId).getCode().substring(0, 7) + "ZH";
        if (StringUtils.isBlank(zhCode) || zhCode.length() < 7) {
            throw new BaseException("userId为" + userId + "的用户所在部门的orgCode配置错误");
        }
        List<UserVo> users = amService.queryUserByOrg(amService.queryOrgByOrgCode(zhCode).getOrgId());
        Assert.notNull("** getToUserId() users is empty", users);
        for (UserVo vo : users) {
            if (hasRoleExist(amService.findRolesByUserId(vo.getUserId()), RoleConstant.XSKF)) {
                LOG.info("** end ** getToUserId() ** userId:{}", vo.getUserId());
                return vo.getUserId();
            }
        }
        LOG.info("** end ** getToUserId() ** userId=-1L");
        return -1L;
    }

    private Boolean hasRoleExist(List<RoleVo> roleVos, String roleCode) {
        LOG.info("hasRoleExist() roleVos{} roleCode{}", new Gson().toJson(roleVos), roleCode);
        if (!Assert.checkParam(roleVos)) {
            LOG.error("hasRoleExist() roleVos{} is null", new Gson().toJson(roleVos));
            return false;
        }
        if (StringUtils.isBlank(roleCode)) {
            LOG.error("hasRoleExist() roleCode{} is null", roleCode);
            return false;
        }
        for (RoleVo role : roleVos) {
            if (StringUtils.contains(role.getCode(), roleCode)) {
                return true;
            }
        }
        return false;
    }

}
