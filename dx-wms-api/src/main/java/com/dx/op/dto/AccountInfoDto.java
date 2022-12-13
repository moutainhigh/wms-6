package com.dx.op.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 账户信息Dto<br>
 * 账户信息Dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AccountInfoDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5439351867588132088L;

    /**
     * 账户名称
     */
    private String name;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 账户金额
     */
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
