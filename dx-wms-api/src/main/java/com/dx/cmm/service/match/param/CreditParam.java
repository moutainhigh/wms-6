package com.dx.cmm.service.match.param;

import java.util.List;

class CreditParam extends MatchParam {

    /**
     */
    private static final long serialVersionUID = -4048122250157445813L;

    /**
     * 投资池编号
     */
    private Long poolId;

    /**
     * 投资用户编号
     */
    private Long userId;

    /**
     * 用户编号集合
     */
    private List<Long> userIds;

    /**
     * 还款日
     */
    private Integer repayDay;

    /**
     * 排序
     */
    private String sort;

    /**
     * 剩余期限-起
     */
    private Integer remainPeriodFrom;

    /**
     * 剩余期限-止
     */
    private Integer remainPeriodTo;

    /**
     * 是否过滤
     */
    private Integer isFilter = 1;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Integer getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Integer repayDay) {
        this.repayDay = repayDay;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getRemainPeriodFrom() {
        return remainPeriodFrom;
    }

    public void setRemainPeriodFrom(Integer remainPeriodFrom) {
        this.remainPeriodFrom = remainPeriodFrom;
    }

    public Integer getRemainPeriodTo() {
        return remainPeriodTo;
    }

    public void setRemainPeriodTo(Integer remainPeriodTo) {
        this.remainPeriodTo = remainPeriodTo;
    }

    public Integer getIsFilter() {
        return isFilter;
    }

    public void setIsFilter(Integer isFilter) {
        this.isFilter = isFilter;
    }

}
