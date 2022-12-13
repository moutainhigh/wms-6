package com.dx.cmm.service.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.result.InvestResults;
import com.dx.cmm.service.results.Result;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.op.service.intf.IProductService;

abstract class SyncAbs implements Sync {

    /**
     * 日志组件
     */
    protected static final Logger LOG = LoggerFactory.getLogger(SyncAbs.class);

    @Autowired
    PaginationDalClient dalClient;

    @Autowired
    IProductService productService;

    @Autowired
    Result<InvestResults> investResult;

    @Autowired
    Result<CreditResults> creditResult;

    @Autowired
    Pools<InvestmentPool> investPool;

    @Autowired
    Pools<CreditorPool> creditPool;

    @Autowired
    Funds<InvestmentFund> investFund;

    @Autowired
    Funds<CreditorFund> creditFund;

    public void check() {

    }

}
