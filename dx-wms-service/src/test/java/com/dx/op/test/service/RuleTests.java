package com.dx.op.test.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.enums.Rule;
import com.dx.cmm.service.rules.ParamRuler;
import com.dx.cmm.service.rules.ResultRuler;
import com.dx.cmm.service.rules.RulerObserver;
import com.dx.cmm.service.rules.Rulers;
import com.dx.cmm.service.tasks.AccountParamTask;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class RuleTests extends BaseTest {

    @Autowired
    private RulerObserver observer;

    @Test
    public void lenderAccountRule() {
        ParamRuler queryDto = new ParamRuler(new AccountParamTask());
        ResultRuler resultDto = observer.parse(queryDto);
        System.out.println(new Gson().toJson(resultDto));
        System.out.println(resultDto.getResults());
    }

    @Test
    public void detail() {
        ParamRuler matchRuleQueryDto = new ParamRuler(new BigDecimal("50000"), Rule.BORROW_MATCH_RULE.getCode(),
                BizCategory.CREDIT.getCode().toString());
        System.out.println(new Gson().toJson(observer.parse(matchRuleQueryDto)));
    }

    @Autowired
    private Rulers<Date, Integer> backPortRuler;

    @Test
    public void backMatchRuler() {
        System.out.println(backPortRuler.parse(DateUtils.parseForDay("2016-03-21")));
    }

    @Autowired
    private Rulers<Date, Integer> billPortRuler;
    
    @Test
    public void billPortRuler() {
        System.out.println(billPortRuler.parse(DateUtils.parseForDay("2016-03-21")));
    }
    
    @Autowired
    private Rulers<Date, Integer> replacePortRuler;
    
    @Test
    public void replacePortRuler() {
        System.out.println(replacePortRuler.parse(new Date()));
    }
    

}
