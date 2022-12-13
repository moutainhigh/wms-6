package com.dx.cmm.service.results;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 
 * 债权匹配管理-匹配结果
 *
 * @author tony
 */
@Entity(name = "t_match_result")
public class MatchResult extends BaseEntity {

    public static final String ERROR = "matchResult.queryError";

    /**
     */
    private static final long serialVersionUID = 359035080373770261L;

    /**
     * 重新匹配
     */
    private static final String REPEAT = "N";

    /**
     * 异常
     */
    private static final String EXCEPTION = "E";

    /**
     * 删除
     */
    private static final String DEL = "D";

    /**
     * 匹配结果-编号
     */
    private Long matchResultId;

    /**
     * 投资池-编号
     */
    private Long investmentPoolId;

    /**
     * 债权池-编号
     */
    private Long creditorPoolId;

    /**
     * 投资池-当前期数
     */
    private Integer currentPeriod;

    /**
     * 匹配结果-转让债权价值
     */
    private BigDecimal transferTotalAmount;

    /**
     * 匹配结果-支付对价
     */
    private BigDecimal payGiveAmount;

    /**
     * 匹配结果-报告日
     */
    private Date reportDate;

    /**
     * 匹配结果-债权比例
     */
    private BigDecimal creditorRate;

    /**
     * 匹配结果-转让金额-月
     */
    private BigDecimal transferEaAmount;

    /**
     * 匹配结果-转让金额-本金-月
     */
    private BigDecimal transferEaCapitalAmount;

    /**
     * 匹配结果-转让金额-利息
     */
    private BigDecimal transferEaInterestAmount;

    /**
     * 匹配结果-转让金额-部分-利息
     */
    private BigDecimal transferEaPartInterestAmount;

    /**
     * 投资报告日
     */
    private Date investReportDay;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    public MatchResult() {

    }

//    public MatchResult(Long userId, Match match, Date reportDate, Integer period) {
//        setInvestmentPoolId(match.getInvestPoolId()).setCreditorPoolId(match.getCreditPoolId()).setCurrentPeriod(period)
//                .setTransferTotalAmount(match.getMatchAmount()).setPayGiveAmount(match.getMatchAmount())
//                .setReportDate(reportDate).setUpdateTime().setCreateTime().setCreateUser(userId).setUpdateUser(userId)
//                .setDataStatus();
//
//    }

    public MatchResult(Integer currentPeriod, BigDecimal transferEaInterestAmount) {
        setCurrentPeriod(currentPeriod);
        setTransferEaInterestAmount(transferEaInterestAmount);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_result_id")
    public Long getMatchResultId() {
        return matchResultId;
    }

    public MatchResult setMatchResultId(Long matchResultId) {
        this.matchResultId = matchResultId;
        return this;
    }

    @Column(name = "investment_pool_id")
    public Long getInvestmentPoolId() {
        return investmentPoolId;
    }

    public MatchResult setInvestmentPoolId(Long investmentPoolId) {
        this.investmentPoolId = investmentPoolId;
        return this;
    }

    @Column(name = "creditor_pool_id")
    public Long getCreditorPoolId() {
        return creditorPoolId;
    }

    public MatchResult setCreditorPoolId(Long creditorPoolId) {
        this.creditorPoolId = creditorPoolId;
        return this;
    }

    @Column(name = "current_period")
    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public MatchResult setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
        return this;
    }

    public MatchResult nextCurrentPeriod() {
        return setCurrentPeriod(getCurrentPeriod() + 1);
    }

    @Column(name = "transfer_total_amount")
    public BigDecimal getTransferTotalAmount() {
        return transferTotalAmount;
    }

    public MatchResult setTransferTotalAmount(BigDecimal transferTotalAmount) {
        this.transferTotalAmount = transferTotalAmount;
        return this;
    }

    public MatchResult nextTransferTotalAmount() {
        return setTransferTotalAmount(getTransferTotalAmount().subtract(getTransferEaCapitalAmount()));
    }

    @Column(name = "pay_give_amount")
    public BigDecimal getPayGiveAmount() {
        return payGiveAmount;
    }

    public MatchResult setPayGiveAmount(BigDecimal payGiveAmount) {
        this.payGiveAmount = payGiveAmount;
        return this;
    }

    public MatchResult setPayGiveAmount() {
        return setPayGiveAmount(getTransferTotalAmount());
    }

    @Column(name = "report_date")
    public Date getReportDate() {
        return reportDate;
    }

    public MatchResult setReportDate(Date reportDate) {
        this.reportDate = reportDate;
        return this;
    }

    public MatchResult nextReportDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getReportDate());
        calendar.add(Calendar.MONTH, 1);
        return setReportDate(calendar.getTime());
    }

    @Column(name = "creditor_rate")
    public BigDecimal getCreditorRate() {
        return creditorRate;
    }

    public void setCreditorRate(BigDecimal creditorRate) {
        this.creditorRate = creditorRate;
    }

    @Column(name = "transfer_ea_amount")
    public BigDecimal getTransferEaAmount() {
        return transferEaAmount;
    }

    public MatchResult setTransferEaAmount(BigDecimal transferEaAmount) {
        this.transferEaAmount = transferEaAmount;
        return this;
    }

    @Column(name = "transfer_ea_capital_amount")
    public BigDecimal getTransferEaCapitalAmount() {
        return transferEaCapitalAmount;
    }

    public MatchResult setTransferEaCapitalAmount(BigDecimal transferEaCapitalAmount) {
        this.transferEaCapitalAmount = transferEaCapitalAmount;
        return this;
    }

    public MatchResult setTransferEaCapitalAmount() {
        return setTransferEaCapitalAmount(getTransferEaAmount().subtract(getTransferEaInterestAmount()));
    }

    @Column(name = "transfer_ea_interest_amount")
    public BigDecimal getTransferEaInterestAmount() {
        return transferEaInterestAmount;
    }

    public MatchResult setTransferEaInterestAmount(BigDecimal transferEaInterestAmount) {
        this.transferEaInterestAmount = transferEaInterestAmount;
        return this;
    }

    public MatchResult nextTransferEaInterestAmount() {
        return setTransferEaInterestAmount(
                getTransferTotalAmount().multiply(getRateMonth()).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Column(name = "transfer_ea_part_interest_amount")
    public BigDecimal getTransferEaPartInterestAmount() {
        return transferEaPartInterestAmount;
    }

    public MatchResult setTransferEaPartInterestAmount(BigDecimal transferEaPartInterestAmount) {
        this.transferEaPartInterestAmount = transferEaPartInterestAmount;
        return this;
    }

    public void del() {
        setDataStatus(DEL).setUpdateTime();
    }

    public void exception() {
        setDataStatus(EXCEPTION).setUpdateTime();
    }

    public void next() {
        setMatchResultId(null).nextCurrentPeriod().nextTransferTotalAmount().setPayGiveAmount().nextReportDate()
                .nextTransferEaInterestAmount().setTransferEaCapitalAmount().insert();
    }

    public void repeat() {
        setDataStatus(REPEAT).setUpdateTime();
    }

    public Date getInvestReportDay() {
        return investReportDay;
    }

    public void setInvestReportDay(Date investReportDay) {
        this.investReportDay = investReportDay;
    }

    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public void setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
    }

}
