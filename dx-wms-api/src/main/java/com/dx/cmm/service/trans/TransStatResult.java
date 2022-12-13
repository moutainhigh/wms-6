package com.dx.cmm.service.trans;

import java.math.BigDecimal;

public class TransStatResult extends TransBaseResult {

    /**
     */
    private static final long serialVersionUID = 2257725634798218061L;

    

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

   

}
