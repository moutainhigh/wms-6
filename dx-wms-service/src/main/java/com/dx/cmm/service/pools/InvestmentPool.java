package com.dx.cmm.service.pools;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.enums.Rule;
import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.dto.TransferTotalDto;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.rules.ParamRuler;
import com.dx.cmm.service.rules.ResultRuler;
import com.dx.cmm.service.rules.RulerObserver;
import com.dx.cmm.service.users.MatchUser;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

/**
 * 
 * 债权匹配管理-投资池
 *
 * @author tony
 */
@Entity(name = "t_investment_pool")
public class InvestmentPool extends Pool {

    /**
     */
    private static final long serialVersionUID = 6376597898566053799L;

    /**
     * 规则分析-平均
     */
    private static final String AVG = "OUTPUT_LENDER_AVG";

    /**
     * 规则分析-最大
     */
    private static final String MAX = "OUTPUT_LENDER_MAX";

    /**
     * 规则分析-数量
     */
    private static final String NUM = "OUTPUT_LENDER_NUM";

    /**
     * 到期
     */
    public static final String TRANS = "T";

    /**
     * 失效
     */
    public static final String FAIL = "F";

    /**
     * 重新
     */
    public static final String NEW = "N";

    /**
     * 生效
     */
    public static final String SUCCESS = "S";

    /**
     * 续投
     */
    public static final String CONTINUE = "G";
    
    /**
     * 月满盈
     */
    public static final Long L007 = 34L;

    /**
     * 投资池-编号
     */
    private Long investmentPoolId;

    /**
     * 投资池-当前期数
     */
    private Integer currentPeriod;

    /**
     * 投资池-账单日
     */
    private Integer billDay;

    /**
     * 投资池-付款金额
     */
    private BigDecimal payTotalAmount;

    /**
     * 投资池-转让对价
     */
    private BigDecimal transTotalAmount;

    /**
     * 投资池-转让日债权价值
     */
    private BigDecimal transCreditorAmount;

    /**
     * 投资池-首次匹配时间
     */
    private Date initMatchTime;

    /**
     * 投资池-计息起算时间
     */
    private Date interestBeginTime;

    /**
     * 投资池-匹配时间
     */
    private Date matchTime;

    /**
     * 投资池-转让日期
     */
    private Date transTime;

    /**
     * 投资池-支付日期
     */
    private Date payTime;

    /**
     * 非数据库字段
     */

    /**
     * 投资池-出借编号
     */
    private Long lenderApplyId;

    /**
     * 投资池-是否固定类产品
     */
    private Boolean isFix;

    /**
     * 投资池-是否转让
     */
    private Boolean isTrans;

    /**
     * 下个报告日-债权转让总价值
     */
    private BigDecimal nextTransferTotalAmount = BigDecimal.ZERO;

    /**
     * 下个报告日-还款总价值
     */
    private BigDecimal nextRepaymentTotalAmount = BigDecimal.ZERO;

    /**
     * 下个报告日-利息总价值
     */
    private BigDecimal nextInterestTotalAmount = BigDecimal.ZERO;

    /**
     * 下个报告日-本金总价值
     */
    private BigDecimal nextPrincalTotalAmount = BigDecimal.ZERO;

    /**
     * 出借编号
     */
    private String lenderCode;

    
    private String versionKey;
    
    public InvestmentPool() {

    }

    public InvestmentPool(MatchBizBase base, RulerObserver ruler, MatchUser user) {
        BeanUtils.copyProperties(base, this);
        setInitTotalAmount(base).initCurrentTotalAmount().setInitPeriod(base).setProductId(base).setMatchUserId(user)
                .setDataStatus().setCreateTime().setCreateUser().setUpdateTime().setUpdateUser();
        setVersionKey("v1.1");
        rule(ruler);
    }

    private void rule(RulerObserver ruler) {
        ResultRuler rule = ruler.parse(new ParamRuler(getInitTotalAmount(), Rule.LENDER_MATCH_RULE));
        setInitEaAmount(rule, AVG).setInitEaAmountRem(rule, AVG).setInitEaAmountMax(rule, MAX)
                .setMatchUserCount(rule, NUM).initCurrentTotalAmount().setCurrentUndoAmount();
    }

    public void match(BigDecimal arg) {
        setCurrentDoneAmount(getCurrentDoneAmount().add(arg));
        setCurrentUndoAmount(getCurrentUndoAmount().subtract(arg));
    }

    public void isTrans() {
        setIsTrans(Integer.compare(getCurrentPeriod(), getInitPeriod()) > 0);
    }
    
    //下个报告日-债权转让总价值 ,服务费,理财人收益,债权总价值(匹配结果-转让债权价值之和)
    public void next(BigDecimal next, BigDecimal accountFee, BigDecimal income, BigDecimal match) {
        part().setCurrentTotalAmount(next.subtract(accountFee).subtract(income)).setCurrentDoneAmount(match)
                .setCurrentUndoAmount().setUpdateTime();
    }

