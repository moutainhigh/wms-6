package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * 投资视图详细Dto<br>
 * 投资视图详细Dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ViewInvestDetailDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5698526073908813670L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 下个报告日
     */
    private Date nextReportDate;

    /**
     * 本报告日
     */
    private Date currentReportDate;

    /**
     * 报告周期-起
     */
    private Date reportDateBegin;

    /**
     * 报告周期-止
     */
    private Date reportDateEnd;

    /**
     * 报告日
     */
    private Integer reportDay;

    /**
     * 账户管理费
     */
    private BigDecimal accountManagerAmount;

    /**
     * 下个报告日借款人应还金额
     */
    private BigDecimal nextRepayAmount;

    /**
     * 本个报告日借款人应还金额
     */
    private BigDecimal currentRepayAmount;

    /**
     * 本个报告日出借金额
     */
    private BigDecimal currentLendAmount;

    /**
     * 本个报告日回收金额
     */
    private BigDecimal currentIncomeAmount;

    /**
     * 初始出借金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 下个报告日资产总额
     */
    private BigDecimal nextTotalAmount;

    /**
     * 上个报告日资产总额
     */
    private BigDecimal lastTotalAmount;

    /**
     * 本个报告日资产总额
     */
    private BigDecimal currentTotalAmount;

    /**
     * 匹配日期
     */
    private Date matchDate;

    /**
     * 投资池编号
     */
    private Long poolId;

    /**
     * 投资生效日
     */
    private Date effectDate;

    /**
     * 转让日期
     */
    private Date transDate;
    /**
     * 债权列表
     */
    private List<ViewCreditDetailDto> dtos;

    public ViewInvestDetailDto() {

    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getNextReportDate() {
        return nextReportDate;
    }

    public void setNextReportDate(Date nextReportDate) {
        this.nextReportDate = nextReportDate;
    }

    public Date getCurrentReportDate() {
        return currentReportDate;
    }

    public void setCurrentReportDate(Date currentReportDate) {
        this.currentReportDate = currentReportDate;
    }

    public Date getReportDateBegin() {
        return reportDateBegin;
    }

    public void setReportDateBegin(Date reportDateBegin) {
        this.reportDateBegin = reportDateBegin;
    }

    public Date getReportDateEnd() {
        return reportDateEnd;
    }

    public void setReportDateEnd(Date reportDateEnd) {
        this.reportDateEnd = reportDateEnd;
    }

    public Integer getReportDay() {
        return reportDay;
    }

    public void setReportDay(Integer reportDay) {
        this.reportDay = reportDay;
    }

    public BigDecimal getAccountManagerAmount() {
        return accountManagerAmount;
    }

    public void setAccountManagerAmount(BigDecimal accountManagerAmount) {
        this.accountManagerAmount = accountManagerAmount;
    }

    public BigDecimal getNextRepayAmount() {
        return nextRepayAmount;
    }

    public void setNextRepayAmount(BigDecimal nextRepayAmount) {
        this.nextRepayAmount = nextRepayAmount;
    }

    public BigDecimal getCurrentRepayAmount() {
        return currentRepayAmount;
    }

    public void setCurrentRepayAmount(BigDecimal currentRepayAmount) {
        this.currentRepayAmount = currentRepayAmount;
    }

    public BigDecimal getCurrentLendAmount() {
        return currentLendAmount;
    }

    public void setCurrentLendAmount(BigDecimal currentLendAmount) {
        this.currentLendAmount = currentLendAmount;
    }

    public BigDecimal getCurrentIncomeAmount() {
        return currentIncomeAmount;
    }

    public void setCurrentIncomeAmount(BigDecimal currentIncomeAmount) {
        this.currentIncomeAmount = currentIncomeAmount;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public BigDecimal getNextTotalAmount() {
        return nextTotalAmount;
    }

    public void setNextTotalAmount(BigDecimal nextTotalAmount) {
        this.nextTotalAmount = nextTotalAmount;
    }

    public BigDecimal getLastTotalAmount() {
        return lastTotalAmount;
    }

    public void setLastTotalAmount(BigDecimal lastTotalAmount) {
        this.lastTotalAmount = lastTotalAmount;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public List<ViewCreditDetailDto> getDtos() {
        return dtos;
    }

    public void setDtos(List<ViewCreditDetailDto> dtos) {
        this.dtos = dtos;
    }

    public void first() {

    }

}
