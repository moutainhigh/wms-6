package com.dx.cmm.service.queues;

import java.math.BigDecimal;

import com.dx.cmm.service.stats.ResultStat;
import com.dx.common.service.utils.AmountUtils;

/**
 * 
 * 统计队列
 *
 * @author tony
 */
public class StatQueue extends ResultStat {

    /**
     */
    private static final long serialVersionUID = -3020392418436534563L;

    /**
     * 总计
     */
    private Integer totalCount;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    private String totalAmountView;

    public Integer getTotalCount() {
        return totalCount;
    }

    public StatQueue setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public StatQueue setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getTotalAmountView() {
        return totalAmountView;
    }

    public StatQueue setTotalAmountView(String totalAmountView) {
        this.totalAmountView = totalAmountView;
        return this;
    }

    StatQueue setTotalAmountView() {
        return setTotalAmountView(AmountUtils.format(getTotalAmount(), "-"));
    }

    StatQueue() {

    }

    public StatQueue(Integer index, BigDecimal totalAmount, Integer totalCount) {
        setTotalAmount(totalAmount).setTotalCount(totalCount).setTotalAmountView().setIndex(index).setStatName("总计");
    }

}