    public void match(Long userId, Integer port, Date reportDate) {
        setBillDay(port).setCurrentPeriod(1).setMatchTime().setInitMatchTime();
        setInitBillDate(reportDate);
        setCurrentDoneAmount(getCurrentTotalAmount()).setCurrentUndoAmount().setDataStatus(MATCH).setUpdateTime()
                .setUpdateUser(userId);

    }

    public void repeat(Long userId) {
        setMatchTime();
        setCurrentDoneAmount(getCurrentTotalAmount()).setCurrentUndoAmount().setDataStatus(MATCH).setUpdateTime()
                .setUpdateUser(userId);

    }

    public void exp(Long userId) {
        setCurrentDoneAmount(getCurrentTotalAmount()).setCurrentUndoAmount().setDataStatus(SUCCESS).setUpdateTime()
                .setUpdateUser(userId);
    }

    public void back(Long userId) {
        setCurrentPeriod(getCurrentPeriod() + 1);
        setCurrentDoneAmount(getCurrentTotalAmount()).setCurrentUndoAmount(BigDecimal.ZERO).setDataStatus(SUCCESS)
                .setUpdateTime().setUpdateUser(userId);
    }

    public void success(Date validDate) throws ParamException {
        Assert.notNull(new ParamException("Valid date must not be null"), validDate);
        setDataStatus(SUCCESS).setUpdateTime();
        setInterestBeginTime(validDate);
    }

    public void fail() {
        setDataStatus(FAIL).setUpdateTime();
    }

    public void doContinue() {
        setDataStatus(CONTINUE).setUpdateTime();
    }

    public void calculate(TransferTotalDto dto) throws ParamException {
        Assert.notNull(new ParamException("dto is null"), dto);
        setNextInterestTotalAmount(dto.getTotalInterestAmount());
        setNextPrincalTotalAmount(dto.getTotalPrincalAmount());
        setNextRepaymentTotalAmount(dto.getTotalRepayAmount());
        setNextTransferTotalAmount(dto.getTotalRepayAmount().add(dto.getTotalInterestAmount()));
    }

    public void calculate(MatchResult result) throws ParamException {
        Assert.notNull(new ParamException("result is null"), result);
        setNextInterestTotalAmount(getNextInterestTotalAmount().add(result.getTransferEaPartInterestAmount()));
        setNextPrincalTotalAmount(getNextPrincalTotalAmount().add(result.getTransferEaCapitalAmount()));
        setNextRepaymentTotalAmount(getNextRepaymentTotalAmount().add(result.getTransferEaAmount()));
        setNextTransferTotalAmount(getNextTransferTotalAmount().add(result.getTransferTotalAmount())
                .add(result.getTransferEaPartInterestAmount()));
    }

    public void transFix(BigDecimal arg0, BigDecimal arg1,BigDecimal firstIncome) throws ParamException {
        Assert.notNull(new ParamException("Rate param must not be null"), arg0, arg1);
        Assert.notNull(new ParamException("Pool id[{0}] period must not be null", getInvestmentPoolId()),
                getInitPeriod());
        Assert.notNull(new ParamException("Pool id[{0}] interest time must not be null", getInvestmentPoolId()),
                getInterestBeginTime());
        setRateMonth(arg0);
        setRateYear(arg1);
        Date tmp = DateUtils.addMonth(getInterestBeginTime(), getInitPeriod());
        setTransTime(DateUtils.isHoliday(tmp) ? DateUtils.getNextWorkday(tmp) : tmp);
        //转让对价计算
        if(Assert.equals(getProductId(),L007)){
        	Assert.notNull("L007 firstIncome must not be null",firstIncome);
        	setTransTotalAmount(getInitTotalAmount().add(getInitTotalAmount().multiply(getRateMonth())).subtract(firstIncome).setScale(2,
                    BigDecimal.ROUND_HALF_UP));
        }else{
        	setTransTotalAmount(getInitTotalAmount().add(getInitTotalAmount().multiply(getRateMonth())).setScale(2,
                    BigDecimal.ROUND_HALF_UP));
        }
        setPayTotalAmount(getTransTotalAmount());

    }

    public void pay() {
        setPayTime(Assert.checkParam(getTransTime()) ? DateUtils.getNextWorkday(getTransTime()) : null);
    }

    public void pay(Date payTime, BigDecimal transCreditorAmount) {
        setPayTime(DateUtils.parseForBegin(DateUtils.formatForBegin(payTime)))
                .setTransCreditorAmount(getCurrentTotalAmount().add(transCreditorAmount)).setUpdateTime()
                .setDataStatus(TRANS);
    }
    
