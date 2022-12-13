package com.dx.cmm.service.funds;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 
 * 基础资金
 *
 * @author tony
 */
public class Fund extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -7301586682176162302L;

    public static final Integer IS_CURRENT = 1;

    public static final Integer NO_CURRENT = 0;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 是否当期:{1:"是",0:"否"}
     */
    private Integer isCurrent = IS_CURRENT;

    /**
     * 报告日
     */
    private Date reportDay;

    @Column(name = "current_period")
    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public Fund setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
        return this;
    }

    public Fund nextCurrentPeriod() {
        return setCurrentPeriod(getCurrentPeriod() + 1);
    }

    @Column(name = "is_current")
    public Integer getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    @Column(name = "report_day")
    public Date getReportDay() {
        return reportDay;
    }

    public Fund setReportDay(Date reportDay) {
        this.reportDay = reportDay;
        return this;
    }

    public Fund setReportDay(Date initDate, Integer currentPeriod) {
        Calendar init = Calendar.getInstance();
        init.setTime(initDate);
        init.add(Calendar.MONTH, currentPeriod - 1);
        return setReportDay(init.getTime());
    }
}
