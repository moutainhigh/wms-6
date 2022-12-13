package com.dx.wms.service.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.IMatchPushService;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.LenderManagermentDao;
import com.dx.wms.service.ILenderLogService;
import com.dx.wms.service.apply.IApplyService;
import com.google.gson.Gson;

/**
 * 
 * 跑批投资生效的数据
 *
 * @author 王蕊
 */
@Service
public class PushInvestSuccessServiceImpl implements IPushInvestSuccessService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(PushInvestSuccessServiceImpl.class);
    /**
     * 理财管理服务
     */
    @Autowired
    private IMatchPushService matchPushService;
    /**
     * 理财申请服务
     */
    @Autowired
    private IApplyService lenderApplyService;

    /**
     * 理财管理服务
     */
    @Autowired
    private LenderManagermentDao lenderManagermentDao;

    @Autowired
    private ILenderLogService lenderLogService;

    @Autowired
    private PaginationDalClient dalClient;

    @Override
    public void push() throws PushException {
        List<SuccessData> datas = dalClient.queryForList("pushSuccess.queryPush", null, SuccessData.class);
        for (final SuccessData data : datas) {
            LOG.info("Push data[{}]", new Gson().toJson(data));
            dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                @Override
                public Boolean invoke() {
                    // 投资生效的数据推送给匹配
                    lenderLogService.add(WMSConstants.INVESTMENT_CONFIRM, -1l, data.getApplyId(),
                            "", WMSConstants.APPROVED);
                    // 修改申请单状态
                    lenderApplyService.updateStatus(data.getApplyId(), 21L);
                    lenderManagermentDao.updateStatus(data.getApplyId());
                    matchPushService.push(MatchPushCode.INVEST_SUCCESS,
                            new PushData(data.getLenderCode(), data.getSettlementDate()));
                    return true;
                }
            });
        }

    }

}
