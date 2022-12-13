package com.dx.cmm.service.queues;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.dx.cmm.enums.BizCategory;

/**
 * 
 * 队列结果Dto
 *
 * @author tony
 */
public class ResultQueue implements Serializable {

    /**
     */
    private static final long serialVersionUID = -6418918653514300388L;

    /**
     * 匹配业务基础编号
     */
    private Long matchBizBaseId;

    /**
     * 客户姓名
     */
    private String matchCustName;

    /**
     * 匹配用户-客户编号
     */
    private String matchCustCode;

    /**
     * 身份证
     */
    private String matchCustIdCard;

    /**
     * 借款金额||出借金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 初始匹配月数
     */
    private Integer initPeriod;

    /**
     * 还款日
     */
    private Integer matchDay;

    /**
     * 产品类型||出借方式
     */
    private Long productId;

    /**
     * 还款起止日期-起||预计出借日期-起
     */
    private Date bizDateBegin;

    /**
     * 还款起止日期-止||预计出借日期-止
     */
    private Date bizDateEnd;

    /**
     * 初始账单日
     */
    private Date initBillDate;

    /**
     * 签约日期
     */
    private Date signDate;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 进件日期
     */
    private Date enterDate;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 属性
     */
    private String attr;

    /**
     * 账单金额
     */
    private BigDecimal initEaBillAmount;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 业务类别
     */
    private BizCategory bizCategory;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    /**
     * 预计收益率-年
     */
    private BigDecimal rateYear;

    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
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

    public String getMatchCustIdCard() {
        return matchCustIdCard;
    }

    public void setMatchCustIdCard(String matchCustIdCard) {
        this.matchCustIdCard = matchCustIdCard;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public Date getBizDateBegin() {
        return bizDateBegin;
    }

    public void setBizDateBegin(Date bizDateBegin) {
        this.bizDateBegin = bizDateBegin;
    }

    public Date getBizDateEnd() {
        return bizDateEnd;
    }

    public void setBizDateEnd(Date bizDateEnd) {
        this.bizDateEnd = bizDateEnd;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public BigDecimal getInitEaBillAmount() {
        return initEaBillAmount;
    }

    public void setInitEaBillAmount(BigDecimal initEaBillAmount) {
        this.initEaBillAmount = initEaBillAmount;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Date getInitBillDate() {
        return initBillDate;
    }

    public void setInitBillDate(Date initBillDate) {
        this.initBillDate = initBillDate;
    }

    public BizCategory getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(BizCategory bizCategory) {
        this.bizCategory = bizCategory;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public void setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

}
