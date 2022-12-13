package com.dx.cmm.service.calc;

import java.util.Date;

public class MonthParamCalc extends BaseCalc {

    /**
     */
    private static final long serialVersionUID = 4343467369829781772L;

    private Date arg0;

    private Date arg1;

    public MonthParamCalc(Date arg0, Date arg1) {
        setArg0(arg0);
        setArg1(arg1);
    }

    public Date getArg0() {
        return arg0;
    }

    public void setArg0(Date arg0) {
        this.arg0 = arg0;
    }

    public Date getArg1() {
        return arg1;
    }

    public void setArg1(Date arg1) {
        this.arg1 = arg1;
    }

}
