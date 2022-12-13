package com.dx.wms.service.scheduler;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.exception.PushException;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.exception.BaseException;
import com.dx.wms.service.IPushDataService;
import com.dx.wms.service.apply.entity.LenderApply;
import com.google.gson.Gson;

@Service
public class PushCustInfoServiceImpl implements IPushCustInfoService {

    @Autowired
    private PaginationDalClient dalClient;

    /**
     * 推送数据服务
     */
    @Autowired
    private IPushDataService pushDataService;
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(PushCustInfoServiceImpl.class);

    @Override
    @Transactional
    public void push() throws PushException {
        List<LenderApply> results = dalClient.queryForList("lenderApply.queryByPayWay", new HashMap<String, Object>(),
                LenderApply.class);
        LOG.info("*** 推送给财务系统的客户信息数据results={} ***", new Gson().toJson(results));
        for (LenderApply apply : results) {
            if (!pushDataService.pushDealDataByLenderApplyId(apply.getLenderApplyId(), 1L)) {
                throw new BaseException(" 推送财务数据异常  ID = " + apply.getLenderApplyId());
            }
        }

    }

}
