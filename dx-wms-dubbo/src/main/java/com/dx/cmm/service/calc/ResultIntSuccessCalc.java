package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("resultIntSuccessCalc")
public class ResultIntSuccessCalc extends IntCalc<ResultIntParamCalc> {

    @Override
    public BigDecimal calc(ResultIntParamCalc param) {
        if (param.getResult().getCurrentPeriod() > 1) {
            return param.getResult().getTransferEaInterestAmount();
        }
        DateResultCalc result = dateCalc.calc(new DateParamCalc(param.getRefDate(), param.getRefDay()));
        return param.getResult().getTransferEaInterestAmount().multiply(result.getSufRate()).setScale(2,
                BigDecimal.ROUND_HALF_UP);
    }

}
