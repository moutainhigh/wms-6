package com.dx.cmm.web.controller.credit;

import org.springframework.beans.BeanUtils;

public class ExportExcelResult {
	
	/**
     * 姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 还款日
     */
    private Integer repayDay;

    /**
     * 初始借款金额
     */
    private String initTotalAmountView;

    /**
     * 还款起始
     */
    private String repayBeginDateView;

    /**
     * 还款期限
     */
    private Integer initPeriod;

    /**
     * 剩余还款月数
     */
    private Integer remainPeriod;

    /**
     * 预计债权收益率(年)
     */
    private String rateYearView;

    /**
     * 产品类型
     */
    private String productView;

    /**
     * 每期还款
     */
    private String repayAmountView;

    /**
     * 月利率
     */
    private String rateMonthView;

    /**
     * 已还款期数
     */
    private Integer repayPeriod;

    /**
     * 当期剩余本金 （期初）| 当期期初债权
     */
    private String currentTotalAmountView;

    /**
     * 当期新增资金
     */
    private String currentDoneAmountView;

    /**
     * 当前剩余债权
     */
    private String currentUndoAmountView;

    /**
     * 上期债权总价值
     */
    private String lastTotalAmountView;

    /**
     * 上期已匹配价值
     */
    private String lastDoneAmountView;

    /**
     * 上期未匹配价值
     */
    private String lastUndoAmountView;

    /**
     * 上期应还利息
     */
    private String lastInterestView;

    /**
     * 上期应还本金
     */
    private String lastCapitalView;
    
    public ExportExcelResult(){
    	
    }
    
    public ExportExcelResult(PoolResult pool){
        BeanUtils.copyProperties(pool, this);
    }

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getRepayDay() {
		return repayDay;
	}

	public void setRepayDay(Integer repayDay) {
		this.repayDay = repayDay;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getInitTotalAmountView() {
		return initTotalAmountView;
	}

	public void setInitTotalAmountView(String initTotalAmountView) {
		this.initTotalAmountView = initTotalAmountView;
	}

	public String getRepayBeginDateView() {
		return repayBeginDateView;
	}

	public void setRepayBeginDateView(String repayBeginDateView) {
		this.repayBeginDateView = repayBeginDateView;
	}

	public Integer getInitPeriod() {
		return initPeriod;
	}

	public void setInitPeriod(Integer initPeriod) {
		this.initPeriod = initPeriod;
	}

	public Integer getRemainPeriod() {
		return remainPeriod;
	}

	public void setRemainPeriod(Integer remainPeriod) {
		this.remainPeriod = remainPeriod;
	}

	public String getRateYearView() {
		return rateYearView;
	}

	public void setRateYearView(String rateYearView) {
		this.rateYearView = rateYearView;
	}

	public String getProductView() {
		return productView;
	}

	public void setProductView(String productView) {
		this.productView = productView;
	}

	public String getRepayAmountView() {
		return repayAmountView;
	}

	public void setRepayAmountView(String repayAmountView) {
		this.repayAmountView = repayAmountView;
	}

	public String getRateMonthView() {
		return rateMonthView;
	}

	public void setRateMonthView(String rateMonthView) {
		this.rateMonthView = rateMonthView;
	}

	public Integer getRepayPeriod() {
		return repayPeriod;
	}

	public void setRepayPeriod(Integer repayPeriod) {
		this.repayPeriod = repayPeriod;
	}

	public String getCurrentTotalAmountView() {
		return currentTotalAmountView;
	}

	public void setCurrentTotalAmountView(String currentTotalAmountView) {
		this.currentTotalAmountView = currentTotalAmountView;
	}

	public String getCurrentDoneAmountView() {
		return currentDoneAmountView;
	}

	public void setCurrentDoneAmountView(String currentDoneAmountView) {
		this.currentDoneAmountView = currentDoneAmountView;
	}

	public String getCurrentUndoAmountView() {
		return currentUndoAmountView;
	}

	public void setCurrentUndoAmountView(String currentUndoAmountView) {
		this.currentUndoAmountView = currentUndoAmountView;
	}

	public String getLastTotalAmountView() {
		return lastTotalAmountView;
	}

	public void setLastTotalAmountView(String lastTotalAmountView) {
		this.lastTotalAmountView = lastTotalAmountView;
	}

	public String getLastDoneAmountView() {
		return lastDoneAmountView;
	}

	public void setLastDoneAmountView(String lastDoneAmountView) {
		this.lastDoneAmountView = lastDoneAmountView;
	}

	public String getLastUndoAmountView() {
		return lastUndoAmountView;
	}

	public void setLastUndoAmountView(String lastUndoAmountView) {
		this.lastUndoAmountView = lastUndoAmountView;
	}

	public String getLastInterestView() {
		return lastInterestView;
	}

	public void setLastInterestView(String lastInterestView) {
		this.lastInterestView = lastInterestView;
	}

	public String getLastCapitalView() {
		return lastCapitalView;
	}

	public void setLastCapitalView(String lastCapitalView) {
		this.lastCapitalView = lastCapitalView;
	}


}
