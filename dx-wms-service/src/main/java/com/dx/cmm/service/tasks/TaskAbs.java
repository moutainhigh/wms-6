package com.dx.cmm.service.tasks;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.manager.Router;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.result.InvestResults;
import com.dx.cmm.service.results.Result;
import com.dx.cmm.service.rules.RulerObserver;
import com.dx.op.service.intf.IProductService;

abstract class TaskAbs extends Router<T> implements Task<T> {

    static final Logger LOG = LoggerFactory.getLogger(TaskAbs.class);

    @Autowired
    RulerObserver ruler;

    @Autowired
    Pools<InvestmentPool> investPool;

    @Autowired
    Pools<CreditorPool> creditPool;

    @Autowired
    Result<InvestResults> investResult;
    
    @Autowired
    Result<CreditResults> creditResult;

    @Autowired
    Funds<InvestmentFund> investFund;

    @Autowired
    IProductService productService;

}
