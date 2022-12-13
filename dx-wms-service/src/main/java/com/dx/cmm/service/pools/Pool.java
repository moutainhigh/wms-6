package com.dx.cmm.service.pools;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.entitys.BaseEntity;
import com.dx.cmm.service.rules.ResultRuler;
import com.dx.cmm.service.users.MatchUser;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;

/**
 * 
 * 基础资金池
 *
 * @author tony
 */
public class Pool extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -8089473617743258270L;

    /**
     * 部分匹配
     */
    static final String PART = "P";

    /**
     * 匹配
     */
    static final String MATCH = "M";

    /**
     * 异常
     */
    static final String EXCEPTION = "E";
    

    /**
     * 匹配用户编号
     */
    private Long matchUserId;

    /**
     * 匹配业务基础编号
     */
    private Long matchBizBaseId;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 初始总金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 初始单笔价值
     */
    private BigDecimal initEaAmount;

    /**
     * 匹配用户-人数
     */
    private Integer matchUserCount;

    /**
     * 当前总交易价值
     */
    private BigDecimal currentTotalAmount;

    /**
     * 当前已交易价值
     */
    private BigDecimal currentDoneAmount = BigDecimal.ZERO;

    /**
     * 当前可交易价值
     */
    private BigDecimal currentUndoAmount;

    /**
     * 初始单笔价值-余
     */
    private BigDecimal initEaAmountRem;

    /**
     * 初始单笔价值-上限
     */
    private BigDecimal initEaAmountMax;

    /**
     * 初始匹配月数
     */
    private Integer initPeriod;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    /**
     * 预计收益率-年
     */
    private BigDecimal rateYear;

    /**
     * 初始账单日
     */
    private Date initBillDate;

    /**
     * 身份证号
     */
    private String matchCustIdCard;

    /**
     * 姓名
     */
    private String matchCustName;

    /**
     * 客户编号
     */
    private String matchCustCode;

    /**
     * 当前报告日
     */
    private Date currentReportDate;

    @Column(name = "match_user_id")
    public Long getMatchUserId() {
        return matchUserId;
    }

    public Pool setMatchUserId(Long matchUserId) {
        this.matchUserId = matchUserId;
        return this;
    }

    public Pool setMatchUserId(MatchUser user) {
        return setMatchUserId(user.getMatchUserId());
    }

    @Column(name = "match_biz_base_id")
    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    public Pool setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Pool setProductId(MatchBizBase base) {
        return setProductId(base.getBizProductId());
    }

    @Column(name = "init_total_amount")
    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public Pool setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
        return this;
    }

    public Pool setInitTotalAmount(MatchBizBase base) {
        return setInitTotalAmount(base.getBizTotalAmount());
    }

    @Column(name = "init_ea_amount")
    public BigDecimal getInitEaAmount() {
        return initEaAmount;
    }

    public Pool setInitEaAmount(BigDecimal initEaAmount) {
        if (Assert.checkParam(initEaAmount)) {
            this.initEaAmount = initEaAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return this;
    }

    public Pool setInitEaAmount(ResultRuler param, String key) {
        return setInitEaAmount(new BigDecimal(MapUtils.getValue(param.getResults(), key)));
    }

    @Column(name = "init_ea_amount_rem")
    public BigDecimal getInitEaAmountRem() {
        return initEaAmountRem;
    }

    public Pool setInitEaAmountRem(BigDecimal initEaAmountRem) {
        if (Assert.checkParam(initEaAmountRem)) {
            this.initEaAmountRem = initEaAmountRem.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return this;
    }

    public Pool setInitEaAmountRem(ResultRuler param, String key) {
        if (!Assert.checkParam(getInitEaAmount())) {
            setInitEaAmount(param, key);
        }
        return setInitEaAmountRem(getInitEaAmount());
    }

    @Column(name = "init_ea_amount_max")
    public BigDecimal getInitEaAmountMax() {
        return initEaAmountMax;
    }

    public Pool setInitEaAmountMax(BigDecimal initEaAmountMax) {
        if (Assert.checkParam(initEaAmountMax)) {
            this.initEaAmountMax = initEaAmountMax.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return this;
    }

    public Pool setInitEaAmountMax(ResultRuler param, String key) {
        return setInitEaAmountMax(new BigDecimal(MapUtils.getValue(param.getResults(), key)));
    }

    @Column(name = "match_user_count")
    public Integer getMatchUserCount() {
        return matchUserCount;
    }

    public Pool setMatchUserCount(Integer matchUserCount) {
        this.matchUserCount = matchUserCount;
        return this;
    }

    public Pool setMatchUserCount(ResultRuler param, String key) {
        return setMatchUserCount(new Integer(MapUtils.getValue(param.getResults(), key)));
    }

    @Column(name = "init_period")
    public Integer getInitPeriod() {
        return initPeriod;
    }

    public Pool setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
        return this;
    }

    public Pool setInitPeriod(MatchBizBase base) {
        return setInitPeriod(base.getBizPeriod());
    }

    @Column(name = "current_total_amount")
    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public Pool setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
        return this;
    }

    public Pool initCurrentTotalAmount() {
        return setCurrentTotalAmount(getInitTotalAmount()).setCurrentUndoAmount();
    }

    @Column(name = "current_done_amount")
    public BigDecimal getCurrentDoneAmount() {
        return currentDoneAmount;
    }

    public Pool setCurrentDoneAmount(BigDecimal currentDoneAmount) {
        this.currentDoneAmount = currentDoneAmount;
        return this;
    }

    @Column(name = "current_undo_amount")
    public BigDecimal getCurrentUndoAmount() {
        return currentUndoAmount;
    }

    public Pool setCurrentUndoAmount(BigDecimal currentUndoAmount) {
        this.currentUndoAmount = currentUndoAmount;
        return this;
    }

    public Pool setCurrentUndoAmount() {
        return setCurrentUndoAmount(getCurrentTotalAmount().subtract(getCurrentDoneAmount()));
    }

    @Column(name = "rate_month")
    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public Pool setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
        return this;
    }

    @Column(name = "rate_year")
    public BigDecimal getRateYear() {
        return rateYear;
    }

    public Pool setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
        return this;
    }

    @Column(name = "init_bill_date")
    public Date getInitBillDate() {
        return initBillDate;
    }

    public void setInitBillDate(Date initBillDate) {
        this.initBillDate = initBillDate;
    }

    public Pool setInitBillDate(MatchBizBase base) {
        setInitBillDate(base.getBizDateBegin());
        return this;
    }

    public String getMatchCustIdCard() {
        return matchCustIdCard;
    }

    public void setMatchCustIdCard(String matchCustIdCard) {
        this.matchCustIdCard = matchCustIdCard;
    }

    public String getMatchCustName() {
        return matchCustName;
    }

    public void setMatchCustName(String matchCustName) {
        this.matchCustName = matchCustName;
    }

    public String getMatchCustCode() {
        return matchCustCode;
    }

    public void setMatchCustCode(String matchCustCode) {
        this.matchCustCode = matchCustCode;
    }

    public Date getCurrentReportDate() {
        return currentReportDate;
    }

    public void setCurrentReportDate(Date currentReportDate) {
        this.currentReportDate = currentReportDate;
    }

}
