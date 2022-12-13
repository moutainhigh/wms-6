package com.dx.cmm.service.tasks;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.users.MatchUser;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("investContinueTask")
public class InvestContinueTask extends QueueTask {

    @Override
    public void execute() throws TaskException {
        List<MatchBizBase> bases = investBizBase.queryArray(false, BizBaseStatus.CONTINUE);
        for (final MatchBizBase base : bases) {
            if (!investPool.exists(base)) {
                dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                    @Override
                    public Boolean invoke() {
                        MatchUser user = investUser.query(base);
                        InvestmentPool pool = new InvestmentPool(base, ruler, user);
                        pool.doContinue();
                        investPool.save(pool);
                        base.exe(BizBaseStatus.CREATED);
                        investBizBase.save(base);
                        return true;
                    }
                });
            }
        }

    }

}
