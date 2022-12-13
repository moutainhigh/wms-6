package com.dx.wms.service.scheduler;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.service.IDueService;
import com.dx.wms.service.apply.IApplyService;
import com.dx.wms.service.apply.entity.LenderApply;
import com.google.gson.Gson;

@Service
public class DealDueDateServiceImpl implements IDealDueDateService {
    /**
     * 理财申请服务
     */
    @Autowired
    private IApplyService applyService;

    @Autowired
    private IDueService dueService;

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(DealDueDateServiceImpl.class);

    @Override
    public void dealDueDate() {
        // 查询出所有 即将到期 状态的 理财申请单
        List<LenderApply> lenderApplys = applyService.getLenderApplyByFormStatus(22L);
        LOG.info("applys[{}]", new Gson().toJson(lenderApplys));
        Date nowDate = new Date();
        for (LenderApply lenderApply : lenderApplys) {
            Date dueDate = DateUtils.addDay(lenderApply.getDueDate(), 1);
            Assert.notNull("理财申请单的到期日为空 ", dueDate);
            LOG.info(" *** dealDueDate() applyId={},dueDate={} *** ", lenderApply.getLenderApplyId(), dueDate);
            if (nowDate.getTime() > dueDate.getTime()) {
                applyService.updateStatus(lenderApply.getLenderApplyId(), 23L);
                LOG.info("** 申请单ID={}，到期时间dueDate={} 的数据被修改状态为到期 ***", lenderApply.getLenderApplyId(),
                        lenderApply.getDueDate());
            }
        }
    }

    @Override
    public void dealSoonDue() {
        // 查询规则接口 查询出即将到期的数据 修改状态
        List<Long> ids = dueService.getDueIds("RAI");
        LOG.info("Ids[{}]", new Gson().toJson(ids));
        if (Assert.checkParam(ids)) {
            applyService.updateFormStatusByIds(ids, 22L);
            LOG.info("修改即将到期申请单  ids={}", new Gson().toJson(ids));
        }
    }

}
