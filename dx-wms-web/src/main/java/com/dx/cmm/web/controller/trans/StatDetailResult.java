package com.dx.cmm.web.controller.trans;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.trans.TransStatDetailResult;
import com.dx.common.service.utils.AmountUtils;

public class StatDetailResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6714343128634508719L;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 统计金额
     */
    private BigDecimal amount;

    /**
     * 统计金额
     */
    private String amountView;

    /**
     * 数量
     */
    private Integer num;

    public StatDetailResult(TransStatDetailResult result) {
        BeanUtils.copyProperties(result, this);
        setAmountView(AmountUtils.format(getAmount(), "0.00"));
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmountView() {
        return amountView;
    }

    public void setAmountView(String amountView) {
        this.amountView = amountView;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
