package com.dx.cmm.service.invest;

import java.math.BigDecimal;

/**
 * 
 * 投资统计结果
 *
 * @author tony
 */
public class InvestStatResult extends InvestBaseResult {

    /**
     */
    private static final long serialVersionUID = 6179904771878903414L;

    /**
     * 数量
     */
    private Integer num1;
    
    /**
     * 统计金额
     */
    private BigDecimal amount1;
    
    /**
     * 数量
     */
    private Integer num16;
    
    /**
     * 统计金额
     */
    private BigDecimal amount16;
    
    /**
     * 账单日
     */
    private Integer billDay;

    public Integer getNum1() {
		return num1;
	}

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public Integer getNum16() {
		return num16;
	}

	public void setNum16(Integer num16) {
		this.num16 = num16;
	}

	public BigDecimal getAmount16() {
		return amount16;
	}

	public void setAmount16(BigDecimal amount16) {
		this.amount16 = amount16;
	}

	public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

}
