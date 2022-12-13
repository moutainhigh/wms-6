package com.dx.cmm.service.match;

public class InvestMatch extends ResultMatch{

    /**
     */
    private static final long serialVersionUID = 4647494450722183527L;

    /**
     * 出借编号
     */
    String lenderCode;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }
    
}
