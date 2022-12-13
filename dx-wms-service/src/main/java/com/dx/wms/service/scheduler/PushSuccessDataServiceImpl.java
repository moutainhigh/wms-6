package com.dx.wms.service.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.fms.service.api.IFinanceDataProcessService;
import com.dx.fms.service.dto.DealRecordDTO;
import com.dx.fms.service.dto.ProcessResultDTO;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.wms.service.IPushDataService;
import com.dx.wms.service.log.ILenderApplyLogDao;
import com.dx.wms.service.log.LenderApplyLog;
import com.google.gson.Gson;

@Service
public class PushSuccessDataServiceImpl implements IPushSuccessDataService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(PushSuccessDataServiceImpl.class);

    /**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;

    /**
     * 推送数据服务
     */
    @Autowired
    private IPushDataService pushDataService;

    /**
     * 财务数据 推送接口
     */
    @Autowired
    private IFinanceDataProcessService financeDataProcessService;
    /**
     * 申请单日志服务
     */
    @Autowired
    private ILenderApplyLogDao lenderApplyLogDao;

    @Override
    @Transactional
    public void pushSuccessData() {
        
                
        List<DealRecordDTO> dealRecordDTOList = getDealRecordDTOList();
        if (Assert.checkParam(dealRecordDTOList)) {
            Map<String, ProcessResultDTO> result = financeDataProcessService.pushDealData(dealRecordDTOList);
            if (!Assert.checkParam(result)) {
                LOG.info("推送数据返回结果集为空");
            }
            for (DealRecordDTO dealRecordDTO : dealRecordDTOList) {
                LOG.info("处理数据 dealRecordDTO={}", new Gson().toJson(dealRecordDTO));
                String invokeLogCode = dealRecordDTO.getOrderNo();
                ProcessResultDTO processResultDTO = result.get(invokeLogCode);
                checkPushData(processResultDTO, result, invokeLogCode);
            }
            LOG.info("***推送结果 result={}", result);
        }
    }

    // 获取交易记录
    private List<DealRecordDTO> getDealRecordDTOList() {
        List<DealRecordDTO> dealRecordDTOList = new ArrayList<DealRecordDTO>();
        List<LenderApplyLog> lenderApplyLogs = getWaitInvestmentLog();
        if (Assert.checkParam(lenderApplyLogs)) {
            for (LenderApplyLog lenderApplyLog : lenderApplyLogs) {
                LOG.info("***volumeSuccessData()   lenderApplyLog={}", new Gson().toJson(lenderApplyLog));
                Long lenderApplyId = lenderApplyLog.getLenderApplyId();
                DealRecordDTO dealRecordDTO = getPushRecordById(lenderApplyId);
                dealRecordDTOList.add(dealRecordDTO);
            }
        }
        return dealRecordDTOList;
    }

    // 获取申请日志表
    private List<LenderApplyLog> getWaitInvestmentLog() {
        return lenderApplyLogDao.queryListByParam(false);
    }

    // 根据出借申请编号获取交易记录
    private DealRecordDTO getPushRecordById(Long lenderApplyId) {
        Assert.notNull("理财申请编号为空", lenderApplyId);
        LOG.info("***volumeSuccessData()   lenderApplyId={}", lenderApplyId);
        DealRecordDTO dealRecordDTO = pushDataService.getPushRecordById(lenderApplyId, -1l, 2);
        return dealRecordDTO;
    }

    // 检验推送数据返回结果集是否为空
    private void checkPushData(ProcessResultDTO processResultDTO, Map<String, ProcessResultDTO> result,
            String invokeLogCode) {
        LOG.info("返回对象 processResultDTO={}", new Gson().toJson(processResultDTO));
        if (!Assert.checkParam(processResultDTO)) {
            LOG.info("推送数据返回结果集对象为空");
        }
        LOG.info("***processResultDTO = {}***", new Gson().toJson(processResultDTO));
        Integer isSuccess = processResultDTO.getIsSuccess();
        if (!Assert.checkParam(isSuccess)) {
            LOG.info("推送数据返回结果集对象为空");
            LOG.info(result.get(invokeLogCode).getMsg());
        }
    }

}
