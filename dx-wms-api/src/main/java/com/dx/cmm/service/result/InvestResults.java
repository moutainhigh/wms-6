package com.dx.cmm.service.result;

import java.io.Serializable;
import java.math.BigDecimal;

public class InvestResults implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6438246176731056801L;

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
     * 转让价值
     */
    private BigDecimal transAmount;

    /**
     * 当前总价值
     */
    private BigDecimal totalAmount;

    /**
     * 利息
     */
    private BigDecimal interest;

    /**
     * 本金
     */
    private BigDecimal capital;

    /**
     * 还款金额
     */
    private BigDecimal repay;

    /**
     * 产品类型
     */
    private Long productId;

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

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
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

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getRepay() {
        return repay;
    }

    public void setRepay(BigDecimal repay) {
        this.repay = repay;
    }

}
