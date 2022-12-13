package com.dx.cmm.service.reports;

import java.io.Serializable;

import com.dx.cmm.enums.ReportType;

/**
 * 
 * 参数报告
 *
 * @author tony
 */
public class ParamReport implements Serializable {

    /**
     */
    private static final long serialVersionUID = -6742636048734607654L;

    /**
     * 业务编号
     */
    private String bizCode;

    /**
     * 报告类型
     */
    private ReportType type;

    /**
     * 报告日
     */
    private Integer billDay;

    public ParamReport() {

    }

    public ParamReport(String bizCode, ReportType type) {
        setBizCode(bizCode);
        setType(type);
    }

    public ParamReport(ReportType type,Integer billDay) {
        setType(type);
        setBillDay(billDay);
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public ReportType getType() {
        return type;
    }

    public void setType(ReportType type) {
        this.type = type;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

}
