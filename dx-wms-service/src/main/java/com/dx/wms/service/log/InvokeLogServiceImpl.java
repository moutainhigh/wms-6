package com.dx.wms.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvokeLogServiceImpl implements IInvokeLogService {
    /**
     * 数据调用记录表Dao
     */
    @Autowired
    private IInvokeLogDao invokeLogDao;
    
    @Override
    public InvokeLog getInvokeLogByLenderId(Long lenderApplyId){
        return invokeLogDao.queryAllByLenderApplyId(lenderApplyId);
    }

    @Override
    public InvokeLog queryByLenderApplyId(long lenderApplyId) {
        return invokeLogDao.queryByLenderApplyId(lenderApplyId);
    }

    @Override
    public InvokeLog queryFailByLenderApplyId(long lenderApplyId) {
        return invokeLogDao.queryFailByLenderApplyId(lenderApplyId);
    }
    
}
