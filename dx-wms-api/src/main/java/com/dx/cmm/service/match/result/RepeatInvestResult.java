package com.dx.cmm.service.match.result;

import java.math.BigDecimal;
import java.util.List;

import com.dx.cmm.service.result.InvestResults;

public class RepeatInvestResult extends InvestResult {

    /**
     */
    private static final long serialVersionUID = -3623271912217210725L;

    /**
     * 初始金额
     */
    private BigDecimal initAmount;

    /**
     * 退回债权数
     */
    private Integer count;

    /**
     * 已匹配金额
     */
    private BigDecimal matchAmount;

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

    public BigDecimal getMatchAmount() {
        return matchAmount;
    }

    public void setMatchAmount(BigDecimal matchAmount) {
        this.matchAmount = matchAmount;
    }

    public List<InvestResults> getResults() {
        return results;
    }

    public void setResults(List<InvestResults> results) {
        this.results = results;
    }

}
