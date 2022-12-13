package com.dx.cmm.service.credit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.base.IMatchBizBaseAccountDao;
import com.dx.cmm.service.base.IMatchBizBaseDao;
import com.dx.cmm.service.funds.ICreditorFundDao;
import com.dx.cmm.service.income.IIncomeDao;
import com.dx.cmm.service.manager.Router;
import com.dx.cmm.service.pools.ICreditorPoolDao;
import com.dx.cmm.service.results.IMatchResultDao;

public class CreditAbs<T> extends Router<T> implements Credit<T> {

    protected static final Logger LOG = LoggerFactory.getLogger("credit");

    @Autowired
    protected ICreditorPoolDao creditorPoolDao;

    @Autowired
    protected ICreditorFundDao creditorFundDao;

    @Autowired
    protected IMatchResultDao matchResultDao;

    @Autowired
    protected IIncomeDao incomeDao;
    
    @Autowired
    protected IMatchBizBaseDao matchBizBaseDao;

    @Autowired
    protected IMatchBizBaseAccountDao matchBizBaseAccountDao;

}
