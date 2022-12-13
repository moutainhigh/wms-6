package com.dx.cmm.service.ports;

import java.util.Date;

/**
 * 
 * 投资端口号
 *
 * @author tony
 */
public class InvestPort extends Port {

    /**
     */
    private static final long serialVersionUID = 23064974230622348L;

    /**
     * 
     */
    static final String KEY = "port:invest:";

    public InvestPort() {

    }

    public InvestPort(Date reportDate) {
        setReportDate(reportDate);
    }
}
