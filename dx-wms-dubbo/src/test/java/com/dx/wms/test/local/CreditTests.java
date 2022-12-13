package com.dx.wms.test.local;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.credit.CreditPoolParam;
import com.dx.cmm.service.credit.CreditStatParam;
import com.dx.cmm.service.credit.ICreditService;
import com.dx.framework.dal.pagination.Pagination;
import com.google.gson.Gson;

public class CreditTests extends BaseTest {

    @Autowired
    private ICreditService creditService;

    @Test
    public void stat() {
        CreditStatParam param = new CreditStatParam();
        param.setCreateDateBegin(new Date());
        param.setCreateDateEnd(new Date());
        Pagination page = new Pagination(10, 1);
        System.out.println(new Gson().toJson(creditService.queryStat(param, page)));
    }

    @Test
    public void pool() {
        CreditPoolParam param = new CreditPoolParam();
        Pagination page = new Pagination(10, 1);
        System.out.println(new Gson().toJson(creditService.queryPool(param, page)));
    }

    @Test
    public void match() {
        System.out.println(new Gson().toJson(creditService.queryLenderFirst("L0535011509060002-001")));
    }
}
