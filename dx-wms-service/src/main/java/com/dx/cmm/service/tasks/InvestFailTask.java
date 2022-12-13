package com.dx.cmm.service.tasks;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.google.gson.Gson;

@Service("investFailTask")
public class InvestFailTask extends SyncTask {

    @Override
    public synchronized void execute()throws TaskException {
        List<MatchBizBase> bases = investBizBase.queryArray(true, BizBaseStatus.FAIL);
        for (final MatchBizBase base : bases) {
            dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                @Override
                public Boolean invoke() {
                    InvestmentPool pool = investPool.query(base);
                    if (!Assert.checkParam(pool)) {
                        LOG.error("Base[{}] not found pool", new Gson().toJson(base));
                        investBizBase.save(base);
                        return true;
                    }
                    if (Assert.equals(pool.getDataStatus(), BizBaseStatus.FAIL.getCode())) {
                        LOG.error("Pool[{}] is fail", new Gson().toJson(pool));
                        investBizBase.save(base);
                        return true;
                    }
                    if (!Assert.equals(pool.getDataStatus(), BizBaseStatus.MATCH.getCode())
                            && !Assert.equals(pool.getDataStatus(), BizBaseStatus.REPEAT.getCode())
                            && !Assert.equals(pool.getDataStatus(), BizBaseStatus.WAIT.getCode())
                            && !Assert.equals(pool.getDataStatus(), BizBaseStatus.CONTINUE.getCode())) {
                        LOG.error("Pool[{}] has error status", new Gson().toJson(pool));
                        return true;
                    }

                    // rollback results
                    execute(investResult.queryArray(pool.getInvestmentPoolId(), 1));
                    // rollback invest
                    execute(pool);
                    investBizBase.save(base);
                    return true;
                }
            });
        }
    }

    private void execute(List<MatchResult> results) {
        for (MatchResult result : results) {
            CreditorPool pool = creditPool.query(result.getCreditorPoolId());
            // rollback credit
            execute(pool, result);
            // rollback base
            execute(pool);
        }
    }

    private void execute(CreditorPool pool, MatchResult result) {
        pool.rollback(result.getTransferTotalAmount());
        creditPool.save(pool);
        result.del();
        creditResult.save(result);
    }

    private void execute(CreditorPool pool) {
        if (Assert.equals(pool.getInitPeriod(), pool.getRemainPeriod())
                && Assert.equals(pool.getDataStatus(), BizBaseStatus.WAIT.getCode())) {
            creditBizBase.save(pool.getMatchBizBaseId(), BizBaseStatus.CREATED);
        }
    }

    private void execute(InvestmentPool pool) {
        pool.fail();
        investPool.save(pool);

    }

}
