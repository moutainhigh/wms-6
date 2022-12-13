package com.dx.cmm.web.controller.credit;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.credit.CreditStatResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;

public class StatResult extends Result {

    /**
     */
    private static final long serialVersionUID = 1679665690903202840L;

    /**
     * 统计金额
     */
    private BigDecimal amountOne;

    /**
     * 统计金额
     */
    private String amountOneView;

    /**
     * 数量
     */
    private Integer numOne;
    
    /*
     * 数量预览
     */
    private String numOneView;
    
    /**
     * 统计金额
     */
    private BigDecimal amountSixteen;

    /**
     * 统计金额
     */
    private String amountSixteenView;

    /**
     * 数量
     */
    private Integer numSixteen;
    
    /*
     * 数量预览
     */
    private String numSixteenView;

    /**
     * 时间编号
     */
    private Long dateId;

    public StatResult(CreditStatResult result) {
        BeanUtils.copyProperties(result, this);
        setAmountOneView().setAmountSixteenView().setNumOneView().setNumSixteenView().setDateView();
        setDateId(getDate().getTime());
    }

	public BigDecimal getAmountOne() {
		return amountOne;
	}

	public void setAmountOne(BigDecimal amountOne) {
		this.amountOne = amountOne;
	}

	public String getAmountOneView() {
		return amountOneView;
	}

	public void setAmountOneView(String amountOneView) {
		this.amountOneView = amountOneView;
	}
	
	public StatResult setAmountOneView(){
		setAmountOneView(Assert.checkParam(getAmountOne()) ? AmountUtils.format(getAmountOne(), "0.00") : "-");
		return this;
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

	public String getAmountSixteenView() {
		return amountSixteenView;
	}

	public void setAmountSixteenView(String amountSixteenView) {
		this.amountSixteenView = amountSixteenView;
	}
	
	public StatResult setAmountSixteenView(){
		setAmountSixteenView(Assert.checkParam(getAmountSixteen()) ? AmountUtils.format(getAmountSixteen(), "0.00") : "-");
		return this;
	}

	public Integer getNumSixteen() {
		return numSixteen;
	}

	public void setNumSixteen(Integer numSixteen) {
		this.numSixteen = numSixteen;
	}

	public Long getDateId() {
		return dateId;
	}

	public void setDateId(Long dateId) {
		this.dateId = dateId;
	}

	public String getNumOneView() {
		return numOneView;
	}

	public void setNumOneView(String numOneView) {
		this.numOneView = numOneView;
	}
	
	public StatResult setNumOneView(){
		setNumOneView(Assert.checkParam(getNumOne()) ? getNumOne().toString() : "-");
		return this;
	}

	public String getNumSixteenView() {
		return numSixteenView;
	}

	public void setNumSixteenView(String numSixteenView) {
		this.numSixteenView = numSixteenView;
	}
	
	public StatResult setNumSixteenView(){
		setNumSixteenView(Assert.checkParam(getNumSixteen()) ? getNumSixteen().toString() : "-");
		return this;
	}
}
