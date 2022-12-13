package com.dx.report.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.report.dto.PastResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;

public class PastResultVo implements Serializable{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 6204605105205958588L;

	/*
	 * 客户姓名
	 */
	private String custName;
	
	/*
	 * 身份证
	 */
	private String idCard;
	
	/*
	 * 出借编号
	 */
	private String lenderCode;
	
	/*
	 * 出借金额
	 */
	private BigDecimal lenderAmount;
	
	/*
	 * 出借金额View
	 */
	private String lenderAmountView;
	
	/*
	 * 回款匹配金额
	 */
	private BigDecimal backMatchAmount;
	
	/*
	 * 回款匹配金额View
	 */
	private String backMatchAmountView;
	
	/*
	 * 
	 */
	private Long productId;
	/*
	 * 出借方式
	 */
	private String productName;
	
	/*
	 * 报告日
	 */
	private int reportDay;
	
	/*
	 * 投资生效日
	 */
	private Date investDay;
	
	/*
	 * 投资生效日View
	 */
	private String investDayView;
	
	/*
	 * 预览使用的账单日
	 */
	private String createTimePre;
	
	/*
	 * 预览使用的报告日
	 */
	private String reportDayPre;

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

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public BigDecimal getLenderAmount() {
		return lenderAmount;
	}

	public void setLenderAmount(BigDecimal lenderAmount) {
		this.lenderAmount = lenderAmount;
	}

	public String getLenderAmountView() {
		return lenderAmountView;
	}

	public void setLenderAmountView(String lenderAmountView) {
		this.lenderAmountView = lenderAmountView;
	}
	
	public PastResultVo setLenderAmountView() {
		this.lenderAmountView=AmountUtils.format(getLenderAmount(), "0.00");
		return this; 
    }

	public BigDecimal getBackMatchAmount() {
		return backMatchAmount;
	}

	public void setBackMatchAmount(BigDecimal backMatchAmount) {
		this.backMatchAmount = backMatchAmount;
	}

	public String getBackMatchAmountView() {
		return backMatchAmountView;
	}

	public void setBackMatchAmountView(String backMatchAmountView) {
		this.backMatchAmountView = backMatchAmountView;
	}
	public PastResultVo setBackMatchAmountView() {
		this.backMatchAmountView=AmountUtils.format(getBackMatchAmount(), "0.00");
		return this; 
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getReportDay() {
		return reportDay;
	}

	public void setReportDay(int reportDay) {
		this.reportDay = reportDay;
	}

	public Date getInvestDay() {
		return investDay;
	}

	public void setInvestDay(Date investDay) {
		this.investDay = investDay;
	}

	public String getInvestDayView() {
		return investDayView;
	}

	public void setInvestDayView(String investDayView) {
		this.investDayView = investDayView;
	}
	
	public void setInvestDayView() {
        setInvestDayView(DateUtils.formatForDay(getInvestDay()));
    }
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	
	public String getCreateTimePre() {
		return createTimePre;
	}

	public void setCreateTimePre(String createTimePre) {
		this.createTimePre = createTimePre;
	}

	public String getReportDayPre() {
		return reportDayPre;
	}

	public void setReportDayPre(String reportDayPre) {
		this.reportDayPre = reportDayPre;
	}

	public PastResultVo(PastResult result){
		BeanUtils.copyProperties(result, this);
		setLenderAmountView();
		setBackMatchAmountView();
		setInvestDayView();
	}
}
