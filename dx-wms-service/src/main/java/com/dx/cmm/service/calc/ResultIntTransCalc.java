package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("resultIntTransCalc")
public class ResultIntTransCalc extends IntCalc<ResultIntParamCalc> {

    @Override
    public BigDecimal calc(ResultIntParamCalc param) {
        DateResultCalc result = dateCalc.calc(new DateParamCalc(param.getRefDate(), param.getRefDay()));
        return param.getResult().getTransferEaInterestAmount().multiply(result.getPreRate()).setScale(2,
                BigDecimal.ROUND_HALF_UP);
    }

}
