package com.dx.cmm.service.income;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.IncomeCategory;
import com.dx.cmm.enums.IncomeType;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.common.service.utils.Assert;

@Service("acountFeeIncome")
public class AcountFeeIncome extends InvestIncomes<InvestmentFund> {

    @Override
    public void inject(InvestmentFund fund) throws InjectException {
    	//收益表
        Income income = new Income(fund.getAccountManagementFee(), IncomeCategory.MANAGER_FEE, IncomeType.COMPANY);
        income.setInvestmentPoolId(fund.getInvestmentPoolId());
        income.setIncomeDay(fund.getInvestmentFundDay());
        if (!Assert.checkParam(incomeDao.insert(income))) {
            throw new InjectException();
        }
    }

}
