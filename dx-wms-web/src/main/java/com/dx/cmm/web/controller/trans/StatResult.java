package com.dx.cmm.web.controller.trans;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.trans.TransStatResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;

public class StatResult extends Result {

    /**
     */
    private static final long serialVersionUID = 1679665690903202840L;

    /**
     * 1号端统计金额
     */
    private BigDecimal amount1;

    /**
     * 1号端统计金额展示
     */
    private String amountView1;

    /**
     * 1号端数量
     */
    private Integer num1;
   
    /*
     * 1号端数量展示
     */
    private String numView1;
    
    /**
     * 16号端统计金额
     */
    private BigDecimal amount16;

    /**
     * 16号端统计金额展示
     */
    private String amountView16;

    /**
     * 16号端数量
     */
    private Integer num16;
    
    /*
     * 16号端数量展示
     */
    private String numView16;

    /**
     * 时间编号
     */
    /*
    private Long dateId;*/

    public StatResult(TransStatResult result) {
        BeanUtils.copyProperties(result, this);
        	setDateView(DateUtils.formatForDay(getDate()));
        	setAmountView1();
        	setAmountView16();
        	setNumView1();
        	setNumView16();
        
        
        //setDateId(getDate().getTime());
    }

    /*public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }*/

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	
	public String getAmountView1() {
		return amountView1;
	}
	
	public StatResult setAmountView1() {
		BigDecimal param = new BigDecimal("-1");
		if(0==param.compareTo(getAmount1())){
			return setAmountView1("-");
		}else{
			return setAmountView1(AmountUtils.format(getAmount1(), "0.00"));
		}
        
    }

	public StatResult setAmountView1(String amountView1) {
        this.amountView1 = amountView1;
        return this;
    }

	public Integer getNum1() {
		return num1;
	}

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public BigDecimal getAmount16() {
		return amount16;
	}

	public void setAmount16(BigDecimal amount16) {
		this.amount16 = amount16;
	}

	public String getAmountView16() {
		return amountView16;
	}

	public StatResult setAmountView16() {
		BigDecimal param = new BigDecimal("-1");
		if(0==param.compareTo(getAmount16())){
			return setAmountView16("-");
		}else{
			return setAmountView16(AmountUtils.format(getAmount16(), "0.00"));
		}
        
    }

	public StatResult setAmountView16(String amountView16) {
        this.amountView16 = amountView16;
        return this;
    }

	public Integer getNum16() {
		return num16;
	}

	public void setNum16(Integer num16) {
		this.num16 = num16;
	}

	public String getNumView1() {
		return numView1;
	}

	public StatResult setNumView1() {
		if(-1==getNum1()){
			return setNumview1("-");
		}else{
			return setNumview1(String.valueOf(getNum1()));
		}
	}
	
	public StatResult setNumview1(String num1){
		 this.numView1=num1;
		 return this;
	}

	public String getNumView16() {
		return numView16;
	}

	public StatResult setNumView16() {
		if(-1==getNum16()){
			return setNumview16("-");
		}else{
			return setNumview16(String.valueOf(getNum16()));
		}
	}
	
	public StatResult setNumview16(String num16){
		 this.numView16=num16;
		 return this;
	}
	
	

	
}
