package com.dx.cmm.service.credit;

import java.math.BigDecimal;
import java.util.Date;

public class CreditPoolResult extends CreditBaseResult {

    /**
     */
    private static final long serialVersionUID = -4684425596404601366L;

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
     * 还款起始
     */
    private Date repayBeginDate;

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
     * 产品类型
     */
    private Long productId;

    /**
     * 每期还款
     */
    private BigDecimal repayAmount;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    /**
     * 已还款期数
     */
    private Integer repayPeriod;

    /**
     * 当期剩余本金 （期初）| 当期期初债权
     */
    private BigDecimal currentTotalAmount;

    /**
     * 当期新增资金
     */
    private BigDecimal currentDoneAmount;

    /**
     * 当前剩余债权
     */
    private BigDecimal currentUndoAmount;

    /**
     * 上期债权总价值
     */
    private BigDecimal lastTotalAmount;

    /**
     * 上期已匹配价值
     */
    private BigDecimal lastDoneAmount;

    /**
     * 上期未匹配价值
     */
    private BigDecimal lastUndoAmount;

    /**
     * 上期应还利息
     */
    private BigDecimal lastInterest;

    /**
     * 上期应还本金
     */
    private BigDecimal lastCapital;

    /**
     * 借款用途
     */
    private String loanType;

    /**
     * 职业状况
     */
    private String workState;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 业务属性
     */
    private String bizAttr;

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

    public Date getRepayBeginDate() {
        return repayBeginDate;
    }

    public void setRepayBeginDate(Date repayBeginDate) {
        this.repayBeginDate = repayBeginDate;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public void setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
    }

    public Integer getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(Integer repayPeriod) {
        this.repayPeriod = repayPeriod;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public BigDecimal getCurrentDoneAmount() {
        return currentDoneAmount;
    }

    public void setCurrentDoneAmount(BigDecimal currentDoneAmount) {
        this.currentDoneAmount = currentDoneAmount;
    }

    public BigDecimal getCurrentUndoAmount() {
        return currentUndoAmount;
    }

    public void setCurrentUndoAmount(BigDecimal currentUndoAmount) {
        this.currentUndoAmount = currentUndoAmount;
    }

    public BigDecimal getLastTotalAmount() {
        return lastTotalAmount;
    }

    public void setLastTotalAmount(BigDecimal lastTotalAmount) {
        this.lastTotalAmount = lastTotalAmount;
    }

    public BigDecimal getLastDoneAmount() {
        return lastDoneAmount;
    }

    public void setLastDoneAmount(BigDecimal lastDoneAmount) {
        this.lastDoneAmount = lastDoneAmount;
    }

    public BigDecimal getLastUndoAmount() {
        return lastUndoAmount;
    }

    public void setLastUndoAmount(BigDecimal lastUndoAmount) {
        this.lastUndoAmount = lastUndoAmount;
    }

    public BigDecimal getLastInterest() {
        return lastInterest;
    }

    public void setLastInterest(BigDecimal lastInterest) {
        this.lastInterest = lastInterest;
    }

    public BigDecimal getLastCapital() {
        return lastCapital;
    }

    public void setLastCapital(BigDecimal lastCapital) {
        this.lastCapital = lastCapital;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }
}
