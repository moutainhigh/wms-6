package com.dx.cmm.service.funds;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 债权匹配管理-债权资金表
 *
 * @author tony
 */
@Entity(name = "t_creditor_fund")
public class CreditorFund extends Fund {

    /**
     */
    private static final long serialVersionUID = -8035413160343425118L;

    /**
     * 债权资金-编号
     */
    private Long creditorFundId;

    /**
     * 债权池-编号
     */
    private Long creditorPoolId;

    /**
     * 债权资金-账单日:{1,16}
     */
    private Integer creditorFundDay;

    /**
     * 上个报告日-债权总价值
     */
    private BigDecimal lastTotalAmount;

    /**
     * 上个报告日-已匹配总价值
     */
    private BigDecimal lastTotalDoneAmount;

    /**
     * 上个报告日-未匹配总价值
     */
    private BigDecimal lastTotalUndoAmount;

    /**
     * 上个报告日-已还本金
     */
    private BigDecimal lastRepaymentPrincalAmount;

    /**
     * 上个报告日-已还利息
     */
    private BigDecimal lastRepaymentInterestAmount;

    /**
     * 上个报告日-还款金额
     */
    private BigDecimal lastRepaymentAmount;

    /**
     * 
     */
    private Date initBillDate;

    public CreditorFund() {

    }

    public CreditorFund(CreditorPool pool, Integer currentPeriod) throws ParamException {
        Assert.notNull(new ParamException("Pool must not be null"), pool);
        setCreditorPoolId(pool).setCreditorFundDay(pool).setLastTotalAmount(pool).setLastTotalDoneAmount(pool)
                .setLastTotalUndoAmount(pool).setLastRepaymentAmount(pool).setLastRepaymentInterestAmount(pool)
                .setLastRepaymentPrincalAmount(pool).setCurrentPeriod(currentPeriod)
                .setReportDay(pool.getInitBillDate(), currentPeriod).setDataStatus().setCreateTime().setUpdateTime()
                .setCreateUser().setUpdateUser();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "creditor_fund_id")
    public Long getCreditorFundId() {
        return creditorFundId;
    }

    public void setCreditorFundId(Long creditorFundId) {
        this.creditorFundId = creditorFundId;
    }

    @Column(name = "creditor_pool_id")
    public Long getCreditorPoolId() {
        return creditorPoolId;
    }

    public CreditorFund setCreditorPoolId(Long creditorPoolId) {
        this.creditorPoolId = creditorPoolId;
        return this;
    }

    public CreditorFund setCreditorPoolId(CreditorPool pool) {
        Assert.notNull("Pool id must not be null", pool.getCreditorPoolId());
        return setCreditorPoolId(pool.getCreditorPoolId());
    }

    @Column(name = "creditor_fund_day")
    public Integer getCreditorFundDay() {
        return creditorFundDay;
    }

    public CreditorFund setCreditorFundDay(Integer creditorFundDay) {
        this.creditorFundDay = creditorFundDay;
        return this;
    }

    public CreditorFund setCreditorFundDay(CreditorPool pool) {
        return setCreditorFundDay(pool.getMatchDay());
    }

    @Column(name = "last_total_amount")
    public BigDecimal getLastTotalAmount() {
        return lastTotalAmount;
    }

    public CreditorFund setLastTotalAmount(BigDecimal lastTotalAmount) {
        this.lastTotalAmount = lastTotalAmount;
        return this;
    }

    public CreditorFund setLastTotalAmount(CreditorPool pool) {
        return setLastTotalAmount(pool.getCurrentTotalAmount());
    }

    @Column(name = "last_total_done_amount")
    public BigDecimal getLastTotalDoneAmount() {
        return lastTotalDoneAmount;
    }

    public CreditorFund setLastTotalDoneAmount(BigDecimal lastTotalDoneAmount) {
        this.lastTotalDoneAmount = lastTotalDoneAmount;
        return this;
    }

    public CreditorFund setLastTotalDoneAmount(CreditorPool pool) {
        return setLastTotalDoneAmount(pool.getCurrentDoneAmount());
    }

    @Column(name = "last_total_undo_amount")
    public BigDecimal getLastTotalUndoAmount() {
        return lastTotalUndoAmount;
    }

    public CreditorFund setLastTotalUndoAmount(BigDecimal lastTotalUndoAmount) {
        this.lastTotalUndoAmount = lastTotalUndoAmount;
        return this;
    }

    public CreditorFund setLastTotalUndoAmount(CreditorPool pool) {
        return setLastTotalUndoAmount(pool.getCurrentUndoAmount());
    }

    @Column(name = "last_repayment_princal_amount")
    public BigDecimal getLastRepaymentPrincalAmount() {
        return lastRepaymentPrincalAmount;
    }

    public CreditorFund setLastRepaymentPrincalAmount(BigDecimal lastRepaymentPrincalAmount) {
        this.lastRepaymentPrincalAmount = lastRepaymentPrincalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        return this;
    }

    public CreditorFund setLastRepaymentPrincalAmount(CreditorPool pool) {
        if (!Assert.checkParam(getLastRepaymentInterestAmount())) {
            setLastRepaymentInterestAmount(pool);
        }
        return setLastRepaymentPrincalAmount(pool.getInitEaBillAmount().subtract(getLastRepaymentInterestAmount()));
    }

    @Column(name = "last_repayment_interest_amount")
    public BigDecimal getLastRepaymentInterestAmount() {
        return lastRepaymentInterestAmount;
    }

    public CreditorFund setLastRepaymentInterestAmount(BigDecimal lastRepaymentInterestAmount) {
        this.lastRepaymentInterestAmount = lastRepaymentInterestAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        return this;
    }

    public CreditorFund setLastRepaymentInterestAmount(CreditorPool pool) {
        return setLastRepaymentInterestAmount(pool.getCurrentTotalAmount().multiply(pool.getRateMonth()));
    }

    @Column(name = "last_repayment_amount")
    public BigDecimal getLastRepaymentAmount() {
        return lastRepaymentAmount;
    }

    public CreditorFund setLastRepaymentAmount(BigDecimal lastRepaymentAmount) {
        this.lastRepaymentAmount = lastRepaymentAmount;
        return this;
    }

    public CreditorFund setLastRepaymentAmount(CreditorPool pool) {
        return setLastRepaymentAmount(pool.getInitEaBillAmount());
    }

    public Date getInitBillDate() {
        return initBillDate;
    }

    public void setInitBillDate(Date initBillDate) {
        this.initBillDate = initBillDate;
    }

}
