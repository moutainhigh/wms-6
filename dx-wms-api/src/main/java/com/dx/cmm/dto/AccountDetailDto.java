package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 账户详情dto<br>
 * 账户详情dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AccountDetailDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7992920317017420784L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

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
     * 投资生效日
     */
    private Date effectDate;

    /**
     * 状态
     */
    private String dataStatus;

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

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
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

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
