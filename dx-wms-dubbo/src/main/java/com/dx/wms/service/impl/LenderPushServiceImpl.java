package com.dx.wms.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.rule.api.dto.RuleParamDto;
import com.dx.rule.service.IRuleTriggerEngineService;
import com.dx.wms.bean.LenderApply;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.ILenderApplyDao;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.ILenderLogService;
import com.dx.wms.service.push.ILenderPushService;
import com.dx.wms.service.push.LenderPushException;
import com.google.gson.Gson;

public class LenderPushServiceImpl implements ILenderPushService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderPushServiceImpl.class);

    private static final String APPROVE = "approve";

    @Autowired
    private PaginationDalClient dalClient;

    @Autowired
    private IRuleTriggerEngineService ruleTriggerEngineService;

    @Autowired
    private ILenderLogService lenderLogService;

    @Autowired
    private IMatchPushService matchPushService;

    @Autowired
    private ILenderApplyDao lenderApplyDao;

    private LenderPushException error(String msg, Object... args) {
        return new LenderPushException(msg, args);
    }

    private void match(PushDataDto data) throws LenderPushException {
        Assert.notNull(error("Statement date or match date must not be null"), data.getStatementDate(),
                data.getMatchDate());
        LOG.info("Push match[{}]", new Gson().toJson(data));
        LenderApply apply = lenderApplyDao.query(data.getLenderCode());
        Assert.notNull(error("Apply[{0}] not found", data.getLenderCode()), apply);
        Long lenderApplyId = apply.getLenderApplyId();
        lenderLogService.add(WMSConstants.MATCH, data.getCreateUser(), lenderApplyId, "匹配完成 ", WMSConstants.APPROVED);
        apply.match(data.getStatementDate(), data.getMatchDate());
        if (!lenderApplyDao.update(apply)) {
            throw error("Apply[{0}] sync match date error", data.getLenderCode());
        }
    }

    private void due(PushDataDto data) throws LenderPushException {
        Assert.notNull(error("Due date date must not be null"), data.getDueDate());
        LOG.info("Push due[{}]", new Gson().toJson(data));
        LenderApply apply = lenderApplyDao.query(data.getLenderCode());
        Assert.notNull(error("Apply[{0}] not found", data.getLenderCode()), apply);
        if (!Assert.checkParam(apply.getSettlementDate())) {
            LOG.error("Apply[{}] miss settlement date", data.getLenderCode());
            apply.setSettlementDate(data.getSettlementDate());
        }
        apply.due(data.getDueDate());
        if (!lenderApplyDao.update(apply)) {
            throw error("Apply[{0}] sync due date error", data.getLenderCode());
        }
        trigger(apply, WMSConstants.INVESTMENT_SUCCESS, APPROVE);
    }

    private void giveUp(PushDataDto data) throws LenderPushException {
        LOG.info("Push give up[{}]", new Gson().toJson(data));
        Long userId = data.getCreateUser();
        LenderApply apply = lenderApplyDao.query(data.getLenderCode());
        lenderLogService.destory(userId, apply.getLenderApplyId(), "", "客户放弃成功");
        // 客户放弃 如果是续投的单子 需要触发规则的销毁接口
        if (Assert.checkParam(apply.getParentId())) {
            lenderApplyDao.sync(apply.getParentId(), "0");
            trigger(apply, WMSConstants.MATCH, APPROVE);
        }
        // 过了投资审核后
        if (apply.getFormStatus().compareTo(14L) >= 0) {
            PushData push = new PushData();
            push.setBizCode(apply.getLenderCode());
            matchPushService.push(MatchPushCode.INVEST_FAIL, push);
        }
        lenderApplyDao.sync(apply, 20L);
    }

    private void trigger(LenderApply apply, String link, String action) {
        RuleParamDto param = new RuleParamDto();
        param.setAppKey(WMSConstants.WMS);
        param.setLinkKey(link);
        param.setActionKey(action);
        param.setBizId(apply.getLenderApplyId());
        param.setParam(apply.getDueDate());
        param.setCreateTime(new Date());
        LOG.info("Execute rule[{}]", new Gson().toJson(param));
        ruleTriggerEngineService.triggerRule(param);
    }

    @Override
    public void push(final PushCode code, final PushDataDto push) throws LenderPushException {
        Assert.notNull(new LenderPushException("Push data or code must not be null"), push, code);
        Assert.notNull(new LenderPushException("Lender code must not be null"), push.getLenderCode());
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                switch (code) {
                    case MATCH_COMPLETE:
                        match(push);
                        break;
                    case DUE_DATE:
                        due(push);
                        break;
                    case GIVE_UP:
                        giveUp(push);
                    default:
                        break;
                }
                return true;
            }
        });

    }

}
