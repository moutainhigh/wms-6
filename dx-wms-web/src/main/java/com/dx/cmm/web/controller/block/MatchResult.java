package com.dx.cmm.web.controller.block;

import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.service.IAMService;
import com.dx.cmm.service.match.MatchCache;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;

public class MatchResult extends Result {
    /**
     */
    private static final long serialVersionUID = -4078680211800161682L;

    /**
     * 当前匹配人
     */
    private Long userId;

    /**
     * 当前匹配人
     */
    private String user;

    /**
     * 占用债权数
     */
    private Set<CreditResult> credits;

    /**
     * 占用债权数
     */
    private Integer creditSize;

    /**
     * 占用投资数
     */
    private Set<InvestResult> invests;
    /**
     * 占用投资数
     */
    private Integer investSize;

    public MatchResult() {

    }

    public MatchResult(MatchCache cache, IAMService amService) {
        BeanUtils.copyProperties(cache, this);
        setCreditSize(getCredits().size());
        setInvestSize(getInvests().size());
        setUser(amService.queryUserById(getUserId()).getName());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<CreditResult> getCredits() {
        return credits;
    }

    public void setCredits(Set<CreditResult> credits) {
        this.credits = credits;
    }

    public Integer getCreditSize() {
        return creditSize;
    }

    public void setCreditSize(Integer creditSize) {
        this.creditSize = creditSize;
    }

    public Set<InvestResult> getInvests() {
        return invests;
    }

    public void setInvests(Set<InvestResult> invests) {
        this.invests = invests;
    }

    public Integer getInvestSize() {
        return investSize;
    }

    public void setInvestSize(Integer investSize) {
        this.investSize = investSize;
    }

}
