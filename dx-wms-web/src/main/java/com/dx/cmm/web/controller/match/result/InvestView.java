package com.dx.cmm.web.controller.match.result;

import java.math.BigDecimal;
import java.util.Date;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;

class InvestView extends MatchView {

    /**
     */
    private static final long serialVersionUID = -3465603616281416506L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 日期
     */
    private Date date;

    /**
     * 日期
     */
    private String dateView;

    /**
     * 出借金额
     */
    private BigDecimal initAmount;

    /**
     * 出借金额
     */
    private String initAmountView;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

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

    public InvestView setDateView() {
        setDateView(DateUtils.formatForDay(getDate()));
        return this;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

    public String getInitAmountView() {
        return initAmountView;
    }

    public InvestView setInitAmountView() {
        setInitAmountView(AmountUtils.format(getInitAmount(), ZERO));
        return this;
    }

    public void setInitAmountView(String initAmountView) {
        this.initAmountView = initAmountView;
    }

}
