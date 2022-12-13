package com.dx.cmm.service.match;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ResultMatch implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1389605805676969597L;

    /**
     * 日期
     */
    Date date;

    /**
     * 日期
     */
    String dateView;

    /**
     * 客户姓名
     */
    String custName;

    /**
     * 身份证
     */
    String idCard;

    /**
     * 初始金额
     */
    BigDecimal initAmount;

    /**
     * 初始金额
     */
    String initAmountView;

    /**
     * 未匹配金额
     */
    BigDecimal undoAmount;

    /**
     * 未匹配金额
     */
    String undoAmountView;

    /**
     * 产品
     */
    Long productId;

    /**
     * 产品
     */
    String productView;

    /**
     * 资金池编号
     */
    Long poolId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateView() {
        return dateView;
    }

    public void setDateView(String dateView) {
        this.dateView = dateView;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

}
