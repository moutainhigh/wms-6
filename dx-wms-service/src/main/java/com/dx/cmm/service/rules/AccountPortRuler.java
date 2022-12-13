package com.dx.cmm.service.rules;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 
 * 账户级别-触发规则
 *
 * @author tony
 */
@Service("accountPortRuler")
public class AccountPortRuler extends AccountRuler<Date, Boolean> {

    private static final String KEY = "accountPortRuler";

    @Override
    public Boolean parse(Date param) {
        MatchRuleGroup group = query(KEY);
        return parseDay(param).equals(Integer.valueOf(group.getExp()));
    }

}
