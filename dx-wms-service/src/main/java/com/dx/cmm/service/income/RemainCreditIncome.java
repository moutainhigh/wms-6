package com.dx.cmm.service.income;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.IncomeCategory;
import com.dx.cmm.enums.IncomeType;
import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.result.CreditResults;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.results.Result;
import com.dx.common.service.utils.Assert;

@Service("remainCreditIncome")
public class RemainCreditIncome extends CreditIncomes<CreditorFund> {

    @Autowired
    private Result<CreditResults> creditResult;

    @Override
    public void inject(CreditorFund fund) throws InjectException {
        BigDecimal amount = fund.getLastRepaymentInterestAmount();//上个报告日-已还利息
        if (!Assert.equals(fund.getLastTotalAmount(), fund.getLastTotalUndoAmount())) {
            List<MatchResult> results = creditResult.queryArray(fund.getCreditorPoolId(), fund.getReportDay());
            for (MatchResult result : results) {
                amount = amount.subtract(result.getTransferEaInterestAmount());
            }
        }
        Income income = new Income(amount, IncomeCategory.CREDITOR, IncomeType.INTERMEDIARY);
        income.setCreditorPoolId(fund.getCreditorPoolId());
        income.setIncomeDay(fund.getCreditorFundDay());
        if (!Assert.checkParam(incomeDao.insert(income))) {
            throw new InjectException();
        }
    }

}
