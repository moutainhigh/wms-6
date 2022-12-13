package com.dx.cmm.service.stats;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 统计子项<br>
 * 统计子项
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ItemCounter implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8152287821106171776L;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 记录数
     */
    private Integer num;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 产品类型
     */
    private Long productId;

    /**
     * 剩余总价值
     */
    private BigDecimal remainTotalAmount;

    /**
     * 已使用总价值
     */
    private BigDecimal usedTotalAmount;

    /**
     * 匹配账单日
     */
    private Integer matchDay;

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getRemainTotalAmount() {
        return remainTotalAmount;
    }

    public void setRemainTotalAmount(BigDecimal remainTotalAmount) {
        this.remainTotalAmount = remainTotalAmount;
    }

    public BigDecimal getUsedTotalAmount() {
        return usedTotalAmount;
    }

    public void setUsedTotalAmount(BigDecimal usedTotalAmount) {
        this.usedTotalAmount = usedTotalAmount;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

}
