package com.dx.cmm.web.controller.credit;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.credit.CreditStatDetailResult;
import com.dx.common.service.utils.AmountUtils;

public class StatDetailResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6714343128634508719L;

    /**
     * 还款日
     */
    private Integer repayDay;

    /**
     * 剩余债权
     */
    private BigDecimal remainAmout;

    /**
     * 剩余债权
     */
    private String remainAmoutView;

    /**
     * 匹配债权
     */
    private BigDecimal matchAmount;

    /**
     * 匹配债权
     */
    private String matchAmountView;

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

    public StatDetailResult(CreditStatDetailResult result) {
        BeanUtils.copyProperties(result, this);
        setAmountView(AmountUtils.format(getAmount(), "0.00"));
        setRemainAmoutView(AmountUtils.format(getRemainAmout(), "0.00"));
        setMatchAmountView(AmountUtils.format(getMatchAmount(), "0.00"));
    }

    public Integer getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Integer repayDay) {
        this.repayDay = repayDay;
    }

    public BigDecimal getRemainAmout() {
        return remainAmout;
    }

    public void setRemainAmout(BigDecimal remainAmout) {
        this.remainAmout = remainAmout;
    }

    public String getRemainAmoutView() {
        return remainAmoutView;
    }

    public void setRemainAmoutView(String remainAmoutView) {
        this.remainAmoutView = remainAmoutView;
    }

    public BigDecimal getMatchAmount() {
        return matchAmount;
    }

    public void setMatchAmount(BigDecimal matchAmount) {
        this.matchAmount = matchAmount;
    }

    public String getMatchAmountView() {
        return matchAmountView;
    }

    public void setMatchAmountView(String matchAmountView) {
        this.matchAmountView = matchAmountView;
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
