package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.service.queues.ResultQueue;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.PerUtils;

/**
 * 
 * 队列结果Vo<br>
 * 队列结果Vo
 *
 * @author tony
 */
public class QueueResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3259311556746237099L;

    /**
     * 匹配业务基础编号
     */
    private Long matchBizBaseId;

    /**
     * 客户姓名
     */
    private String matchCustName;

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
     * 剩余匹配月数
     */
    private Integer remainPeriod;

    /**
     * 还款日
     */
    private Integer matchDay;

    /**
     * 产品类型||出借方式
     */
    private Long productId;

    /**
     * 初始账单日
     */
    private Date initBillDate;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    /**
     * 预计收益率-年
     */
    private BigDecimal rateYear;

    /**
     * 账单金额
     */
    private BigDecimal initEaBillAmount;

    /**
     * 匹配用户-客户编号
     */
    private String matchCustCode;

    /**
     * 借款金额||出借金额
     */
    private String initTotalAmountView;

    /**
     * 产品类型||出借方式
     */
    private String productView;

    /**
     * 还款起止日期-起||预计出借日期-起
     */
    private Date bizDateBegin;

    /**
     * 还款起止日期-起||预计出借日期-起
     */
    private String bizDateBeginView;

    /**
     * 还款起止日期-止||预计出借日期-止
     */
    private Date bizDateEnd;

    /**
     * 还款起止日期-止||预计出借日期-止
     */
    private String bizDateEndView;

    /**
     * 还款起止日期 ||预计出借日期
     */
    private String bizDateView;

    /**
     * 初始账单日
     */
    private Date initBillDateView;

    /**
     * 签约日期
     */
    private Date signDate;

    /**
     * 签约日期
     */
    private String signDateView;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 申请日期
     */
    private String applyDateView;

    /**
     * 进件日期
     */
    private Date enterDate;

    /**
     * 进件日期
     */
    private String enterDateView;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 月利率
     */
    private String rateMonthView;

    /**
     * 预计收益率-年
     */
    private String rateYearView;

    /**
     * 账单金额
     */
    private String initEaBillAmountView;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    public QueueResultVo() {

    }

    public QueueResultVo(ResultQueue result, Map<String, String> product, Long userId) {
        BeanUtils.copyProperties(result, this);
        setCreateUser(userId);
        setUpdateUser(userId);
        CreditAttr attr = Assert.checkParam(result.getAttr())
                ? JSON.parseObject(result.getAttr(), CreditAttr.class) : new CreditAttr();
        view(product, attr);
    }

    private void view(Map<String, String> product, CreditAttr attr) {
        setProductView(product.get(getProductId().toString()));
        setBizDateBeginView(DateUtils.formatForDay(getBizDateBegin(), "-"));
        setBizDateEndView(DateUtils.formatForDay(getBizDateEnd(), "-"));
        String bizDateView = MessageFormat.format("{0} 至 {1}", getBizDateBeginView(), getBizDateEndView());
        setBizDateView(bizDateView);
        setSignDateView(DateUtils.formatForDay(getSignDate(), "-"));
        setApplyDateView(DateUtils.formatForDay(getApplyDate(), "-"));
        setEnterDateView(DateUtils.formatForDay(getEnterDate(), "-"));
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), "0.00"));
        setRateMonth(attr.getRate());
        setRateMonthView(PerUtils.format(getRateMonth()));
        setRateYear(attr.getAnnualReRate());
        setRateYearView(PerUtils.format(getRateYear()));
        setInitEaBillAmountView(AmountUtils.format(getInitEaBillAmount(), "0.00"));
    }

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

    public String getBizDateBeginView() {
        return bizDateBeginView;
    }

    public void setBizDateBeginView(String bizDateBeginView) {
        this.bizDateBeginView = bizDateBeginView;
    }

    public Date getBizDateEnd() {
        return bizDateEnd;
    }

    public void setBizDateEnd(Date bizDateEnd) {
        this.bizDateEnd = bizDateEnd;
    }

    public String getBizDateEndView() {
        return bizDateEndView;
    }

    public void setBizDateEndView(String bizDateEndView) {
        this.bizDateEndView = bizDateEndView;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSignDateView() {
        return signDateView;
    }

    public void setSignDateView(String signDateView) {
        this.signDateView = signDateView;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyDateView() {
        return applyDateView;
    }

    public void setApplyDateView(String applyDateView) {
        this.applyDateView = applyDateView;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getEnterDateView() {
        return enterDateView;
    }

    public void setEnterDateView(String enterDateView) {
        this.enterDateView = enterDateView;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getBizDateView() {
        return bizDateView;
    }

    public void setBizDateView(String bizDateView) {
        this.bizDateView = bizDateView;
    }

    public String getMatchCustIdCard() {
        return matchCustIdCard;
    }

    public void setMatchCustIdCard(String matchCustIdCard) {
        this.matchCustIdCard = matchCustIdCard;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public void setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
    }

    public String getRateMonthView() {
        return rateMonthView;
    }

    public void setRateMonthView(String rateMonthView) {
        this.rateMonthView = rateMonthView;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    public String getRateYearView() {
        return rateYearView;
    }

    public void setRateYearView(String rateYearView) {
        this.rateYearView = rateYearView;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getMatchCustCode() {
        return matchCustCode;
    }

    public void setMatchCustCode(String matchCustCode) {
        this.matchCustCode = matchCustCode;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public Date getInitBillDate() {
        return initBillDate;
    }

    public void setInitBillDate(Date initBillDate) {
        this.initBillDate = initBillDate;
    }

    public Date getInitBillDateView() {
        return initBillDateView;
    }

    public void setInitBillDateView(Date initBillDateView) {
        this.initBillDateView = initBillDateView;
    }

    public BigDecimal getInitEaBillAmount() {
        return initEaBillAmount;
    }

    public void setInitEaBillAmount(BigDecimal initEaBillAmount) {
        this.initEaBillAmount = initEaBillAmount;
    }

    public String getInitEaBillAmountView() {
        return initEaBillAmountView;
    }

    public void setInitEaBillAmountView(String initEaBillAmountView) {
        this.initEaBillAmountView = initEaBillAmountView;
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

}