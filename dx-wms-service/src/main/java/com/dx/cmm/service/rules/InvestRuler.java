package com.dx.cmm.service.rules;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.Rule;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 理财端-匹配规则服务<br>
 * 理财端-匹配规则服务
 *
 * @author tony
 */
@Service
public class InvestRuler extends RulerRegister {

    @Override
    public Boolean supports(ParamRuler param) {
        return Assert.equals(param.getRule(), Rule.LENDER_MATCH_RULE);
    }

}
