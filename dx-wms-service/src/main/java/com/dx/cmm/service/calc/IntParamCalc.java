package com.dx.cmm.service.calc;

import java.util.Date;

/**
 * 
 * 利息参数
 *
 * @author tony
 */
class IntParamCalc extends BaseCalc {

    /**
     */
    private static final long serialVersionUID = -8496955030765954580L;

    /**
     * 参考日期
     */
    private Date refDate;

    /**
     * 参考日
     */
    private Integer refDay;

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
