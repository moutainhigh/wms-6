package com.dx.cmm.service.invest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.base.IMatchBizBaseAccountDao;
import com.dx.cmm.service.base.IMatchBizBaseDao;
import com.dx.cmm.service.funds.IInvestmentFundDao;
import com.dx.cmm.service.income.IIncomeDao;
import com.dx.cmm.service.manager.Router;
import com.dx.cmm.service.pools.IInvestmentPoolDao;
import com.dx.cmm.service.results.IMatchResultDao;

public abstract class InvestAbs<T> extends Router<T> implements Invest<T> {

    protected static final Logger LOG = LoggerFactory.getLogger("invest");

    @Autowired
    protected IInvestmentFundDao investmentFundDao;

    @Autowired
    protected IInvestmentPoolDao investmentPoolDao;

    @Autowired
    protected IMatchResultDao matchResultDao;

    @Autowired
    protected IIncomeDao incomeDao;

    @Autowired
    protected IMatchBizBaseDao matchBizBaseDao;

    @Autowired
    protected IMatchBizBaseAccountDao matchBizBaseAccountDao;

}
