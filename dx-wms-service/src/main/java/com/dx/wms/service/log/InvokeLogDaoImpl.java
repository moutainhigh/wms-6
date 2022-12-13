package com.dx.wms.service.log;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Component
public class InvokeLogDaoImpl extends BaseDaoImpl<InvokeLog> implements IInvokeLogDao {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(InvokeLogDaoImpl.class);

    @Override
    public InvokeLog queryByInvokeLogCode(String invokeLogCode) {
        Assert.notNull("**queryByInvokeLogCode() invokeLogCode can not be null**", invokeLogCode);
        LOG.info("**queryByInvokeLogCode() invokeLogCode={}**", invokeLogCode);
        return dalClient.queryForObject("invokeLog.queryByInvokeLogCode",
                MapUtils.getParamMap("invokeLogCode", invokeLogCode), InvokeLog.class);
    }

    @Override
    public InvokeLog queryByLenderApplyId(long lenderApplyId) {
        Assert.notNull("**queryByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**queryByLenderApplyId() lenderApplyId={}**", lenderApplyId);
        return dalClient.queryForObject("invokeLog.queryByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), InvokeLog.class);
    }
    
    @Override
    public InvokeLog queryAllByLenderApplyId(long lenderApplyId) {
        Assert.notNull("**queryAllByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**queryAllByLenderApplyId() lenderApplyId={}**", lenderApplyId);
        return dalClient.queryForObject("invokeLog.queryAllByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), InvokeLog.class);
    }
    
    @Override
    public int setInvokeLogStatusByCode(String invokeLogCode , String dataStatus){
        Assert.notNull("**setInvokeLogStatesByCode() invokeLogCode can not be null**", invokeLogCode);
        Assert.notNull("**setInvokeLogStatesByCode() dataStatus can not be null**", dataStatus);
        LOG.info("**setInvokeLogStatesByCode() invokeLogCode={},dataStatus={}***", invokeLogCode,dataStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("invokeLogCode", invokeLogCode);
        paramMap.put("dataStatus", dataStatus);
        LOG.info("**setInvokeLogStatesByCode() paramMap={}**", paramMap);
        return dalClient.execute("invokeLog.setInvokeLogStatusByCode", paramMap);
    }
    
    @Override
    public InvokeLog queryFailByLenderApplyId(long lenderApplyId){
        Assert.notNull("**queryFailByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**queryFailByLenderApplyId() lenderApplyId={}**", lenderApplyId);
        return dalClient.queryForObject("invokeLog.queryFailByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), InvokeLog.class);
    }
}
