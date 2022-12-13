package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.result.InvestResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;

/**
 * 
 * 债权总价值运算
 *
 * @author tony
 */
@Service("totalTransCalc")
public class TotalTransCalc extends CalcAbs<InvestmentFund, BigDecimal> {

    @Autowired
    private Result<InvestResults> investResult;

    @Override
    public BigDecimal calc(InvestmentFund fund) {
        List<MatchResult> results = investResult.queryArray(fund.getInvestmentPoolId(), fund.getCurrentPeriod());
        LOG.info("result is ready result={}",JSON.toJSON(results));
        BigDecimal total = BigDecimal.ZERO;
        for (MatchResult result : results) {
            total = total.add(result.getTransferTotalAmount());
        }
        return total;
    }

}
