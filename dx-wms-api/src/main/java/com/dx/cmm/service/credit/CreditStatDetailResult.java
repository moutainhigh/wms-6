package com.dx.cmm.service.credit;

import java.math.BigDecimal;

/**
 * 
 * 债权统计明细
 *
 * @author tony
 */
public class CreditStatDetailResult extends CreditStatResult {

    /**
     */
    private static final long serialVersionUID = 1996251022880484628L;

    /**
     * 还款日
     */
    private Integer repayDay;

    /**
     * 剩余债权
     */
    private BigDecimal remainAmout;

    /**
     * 匹配债权
     */
    private BigDecimal matchAmount;

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

    public BigDecimal getMatchAmount() {
        return matchAmount;
    }

    public void setMatchAmount(BigDecimal matchAmount) {
        this.matchAmount = matchAmount;
    }

}
