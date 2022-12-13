package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.service.stats.ItemCounter;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 统计子项Vo
 *
 * @author tony
 */
public class CountItemVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -1775638583436244048L;

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
     * 总金额
     */
    private String totalAmountView;

    /**
     * 产品类型
     */
    private Long productId;

    /**
     * 产品类型
     */
    private String productView;

    /**
     * 剩余总价值
     */
    private BigDecimal remainTotalAmount;

    /**
     * 剩余总价值
     */
    private String remainTotalAmountView;

    /**
     * 已使用总价值
     */
    private BigDecimal usedTotalAmount;

    /**
     * 已使用总价值
     */
    private String usedTotalAmountView;

    /**
     * 匹配账单日
     */
    private Integer matchDay;

    public CountItemVo() {

    }

    public CountItemVo(ItemCounter item) {
        try {
            PropertyUtils.copyProperties(this, item);
            view();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

    private void view() {
        setTotalAmountView(AmountUtils.format(getTotalAmount(), "0.00"));
        setRemainTotalAmountView(AmountUtils.format(getRemainTotalAmount(), "0.00"));
        setUsedTotalAmountView(AmountUtils.format(getUsedTotalAmount(), "0.00"));
    }

    public CountItemVo(ItemCounter item, Map<String, String> product) {
        try {
            PropertyUtils.copyProperties(this, item);
            view();
            view(product);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

    private void view(Map<String, String> product) {
        setProductView(Assert.checkParam(getProductId()) ? product.get(getProductId().toString()) : "");
        setTotalAmountView(AmountUtils.format(getTotalAmount(), "0.00"));
    }

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

    public String getTotalAmountView() {
        return totalAmountView;
    }

    public void setTotalAmountView(String totalAmountView) {
        this.totalAmountView = totalAmountView;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public BigDecimal getRemainTotalAmount() {
        return remainTotalAmount;
    }

    public void setRemainTotalAmount(BigDecimal remainTotalAmount) {
        this.remainTotalAmount = remainTotalAmount;
    }

    public String getRemainTotalAmountView() {
        return remainTotalAmountView;
    }

    public void setRemainTotalAmountView(String remainTotalAmountView) {
        this.remainTotalAmountView = remainTotalAmountView;
    }

    public BigDecimal getUsedTotalAmount() {
        return usedTotalAmount;
    }

    public void setUsedTotalAmount(BigDecimal usedTotalAmount) {
        this.usedTotalAmount = usedTotalAmount;
    }

    public String getUsedTotalAmountView() {
        return usedTotalAmountView;
    }

    public void setUsedTotalAmountView(String usedTotalAmountView) {
        this.usedTotalAmountView = usedTotalAmountView;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

}
