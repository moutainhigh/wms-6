package com.dx.cmm.service.restorer;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.CreditIntParamCalc;
import com.dx.cmm.service.calc.RepayParamCalc;
import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.MatchResult;

@Service("resultErrorRestorer")
public class ResultErrorRestorer extends RestorerAbs<MatchResult> {

    @Autowired
    private Calc<CreditIntParamCalc, BigDecimal> creditIntCalc;

    @Autowired
    private Calc<RepayParamCalc, BigDecimal> creditRepayCalc;

    @Autowired
    private Restorer<InvestmentFund> investFundRestorer;

    @Override
    public void repair(MatchResult result) throws RepairException {
        CreditorPool pool = creditPool.query(result.getCreditorPoolId());
        CreditorFund creditorFund = creditFund.query(result.getCreditorPoolId(), result.getReportDate());
        List<MatchResult> results = creditResult.queryArray(result.getCreditorPoolId(), result.getReportDate());
        BigDecimal interest = creditIntCalc.calc(new CreditIntParamCalc(result, results, pool, creditorFund));
        BigDecimal repay = creditRepayCalc.calc(new RepayParamCalc(result, results, pool));
        BigDecimal capital = repay.subtract(interest);
        result.setTransferEaAmount(repay).setTransferEaInterestAmount(interest).setTransferEaCapitalAmount(capital)
                .setUpdateTime();
        try {
            LOG.info("Result id[{}] need update", result.getMatchResultId());
            creditResult.save(result);
            InvestmentFund investmentFund = investFund.query(result.getInvestmentPoolId(), result.getCurrentPeriod());
            investFundRestorer.repair(investmentFund);
        } catch (SaveException | RepairException e) {
            throw new SaveException(e.getMessage());
        }
    }

}
