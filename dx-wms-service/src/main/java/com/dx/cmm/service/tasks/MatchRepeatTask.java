package com.dx.cmm.service.tasks;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.google.gson.Gson;

@Service("matchRepeatTask")
public class MatchRepeatTask extends SyncTask {

    @Override
    public synchronized void execute() throws TaskException {
        List<MatchBizBase> bases = investBizBase.queryArray(true, BizBaseStatus.REPEAT);
        for (final MatchBizBase base : bases) {
            final InvestmentPool pool = investPool.query(base);
            if (!Assert.checkParam(pool)) {
                LOG.error("Base[{}] not found pool", new Gson().toJson(base));
                continue;
            }
            if (Assert.equals(pool.getDataStatus(), BizBaseStatus.REPEAT.getCode())) {
                LOG.error("Pool[{}] is repeating", new Gson().toJson(pool));
                continue;
            }
            if (!Assert.equals(pool.getDataStatus(), BizBaseStatus.MATCH.getCode())) {
                LOG.error("Pool[{}] has error status", new Gson().toJson(pool));
                continue;
            }
            final InvestAttr attr = base.invest();
            if (!Assert.checkParam(attr.getCreditIds())) {
                LOG.error("Base[{}] has no credits", new Gson().toJson(base));
                continue;
            }
            dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                @Override
                public Boolean invoke() {
                    BigDecimal back = execute(investResult.queryArray(pool.getInvestmentPoolId(), 1),
                            attr.getCreditIds());
                    pool.repeat(back);
                    investPool.save(pool);
                    investBizBase.save(base);
                    return true;
                }
            });
        }

    }

    private BigDecimal execute(List<MatchResult> results, Set<Long> creditIds) {
        BigDecimal total = BigDecimal.ZERO;
        for (MatchResult result : results) {
            for (Long creditId : creditIds) {
                if (Assert.equals(result.getCreditorPoolId(), creditId)) {
                    execute(creditPool.query(creditId), result);
                    execute(result);
                    total = total.add(result.getTransferTotalAmount());
                }
            }
        }
        return total;
    }

    private void execute(MatchResult result) {
        result.repeat();
        investResult.save(result);
    }

    private void execute(CreditorPool pool, MatchResult result) {
        pool.rollback(result.getTransferTotalAmount());
        creditPool.save(pool);
    }
}
