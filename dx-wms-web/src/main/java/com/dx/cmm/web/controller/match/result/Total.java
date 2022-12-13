package com.dx.cmm.web.controller.match.result;

import java.math.BigDecimal;

import com.dx.cmm.service.match.MatchCache;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;

public class Total extends MatchView {

    /**
     */
    private static final long serialVersionUID = -3745524320970548503L;

    private Integer totalCounts = 0;

    private BigDecimal totalAmounts = BigDecimal.ZERO;

    private String totalAmountsView = ZERO;

    private Integer matchCounts = 0;

    private BigDecimal matchAmounts = BigDecimal.ZERO;

    private BigDecimal remainAmounts = BigDecimal.ZERO;

    private String remainAmountsView = ZERO;

    private BigDecimal needAmounts = BigDecimal.ZERO;

    private String needAmountsView = ZERO;

    private Integer needCounts = 0;

    private Integer port = 0;

    public Total(MatchCache cache) {
        if (Assert.checkParam(cache)) {
            for (Match match : cache.getMatches()) {
                this.matchAmounts = this.matchAmounts.add(match.getMatchAmount());
                if (Assert.checkParam(match.getMatchAmount())) {
                    this.matchCounts = this.matchCounts + 1;
                }
            }
            for (CreditResult credit : cache.getCredits()) {
                this.totalCounts = this.totalCounts + 1;
                this.totalAmounts = this.totalAmounts.add(credit.getUndoAmount());
            }

            for (InvestResult invest : cache.getInvests()) {
                this.needAmounts = this.needAmounts.add(invest.getUndoAmount());
                this.needCounts = this.needCounts + 1;
            }
            setPort(cache.getPort());
        }
        setRemainAmounts();
        setTotalAmountsView();
        setRemainAmountsView();
        setNeedAmountsView();
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public BigDecimal getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(BigDecimal totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public String getTotalAmountsView() {
        return totalAmountsView;
    }

    public void setTotalAmountsView(String totalAmountsView) {
        this.totalAmountsView = totalAmountsView;
    }

    private void setTotalAmountsView() {
        setTotalAmountsView(AmountUtils.format(getTotalAmounts(), ZERO));
    }

    public Integer getMatchCounts() {
        return matchCounts;
    }

    public void setMatchCounts(Integer matchCounts) {
        this.matchCounts = matchCounts;
    }

    public BigDecimal getMatchAmounts() {
        return matchAmounts;
    }

    public void setMatchAmounts(BigDecimal matchAmounts) {
        this.matchAmounts = matchAmounts;
    }

    public BigDecimal getRemainAmounts() {
        return remainAmounts;
    }

    public void setRemainAmounts(BigDecimal remainAmounts) {
        this.remainAmounts = remainAmounts;
    }

    private void setRemainAmounts() {
        setRemainAmounts(getNeedAmounts().subtract(getMatchAmounts()));
    }

    public String getRemainAmountsView() {
        return remainAmountsView;
    }

    public void setRemainAmountsView(String remainAmountsView) {
        this.remainAmountsView = remainAmountsView;
    }

    private void setRemainAmountsView() {
        setRemainAmountsView(AmountUtils.format(getRemainAmounts(), ZERO));
    }

    public BigDecimal getNeedAmounts() {
        return needAmounts;
    }

    public void setNeedAmounts(BigDecimal needAmounts) {
        this.needAmounts = needAmounts;
    }

    public String getNeedAmountsView() {
        return needAmountsView;
    }

    public void setNeedAmountsView(String needAmountsView) {
        this.needAmountsView = needAmountsView;
    }

    private void setNeedAmountsView() {
        setNeedAmountsView(AmountUtils.format(getNeedAmounts(), ZERO));
    }

    public Integer getNeedCounts() {
        return needCounts;
    }

    public void setNeedCounts(Integer needCounts) {
        this.needCounts = needCounts;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
