package com.dx.cmm.service.rules;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.common.service.utils.Assert;

abstract class PortAbs extends RulersAbs<Date, Integer> {

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger("port.rulers");

    Integer parse(Date param, String key) {
        Integer arg = parseDay(param);
        MatchRuleGroup detail = query(key);
        List<String> exps = parseExp(detail.getExp());
        for (String exp : exps) {
            List<Integer> params = parseParam(exp);
            if (params.get(0).compareTo(arg) <= 0 && params.get(1).compareTo(arg) >= 0) {
                return params.get(2);
            }

        }
        return null;
    }

    

    private List<Integer> parseParam(String exp) {
        String[] array = exp.split("\\D+");
        List<Integer> params = new LinkedList<Integer>();
        for (String param : array) {
            if (Assert.checkParam(param)) {
                params.add(Integer.valueOf(param));
            }
        }
        return params;
    }
}
