package com.dx.cmm.service.match.param;

import java.math.BigDecimal;
import java.util.List;

import com.dx.cmm.service.match.MatchBase;
import com.dx.common.service.utils.Assert;

class MatchParam extends MatchBase {

    /**
     */
    private static final long serialVersionUID = 1326516101518065050L;

    private static final BigDecimal UNIT = new BigDecimal("10000");

    /**
     * 筛选金额-起
     */
    private BigDecimal filterAmountFrom;

    /**
     * 筛选金额-止
     */
    private BigDecimal filterAmountTo;

    /**
     * 资金池编号集合
     */
    private List<Long> poolIds;

    public BigDecimal getFilterAmountFrom() {
        return filterAmountFrom;
    }

    public void setFilterAmountFrom(BigDecimal filterAmountFrom) {
        this.filterAmountFrom = filterAmountFrom;
    }

    private MatchParam setFilterAmountFrom() {
        if (Assert.checkParam(getFilterAmountFrom())) {
            setFilterAmountFrom(getFilterAmountFrom().multiply(UNIT));
        }
        return this;
    }

    public BigDecimal getFilterAmountTo() {
        return filterAmountTo;
    }

    public void setFilterAmountTo(BigDecimal filterAmountTo) {
        this.filterAmountTo = filterAmountTo;
    }

    private MatchParam setFilterAmountTo() {
        if (Assert.checkParam(getFilterAmountTo())) {
            setFilterAmountTo(getFilterAmountTo().multiply(UNIT));
        }
        return this;
    }

    public List<Long> getPoolIds() {
        return poolIds;
    }

    public void setPoolIds(List<Long> poolIds) {
        this.poolIds = poolIds;
    }

    public void init(List<Long> poolIds) {
        setPoolIds(poolIds);
    }
    
    public void amount(){
        setFilterAmountFrom().setFilterAmountTo();
    }

}
