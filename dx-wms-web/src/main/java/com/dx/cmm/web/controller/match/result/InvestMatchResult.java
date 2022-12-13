package com.dx.cmm.web.controller.match.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.result.InvestResults;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.PerUtils;

public class InvestMatchResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = -5014478198672729731L;

    private static final String ZERO = "0.00";

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 债权比例
     */
    private BigDecimal creditRate;

    /**
     * 债权比例
     */
    private String creditRateView;

    /**
     * 转让价值
     */
    private BigDecimal transAmount;

    /**
     * 转让价值
     */
    private String transAmountView;

    /**
     * 当前总价值
     */
    private BigDecimal totalAmount;

    /**
     * 当前总价值
     */
    private String totalAmountView;

    /**
     * 利息
     */
    private BigDecimal interest;

    /**
     * 利息
     */
    private String interestView;

    /**
     * 本金
     */
    private BigDecimal capital;

    /**
     * 本金
     */
    private String capitalView;

    /**
     * 还款金额
     */
    private BigDecimal repay;

    /**
     * 还款金额
     */
    private String repayView;

    /**
     * 产品类型
     */
    private Long productId;

    /**
     * 产品类型
     */
    private String productView;

    public InvestMatchResult(InvestResults results, Map<Long, String> product) {
        BeanUtils.copyProperties(results, this);
        setCreditRateView().setTotalAmountView().setTransAmountView().setProductView(product).setInterestView()
                .setCapitalView().setRepayView();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(BigDecimal creditRate) {
        this.creditRate = creditRate;
    }

    public String getCreditRateView() {
        return creditRateView;
    }

    public void setCreditRateView(String creditRateView) {
        this.creditRateView = creditRateView;
    }

    public InvestMatchResult setCreditRateView() {
        setCreditRateView(PerUtils.format(getCreditRate()));
        return this;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransAmountView() {
        return transAmountView;
    }

    public void setTransAmountView(String transAmountView) {
        this.transAmountView = transAmountView;
    }

    public InvestMatchResult setTransAmountView() {
        setTransAmountView(AmountUtils.format(getTransAmount(), ZERO));
        return this;
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

    public InvestMatchResult setTotalAmountView() {
        setTotalAmountView(AmountUtils.format(getTransAmount(), ZERO));
        return this;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public String getInterestView() {
        return interestView;
    }

    public void setInterestView(String interestView) {
        this.interestView = interestView;
    }

    public InvestMatchResult setInterestView() {
        setInterestView(AmountUtils.format(getInterest(), ZERO));
        return this;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public String getCapitalView() {
        return capitalView;
    }

    public void setCapitalView(String capitalView) {
        this.capitalView = capitalView;
    }

    public InvestMatchResult setCapitalView() {
        setCapitalView(AmountUtils.format(getCapital(), ZERO));
        return this;
    }

    public BigDecimal getRepay() {
        return repay;
    }

    public void setRepay(BigDecimal repay) {
        this.repay = repay;
    }

    public String getRepayView() {
        return repayView;
    }

    public void setRepayView(String repayView) {
        this.repayView = repayView;
    }

    public InvestMatchResult setRepayView() {
        setRepayView(AmountUtils.format(getRepay(), ZERO));
        return this;
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

    public InvestMatchResult setProductView(Map<Long, String> product) {
        setProductView(product.get(getProductId()));
        return this;
    }

}
