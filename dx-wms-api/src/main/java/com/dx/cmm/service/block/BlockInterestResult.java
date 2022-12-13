package com.dx.cmm.service.block;

import java.math.BigDecimal;

/**
 * 
 * 异常利息查询dto
 *
 * @author EDison
 * 
 */
public class BlockInterestResult extends BlockResult {

    /**
     */

    private static final long serialVersionUID = 7111662235042526209L;

    /**
     * 出借编号
     */
    private String leaderCode;

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
     * 转让还款金额
     */
    private BigDecimal transferEaAmount;

    /**
     * 转让债权比例
     */
    private BigDecimal creditorRate;

    /**
     * 转让本金
     */
    private BigDecimal transferEaCapitalAmount;

    /**
     * 转让利息
     */
    private BigDecimal transferEaInterestAmount;

    /**
     * 利息差
     */
    private BigDecimal interestMargin;

    /**
     * 当前债权总价值
     */
    private BigDecimal currentTotalAmount;

    /**
     * 初始债权价值
     */
    private BigDecimal initTotalAmount;

    /**
     * 还款金额
     */
    private BigDecimal initEaBillAmount;

    /**
     * 还款期限
     */
    private Integer initPeriod;

    /**
     * 剩余期限
     */
    private Integer remainPeriod;

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
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

    public BigDecimal getTransferEaInterestAmount() {
        return transferEaInterestAmount;
    }

    public void setTransferEaInterestAmount(BigDecimal transferEaInterestAmount) {
        this.transferEaInterestAmount = transferEaInterestAmount;
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

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

}
