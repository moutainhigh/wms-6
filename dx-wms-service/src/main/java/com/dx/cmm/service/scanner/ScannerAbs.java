package com.dx.cmm.service.scanner;

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

abstract class ScannerAbs implements Scanner {

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger("scanner");

    @Autowired
    Pools<CreditorPool> creditPool;

    @Autowired
    Funds<CreditorFund> creditFund;

    @Autowired
    Pools<InvestmentPool> investPool;

    @Autowired
    Funds<InvestmentFund> investFund;

    @Autowired
    Result<CreditResults> creditResult;

    @Autowired
    Result<InvestResults> investResult;

    /**
     * dalClient
     */
    @Autowired
    PaginationDalClient dalClient;
}
