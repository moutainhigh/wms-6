package com.dx.cmm.service.scanner;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.restorer.RepairException;
import com.dx.cmm.service.restorer.Restorer;
import com.dx.common.service.utils.Assert;

@Service("investScanner")
public class InvestScanner extends ScannerAbs {

    @Autowired
    private Restorer<InvestmentPool> investRestorer;

    @Override
    public void scanner() {
        List<InvestmentPool> pools = investPool.queryArray(99, MatchStatus.SUCCESS);
        Integer error = 0;
        Integer repair = 0;
        for (InvestmentPool pool : pools) {
            Calendar initTime = Calendar.getInstance();
            initTime.setTime(pool.getInitMatchTime());
            Calendar now = Calendar.getInstance();
            Integer months = (now.get(Calendar.YEAR) - initTime.get(Calendar.YEAR)) * 12
                    + (now.get(Calendar.MONTH) - initTime.get(Calendar.MONTH));
            if (!Assert.equals(months + 1, pool.getCurrentPeriod())) {
                LOG.error("Pool id[{}] current period[{}] ,in fact[{}] error", pool.getInvestmentPoolId(),
                        pool.getCurrentPeriod(), months + 1);
                error++;
                pool.setCurrentPeriod(months + 1);
                try {
                    investRestorer.repair(pool);
                    repair++;
                } catch (RepairException e) {
                    LOG.error("Repair pool error[{}]", e.getMessage());
                }
            }
        }
        LOG.info("Error[{}],repair[{}]", error, repair);
    }

}
