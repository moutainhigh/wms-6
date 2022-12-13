/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: InvestController.java
 * Author:   朱道灵
 * Date:     2016年5月3日 下午1:36:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.report.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.invest.IInvestService;
import com.dx.cmm.web.controller.BaseController;
import com.dx.wms.service.IProductService;

/**
 * 投资管理controller
 *
 * @author 朱道灵
 */
abstract class InvestController extends BaseController{
    
    static final String APP = "wms";
       
    @Autowired
    IInvestService investService;

    @Autowired
    IProductService productService;

}
