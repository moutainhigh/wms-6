package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.service.queues.StatQueue;
import com.dx.cmm.service.stats.ItemCounter;
import com.dx.cmm.service.stats.ResultCounter;
import com.dx.common.service.utils.AmountUtils;

/**
 * 
 * 统计结果Vo<br>
 * 统计结果Vo
 *
 * @author tony
 */
public class CountResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2636377281198706319L;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 总金额
     */
    private String totalAmountView;

    /**
     * 总计
     */
    private Integer totalCount;

    /**
     * 统计明细集合
     */
    private List<CountItemVo> items;

    public CountResultVo() {

    }

    public CountResultVo(StatQueue result, Map<String, String> product) {
        try {
            PropertyUtils.copyProperties(this, result);
            //view(result, product);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

    public CountResultVo(ResultCounter result) {
        try {
            PropertyUtils.copyProperties(this, result);
            view(result);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

    private void view(ResultCounter result) {
        List<CountItemVo> items = new ArrayList<CountItemVo>();
        for (ItemCounter item : result.getItems()) {
            items.add(new CountItemVo(item));
        }
        setItems(items);
    }

    private void view(ResultCounter result, Map<String, String> product) {
        setTotalAmountView(AmountUtils.format(getTotalAmount(), "0.00"));
        List<CountItemVo> items = new ArrayList<CountItemVo>();
        for (ItemCounter item : result.getItems()) {
            items.add(new CountItemVo(item, product));
        }
        setItems(items);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmountView() {
        return totalAmountView;
    }

    public void setTotalAmountView(String totalAmountView) {
        this.totalAmountView = totalAmountView;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<CountItemVo> getItems() {
        return items;
    }

    public void setItems(List<CountItemVo> items) {
        this.items = items;
    }

}
