package com.dx.cmm.service.scanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.restorer.RepairException;
import com.dx.cmm.service.restorer.Restorer;

@Service("investFundScanner")
public class InvestFundScanner extends ScannerAbs {

    @Autowired
    private Restorer<InvestmentFund> investFundRestorer;

    @Override
    public void scanner() {
        List<InvestmentFund> funds = investFund.queryArray(InvestmentFund.ERROR);
        Integer error = 0;
        Integer repair = 0;
        for (InvestmentFund fund : funds) {
            error++;
            try {
                investFundRestorer.repair(fund);
                repair++;
            } catch (RepairException e) {
                LOG.error("Repair fund error[{}]", e.getMessage());
            }
        }
        LOG.info("Error[{}],repair[{}]", error, repair);
    }
}
