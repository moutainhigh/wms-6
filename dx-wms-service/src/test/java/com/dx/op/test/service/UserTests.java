package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.users.IMatchUserDao;
import com.dx.cmm.service.users.MatchUser;
import com.dx.cmm.service.users.User;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class UserTests extends BaseTest {

    @Autowired
    private User<InvestmentPool> investUser;

    @Autowired
    private IMatchUserDao matchUserDao;

    @Test
    public void investUser() {
        System.out.println(new Gson().toJson(investUser.query(702L)));
    }

    @Test
    public void db() {
        MatchUser user = matchUserDao.queryById(MatchUser.class, 702L);
        String gStr = new Gson().toJson(user);
        System.out.println(gStr);
        System.out.println(new Gson().fromJson(gStr, MatchUser.class));
        String jStr = JSON.toJSONString(user);
        System.out.println(jStr);
        System.out.println(JSON.parseObject(jStr, MatchUser.class));
    }

}
