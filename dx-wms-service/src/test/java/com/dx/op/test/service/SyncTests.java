package com.dx.op.test.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.sync.Sync;
import com.dx.wms.common.test.BaseTest;

public class SyncTests extends BaseTest {

    @Autowired
    private Sync transTimeSync;

    @Test
    public void syncTrans() {
        transTimeSync.sync();
    }

    @Autowired
    private Sync transDataSync;

    @Test
    public void syncTransData() {
        transDataSync.sync();
    }

    @Autowired
    private Sync transBackSync;

    @Test
    public void syncTransBack() {
        transBackSync.sync();
    }

    @Autowired
    private Sync payTimeSync;

    @Test
    public void syncPayTime() {
        payTimeSync.sync();
    }

    @Autowired
    private Sync initBillDaySync;

    @Test
    public void syncInitBillDay() {
        initBillDaySync.sync();
    }

    @Autowired
    private Sync resultReportDaySync;

    @Test
    public void syncResultReportDay() {
        resultReportDaySync.sync();
    }

    @Autowired
    private Sync investReportDaySync;

    @Test
    public void syncInvestReportDay() {
        investReportDaySync.sync();
    }

    @Autowired
    private Sync creditReportDaySync;

    @Test
    public void syncCreditReportDay() {
        creditReportDaySync.sync();
    }

    public static void main(String[] args) {
        BigDecimal trans = new BigDecimal("13958.23");
        BigDecimal total = new BigDecimal("36836.05");
        BigDecimal repay = new BigDecimal("1276.94");
        BigDecimal interest = total.multiply(new BigDecimal("0.011150657854400")).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(interest);
        System.out.println(trans.divide(total, 15, BigDecimal.ROUND_HALF_UP));// .subtract(new
                                                                              // BigDecimal("0.479965170754117"))
        System.out.println(BigDecimal.ONE.subtract(new BigDecimal("0.227129130294915"))
                .subtract(new BigDecimal("0.393942347238643")));
        System.out.println(repay.multiply(new BigDecimal("0.378928522466442")).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out
                .println(interest.multiply(new BigDecimal("0.378928522466442")).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
