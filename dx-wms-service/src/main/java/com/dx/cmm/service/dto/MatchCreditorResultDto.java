package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MatchCreditorResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7435534324135161950L;

    /**
     * 债权池-编号
     */
    private Long creditorPoolId;

    private String creditorName;

    private Long creditorUserId;

    private Integer matchDay;

    private Date billDate;

    private BigDecimal initEaAmount;
    /**
     * 债权池-初始单笔价值-余
     */
    private BigDecimal initEaAmountRem;

    /**
     * 债权池-初始单笔价值-上限
     */
    private BigDecimal initEaAmountMax;

    /**
     * 债权池-当前总交易价值
     */
    private BigDecimal currentTotalAmount;

    /**
     * 债权池-当前已交易价值
     */
    private BigDecimal currentDoneAmount;

    /**
     * 债权池-当前可交易价值
     */
    private BigDecimal currentUndoAmount;

    private Integer initPeriod;

    private BigDecimal rateMonth;

    private BigDecimal initEaBillAmount;

    private BigDecimal initTotalAmount;

    private String productView;

    private Long productId;

    private BigDecimal rateYear;

    private String rateYearView;

    private String rateMonthView;

    private Integer remainPeriod;

    private BigDecimal rate;

    private String rateView;

    public Long getCreditorPoolId() {
        return creditorPoolId;
    }

    public void setCreditorPoolId(Long creditorPoolId) {
        this.creditorPoolId = creditorPoolId;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public Long getCreditorUserId() {
        return creditorUserId;
    }

    public void setCreditorUserId(Long creditorUserId) {
        this.creditorUserId = creditorUserId;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getInitEaAmount() {
        return initEaAmount;
    }

    public void setInitEaAmount(BigDecimal initEaAmount) {
        this.initEaAmount = initEaAmount;
    }

    public BigDecimal getInitEaAmountRem() {
        return initEaAmountRem;
    }

    public void setInitEaAmountRem(BigDecimal initEaAmountRem) {
        this.initEaAmountRem = initEaAmountRem;
    }

    public BigDecimal getInitEaAmountMax() {
        return initEaAmountMax;
    }

    public void setInitEaAmountMax(BigDecimal initEaAmountMax) {
        this.initEaAmountMax = initEaAmountMax;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public BigDecimal getCurrentDoneAmount() {
        return currentDoneAmount;
    }

    public void setCurrentDoneAmount(BigDecimal currentDoneAmount) {
        this.currentDoneAmount = currentDoneAmount;
    }

    public BigDecimal getCurrentUndoAmount() {
        return currentUndoAmount;
    }

    public void setCurrentUndoAmount(BigDecimal currentUndoAmount) {
        this.currentUndoAmount = currentUndoAmount;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public void setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
    }

    public BigDecimal getInitEaBillAmount() {
        return initEaBillAmount;
    }

    public void setInitEaBillAmount(BigDecimal initEaBillAmount) {
        this.initEaBillAmount = initEaBillAmount;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    public String getRateYearView() {
        return rateYearView;
    }

    public void setRateYearView(String rateYearView) {
        this.rateYearView = rateYearView;
    }

    public String getRateMonthView() {
        return rateMonthView;
    }

    public void setRateMonthView(String rateMonthView) {
        this.rateMonthView = rateMonthView;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getRateView() {
        return rateView;
    }

    public void setRateView(String rateView) {
        this.rateView = rateView;
    }

}
