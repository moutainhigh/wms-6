/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: InvokeLogSaveServiceImpl.java
 * Author:   yangbao
 * Date:     2016年1月7日 上午1:02:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class InvokeLogSaveServiceImpl implements IInvokeLogSaveService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(InvokeLogSaveServiceImpl.class);

    @Autowired
    private ILenderApplyDao applyDao;
    /**
     * 数据调用记录表Dao
     */
    @Autowired
    private IInvokeLogDao invokeLogDao;

    @Override
    public InvokeLog save(Long lenderApplyId, String lenderCode, Long userId, Integer invokeResult) {
        Assert.notNull("**save() lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("**InvokeLog save() lenderCode can not be null**", lenderCode);
        Assert.notNull("**save() userId can not be null**", userId);
        Assert.notNull("**save() invokeResult can not be null**", invokeResult);
        LOG.info("**InvokeLog save()  lenderApplyId={},lenderCode={},userId={},invokeResult={}**", lenderApplyId,
                lenderCode, userId, invokeResult);
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, lenderApplyId);
        Assert.notNull("理财申请数据为空", lenderApply);
        InvokeLog invokeLog = new InvokeLog();
        invokeLog.setLenderApplyId(lenderApplyId);
        invokeLog.setLenderCode(lenderCode);
        invokeLog.setInvokeResult(invokeResult);
        invokeLog.setPayWayId(lenderApply.getPayWayId());
        invokeLog.setCreateUser(userId);
        invokeLog.setUpdateUser(userId);
        invokeLog.setDataStatus(WMSConstants.DATE_STATUS_A);
        invokeLog.setInvokeLogId(invokeLogDao.insert(invokeLog));
        return invokeLog;
    }

}
