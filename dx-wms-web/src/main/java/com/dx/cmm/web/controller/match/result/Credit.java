package com.dx.cmm.web.controller.match.result;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.CreditResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.PerUtils;

public class Credit extends MatchView {

    /**
     */
    private static final long serialVersionUID = -1086902969427278335L;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 当前债权
     */
    private BigDecimal currentAmount;

    /**
     * 推荐比例
     */
    private BigDecimal rate;

    /**
     * 推荐比例
     */
    private String rateView;

    /**
     * 剩余债权
     */
    private BigDecimal undoAmount;

    /**
     * 剩余债权
     */
    private String undoAmountView;

    /**
     * 初始债权
     */
    private BigDecimal initAmount;

    /**
     * 初始债权
     */
    private String initAmountView;

    /**
     * 还款期数
     */
    private Integer initPeriod;

    /**
     * 剩余期数
     */
    private Integer remainPeriod;

    /**
     * 年利率
     */
    private BigDecimal rateYear;

    /**
     * 年利率
     */
    private String rateYearView;

    /**
     * 还款日
     */
    private Integer portDay;

    /**
     * 还款日
     */
    private String portDayView;

    public Credit(CreditResult credit, Map<Long, String> product, Map<String, String> port) {
        BeanUtils.copyProperties(credit, this);
        setUndoAmountView().setInitAmountView().setRateYearView().setPortDayView(port).setRateView();
        setProductView(product);
                

    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
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

    public Credit setRateView() {
        setRate(getUndoAmount().divide(getCurrentAmount(), 15, BigDecimal.ROUND_HALF_UP));
        setRateView(PerUtils.format(getRate()));
        return this;
    }

    public BigDecimal getUndoAmount() {
        return undoAmount;
    }

    public void setUndoAmount(BigDecimal undoAmount) {
        this.undoAmount = undoAmount;
    }

    public String getUndoAmountView() {
        return undoAmountView;
    }

    public void setUndoAmountView(String undoAmountView) {
        this.undoAmountView = undoAmountView;
    }

    public Credit setUndoAmountView() {
        setUndoAmountView(AmountUtils.format(getUndoAmount(), ZERO));
        return this;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

    public String getInitAmountView() {
        return initAmountView;
    }

    public void setInitAmountView(String initAmountView) {
        this.initAmountView = initAmountView;
    }

    public Credit setInitAmountView() {
        setInitAmountView(AmountUtils.format(getInitAmount(), ZERO));
        return this;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
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

    public Credit setRateYearView() {
        setRateYearView(PerUtils.format(getRateYear()));
        return this;
    }

    public Integer getPortDay() {
        return portDay;
    }

    public void setPortDay(Integer portDay) {
        this.portDay = portDay;
    }

    public String getPortDayView() {
        return portDayView;
    }

    public void setPortDayView(String portDayView) {
        this.portDayView = portDayView;
    }

    public Credit setPortDayView(Map<String, String> port) {
        setPortDayView(port.get(String.valueOf(getPortDay())));
        return this;
    }

}
