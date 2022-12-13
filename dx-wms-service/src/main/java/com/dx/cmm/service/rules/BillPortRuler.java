package com.dx.cmm.service.rules;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 
 * 账单端-匹配规则服务
 *
 * @author tony
 */
@Service("billPortRuler")
public class BillPortRuler extends PortAbs {

    private static final String KEY = "billPortRuler";

    @Override
    public Integer parse(Date param) {
        return parse(param, KEY);
    }

}
