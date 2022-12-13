package com.dx.cmm.service.stats;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dx.common.service.utils.Assert;

/**
 * 
 * 统计结果Dto<br>
 * 统计结果Dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResultCounter implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7233765488454684193L;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 总计
     */
    private Integer totalCount;

    /**
     * 统计明细集合
     */
    private List<ItemCounter> items;

    public ResultCounter() {

    }

    public ResultCounter(List<ItemCounter> items) {
        setItems(items);
        Integer totalCount = 0;
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (ItemCounter item : getItems()) {
            totalCount = totalCount + (!Assert.checkParam(item.getNum()) ? 0 : item.getNum());
            totalAmount = totalAmount
                    .add(!Assert.checkParam(item.getTotalAmount()) ? BigDecimal.ZERO : item.getTotalAmount());
        }
        setTotalCount(totalCount);
        setTotalAmount(totalAmount);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<ItemCounter> getItems() {
        return items;
    }

    public void setItems(List<ItemCounter> items) {
        this.items = items;
    }

}
