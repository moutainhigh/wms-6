package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.dto.AccountDetailDto;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

public class AccountDetailVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -5532714949849192379L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 出借方式
     */
    private String productView;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 出借金额
     */
    private String lenderAmountView;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 当前资产价值
     */
    private BigDecimal currentAmount;

    /**
     * 当前资产价值
     */
    private String currentAmountView;

    /**
     * 投资生效日
     */
    private Date effectDate;

    /**
     * 投资生效日
     */
    private String effectDateView;

    /**
     * 状态
     */
    private String dataStatus;

    /**
     * 状态
     */
    private String dataStatusView;

    private static final String OFF_LINE = "线下";

    private static final String ON_LINE = "线上";

    private static final String OFF_LINE_KEY = "O";

    public AccountDetailVo() {

    }

    public AccountDetailVo(AccountDetailDto dto, Map<String, String> productMap) {
        try {
            PropertyUtils.copyProperties(this, dto);
            setCurrentAmountView(AmountUtils.format(getCurrentAmount(), "-"));
            setLenderAmountView(AmountUtils.format(getLenderAmount(), "-"));
            setEffectDateView(Assert.checkParam(getEffectDate()) ? DateUtils.formatForDay(getEffectDate()) : "-");
            setProductView(productMap.get(String.valueOf(getProductId())));
            setDataStatusView(Assert.equals(getDataStatus(), OFF_LINE_KEY) ? OFF_LINE : ON_LINE);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
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

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public String getLenderAmountView() {
        return lenderAmountView;
    }

    public void setLenderAmountView(String lenderAmountView) {
        this.lenderAmountView = lenderAmountView;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getCurrentAmountView() {
        return currentAmountView;
    }

    public void setCurrentAmountView(String currentAmountView) {
        this.currentAmountView = currentAmountView;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getEffectDateView() {
        return effectDateView;
    }

    public void setEffectDateView(String effectDateView) {
        this.effectDateView = effectDateView;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDataStatusView() {
        return dataStatusView;
    }

    public void setDataStatusView(String dataStatusView) {
        this.dataStatusView = dataStatusView;
    }

}
