package com.dx.op.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LoanDayResultVo implements Serializable {
    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 初始借款金额应为合同金额
     */
    private String contractAmountInfo;

    /**
     * 本次转让债权价值
     */
    private String creditorValueInfo;

    /**
     * 需支付对价
     */
    private String payAmountInfo;

    /**
     * 借款职业情况
     */
    private String professionStatusInfo;

    /**
     * 借款用途
     */
    private String loanTypeInfo;

    /**
     * 首次还款日
     */
    private Date refundFirstTime;

    /**
     * 首次还款日
     */
    private String refundFirstTimeInfo;

    /**
     * 还款期限（月）
     */
    private String approveDeadlineInfo;

    /**
     * 剩余还款期限
     */
    private String overplusDeadline;

    /**
     * 预计债权年收益率
     */
    private String pow;

    /**
     * 审批产品类型
     */
    private String approveProdTypeInfo;

    /**
     * 月偿还本息数额
     */
    private String backMoneyPer;

    /**
     * 还款止日
     */
    private String refundLastTime;

    /**
     * 划款金额（元）
     */
    private BigDecimal loanAmount;

    private String loanAmountInfo;

    /**
     * 实际月利率
     */
    private String realRate;

    /**
     * 还款日
     */
    private Integer repaymentDay;

    /**
     * 签约日期
     */
    private Date signTime;

    /**
     * 签约日期
     */
    private String signTimeInfo;

    /**
     * 职业原始
     */
    private String position;

    public String getBackMoneyPer() {
        return backMoneyPer;
    }

    public void setBackMoneyPer(String backMoneyPer) {
        this.backMoneyPer = backMoneyPer;
    }

    /**
     * @return the realRate
     */
    public String getRealRate() {
        return realRate;
    }

    /**
     * @param realRate the realRate to set
     */
    public void setRealRate(String realRate) {
        this.realRate = realRate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the professionStatusInfo
     */
    public String getProfessionStatusInfo() {
        return professionStatusInfo;
    }

    /**
     * @param professionStatusInfo the professionStatusInfo to set
     */
    public void setProfessionStatusInfo(String professionStatusInfo) {
        this.professionStatusInfo = professionStatusInfo;
    }

    /**
     * @return the loanTypeInfo
     */
    public String getLoanTypeInfo() {
        return loanTypeInfo;
    }

    /**
     * @param loanTypeInfo the loanTypeInfo to set
     */
    public void setLoanTypeInfo(String loanTypeInfo) {
        this.loanTypeInfo = loanTypeInfo;
    }

    /**
     * @return the refundFirstTime
     */
    public Date getRefundFirstTime() {
        return refundFirstTime;
    }

    /**
     * @param refundFirstTime the refundFirstTime to set
     */
    public void setRefundFirstTime(Date refundFirstTime) {
        this.refundFirstTime = refundFirstTime;
    }

    public String getRefundFirstTimeInfo() {
        return refundFirstTimeInfo;
    }

    public void setRefundFirstTimeInfo(String refundFirstTimeInfo) {
        this.refundFirstTimeInfo = refundFirstTimeInfo;
    }

    /**
     * @return the approveDeadlineInfo
     */
    public String getApproveDeadlineInfo() {
        return approveDeadlineInfo;
    }

    /**
     * @param approveDeadlineInfo the approveDeadlineInfo to set
     */
    public void setApproveDeadlineInfo(String approveDeadlineInfo) {
        this.approveDeadlineInfo = approveDeadlineInfo;
    }

    /**
     * @return the approveProdTypeInfo
     */
    public String getApproveProdTypeInfo() {
        return approveProdTypeInfo;
    }

    /**
     * @param approveProdTypeInfo the approveProdTypeInfo to set
     */
    public void setApproveProdTypeInfo(String approveProdTypeInfo) {
        this.approveProdTypeInfo = approveProdTypeInfo;
    }

    /**
     * @return the refundLastTime
     */
    public String getRefundLastTime() {
        return refundLastTime;
    }

    /**
     * @param refundLastTime the refundLastTime to set
     */
    public void setRefundLastTime(String refundLastTime) {
        this.refundLastTime = refundLastTime;
    }

    /**
     * @return the loanAmount
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @return the repaymentDay
     */
    public Integer getRepaymentDay() {
        return repaymentDay;
    }

    /**
     * @param repaymentDay the repaymentDay to set
     */
    public void setRepaymentDay(Integer repaymentDay) {
        this.repaymentDay = repaymentDay;
    }

    /**
     * @return the signTime
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * @param signTime the signTime to set
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignTimeInfo() {
        return signTimeInfo;
    }

    public void setSignTimeInfo(String signTimeInfo) {
        this.signTimeInfo = signTimeInfo;
    }

    /**
     * @return the overplusDeadline
     */
    public String getOverplusDeadline() {
        return overplusDeadline;
    }

    /**
     * @param overplusDeadline the overplusDeadline to set
     */
    public void setOverplusDeadline(String overplusDeadline) {
        this.overplusDeadline = overplusDeadline;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the pow
     */
    public String getPow() {
        return pow;
    }

    /**
     * @param pow the pow to set
     */
    public void setPow(String pow) {
        this.pow = pow;
    }

    public String getContractAmountInfo() {
        return contractAmountInfo;
    }

    public void setContractAmountInfo(String contractAmountInfo) {
        this.contractAmountInfo = contractAmountInfo;
    }

    public String getCreditorValueInfo() {
        return creditorValueInfo;
    }

    public void setCreditorValueInfo(String creditorValueInfo) {
        this.creditorValueInfo = creditorValueInfo;
    }

    public String getPayAmountInfo() {
        return payAmountInfo;
    }

    public void setPayAmountInfo(String payAmountInfo) {
        this.payAmountInfo = payAmountInfo;
    }

    public String getLoanAmountInfo() {
        return loanAmountInfo;
    }

    public void setLoanAmountInfo(String loanAmountInfo) {
        this.loanAmountInfo = loanAmountInfo;
    }

}
