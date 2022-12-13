/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackController.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午1:39:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.web.controller.back;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.back.IMatchBackService;
import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.web.controller.BaseController;
import com.dx.framework.exception.BaseException;
import com.dx.wms.service.apply.ILenderApplyService;

import cn.creditrest.finance.api.service.IFinanceDataProcessRestService;

/**
 * 回款
 *
 * @author 朱道灵
 */
class BackController extends BaseController {

    
    static final Logger LOG = LoggerFactory.getLogger("back.log");
    
    @Autowired
    IMatchBackService matchBackService;

    @Autowired
    ILenderApplyService lenderApplyService;

    @Autowired
    IFinanceDataProcessRestService financeDataProcessRestService;
    
    @Autowired
    Funds<InvestmentFund> investFund;

    void error(Map<String, Object> result, BaseException e) {
        result.put("result", false);
        result.put("msg", e.getMessage());
    }
    
    void error(Map<String, Object> result, String msg) {
        result.put("result", false);
        result.put("msg", msg);
    }
    
}
