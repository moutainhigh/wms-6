package com.dx.wms.web.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.credit.CreditMatchResult;
import com.dx.common.service.utils.DateUtils;

public class ReMatchVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4814863147870765407L;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 转让债权价值
     */
    private BigDecimal transAmount;

    /**
     * 支付对价
     */
    private BigDecimal payAmount;

    /**
     * 职业状况
     */
    private String workState;

    /**
     * 借款用途
     */
    private String loanType;

    /**
     * 还款起始Vo
     */
    private String repayBeginDateVo;

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

    private String rateYearView;
    /**
     * 业务属性
     */
    private String bizAttr;

    public ReMatchVo(CreditMatchResult dto) {
        BeanUtils.copyProperties(dto, this);
        setWorkState(dto.getWorkState());
        setLoanType(dto.getLoanType());
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
        setRateYearView(nf.format(dto.getRateYear()));
        setRepayBeginDateVo(DateUtils.formatForDay(dto.getRepayBeginDate()));
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getRepayBeginDateVo() {
        return repayBeginDateVo;
    }

    public void setRepayBeginDateVo(String repayBeginDateVo) {
        this.repayBeginDateVo = repayBeginDateVo;
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

    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public String getRateYearView() {
        return rateYearView;
    }

    public void setRateYearView(String rateYearView) {
        this.rateYearView = rateYearView;
    }

}
