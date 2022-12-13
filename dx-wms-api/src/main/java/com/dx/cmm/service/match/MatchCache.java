package com.dx.cmm.service.match;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;

public class MatchCache extends MatchBase {

    /**
     */
    private static final long serialVersionUID = -6328770264442965067L;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 债权集合
     */
    private Set<CreditResult> credits;

    /**
     * 投资集合
     */
    private Set<InvestResult> invests;

    /**
     * 匹配
     */
    private Set<Match> matches;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * 报告日
     */
    private Date reportDate;

    public MatchCache() {

    }

    public MatchCache(Long userId, Integer port, Date reportDate, Set<InvestResult> invests) {
        setPort(port);
        setReportDate(reportDate);
        setUserId(userId);
        setInvests(invests);
        setCredits(new HashSet<CreditResult>());
        setMatches(new HashSet<Match>());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<CreditResult> getCredits() {
        return credits;
    }

    public void setCredits(Set<CreditResult> credits) {
        this.credits = credits;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Set<InvestResult> getInvests() {
        return invests;
    }

    public void setInvests(Set<InvestResult> invests) {
        this.invests = invests;
    }

}
