package com.dx.op.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.service.ports.CreditPort;
import com.dx.cmm.service.ports.InvestPort;
import com.dx.cmm.service.ports.Ports;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class PortTests extends BaseTest {

    @Autowired
    private Ports<CreditPort> creditPorts;

    @Test
    public void creditPorts() {
        System.out.println(new Gson().toJson(creditPorts.current(16)));
    }

    @Autowired
    private Ports<InvestPort> investPorts;

    @Test
    public void investPort() {
        System.out.println(new Gson().toJson(investPorts.current(16)));
    }
}
