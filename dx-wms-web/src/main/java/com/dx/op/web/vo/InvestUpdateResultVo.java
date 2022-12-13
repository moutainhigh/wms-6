/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: InvestUpdateResultVo.java
 * Author:   朱道灵
 * Date:     2016年5月8日 下午12:36:15
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.invest.InvestUpdateResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

/**
 * 投资更新结果Vo
 *
 * @author 朱道灵
 */
public class InvestUpdateResultVo implements Serializable{

    /**
     */
    private static final long serialVersionUID = 7973498218237312255L;
    
    private static final String ZERO = "0.00";
    
    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;
    
    /**
     * 身份证号
     */
    private String idCard;
    
    /**
     * 客户编号
     */
    private String lenderCustCode;
    
    /**
     * 资金池编号
     */
    private Long poolId;
    
    /**
     * 初始出借金额
     */
    private BigDecimal initTotalAmount;
    
    /**
     * 初始出借金额视图
     */
    private String initTotalAmountView;
    
    /**
     * 出借方式视图
     */
    private String productName;

    /**
     * 出借方式
     */
    private Long productId;
    
    /**
     * 当前资产价值
     */
    private BigDecimal currentTotalAmount;
    
    /**
     * 当前资产价值视图
     */
    private String currentTotalAmountView;
    
    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 账单日视图
     */
    private String billDayView;
    
    /**
     * '首次匹配日期'
     */
    private Date date;
    
    /**
     * '首次匹配日期视图
     */
    private String dateView;
    
    /**
     * 计息日
     */
    private Date interestBeginTime;
    
    /**
     * 计息日视图
     */
    private String interestBeginTimeView;
    
    public InvestUpdateResultVo(){
        
    }

    public InvestUpdateResultVo(InvestUpdateResult investUpdate, final Map<Long, String> product){
        BeanUtils.copyProperties(investUpdate, this);
        setBillDayView();
        setCurrentTotalAmountView();
        setDateView();
        setInitTotalAmountView();
        setProductName(product);
        setInterestBeginTimeView();
    }
    
    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

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

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public void setInitTotalAmountView() {
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
    }
    
    public String getProductName() {
        return productName;
    }

    public InvestUpdateResultVo  setProductName(String productName) {
        this.productName = productName;
        return this;
    }
    
    public InvestUpdateResultVo setProductName(final Map<Long, String> product) {
        return setProductName(product.get(getProductId()));
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }
    
    public String getCurrentTotalAmountView() {
        return currentTotalAmountView;
    }

    public void setCurrentTotalAmountView(String currentTotalAmountView) {
        this.currentTotalAmountView = currentTotalAmountView;
    }

    public void setCurrentTotalAmountView() {
        setCurrentTotalAmountView(AmountUtils.format(getCurrentTotalAmount(), ZERO));
    }
    
    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public String getBillDayView() {
        return billDayView;
    }

    public void setBillDayView(String billDayView) {
        this.billDayView = billDayView;
    }
    
    public void setBillDayView() {
        setBillDayView(Assert.checkParam(getBillDay())? String.valueOf(getBillDay()):"-");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateView() {
        return dateView;
    }

    public void setDateView(String dateView) {
        this.dateView = dateView;
    }
    
    public void setDateView() {
        setDateView(DateUtils.formatForDay(getDate(), "-"));
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public String getInterestBeginTimeView() {
        return interestBeginTimeView;
    }

    public void setInterestBeginTimeView(String interestBeginTimeView) {
        this.interestBeginTimeView = interestBeginTimeView;
    }

    public void setInterestBeginTimeView() {
        setInterestBeginTimeView(DateUtils.formatForDay(getInterestBeginTime(), "-"));
    }
    
}
