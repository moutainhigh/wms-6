package com.dx.cmm.service.match.result;

import java.math.BigDecimal;

public class BackInvestResult extends InvestResult {

    /**
     */
    private static final long serialVersionUID = -8009149161091875172L;

    /**
     * 出借金额
     */
    private BigDecimal initAmount;

    /**
     * 冻结周期
     */
    private Integer initPeriod;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
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
