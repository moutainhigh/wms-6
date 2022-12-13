/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustFinanceServiceImpl.java
 * Author:   michelle
 * Date:     2015年8月1日 上午11:49:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.apply;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.dao.ICustFinanceDao;
import com.dx.wms.service.apply.entity.CustFinance;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author michelle
 */
@Service
public class CustFinanceServiceImpl implements ICustFinanceService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustFinanceServiceImpl.class);

    /**
     * 客户金融表
     */
    @Autowired
    private ICustFinanceDao custFinanceDao;

    @Override
    public List<CustFinance> queryByApplyId(Long lenderApplyId) {
        Assert.notNull("**getCustFinancesByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**getCustFinancesByLenderApplyId() lenderApplyId={}", lenderApplyId);
        return custFinanceDao.queryByApply(lenderApplyId);
    }

}
