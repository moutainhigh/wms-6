package com.dx.cmm.service.chain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("bizBaseExceptionChain")
public class BizBaseExceptionChain extends BatchChain {

    @Autowired
    private BizBase<CreditorPool> creditBizBase;

    @Autowired
    private Pools<CreditorPool> creditPool;

    @Autowired
    private Result<CreditResults> creditResult;

    @Autowired
    private Pools<InvestmentPool> investPool;

    @Override
    public void next(Integer billDay) throws ChainExecption {
        LOG.info("Credit replace chain[{}] startup", billDay);
        final List<MatchBizBase> bases = creditBizBase.queryArray(billDay, true, BizBaseStatus.EXCEPTION);
        LOG.info("Credits[{}] need to replace", bases.size());
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                for (MatchBizBase base : bases) {
                    CreditorPool pool = creditPool.query(base);
                    if (!Assert.checkParam(pool)) {
                        LOG.error("Base[{}] not found pool", base.getBizContractCode());
                        throw new ChainExecption("Pool must not be null");
                    }
                    if (pool.isException()) {
                        LOG.error("Pool[{}] is exception", pool.getCreditorPoolId());
                        throw new ChainExecption("Pool[{0}] is exception", pool.getCreditorPoolId());
                    }
                    LOG.info("Credit[{}] need to replace", pool.getCreditorPoolId());
                    execute(creditResult.queryArray(pool.getCreditorPoolId(), pool.getCurrentReportDate()));
                    pool.exception();
                    creditPool.save(pool);
                    creditBizBase.save(base);
                }
                return true;
            }
        });
        if (Assert.checkParam(getNext())) {
            getNext().next(billDay);
        }

    }

    private void execute(MatchResult result, InvestmentPool pool) {
        if (!Assert.equals(pool.getDataStatus(), BizBaseStatus.SUCCESS.getCode())
                && !Assert.equals(pool.getDataStatus(), BizBaseStatus.EXCEPTION.getCode())) {
            throw new ChainExecption("Pool[{0}] status[{1}] must success or exception", pool.getInvestmentPoolId(),
                    pool.getDataStatus());
        }
        pool.exception();
        pool.setCurrentDoneAmount(pool.getCurrentDoneAmount().subtract(result.getTransferTotalAmount()));
        pool.setCurrentUndoAmount();
        investPool.save(pool);
    }

    private void execute(List<MatchResult> results) {
        for (MatchResult result : results) {
            execute(result, investPool.query(result.getInvestmentPoolId()));
            result.exception();
            creditResult.save(result);
        }
    }

}
