package com.dx.cmm.service.pools;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.enums.Rule;
import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.results.MatchResult;
import com.dx.cmm.service.rules.ParamRuler;
import com.dx.cmm.service.rules.ResultRuler;
import com.dx.cmm.service.rules.RulerObserver;
import com.dx.cmm.service.users.MatchUser;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 债权匹配管理-债权池
 *
 * @author tony
 */
@Entity(name = "t_creditor_pool")
public class CreditorPool extends Pool {

    /**
     */
    private static final long serialVersionUID = 3504947980190560257L;

    /**
     * 规则分析-平均
     */
    private static final String AVG = "OUTPUT_BORROW_AVG";

    /**
     * 规则分析-最大
     */
    private static final String MAX = "OUTPUT_BORROW_MAX";

    /**
     * 规则分析-数量
     */
    private static final String NUM = "OUTPUT_BORROW_NUM";

    /**
     * 债权池-编号
     */
    private Long creditorPoolId;

    /**
     * 账单金额
     */
    private BigDecimal initEaBillAmount;

    /**
     * 债权池-剩余匹配月数
     */
    private Integer remainPeriod;

    /**
     * 债权池-匹配日
     */
    private Integer matchDay;

    /**
     * 报告日
     */
    private Integer reportDay;

    /**
     * 匹配结果集合
     */
    private List<MatchResult> results;

    /**
     * 剩余债权月数
     */
    private Integer remainMonths;

    public CreditorPool() {

    }

    public CreditorPool(MatchBizBase base, RulerObserver ruler, MatchUser user) {
        BeanUtils.copyProperties(base, this);
        CreditAttr attr = base.credit();
        setInitBillDate(base.getBizDateBegin());
        setMatchDay(base).setInitEaBillAmount(base).setRateYear(attr.getAnnualReRate()).setRateMonth(attr.getRate())
                .setInitTotalAmount(base).initCurrentTotalAmount().setInitPeriod(base).setProductId(base)
                .setMatchUserId(user).setDataStatus().setCreateTime().setCreateUser().setUpdateTime().setUpdateUser();
        setRemainPeriod();
        insert(ruler);
    }

    private void insert(RulerObserver ruler) {
        ResultRuler rule = ruler.parse(new ParamRuler(getInitTotalAmount(), Rule.BORROW_MATCH_RULE));
        setInitEaAmount(rule, AVG).setInitEaAmountRem(rule, AVG).setInitEaAmountMax(rule, MAX)
                .setMatchUserCount(rule, NUM).initCurrentTotalAmount().setCurrentUndoAmount();
    }

    private BigDecimal nextTotalAmount() {
        if (!Assert.checkParam(getCurrentUndoAmount())) {
            return getCurrentDoneAmount();
        }
        return getCurrentTotalAmount().subtract(getInitEaBillAmount().subtract(interest()));
    }

    public BigDecimal interest() {
        return getCurrentTotalAmount().multiply(getRateMonth()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal capital() {
        return getInitEaBillAmount().subtract(interest());
    }

    public void rollback(BigDecimal transAmount) throws ParamException {
        setCurrentDoneAmount(getCurrentDoneAmount().subtract(transAmount));
        setCurrentUndoAmount(getCurrentUndoAmount().add(transAmount))
                .setDataStatus(!Assert.checkParam(getCurrentDoneAmount()) ? INIT : PART);
    }

    public void match(Long userId, BigDecimal matchAmount) {
        setCurrentDoneAmount(getCurrentDoneAmount().add(matchAmount));
        setCurrentUndoAmount(getCurrentTotalAmount().subtract(getCurrentDoneAmount()));
        setUpdateTime().setUpdateUser(userId).setDataStatus(!Assert.checkParam(getCurrentUndoAmount()) ? MATCH
                : Assert.equals(getCurrentUndoAmount(), getCurrentTotalAmount()) ? INIT : PART);
    }

    public void exception() {
        setDataStatus(EXCEPTION).setUpdateTime();
    }

    public void remain(BigDecimal total, BigDecimal capital) {
        setRemainPeriod();
        if (getRemainPeriod()==0) {
            setCurrentDoneAmount(BigDecimal.ZERO).setCurrentTotalAmount(BigDecimal.ZERO)
            .setCurrentUndoAmount();
        }else{
            setCurrentDoneAmount(total.subtract(capital)).setCurrentTotalAmount(nextTotalAmount())
            .setCurrentUndoAmount();
        }
        setUpdateTime();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "creditor_pool_id")
    public Long getCreditorPoolId() {
        return creditorPoolId;
    }

    public void setCreditorPoolId(Long creditorPoolId) {
        this.creditorPoolId = creditorPoolId;
    }

    @Column(name = "init_ea_bill_amount")
    public BigDecimal getInitEaBillAmount() {
        return initEaBillAmount;
    }

    public CreditorPool setInitEaBillAmount(BigDecimal initEaBillAmount) {
        this.initEaBillAmount = initEaBillAmount;
        return this;
    }

    public CreditorPool setInitEaBillAmount(MatchBizBase base) {
        return setInitEaBillAmount(base.getBizAmount());
    }

    @Column(name = "remain_period")
    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public CreditorPool setRemainPeriod() {
        if (Assert.checkParam(getRemainPeriod())) {
            setRemainPeriod(getRemainPeriod() - 1);
        } else {
            setRemainPeriod(getInitPeriod());
        }
        return this;
    }

    @Column(name = "match_day")
    public Integer getMatchDay() {
        return matchDay;
    }

    public CreditorPool setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
        return this;
    }

    public CreditorPool setMatchDay(MatchBizBase base) {
        return setMatchDay(base.getBizBillDay());
    }

    public Integer getReportDay() {
        return reportDay;
    }

    public void setReportDay(Integer reportDay) {
        this.reportDay = reportDay;
    }

    public List<MatchResult> getResults() {
        return results;
    }

    public void setResults(List<MatchResult> results) {
        this.results = results;
    }

    public Integer getRemainMonths() {
        return remainMonths;
    }

    public void setRemainMonths(Integer remainMonths) {
        this.remainMonths = remainMonths;
    }

    public Boolean isException() {
        return Assert.equals(getDataStatus(), EXCEPTION);
    }

}
