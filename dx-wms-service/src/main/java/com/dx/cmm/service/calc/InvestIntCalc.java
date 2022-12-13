 package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 投资利息运算
 *
 * @author tony
 */
@Service("investIntCalc")
public class InvestIntCalc extends IntCalc<InvestIntParamCalc> {

    @Autowired
    private Calc<DateParamCalc, DateResultCalc> dateCalc;

    @Override
    public BigDecimal calc(InvestIntParamCalc param) {
        if (param.getCurrentPeriod() > 1) {
            return param.getTotalInterest();
        }
        DateResultCalc result = dateCalc.calc(new DateParamCalc(param.getRefDate(), param.getRefDay()));
        return param.getTotalInterest().multiply(result.getSufRate()).setScale(2, BigDecimal.ROUND_HALF_UP);

    }

}
