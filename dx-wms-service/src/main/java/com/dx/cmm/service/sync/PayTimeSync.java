package com.dx.cmm.service.sync;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.pools.InvestmentPool;
import com.google.gson.Gson;

@Service("payTimeSync")
public class PayTimeSync extends SyncAbs {



    @Override
    public void sync() {
        LOG.info("Pay start");
        List<InvestmentPool> pools = dalClient.queryForList("batchSync.syncPayTime", null, InvestmentPool.class);
        LOG.info("Pools size[{}]", pools.size());
        for (InvestmentPool pool : pools) {
            pool.pay();
            pool.setUpdateTime();
            LOG.info("Invest pool[{}]", new Gson().toJson(pool));
            investPool.save(pool);
        }

    }

}
