package com.dx.cmm.service.credit;

import java.math.BigDecimal;

public class CreditMatchResult extends CreditPoolResult {

    /**
     */
    private static final long serialVersionUID = -4814863147870765407L;

    /**
     * 匹配编号
     */
    private Long matchId;

    /**
     * 转让债权价值
     */
    private BigDecimal transAmount;

    /**
     * 支付对价
     */
    private BigDecimal payAmount;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

}
