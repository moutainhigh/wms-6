package com.dx.cmm.service.match.result;

import java.math.BigDecimal;

public class AddInvestResult extends InvestResult {

    /**
     */
    private static final long serialVersionUID = -898285065076021835L;

    /**
     * 客户分类
     */
    private Integer category;

    /**
     * 初始金额
     */
    private BigDecimal initAmount;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

}
