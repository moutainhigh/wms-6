package com.dx.cmm.service.trans;

import java.io.Serializable;
import java.util.Date;

class TransBaseResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = -1822652736415757333L;
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
