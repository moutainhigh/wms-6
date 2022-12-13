package com.dx.cmm.web.controller.match.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.dx.common.service.utils.AmountUtils;

class MatchView implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4957359277670825006L;

    static final String ZERO = "0.00";

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 产品
     */
    private Long productId;

    /**
     * 产品
     */
    private String productView;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 未匹配金额
     */
    private BigDecimal undoAmount;

    /**
     * 未匹配金额
     */
    private String undoAmountView;

    /**
     * 用户编号
     */
    private Long userId;

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

    public MatchView setProductView(Map<Long, String> product) {
        setProductView(product.get(getProductId()));
        return this;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
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

    public MatchView setUndoAmountView() {
        setUndoAmountView(AmountUtils.format(getUndoAmount(), ZERO));
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
