package com.dx.cmm.service.sync;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;

@Service("initBillDaySync")
public class InitBillDaySync extends SyncAbs {

    @Override
    @Transactional
    public void sync() {
        List<InvestmentPool> pools = investPool.queryAll();
        Integer error = 0;
        Integer success = 0;
        for (InvestmentPool pool : pools) {
            if (Assert.checkParam(pool.getBillDay()) && Assert.checkParam(pool.getInitMatchTime())) {
                LOG.debug("Pool id[{}] ,bill day[{}]", pool.getInvestmentPoolId(), pool.getBillDay());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(pool.getInitMatchTime());
                calendar.set(Calendar.DAY_OF_MONTH, pool.getBillDay());
                calendar.add(Calendar.MONTH, 1);
                pool.setInitBillDate(calendar.getTime());
                LOG.info("Init bill date[{}]", pool.getInitBillDate());
                try {
                    investPool.save(pool);
                } catch (SaveException e) {
                    error++;
                    continue;
                }
                success++;
            }
        }
        LOG.info("Total[{}] success[{}] error[{}]", pools.size(), success, error);
    }

    @Override
    public void check() {
        List<InvestmentPool> pools = investPool.queryAll();
        Integer error = 0;
        for (InvestmentPool pool : pools) {
            if (Assert.checkParam(pool.getBillDay()) && Assert.checkParam(pool.getInitBillDate())
                    && Assert.checkParam(pool.getInitMatchTime())) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(pool.getInitMatchTime());
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, pool.getBillDay());
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                if (calendar.getTime().compareTo(pool.getInitBillDate()) != 0) {
                    LOG.info("Pool id[{}] arg0[{}] arg1[{}] date error", pool.getInvestmentPoolId(), calendar.getTime(),
                            pool.getInitBillDate());
                    error++;
                }
            }
        }
        LOG.info("Error[{}]", error);
    }

}
