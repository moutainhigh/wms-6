package com.dx.cmm.service.match.result;

import java.math.BigDecimal;

/**
 * 
 * 债权结果
 *
 * @author tony
 */
public class CreditResult extends MatchResult {

    /**
     */
    private static final long serialVersionUID = -6510286138237669525L;

    /**
     * 当前债权
     */
    private BigDecimal currentAmount;

    /**
     * 还款期数
     */
    private Integer initPeriod;

    /**
     * 剩余期数
     */
    private Integer remainPeriod;

    /**
     * 年利率
     */
    private BigDecimal rateYear;

    /**
     * 初始金额
     */
    private BigDecimal initAmount;

    /**
     * 用户编号
     */
    private Long userId;

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CreditResult) {
            if (this.getPoolId().equals(((CreditResult) obj).getPoolId())) {
                return true;
            }
        }
        return false;
    }

}
