package com.dx.cmm.service.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;

public abstract class SyncTask extends TaskAbs {

    @Autowired
    BizBase<InvestmentPool> investBizBase;

    @Autowired
    BizBase<CreditorPool> creditBizBase;
}
