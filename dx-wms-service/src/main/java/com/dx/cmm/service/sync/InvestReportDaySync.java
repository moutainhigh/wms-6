package com.dx.cmm.service.sync;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.common.service.utils.Assert;

@Service("investReportDaySync")
public class InvestReportDaySync extends SyncAbs {

    @Override
    public void sync() {
        List<InvestmentFund> funds = investFund.queryArray(InvestmentFund.REPORT_NULL);
        for (InvestmentFund fund : funds) {
            if (Assert.checkParam(fund.getInitBillDate())) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fund.getInitBillDate());
                calendar.add(Calendar.MONTH, fund.getCurrentPeriod() - 1);
                fund.setReportDay(calendar.getTime());
                investFund.save(fund);
            }
        }
    }

}
