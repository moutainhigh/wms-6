package com.dx.cmm.service.chain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.MonthParamCalc;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.ports.CreditPort;
import com.dx.cmm.service.ports.Ports;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("creditRemainChain")
public class CreditRemainChain extends BatchChain {

    @Autowired
    private Pools<CreditorPool> creditPool;

    @Autowired
    private Calc<CreditorPool, Boolean> creditRemainCalc;

    @Autowired
    private Calc<MonthParamCalc, Integer> monthCalc;

    @Autowired
    private Ports<CreditPort> creditPorts;

    @Override
    @Transactional
    public void next(Integer port) {
        LOG.info("Credit remain chain[{}] startup", port);
        final List<CreditorPool> pools = creditPool.queryArray(port, MatchStatus.WAIT, MatchStatus.MATCH,
                MatchStatus.PART);
        LOG.info("Credits[{}] need to remain", pools.size());
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                for (CreditorPool pool : pools) {
                    pool.setRemainMonths(monthCalc
                            .calc(new MonthParamCalc(pool.getInitBillDate(), creditPorts.next(pool.getMatchDay()))));
                    creditRemainCalc.calc(pool);
                }
                return true;
            }
        });
        if (Assert.checkParam(getNext())) {
            getNext().next(port);
        }
    }

}
