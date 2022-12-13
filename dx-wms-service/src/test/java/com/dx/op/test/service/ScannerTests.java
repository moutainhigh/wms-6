package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.scanner.Scanner;
import com.dx.wms.common.test.BaseTest;

public class ScannerTests extends BaseTest {

    @Autowired
    private Scanner creditScanner;

    @Test
    public void credit() {
        creditScanner.scanner();
    }

    @Autowired
    private Scanner investScanner;

    @Test
    public void invest() {
        investScanner.scanner();
    }

    @Autowired
    private Scanner resultScanner;

    @Test
    public void result() {
        resultScanner.scanner();
    }

    @Autowired
    private Scanner investFundScanner;

    @Test
    public void fund() {
        investFundScanner.scanner();
    }

    @Autowired
    private Scanner resultErrorScanner;

    @Test
    public void resultError() {
        resultErrorScanner.scanner();
    }
}
