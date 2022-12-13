package com.dx.cmm.service.calc;

import java.util.Date;

public class DateParamCalc extends BaseCalc {

    /**
     */
    private static final long serialVersionUID = 3489457744575166273L;

    /**
     * 参考日期
     */
    private Date refDate;

    /**
     * 参考日
     */
    private Integer refDay;

    public DateParamCalc(Date refDate, Integer refDay) {
        setRefDate(refDate);
        setRefDay(refDay);
    }

    public Date getRefDate() {
        return refDate;
    }

    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    public Integer getRefDay() {
        return refDay;
    }

    public void setRefDay(Integer refDay) {
        this.refDay = refDay;
    }

}
