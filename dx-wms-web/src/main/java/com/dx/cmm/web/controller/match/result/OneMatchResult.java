package com.dx.cmm.web.controller.match.result;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dx.cmm.service.match.MatchCache;
import com.dx.cmm.service.match.result.Match;
import com.dx.common.service.utils.Assert;

public class OneMatchResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1757354774473598143L;

    private Credit credit;

    private BigDecimal matchAmount = BigDecimal.ZERO;

    public OneMatchResult(Credit credit, MatchCache cache) {
        setCredit(credit);
        for (Match match : cache.getMatches()) {
            if (Assert.equals(match.getCreditPoolId(), credit.getPoolId())) {
                setMatchAmount(match.getMatchAmount());
            }
        }
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public BigDecimal getMatchAmount() {
        return matchAmount;
    }

    public void setMatchAmount(BigDecimal matchAmount) {
        this.matchAmount = matchAmount;
    }

}
