package com.dx.cmm.service.calc;

import java.math.BigDecimal;

/**
 * 
 * 日期结果
 *
 * @author tony
 * 
 */
public class DateResultCalc extends BaseCalc {

    /**
     */
    private static final long serialVersionUID = -4885099261620393965L;

    /**
     * 总天数
     */
    private Integer totalDays;

    /**
     * 前置天数
     */
    private Integer preDays;

    /**
     * 前置比例
     */
    private BigDecimal preRate;

    /**
     * 后置天数
     */
    private Integer sufDays;

    /**
     * 后置比例
     */
    private BigDecimal sufRate;

    public DateResultCalc(Integer totalDays, Integer preDays, BigDecimal preRate, Integer sufDays, BigDecimal sufRate) {
        setTotalDays(totalDays);
        setPreDays(preDays);
        setPreRate(preRate);
        setSufDays(sufDays);
        setSufRate(sufRate);
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Integer getPreDays() {
        return preDays;
    }

    public void setPreDays(Integer preDays) {
        this.preDays = preDays;
    }

    public BigDecimal getPreRate() {
        return preRate;
    }

    public void setPreRate(BigDecimal preRate) {
        this.preRate = preRate;
    }

    public Integer getSufDays() {
        return sufDays;
    }

    public void setSufDays(Integer sufDays) {
        this.sufDays = sufDays;
    }

    public BigDecimal getSufRate() {
        return sufRate;
    }

    public void setSufRate(BigDecimal sufRate) {
        this.sufRate = sufRate;
    }

}
