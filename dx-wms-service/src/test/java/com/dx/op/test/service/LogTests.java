package com.dx.op.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.log.IMatchLogDao;
import com.dx.cmm.service.log.MatchLog;
import com.dx.cmm.service.log.MatchLogService;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class LogTests extends BaseTest {

    @Autowired
    public IMatchLogDao matchLogDao;

    @Test
    public void Test_1() {
        MatchLog ml = new MatchLog();
        // ml.setMatchLogId(20L);
        // ml.setMatchLogId(6L);
        ml.setRelationId(5L);
        ml.setRelationTable("t_investment_pool");
        

        System.out.println(matchLogDao.insert(ml));
    }

    @Test
    public void Test_2() {

        MatchLog ml = new MatchLog();
        ml.setMatchLogId(6L);
        // ml.setMatchLogId(L);
        ml.setLogMsg("haha");
        ml.setRelationId(5L);
        ml.setRelationTable("lala");
        ml.setLogMsg("yaya");
        boolean b = matchLogDao.update(ml);
        System.out.println(b);
        // System.out.println(MatchLogDao.removeById(MatchLog.class,ml.getMatchLogId())
        // );
        System.out.println("=======" + new Gson().toJson(matchLogDao.queryById(MatchLog.class, ml.getMatchLogId())));
        // for(int i= 0 ; i <101; i++){
        // MatchLogDao.insert(ml);
    }

    @Test
    public void TEST_3() {
        List<MatchLog> lists = matchLogDao.queryAll(MatchLog.class);
        for (MatchLog list : lists) {
            list.setDataStatus("A");
            list.setCreateUser(-1L);
            list.setUpdateUser(-1L);
            list.setUpdateTime();
            list.setCreateTime();
            matchLogDao.update(list);
        }
    }

    @Test
    public void TEST_4() {

        // ml.setMatchLogId(400L);
        // ml.setRelationId(5L);
        // ml.setRelationTable("112233".toString());
        // ml.setLogMsg("PIUPIU");
        // ml.setDataStatus("A");
        // ml.setCreateUser(-1L);
        // ml.setUpdateUser(-1L);
        // ml.setUpdateTime();
        // ml.setCreateTime();
        // matchLogDao.removeById(MatchLog.class,ml.getMatchLogId());
        // matchLogDao.update(ml);

        System.out.println(matchLogDao.queryAll(MatchLog.class));

        System.out.println("============" + new Gson().toJson(matchLogDao.queryAll(MatchLog.class)));

    }

    @Autowired
    private MatchLogService<InvestmentPool> matchLogService;

    @Test
    public void test04() {
         
        matchLogService.queryByTable(InvestmentPool.class);
        
        System.out.println("============" + new Gson().toJson(matchLogService.queryByTable(InvestmentPool.class)));
    }
      

    @Autowired
    private MatchLogService<CreditorPool> matchLogService1;

    @Test
    public void test05() {
        matchLogService1.queryByTable(CreditorPool.class,null);
    }
}
