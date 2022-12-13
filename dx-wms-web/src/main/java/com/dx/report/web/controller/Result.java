package com.dx.report.web.controller;

import java.io.Serializable;
import java.util.Date;

import com.dx.common.service.utils.DateUtils;

class Result implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2430480534619218560L;

    /**
     * 日期
     */
    private Date date;

    /**
     * 日期
     */
    private String dateView;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateView() {
        return dateView;
    }

    public void setDateView(String dateView) {
        this.dateView = dateView;
    }

    public void setDateView() {
        setDateView(DateUtils.formatForDay(getDate(), "-"));
    }

}
