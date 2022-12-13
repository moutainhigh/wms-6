package com.dx.cmm.service.match.result;

import java.math.BigDecimal;
import java.util.List;

import com.dx.cmm.service.result.InvestResults;

public class ExpInvestResult extends InvestResult {

    /**
     */
    private static final long serialVersionUID = 7453399292720030826L;

    /**
     * 出借金额
     */
    private BigDecimal initAmount;

    /**
     * 退回债权数
     */
    private Integer count;

    /**
     * 冻结期数
     */
    private Integer initPeriod;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 匹配详情
     */
    private List<InvestResults> results;

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public List<InvestResults> getResults() {
        return results;
    }

    public void setResults(List<InvestResults> results) {
        this.results = results;
    }

}
