package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;
import com.dx.common.service.utils.Assert;

@Service("creditRateCalc")
public class CreditRateCalc extends CalcAbs<Match, BigDecimal> {

    @Autowired
    private Result<CreditResults> creditResult;

    @Override
    public BigDecimal calc(Match param) {
        if (Assert.equals(param.getMatchAmount(), param.getTotalAmount())) {
            BigDecimal rate = BigDecimal.ZERO;
            List<MatchResult> results = creditResult.queryArray(param.getCreditPoolId(), param.getPortDate());
            for (MatchResult result : results) {
                rate = rate.subtract(result.getCreditorRate());
            }
            return rate;
        }
        return param.getMatchAmount().divide(param.getTotalAmount(), 15, BigDecimal.ROUND_HALF_UP);
    }

}
