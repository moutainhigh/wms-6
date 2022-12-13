package com.dx.cmm.web.controller.credit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.credit.CreditPoolResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.PerUtils;

public class PoolResult extends Result {

    /**
     */
    private static final long serialVersionUID = 1527479041435273168L;

    private static final String ZERO = "0.00";
    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 还款日
     */
    private Integer repayDay;

    /**
     * 姓名
     */
    private String custName;

    /**
     * 初始借款金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 初始借款金额
     */
    private String initTotalAmountView;

    /**
     * 还款起始
     */
    private Date repayBeginDate;

    /**
     * 还款起始
     */
    private String repayBeginDateView;

    /**
     * 还款期限
     */
    private Integer initPeriod;

    /**
     * 剩余还款月数
     */
    private Integer remainPeriod;

    /**
     * 预计债权收益率(年)
     */
    private BigDecimal rateYear;

    /**
     * 预计债权收益率(年)
     */
    private String rateYearView;

    /**
     * 产品类型
     */
    private Long productId;

    /**
     * 产品类型
     */
    private String productView;

    /**
     * 每期还款
     */
    private BigDecimal repayAmount;

    /**
     * 每期还款
     */
    private String repayAmountView;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    /**
     * 月利率
     */
    private String rateMonthView;

    /**
     * 已还款期数
     */
    private Integer repayPeriod;

    /**
     * 当期剩余本金 （期初）| 当期期初债权
     */
    private BigDecimal currentTotalAmount;

    /**
     * 当期剩余本金 （期初）| 当期期初债权
     */
    private String currentTotalAmountView;

    /**
     * 当期新增资金
     */
    private BigDecimal currentDoneAmount;

    /**
     * 当期新增资金
     */
    private String currentDoneAmountView;

    /**
     * 当前剩余债权
     */
    private BigDecimal currentUndoAmount;

    /**
     * 当前剩余债权
     */
    private String currentUndoAmountView;

    /**
     * 上期债权总价值
     */
    private BigDecimal lastTotalAmount;

    /**
     * 上期债权总价值
     */
    private String lastTotalAmountView;

    /**
     * 上期已匹配价值
     */
    private BigDecimal lastDoneAmount;

    /**
     * 上期已匹配价值
     */
    private String lastDoneAmountView;

    /**
     * 上期未匹配价值
     */
    private BigDecimal lastUndoAmount;

    /**
     * 上期未匹配价值
     */
    private String lastUndoAmountView;

    /**
     * 上期应还利息
     */
    private BigDecimal lastInterest;

    /**
     * 上期应还利息
     */
    private String lastInterestView;

    /**
     * 上期应还本金
     */
    private BigDecimal lastCapital;

    /**
     * 上期应还本金
     */
    private String lastCapitalView;

    /**
     * 资金池编号
     */
    private Long poolId;

    public PoolResult(CreditPoolResult result, final Map<Long, String> product) {
        BeanUtils.copyProperties(result, this);
        setRepayPeriod().setInitTotalAmountView().setRepayBeginDateView().setRateYearView().setProductView(product)
                .setRepayAmountView().setRateMonthView().setCurrentTotalAmountView().setCurrentUndoAmountView()
                .setCurrentDoneAmountView().setLastTotalAmountView().setLastUndoAmountView().setLastDoneAmountView()
                .setLastCapitalView().setLastInterestView();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Integer repayDay) {
        this.repayDay = repayDay;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public PoolResult setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
        return this;
    }

    public PoolResult setInitTotalAmountView() {
        return setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
    }

    public Date getRepayBeginDate() {
        return repayBeginDate;
    }

    public void setRepayBeginDate(Date repayBeginDate) {
        this.repayBeginDate = repayBeginDate;
    }

    public String getRepayBeginDateView() {
        return repayBeginDateView;
    }

    public PoolResult setRepayBeginDateView(String repayBeginDateView) {
        this.repayBeginDateView = repayBeginDateView;
        return this;
    }

