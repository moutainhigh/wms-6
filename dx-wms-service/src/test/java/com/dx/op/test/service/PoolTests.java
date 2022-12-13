package com.dx.op.test.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class PoolTests extends BaseTest {

    @Autowired
    private Pools<CreditorPool> creditPool;

    @Test
    public void creditPool() {
        List<CreditorPool> pools = creditPool.queryArray(1, MatchStatus.PART);
        for (CreditorPool pool : pools) {
            System.out.println(new Gson().toJson(pool));
        }
    }

    @Autowired
    private Pools<InvestmentPool> investPool;

    @Test
    public void investPool() {
        Set<Long> ids = new HashSet<>();
        ids.add(1L);
        System.out.println(new Gson().toJson(investPool.queryArray(ids)));
    }
}
