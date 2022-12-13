package com.dx.cmm.service.invest;

import java.util.Date;

class InvestBaseResult extends InvestBase {

    /**
     */
    private static final long serialVersionUID = 173389873277663349L;

    /**
     * 日期
     */
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
