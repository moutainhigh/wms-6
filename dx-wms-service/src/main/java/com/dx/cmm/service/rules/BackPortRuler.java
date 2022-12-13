package com.dx.cmm.service.rules;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 
 * 回款匹配-触发规则
 *
 * @author tony
 */
@Service("backPortRuler")
public class BackPortRuler extends PortAbs {

    private static final String KEY = "backPortRuler";

    @Override
    public Integer parse(Date param) {
        return parse(param, KEY);
    }
}
