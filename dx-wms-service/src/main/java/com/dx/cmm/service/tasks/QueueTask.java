package com.dx.cmm.service.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.users.User;

abstract class QueueTask extends SyncTask {

    @Autowired
    User<InvestmentPool> investUser;
}
