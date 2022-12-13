package com.dx.cmm.web.controller.match.result;

import java.util.Date;

import com.dx.common.service.utils.DateUtils;

public class PartInvest extends InvestView{

    /**
     */
    private static final long serialVersionUID = -3128000449436676893L;

    /**
     * 账单日
     */
    private Integer portDay;

    /**
     * 首期账单日
     */
    private Date portDate;

    /**
     * 首期账单日
     */
    private String portDateView;

    /**
     * 冻结周期
     */
    private Integer initPeriod;

    /**
     * 当前期数
     */
    private Integer currentPeriod;
    
    public Integer getPortDay() {
        return portDay;
    }

    public void setPortDay(Integer portDay) {
        this.portDay = portDay;
    }

    public Date getPortDate() {
        return portDate;
    }

    public void setPortDate(Date portDate) {
        this.portDate = portDate;
    }

    public String getPortDateView() {
        return portDateView;
    }

    public void setPortDateView(String portDateView) {
        this.portDateView = portDateView;
    }

    public PartInvest setPortDateView() {
        setPortDateView(DateUtils.formatForDay(getPortDate()));
        return this;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

}
