package com.dx.cmm.service.restorer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.Result;

abstract class RestorerAbs<T> implements Restorer<T>{

    static final Logger LOG = LoggerFactory.getLogger(RestorerAbs.class);

    @Autowired
    Funds<InvestmentFund> investFund;

    @Autowired
    Pools<CreditorPool> creditPool;

    @Autowired
    Funds<CreditorFund> creditFund;

    @Autowired
    Result<CreditResults> creditResult;

}
