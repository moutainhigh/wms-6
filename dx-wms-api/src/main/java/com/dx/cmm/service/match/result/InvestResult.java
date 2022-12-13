package com.dx.cmm.service.match.result;

import java.util.List;

public class InvestResult extends MatchResult {

    /**
     */
    private static final long serialVersionUID = -7259499258123238138L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 已匹配用户编号集合
     */
    private List<Long> matchUserIds;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getMatchUserIds() {
        return matchUserIds;
    }

    public void setMatchUserIds(List<Long> matchUserIds) {
        this.matchUserIds = matchUserIds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InvestResult) {
            if (this.getPoolId().equals(((InvestResult) obj).getPoolId())) {
                return true;
            }
        }
        return false;
    }
}