    public void test(BigDecimal transCreditorAmount){
        setTransCreditorAmount(getCurrentTotalAmount().add(transCreditorAmount));
    }

    public InvestmentPool part() {
        setDataStatus(PART);
        return this;
    }

    public InvestmentPool exception() {
        setDataStatus(EXCEPTION);
        return this;
    }

    public void repeat(BigDecimal back) {
        setCurrentDoneAmount(getCurrentDoneAmount().subtract(back)).setCurrentUndoAmount().setDataStatus(NEW);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "investment_pool_id")
    public Long getInvestmentPoolId() {
        return investmentPoolId;
    }

    public void setInvestmentPoolId(Long investmentPoolId) {
        this.investmentPoolId = investmentPoolId;
    }

    @Column(name = "current_period")
    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public InvestmentPool setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
        return this;
    }

    @Column(name = "bill_day")
    public Integer getBillDay() {
        return billDay;
    }

    public InvestmentPool setBillDay(Integer billDay) {
        this.billDay = billDay;
        return this;
    }

    @Column(name = "pay_total_amount")
    public BigDecimal getPayTotalAmount() {
        return payTotalAmount;
    }

    public void setPayTotalAmount(BigDecimal payTotalAmount) {
        this.payTotalAmount = payTotalAmount;
    }

    @Column(name = "trans_total_amount")
    public BigDecimal getTransTotalAmount() {
        return transTotalAmount;
    }

    public void setTransTotalAmount(BigDecimal transTotalAmount) {
        this.transTotalAmount = transTotalAmount;
    }

    @Column(name = "trans_creditor_amount")
    public BigDecimal getTransCreditorAmount() {
        return transCreditorAmount;
    }

    public InvestmentPool setTransCreditorAmount(BigDecimal transCreditorAmount) {
        this.transCreditorAmount = transCreditorAmount;
        return this;
    }

    @Column(name = "init_match_time")
    public Date getInitMatchTime() {
        return initMatchTime;
    }

    public void setInitMatchTime(Date initMatchTime) {
        this.initMatchTime = initMatchTime;
    }

    private InvestmentPool setInitMatchTime() {
        setInitMatchTime(new Date());
        return this;
    }

    @Column(name = "interest_begin_time")
    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    @Column(name = "match_time")
    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    private InvestmentPool setMatchTime() {
        setMatchTime(new Date());
        return this;
    }

    @Column(name = "trans_time")
    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    @Column(name = "pay_time")
    public Date getPayTime() {
        return payTime;
    }

    public InvestmentPool setPayTime(Date payTime) {
        this.payTime = payTime;
        return this;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public Boolean getIsFix() {
        return isFix;
    }

    public void setIsFix(Boolean isFix) {
        this.isFix = isFix;
    }

    public Boolean getIsTrans() {
        return isTrans;
    }

    public void setIsTrans(Boolean isTrans) {
        this.isTrans = isTrans;
    }

    public BigDecimal getNextTransferTotalAmount() {
        return nextTransferTotalAmount;
    }

    public void setNextTransferTotalAmount(BigDecimal nextTransferTotalAmount) {
        this.nextTransferTotalAmount = nextTransferTotalAmount;
    }

    public void total() {
        setNextTransferTotalAmount(getCurrentTotalAmount().add(getNextInterestTotalAmount()));
    }

    public BigDecimal getNextRepaymentTotalAmount() {
        return nextRepaymentTotalAmount;
    }

    public void setNextRepaymentTotalAmount(BigDecimal nextRepaymentTotalAmount) {
        this.nextRepaymentTotalAmount = nextRepaymentTotalAmount;
    }

    public void repay(BigDecimal repay) {
        setNextRepaymentTotalAmount(getNextRepaymentTotalAmount().add(repay));
    }

    public BigDecimal getNextInterestTotalAmount() {
        return nextInterestTotalAmount;
    }

    public void setNextInterestTotalAmount(BigDecimal nextInterestTotalAmount) {
        this.nextInterestTotalAmount = nextInterestTotalAmount;
    }

    public void interest(BigDecimal interest) {
        setNextInterestTotalAmount(getNextInterestTotalAmount().add(interest));
    }

    public BigDecimal getNextPrincalTotalAmount() {
        return nextPrincalTotalAmount;
    }

    public void setNextPrincalTotalAmount(BigDecimal nextPrincalTotalAmount) {
        this.nextPrincalTotalAmount = nextPrincalTotalAmount;
    }

    public void princal(BigDecimal princal) {
        setNextPrincalTotalAmount(getNextPrincalTotalAmount().add(princal));
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    @Column(name = "version_key")
    public String getVersionKey() {
        return versionKey;
    }

    public void setVersionKey(String versionKey) {
        this.versionKey = versionKey;
    }
    
  
}
