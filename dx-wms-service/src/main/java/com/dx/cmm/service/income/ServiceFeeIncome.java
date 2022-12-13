package com.dx.cmm.service.income;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.InvestmentFund;

@Service("serviceFeeIncome")
public class ServiceFeeIncome extends InvestIncomes<InvestmentFund>{

    @Override
    public void inject(InvestmentFund fund) {
    
    }

}
