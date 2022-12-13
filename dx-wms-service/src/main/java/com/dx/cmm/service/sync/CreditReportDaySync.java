package com.dx.cmm.service.sync;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.funds.ICreditorFundDao;
import com.dx.common.service.utils.Assert;

@Service("creditReportDaySync")
public class CreditReportDaySync extends SyncAbs {

    @Autowired
    private ICreditorFundDao creditorFundDao;
    @Override
    public void sync() {
        List<CreditorFund> funds = creditFund.queryAll();
        for (CreditorFund fund : funds) {
            if (Assert.checkParam(fund.getInitBillDate())) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fund.getInitBillDate());
                calendar.add(Calendar.MONTH, fund.getCurrentPeriod() - 1);
                fund.setReportDay(calendar.getTime());
                creditorFundDao.update(fund);
            }
        }
    }

}
