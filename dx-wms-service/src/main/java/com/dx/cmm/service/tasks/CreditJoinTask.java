package com.dx.cmm.service.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.TaskException;
import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.MonthParamCalc;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.ports.CreditPort;
import com.dx.cmm.service.ports.Ports;
import com.dx.cmm.service.users.MatchUser;
import com.dx.cmm.service.users.User;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("creditJoinTask")
public class CreditJoinTask extends QueueTask {

    @Autowired
    private BizBase<CreditorPool> creditBizBase;

    @Autowired
    private User<CreditorPool> creditUser;

    @Autowired
    private Calc<CreditorPool, Boolean> creditRemainCalc;

    @Autowired
    private Calc<MonthParamCalc, Integer> monthCalc;

    @Autowired
    private Ports<CreditPort> creditPorts;

    @Override
    public synchronized void execute() throws TaskException {
        List<MatchBizBase> bases = creditBizBase.queryArray(false, BizBaseStatus.WAIT);
        for (final MatchBizBase base : bases) {
            if (!creditPool.exists(base)) {
                dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
                    @Override
                    public Boolean invoke() {
                        MatchUser user = creditUser.query(base);
                        CreditorPool pool = new CreditorPool(base, ruler, user);
                        creditPool.save(pool);
                        pool.setRemainMonths(monthCalc.calc(
                                new MonthParamCalc(pool.getInitBillDate(), creditPorts.current(pool.getMatchDay()))));
                        if (!creditRemainCalc.calc(pool)) {
                            throw new TaskException("Contract code[{0}] calc remain error", base.getBizContractCode());
                        }
                        creditPool.save(pool);
                        base.exe(BizBaseStatus.CREATED);
                        creditBizBase.save(base);
                        return true;
                    }
                });

            }
        }

    }

}
