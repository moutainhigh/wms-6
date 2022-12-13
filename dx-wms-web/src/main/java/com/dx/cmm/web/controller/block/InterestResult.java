package com.dx.cmm.web.controller.block;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.block.BlockInterestResult;
import com.dx.common.service.utils.AmountUtils;

/**
 * 
 * 异常利息查询结果vo
 *
 * @author EDison
 */
public class InterestResult extends Result {

    private static final String ZERO = "0.00";

    /**
     */
    private static final long serialVersionUID = -8508539976805314562L;

    /**
     * 出借编号
     */
    private String lenderCode;
    /**
     * 借款客户
     */
    private String applyCustName;

    /**
     * 合同编号
     */
    private String bizContractCode;
    /**
     * 转让债权价值
     */
    private BigDecimal transferTotalAmount;
    /**
     * 转让债权价值视图
     */
    private String transferTotalAmountView;
    /**
     * 转让还款金额
     */
    private BigDecimal transferEaAmount;
    /**
     * 转让还款金额视图
     */
    private String transferEaAmountView;
    /**
     * 转让债权比例
     */
    private BigDecimal creditorRate;
    /**
     * 转让债权比例视图
     */
    private String creditorRateView;
    /**
     * 转让本金
     */
    private BigDecimal transferEaCapitalAmount;
    /**
     * 转让本金视图
     */
    private String transferEaCapitalAmountView;
    /**
     * 转让利息
     */
    private BigDecimal transferEaInterestAmount;
    /**
     * 转让利息视图
     */
    private String transferEaInterestAmountView;

    /**
     * 利息差
     */
    private BigDecimal interestMargin;
    /**
     * 利息差视图
     */
    private String interestMarginView;
    /**
     * 当前债权总价值
     */
    private BigDecimal currentTotalAmount;
    /**
     * 当前债权总价值视图
     */
    private String currentTotalAmountView;
    /**
     * 初始债权价值
     */
    private BigDecimal initTotalAmount;
    /**
     * 初始债权价值视图
     */
    private String initTotalAmountView;
    /**
     * 还款金额
     */
    private BigDecimal initEaBillAmount;
    /**
     * 还款金额视图
     */
    private String initEaBillAmountView;
    /**
     * 还款期限
     */
    private Integer initPeriod;
    /**
     * 剩余期限
     */
    private Integer remainPeriod;

    public InterestResult() {

    }

    public InterestResult(BlockInterestResult result) {
        BeanUtils.copyProperties(result, this);
        setCreditorRateView();
        setCurrentTotalAmountView();
        setInitEaBillAmountView();
        setInitTotalAmountView();
        setInterestMarginView();
        setTransferEaAmountView();
        setTransferTotalAmountView();
        setTransferEaInterestAmountView();
        setTransferEaCapitalAmountView();

    }

    public String getTransferTotalAmountView() {
        return transferTotalAmountView;
    }

    public void setTransferTotalAmountView(String transferTotalAmountView) {
        this.transferTotalAmountView = transferTotalAmountView;
    }

    public void setTransferTotalAmountView() {
        setTransferTotalAmountView(AmountUtils.format(getTransferTotalAmount(), ZERO));
    }

    public String getTransferEaAmountView() {
        return transferEaAmountView;
    }

    public void setTransferEaAmountView(String transferEaAmountView) {
        this.transferEaAmountView = transferEaAmountView;
    }

    public void setTransferEaAmountView() {
        setTransferEaAmountView(AmountUtils.format(getTransferEaAmount(), ZERO));
    }

    public String getCreditorRateView() {
        return creditorRateView;
    }

    public void setCreditorRateView(String creditorRateView) {
        this.creditorRateView = creditorRateView;
    }

    public void setCreditorRateView() {
        setCreditorRateView(AmountUtils.format(getCreditorRate(), ZERO));
    }

    public String getTransferEaCapitalAmountView() {
        return transferEaCapitalAmountView;
    }

    public void setTransferEaCapitalAmountView(String transferEaCapitalAmountView) {
        this.transferEaCapitalAmountView = transferEaCapitalAmountView;
    }

    public void setTransferEaCapitalAmountView() {
        setTransferEaCapitalAmountView(AmountUtils.format(getTransferEaCapitalAmount(), ZERO));
    }

    public String getTransferEaInterestAmountView() {
        return transferEaInterestAmountView;
    }

    public void setTransferEaInterestAmountView(String transferEaInterestAmountView) {
        this.transferEaInterestAmountView = transferEaInterestAmountView;
    }

    public void setTransferEaInterestAmountView() {
        setTransferEaInterestAmountView(AmountUtils.format(getTransferEaInterestAmount(), ZERO));
    }

    public String getInterestMarginView() {
        return interestMarginView;
    }

    public void setInterestMarginView(String interestMarginView) {
        this.interestMarginView = interestMarginView;
    }

    public void setInterestMarginView() {
        setInterestMarginView(AmountUtils.format(getInterestMargin(), ZERO));
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

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public void setInitTotalAmountView() {
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
    }

    public String getInitEaBillAmountView() {
        return initEaBillAmountView;
    }

    public void setInitEaBillAmountView(String initEaBillAmountView) {
        this.initEaBillAmountView = initEaBillAmountView;
    }

    public void setInitEaBillAmountView() {
        setInitEaBillAmountView(AmountUtils.format(getInitEaBillAmount(), ZERO));
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getApplyCustName() {
        return applyCustName;
    }

    public void setApplyCustName(String applyCustName) {
        this.applyCustName = applyCustName;
    }

    public String getBizContractCode() {
        return bizContractCode;
    }

    public void setBizContractCode(String bizContractCode) {
        this.bizContractCode = bizContractCode;
    }

    public BigDecimal getTransferTotalAmount() {
        return transferTotalAmount;
    }

    public void setTransferTotalAmount(BigDecimal transferTotalAmount) {
        this.transferTotalAmount = transferTotalAmount;
    }

    public BigDecimal getTransferEaAmount() {
        return transferEaAmount;
    }

    public void setTransferEaAmount(BigDecimal transferEaAmount) {
        this.transferEaAmount = transferEaAmount;
    }

    public BigDecimal getCreditorRate() {
        return creditorRate;
    }

    public void setCreditorRate(BigDecimal creditorRate) {
        this.creditorRate = creditorRate;
    }

    public BigDecimal getTransferEaCapitalAmount() {
        return transferEaCapitalAmount;
    }

    public void setTransferEaCapitalAmount(BigDecimal transferEaCapitalAmount) {
        this.transferEaCapitalAmount = transferEaCapitalAmount;
    }

    public BigDecimal getInterestMargin() {
        return interestMargin;
    }

    public void setInterestMargin(BigDecimal interestMargin) {
        this.interestMargin = interestMargin;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public BigDecimal getInitEaBillAmount() {
        return initEaBillAmount;
    }

    public void setInitEaBillAmount(BigDecimal initEaBillAmount) {
        this.initEaBillAmount = initEaBillAmount;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public BigDecimal getTransferEaInterestAmount() {
        return transferEaInterestAmount;
    }

    public void setTransferEaInterestAmount(BigDecimal transferEaInterestAmount) {
        this.transferEaInterestAmount = transferEaInterestAmount;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

}
