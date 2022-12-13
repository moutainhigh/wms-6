package com.dx.cmm.service.rules;

import java.util.Date;

import org.springframework.stereotype.Service;
/**
 * 
 * 债权替换-触发规则
 *
 * @author tony
 */
@Service("replacePortRuler")
public class ReplacePortRuler extends PortAbs {

    private static final String KEY = "replacePortRuler";

    @Override
    public Integer parse(Date param) {
        return parse(param, KEY);
    }

}
