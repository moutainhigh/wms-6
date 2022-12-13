package com.dx.cmm.service.ports;

import java.util.Date;

/**
 * 
 * 债权端口
 *
 * @author tony
 */
public class CreditPort extends Port {

    /**
     */
    private static final long serialVersionUID = -8313389734633795388L;

    /**
     * 
     */
    static final String KEY = "port:credit:";

    public CreditPort(){
        
    }
    public CreditPort(Date reportDate) {
        setReportDate(reportDate);
    }

}
