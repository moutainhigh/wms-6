package com.dx.cmm.service.rules;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

abstract class RulersAbs<P, R> implements Rulers<P, R> {

    @Autowired
    IMatchRuleGroupDao matchRuleGroupDao;

    @Autowired
    IMatchRuleGroupDetailDao matchRuleGroupDetailDao;

    @Autowired
    IMatchRuleDetailDao matchRuleDetailDao;

    MatchRuleGroup query(String key) {
        return matchRuleGroupDao.query(key);
    }

    Integer parseDay(Date param) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(param);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    List<String> parseExp(String exp) {
        List<String> results = new ArrayList<>();
        int i = 0;
        int start = 0;
        int end = 0;
        char[] chars = exp.toCharArray();
        for (char c : chars) {
            if (c == '{') {
                start = i;
            }
            if (c == '}') {
                end = i + 1;
                results.add(String.copyValueOf(chars, start, end - start));
            }
            i++;
        }
        return results;
    }

}
