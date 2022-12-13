package com.dx.cmm.web.controller.credit;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.credit.ICreditService;
import com.dx.cmm.web.controller.BaseController;
import com.dx.wms.service.IProductService;

abstract class CreditController extends BaseController {

    static final String APP = "ccs";

    @Autowired
    ICreditService creditService;

    @Autowired
    IProductService productService;
}
