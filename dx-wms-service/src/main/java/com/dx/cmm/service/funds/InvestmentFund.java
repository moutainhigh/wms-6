package com.dx.cmm.service.funds;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.pools.InvestmentPool;

/**
 * 
 * 债权匹配管理-投资资金表
 *
 * @author tony
 */
@Entity(name = "t_investment_fund")
public class InvestmentFund extends Fund {

    /**
     */
    private static final long serialVersionUID = -555219325559421750L;

    public static final String ERROR = "investmentFund.queryCurrentError";

    public static final String REPORT_NULL = "investmentFund.queryReportNull";

    /**
     * 已请求
     */
    private static final Integer IS_EXE = 1;

    /**
     * 投资资金-编号
     */
    private Long investmentFundId;

    /**
     * 投资池-编号
     */
    private Long investmentPoolId;

    /**
     * 投资池-账单日:{1,16}
     */
    private Integer investmentFundDay;

    /**
     * 下个报告日-债权转让总价值
     */
    private BigDecimal nextTransferTotalAmount;

    /**
     * 下个报告日-还款总价值
     */
    private BigDecimal nextRepaymentTotalAmount;

    /**
     * 下个报告日-利息总价值
     */
    private BigDecimal nextInterestTotalAmount;

    /**
     * 下个报告日-本金总价值
     */
    private BigDecimal nextPrincalTotalAmount;

    /**
     * 账户管理费
     */
    private BigDecimal accountManagementFee = BigDecimal.ZERO;

    /**
     * 理财人收益
     */
    private BigDecimal lenderIncomeAmount = BigDecimal.ZERO;

    /**
     * 初始账单日
     */
    private Date initBillDate;

    /**
     * 当期总匹配金额
     */
    private BigDecimal totalAmount;

    /**
     * 当前总本金
     */
    private BigDecimal totalCapital;

    /**
     * 当前总利息
     */
    private BigDecimal totalInterest;

    /**
     * 当期总还款金额
     */
    private BigDecimal totalEa;

    /**
     * 投资生效日
     */
    private Date interestBeginTime;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 顺位
     */
    private Integer dataIndex = 0;

    public InvestmentFund() {

    }

    public InvestmentFund(InvestmentPool pool, Date reportDay) {
        BeanUtils.copyProperties(pool, this);
        setReportDay(reportDay);
        init(pool);
    }

    public InvestmentFund(InvestmentPool pool) {
        BeanUtils.copyProperties(pool, this);
        setReportDay(pool.getInitBillDate());
        init(pool);
    }

    private void init(InvestmentPool pool) {
        setInvestmentFundDay(pool);
        setIsCurrent(IS_CURRENT);
        setAccountManagementFee(BigDecimal.ZERO);
        setLenderIncomeAmount(BigDecimal.ZERO);
        setCreateTime().setCreateUser().setUpdateTime().setUpdateUser().setDataStatus();
    }

    public void update(InvestmentPool pool) {
        setNextTransferTotalAmount(pool.getNextTransferTotalAmount());
        setNextRepaymentTotalAmount(pool.getNextRepaymentTotalAmount());
        setNextPrincalTotalAmount(pool.getNextPrincalTotalAmount());
        setNextInterestTotalAmount(pool.getNextInterestTotalAmount());
    }

    public void trans(InvestmentPool pool, BigDecimal interest) {
        setNextInterestTotalAmount(interest);
        setAccountManagementFee(pool.getTransCreditorAmount().subtract(pool.getTransTotalAmount()));
        setLenderIncomeAmount(pool.getTransTotalAmount().subtract(pool.getInitTotalAmount()));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "investment_fund_id")
    public Long getInvestmentFundId() {
        return investmentFundId;
    }

    public void setInvestmentFundId(Long investmentFundId) {
        this.investmentFundId = investmentFundId;
    }

    @Column(name = "investment_pool_id")
    public Long getInvestmentPoolId() {
        return investmentPoolId;
    }

    public void setInvestmentPoolId(Long investmentPoolId) {
        this.investmentPoolId = investmentPoolId;
    }

    @Column(name = "investment_fund_day")
    public Integer getInvestmentFundDay() {
        return investmentFundDay;
    }

    public void setInvestmentFundDay(Integer investmentFundDay) {
        this.investmentFundDay = investmentFundDay;
    }

    public void setInvestmentFundDay(InvestmentPool pool) {
        setInvestmentFundDay(pool.getBillDay());
    }

    @Column(name = "next_transfer_total_amount")
    public BigDecimal getNextTransferTotalAmount() {
        return nextTransferTotalAmount;
    }

    public void setNextTransferTotalAmount(BigDecimal nextTransferTotalAmount) {
        this.nextTransferTotalAmount = nextTransferTotalAmount;
    }

    @Column(name = "next_repayment_total_amount")
    public BigDecimal getNextRepaymentTotalAmount() {
        return nextRepaymentTotalAmount;
    }

    public void setNextRepaymentTotalAmount(BigDecimal nextRepaymentTotalAmount) {
        this.nextRepaymentTotalAmount = nextRepaymentTotalAmount;
    }

    @Column(name = "next_interest_total_amount")
    public BigDecimal getNextInterestTotalAmount() {
        return nextInterestTotalAmount;
    }

    public void setNextInterestTotalAmount(BigDecimal nextInterestTotalAmount) {
        this.nextInterestTotalAmount = nextInterestTotalAmount;
    }

    @Column(name = "next_princal_total_amount")
    public BigDecimal getNextPrincalTotalAmount() {
        return nextPrincalTotalAmount;
    }

    public void setNextPrincalTotalAmount(BigDecimal nextPrincalTotalAmount) {
        this.nextPrincalTotalAmount = nextPrincalTotalAmount;
    }

    @Column(name = "account_management_fee")
    public BigDecimal getAccountManagementFee() {
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    @Column(name = "lender_income_amount")
    public BigDecimal getLenderIncomeAmount() {
        return lenderIncomeAmount;
    }

    public void setLenderIncomeAmount(BigDecimal lenderIncomeAmount) {
        this.lenderIncomeAmount = lenderIncomeAmount;
    }

    @Column(name = "data_index")
    public Integer getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(Integer dataIndex) {
        this.dataIndex = dataIndex;
    }

    public Date getInitBillDate() {
        return initBillDate;
    }

    public void setInitBillDate(Date initBillDate) {
        this.initBillDate = initBillDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(BigDecimal totalCapital) {
        this.totalCapital = totalCapital;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getTotalEa() {
        return totalEa;
    }

    public void setTotalEa(BigDecimal totalEa) {
        this.totalEa = totalEa;
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void exe() {
        setDataIndex(IS_EXE);
        setUpdateTime();
    }

}
