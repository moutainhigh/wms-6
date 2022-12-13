package com.dx.op.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.match.IMatchService;
import com.dx.cmm.service.match.param.AddCreditParam;
import com.dx.cmm.service.match.param.AddInvestParam;
import com.dx.cmm.service.match.param.BackCreditParam;
import com.dx.cmm.service.match.param.BackInvestParam;
import com.dx.cmm.service.match.result.AddInvestResult;
import com.dx.cmm.service.match.result.BackInvestResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class MatchTests extends BaseTest {

    @Test
    public void testInterest() {
        BigDecimal total = new BigDecimal("23871.90");
        BigDecimal rateMonth = new BigDecimal("0.011231479118809");
        BigDecimal interest = total.multiply(rateMonth).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal eaAmount = new BigDecimal("1339.33");
        BigDecimal capital = eaAmount.subtract(interest);
        System.out.println("interest--> " + interest);
        System.out.println("capital--> " + capital);
    }

    @Test
    public void testPartInterest() {
        BigDecimal part = new BigDecimal("11").divide(new BigDecimal("29"), 15, BigDecimal.ROUND_HALF_UP);
        System.out.println(part);
        BigDecimal interest = new BigDecimal("2249.29");
        System.out.println(part.multiply(interest).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    public static void main(String[] args) {
        BigDecimal rate = new BigDecimal("0.011150894378365");
        BigDecimal total = new BigDecimal("8375.53");
        BigDecimal interest = total.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal capital = new BigDecimal("3848.17").subtract(interest);
        System.out.println(interest);
        System.out.println(capital);
        
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        System.out.println(lists.contains(4));
    }

    @Autowired
    private IMatchService<AddInvestParam, AddCreditParam, AddInvestResult> addMatch;

    @Test
    public void addMatch() {
        AddInvestParam param = new AddInvestParam();
        Pagination page = new Pagination(15, 1);
        System.out.println(addMatch.queryInvest(param, page));
    }

    @Test
    public void cache() {
        System.out.println(addMatch.queryCache(35L));
    }

    @Autowired
    private IMatchService<BackInvestParam, BackCreditParam, BackInvestResult> backMatch;

    @Test
    public void backMatch() {
        System.out.println(new Gson().toJson(backMatch.auto(207L)));
        // backMatch.auto(207L);
    }
}
