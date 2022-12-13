package com.dx.wms.service.scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.bpm.constants.ProcessConstans;
import com.dx.bpm.service.IProcessService;
import com.dx.bpm.service.ITaskService;
import com.dx.bpm.vo.CompleteForm;
import com.dx.bpm.vo.TaskVo;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.fms.service.dto.ParamRecordDTO;
import com.dx.fms.service.dto.QueryRecordDTO;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.IDueService;
import com.dx.wms.service.ILenderLogService;
import com.dx.wms.service.apply.IApplyService;
import com.dx.wms.service.apply.ICustLenderApplyService;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.log.ApplyLog;
import com.dx.wms.service.log.IInvokeLogDao;
import com.dx.wms.service.log.ILenderApplyLogService;
import com.dx.wms.service.log.InvokeLog;
import com.google.gson.Gson;

@Service
public class LenderDestoryServiceImpl implements ILenderDestoryService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderDestoryServiceImpl.class);

    /**
     * 理财申请服务
     */
    @Autowired
    private IApplyService applyService;

    /**
     * 理财申请日志服务
     */
    @Autowired
    private ILenderApplyLogService lenderApplyLogService;

    /**
     * 调用日志服务
     */
    @Autowired
    private IInvokeLogDao invokeLogDao;

    /**
     * 财务数据 推送接口
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 理财管理服务
     */
    @Autowired
    private IMatchPushService matchPushService;

    /**
     * 理财申请服务
     */
    @Autowired
    private ICustLenderApplyService custLenderApplyService;

    @Autowired
    private ILenderApplyDao applyDao;

    /**
     * 流程服务
     */
    @Autowired
    private IProcessService processService;

    /**
     * 任务服务
     */
    @Autowired
    private ITaskService taskService;

    @Autowired
    private IDueService dueService;

    @Autowired
    private ILenderLogService lenderLogService;

    @Autowired
    private PaginationDalClient dalClient;

    private Boolean hasFlow(Long status) {
        return Assert.equals(status, 10L) || Assert.equals(status, 11L) || Assert.equals(status, 12L)
                || Assert.equals(status, 13L);
    }

    @Override
    public void destoryContinue() {
        // 查询规则接口 查询到期5天需要失效的数据
        List<Long> ids = dueService.getDueIds("RAK");
        if (!Assert.checkParam(ids)) {
            LOG.info("No continue datas destory");
            return;
        }
        List<LenderApply> datas = applyService.queryApplyByIds(ids);
        for (LenderApply data : datas) {
            execute(data);
        }
    }

    private void execute(final LenderApply data) {
        LOG.info("Destory continue data[{}]", new Gson().toJson(data));
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                applyService.destory(data.getParentId(), "0");
                if (!Assert.checkParam(data.getFormStatus())) {
                    // 草稿状态
                    applyService.updateForStatus(data.getLenderApplyId(), WMSConstants.DELETED);
                    return true;
                }
                if (hasFlow(data.getFormStatus())) {
                    // 修改理财申请单状态
                    applyService.updateStatus(data.getLenderApplyId(), 20L);
                    custLenderApplyService.update(data);
                    // 修改理财申请单日志
                    lenderLogService.add(WMSConstants.INVESTMENT_FAIL, -1L,
                            data.getLenderApplyId(), "该笔续投未在有效时间内提交运营，续投申请失效", WMSConstants.REFUSE);
                    destroy(data);
                }
                return true;
            }
        });
    }

    private void destroy(LenderApply apply) {
        // 不是等待匹配的数据 需要结束工作流
        if (!Assert.checkParam(apply.getProcInsId())) {
            return;
        }
        CompleteForm form = new CompleteForm();
        LOG.info("destroy() ** lender_apply_id={},procInsId={}",apply.getLenderApplyId(),apply.getProcInsId()); 
        TaskVo task = taskService.queryTaskByProcessInstance(apply.getProcInsId());
        Assert.notNull("Task must not be null", task);
        form.setProInsId(apply.getProcInsId());
        form.setTaskId(task.getId());
        form.setLoanApplyId(apply.getLenderApplyId());
        form.setUserId("-1");
        form.setContent("该笔续投未在有效时间内提交运营，续投申请失效");
        form.setPass(ProcessConstans.CHECK_QUIT);
        form.setAppKey("wms");
        processService.complete(form);
    }

    @Override
    public void destory() {
        List<ApplyLog> datas = lenderApplyLogService.queryCreateTime();
        filter(datas);
        if (!Assert.checkParam(datas)) {
            LOG.info("No destory datas");
            return;
        }
        for (final ApplyLog data : datas) {
            dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                @Override
                public Boolean invoke() {
                    Long applyId = data.getLenderApplyId();
                    InvokeLog invoke = invokeLogDao.queryByLenderApplyId(applyId);
                    LOG.info("Invoke[{}]", new Gson().toJson(invoke));
                    // 有调用日志的数据 已经推送过还款系统 凭证需要作废 添加到财务推送list里面
                    if (Assert.checkParam(invoke)) {
                        ParamRecordDTO param = param(invoke, applyId);
                        if (success(applyId, invoke, param)) {
                            return true;
                        }
                        // 推送财务
                        pushFinance(param);
                    }
                    // 查询出需要推送匹配的数据
                    LenderApply apply = applyDao.queryById(LenderApply.class, applyId);
                    Assert.notNull("Apply must not be null", apply);
                    LOG.info("Apply=[{}]", new Gson().toJson(apply));
                    destory(apply);
                    pushMatch(apply);
                    return true;
                }
            });
        }
    }

    private void destory(LenderApply apply) {
        lenderLogService.add(WMSConstants.INVESTMENT_FAIL, -1L, apply.getLenderApplyId(), "",
                WMSConstants.REFUSE);
        applyService.updateStatus(apply.getLenderApplyId(), 20L);
        custLenderApplyService.update(apply);
    }

    private Boolean success(Long applyId, InvokeLog invoke, ParamRecordDTO param) {
        // 查询结果
        List<QueryRecordDTO> records = commonService.queryDealDetail(param);
        Assert.notNull("Trade records[{}]", new Gson().toJson(records));
        for (QueryRecordDTO record : records) {
            // 最新的流水号
            if (StringUtils.endsWithIgnoreCase(record.getBizCode(), invoke.getLenderCode())) {
                // 成功的数据 转到投资等待
                if (Assert.checkParam(record.getTradeResult()) && record.getTradeResult().equals(1)) {
                    lenderLogService.add(WMSConstants.CONTRIBUTIVE_CONFIRM, -1l, applyId, "", 1);
                    applyService.updateStatus(applyId, 19L);
                    return true;
                }
            }
        }
        return false;
    }

    private void filter(List<ApplyLog> datas) {
        Iterator<ApplyLog> iter = datas.iterator();
        while (iter.hasNext()) {
            ApplyLog data = iter.next();
            if (DateUtils.getNextWorkday(data.getCreateTime(), 15).compareTo(new Date()) > 0) {
                iter.remove();
            }
        }
    }

    private ParamRecordDTO param(InvokeLog log, Long applyId) {
        ParamRecordDTO param = new ParamRecordDTO();
        param.setBizCode(log.getLenderCode());
        param.setBizId(applyId);
        param.setBizSource(1);
        param.setTradeType(1);
        return param;
    }

    private void pushFinance(ParamRecordDTO data) {
        commonService.nullifyDealData(new ArrayList<ParamRecordDTO>(Arrays.asList(data)));
    }

    private void pushMatch(LenderApply apply) {
        matchPushService.push(MatchPushCode.INVEST_FAIL,
                new PushData(apply.getLenderCustCode(), apply.getLenderCode()));
    }
}