    public PoolResult setRepayBeginDateView() {
        return setRepayBeginDateView(DateUtils.formatForDay(getRepayBeginDate()));
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

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    public String getRateYearView() {
        return rateYearView;
    }

    public PoolResult setRateYearView(String rateYearView) {
        this.rateYearView = rateYearView;
        return this;
    }

    public PoolResult setRateYearView() {
        return setRateYearView(PerUtils.format(getRateYear()));
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

    public PoolResult setProductView(String productView) {
        this.productView = productView;
        return this;
    }

    public PoolResult setProductView(final Map<Long, String> product) {
        return setProductView(product.get(getProductId()));
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getRepayAmountView() {
        return repayAmountView;
    }

    public PoolResult setRepayAmountView(String repayAmountView) {
        this.repayAmountView = repayAmountView;
        return this;
    }

    public PoolResult setRepayAmountView() {
        return setRepayAmountView(AmountUtils.format(getRepayAmount(), ZERO));
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

    public PoolResult setRateMonthView(String rateMonthView) {
        this.rateMonthView = rateMonthView;
        return this;
    }

    public PoolResult setRateMonthView() {
        return setRateMonthView(PerUtils.format(getRateMonth()));
    }

    public Integer getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(Integer repayPeriod) {
        this.repayPeriod = repayPeriod;
    }

    public PoolResult setRepayPeriod() {
        if (!Assert.checkParam(getRepayPeriod())) {
            setRepayPeriod(0);
        }
        return this;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public String getCurrentTotalAmountView() {
        return currentTotalAmountView;
    }

    public PoolResult setCurrentTotalAmountView(String currentTotalAmountView) {
        this.currentTotalAmountView = currentTotalAmountView;
        return this;
    }

    public PoolResult setCurrentTotalAmountView() {
        return setCurrentTotalAmountView(AmountUtils.format(getCurrentTotalAmount(), ZERO));
    }

    public BigDecimal getCurrentDoneAmount() {
        return currentDoneAmount;
    }

    public void setCurrentDoneAmount(BigDecimal currentDoneAmount) {
        this.currentDoneAmount = currentDoneAmount;
    }

    public String getCurrentDoneAmountView() {
        return currentDoneAmountView;
    }

    public PoolResult setCurrentDoneAmountView(String currentDoneAmountView) {
        this.currentDoneAmountView = currentDoneAmountView;
        return this;
    }

    public PoolResult setCurrentDoneAmountView() {
        return setCurrentDoneAmountView(AmountUtils.format(getCurrentDoneAmount(), ZERO));
    }

    public BigDecimal getCurrentUndoAmount() {
        return currentUndoAmount;
    }

    public void setCurrentUndoAmount(BigDecimal currentUndoAmount) {
        this.currentUndoAmount = currentUndoAmount;
    }

    public String getCurrentUndoAmountView() {
        return currentUndoAmountView;
    }

    public PoolResult setCurrentUndoAmountView(String currentUndoAmountView) {
        this.currentUndoAmountView = currentUndoAmountView;
        return this;
    }

    public PoolResult setCurrentUndoAmountView() {
        return setCurrentUndoAmountView(AmountUtils.format(getCurrentUndoAmount(), ZERO));
    }

    public BigDecimal getLastTotalAmount() {
        return lastTotalAmount;
    }

    public void setLastTotalAmount(BigDecimal lastTotalAmount) {
        this.lastTotalAmount = lastTotalAmount;
    }

    public String getLastTotalAmountView() {
        return lastTotalAmountView;
    }

    public PoolResult setLastTotalAmountView(String lastTotalAmountView) {
        this.lastTotalAmountView = lastTotalAmountView;
        return this;
    }

    public PoolResult setLastTotalAmountView() {
        return setLastTotalAmountView(AmountUtils.format(getLastTotalAmount(), ZERO));
    }

    public BigDecimal getLastDoneAmount() {
        return lastDoneAmount;
    }

    public void setLastDoneAmount(BigDecimal lastDoneAmount) {
        this.lastDoneAmount = lastDoneAmount;
    }

    public String getLastDoneAmountView() {
        return lastDoneAmountView;
    }

    public PoolResult setLastDoneAmountView(String lastDoneAmountView) {
        this.lastDoneAmountView = lastDoneAmountView;
        return this;
    }

    public PoolResult setLastDoneAmountView() {
        return setLastDoneAmountView(AmountUtils.format(getLastDoneAmount(), ZERO));
    }

    public BigDecimal getLastUndoAmount() {
        return lastUndoAmount;
    }

    public void setLastUndoAmount(BigDecimal lastUndoAmount) {
        this.lastUndoAmount = lastUndoAmount;
    }

    public String getLastUndoAmountView() {
        return lastUndoAmountView;
    }

    public PoolResult setLastUndoAmountView(String lastUndoAmountView) {
        this.lastUndoAmountView = lastUndoAmountView;
        return this;
    }

    public PoolResult setLastUndoAmountView() {
        return setLastUndoAmountView(AmountUtils.format(getLastUndoAmount(), ZERO));
    }

    public BigDecimal getLastInterest() {
        return lastInterest;
    }

    public void setLastInterest(BigDecimal lastInterest) {
        this.lastInterest = lastInterest;
    }

    public String getLastInterestView() {
        return lastInterestView;
    }

    public PoolResult setLastInterestView(String lastInterestView) {
        this.lastInterestView = lastInterestView;
        return this;
    }

    public PoolResult setLastInterestView() {
        return setLastInterestView(AmountUtils.format(getLastInterest(), ZERO));
    }

    public BigDecimal getLastCapital() {
        return lastCapital;
    }

    public void setLastCapital(BigDecimal lastCapital) {
        this.lastCapital = lastCapital;
    }

    public String getLastCapitalView() {
        return lastCapitalView;
    }

    public PoolResult setLastCapitalView(String lastCapitalView) {
        this.lastCapitalView = lastCapitalView;
        return this;
    }

    public PoolResult setLastCapitalView() {
        return setLastCapitalView(AmountUtils.format(getLastCapital(), ZERO));
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

}
