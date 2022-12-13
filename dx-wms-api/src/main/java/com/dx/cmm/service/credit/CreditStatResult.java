package com.dx.cmm.service.credit;

import java.math.BigDecimal;

public class CreditStatResult extends CreditBaseResult {

    /**
     */
    private static final long serialVersionUID = -3613138570106113843L;

    /**
     * 统计金额(1号端)
     */
    private BigDecimal amountOne;

    /**
     * 数量(1号端)
     */
    private Integer numOne;
    
    /**
     * 统计金额(16号端)
     */
    private BigDecimal amountSixteen;

    /**
     * 数量(16号端)
     */
    private Integer numSixteen;
    
    /**
     * 统计金额
     */
    private BigDecimal amount;

    /**
     * 数量
     */
    private Integer num;

	public BigDecimal getAmountOne() {
		return amountOne;
	}

	public void setAmountOne(BigDecimal amountOne) {
		this.amountOne = amountOne;
	}

	public Integer getNumOne() {
		return numOne;
	}

	public void setNumOne(Integer numOne) {
		this.numOne = numOne;
	}

	public BigDecimal getAmountSixteen() {
		return amountSixteen;
	}

	public void setAmountSixteen(BigDecimal amountSixteen) {
		this.amountSixteen = amountSixteen;
	}

	public Integer getNumSixteen() {
		return numSixteen;
	}

	public void setNumSixteen(Integer numSixteen) {
		this.numSixteen = numSixteen;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
