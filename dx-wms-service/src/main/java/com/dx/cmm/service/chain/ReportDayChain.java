package com.dx.cmm.service.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.ports.CreditPort;
import com.dx.cmm.service.ports.InvestPort;
import com.dx.cmm.service.ports.Ports;
import com.dx.common.service.utils.Assert;

@Service("reportDayChain")
public class ReportDayChain extends BatchChain {

    @Autowired
    private Ports<CreditPort> creditPorts;

    @Autowired
    private Ports<InvestPort> investPorts;

    @Override
    public void next(Integer port) {
        creditPorts.update(port);
        investPorts.update(port);
        if (Assert.checkParam(getNext())) {
            getNext().next(port);
        }

    }

}
