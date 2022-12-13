package com.dx.cmm.service.restorer;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.InvestIntParamCalc;
import com.dx.cmm.service.funds.InvestmentFund;

@Service("investFundRestorer")
public class InvestFundRestorer extends RestorerAbs<InvestmentFund> {

    @Autowired
    private Calc<InvestIntParamCalc, BigDecimal> investIntCalc;

    @Override
    public void repair(InvestmentFund fund) throws RepairException {
        fund.setNextInterestTotalAmount(investIntCalc.calc(new InvestIntParamCalc(fund)));
        fund.setNextPrincalTotalAmount(fund.getTotalCapital());
        fund.setNextRepaymentTotalAmount(fund.getTotalEa());
        fund.setNextTransferTotalAmount(fund.getTotalAmount().add(fund.getNextInterestTotalAmount()));
        fund.setUpdateTime();
        try {
            LOG.info("Fund id[{}] need to repair", fund.getInvestmentFundId());
            investFund.save(fund);
        } catch (SaveException e) {
            throw new RepairException("Repair fund error");
        }
    }
}
