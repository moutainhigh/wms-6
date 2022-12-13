package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;

@Service("creditResultCalc")
public class CreditResultCalc extends CalcAbs<CreditorPool, List<BigDecimal>> {

    @Autowired
    private Result<CreditResults> creditResult;

    @Autowired
    private Calc<MatchResult, Boolean> resultNextCalc;

    @Override
    public List<BigDecimal> calc(CreditorPool pool) throws SaveException {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal capital = BigDecimal.ZERO;
        List<MatchResult> results = creditResult.queryArray(pool.getCreditorPoolId(), pool.getCurrentReportDate());
        for (MatchResult result : results) {
            total = total.add(result.getTransferTotalAmount());
            capital = capital.add(result.getTransferEaCapitalAmount());
            result.setRateMonth(pool.getRateMonth());
                resultNextCalc.calc(result);
            
        }
        return new ArrayList<BigDecimal>(Arrays.asList(total, capital));
    }
}
