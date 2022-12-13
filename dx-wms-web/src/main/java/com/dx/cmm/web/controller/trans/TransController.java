package com.dx.cmm.web.controller.trans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.trans.IMatchTransService;
import com.dx.cmm.web.controller.BaseController;

abstract class TransController extends BaseController{
    
    static final Logger LOG = LoggerFactory.getLogger("trans.log");

    @Autowired
    IMatchTransService transService;
}
