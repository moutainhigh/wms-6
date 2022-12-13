package com.dx.cmm.service.rules;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.Rule;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 信贷端-匹配规则服务<br>
 * 信贷端-匹配规则服务s
 *
 * @author tony
 */
@Service
public class CreditRuler extends RulerRegister {

    @Override
    public Boolean supports(ParamRuler param) {
        return Assert.equals(param.getRule(), Rule.BORROW_MATCH_RULE);
    }

}
