package com.dx.cmm.service.tasks;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 账户任务Dto
 *
 * @author tony
 */
public class AccountParamTask implements Serializable {

    /**
     */
    private static final long serialVersionUID = -9032108139296590356L;

    /**
     * 客户编号
     */
    private String custCode;

    /**
     * 账户金额
     */
    private BigDecimal accountAmount;

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

}
