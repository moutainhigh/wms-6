package com.dx.cmm.service.queues;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.dx.cmm.enums.BizCategory;

/**
 * 
 * 参数队列
 *
 * @author tony
 */
public class ParamQueue implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2399083039453192340L;

    /**
     * 业务类别
     */
    private Integer type;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 还款日
     */
    private Integer repaymentDay;

    /**
     * 出借方式
     */
    private Long lenderWay;

    /**
     * 申请日期-起
     */
    private Date applyDateBegin;

    /**
     * 申请日期-止
     */
    private Date applyDateEnd;

    /**
     * 进件日期-起
     */
    private Date enterDateBegin;

    /**
     * 进件日期-止
     */
    private Date enterDateEnd;

    /**
     * 签约日期-起
     */
    private Date signDateBegin;

    /**
     * 签约日期-止
     */
    private Date siginDateEnd;

    /**
     * 业务总计金额
     */
    private BigDecimal bizTotalAmount;

    /**
     * 业务类型
     */
    private BizCategory biz;

    /**
     * 队列统计
     */
    private QueueStats stats;

    public ParamQueue() {

    }

    public ParamQueue(BizCategory biz) {
        setBiz(biz);
        setType(biz.getCode());
    }

    public ParamQueue(String biz) {
        setType(BizCategory.getCode(biz));
        setBiz(BizCategory.getEunm(biz));
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRepaymentDay() {
        return repaymentDay;
    }

    public void setRepaymentDay(Integer repaymentDay) {
        this.repaymentDay = repaymentDay;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getLenderWay() {
        return lenderWay;
    }

    public void setLenderWay(Long lenderWay) {
        this.lenderWay = lenderWay;
    }

    public Date getApplyDateBegin() {
        return applyDateBegin;
    }

    public void setApplyDateBegin(Date applyDateBegin) {
        this.applyDateBegin = applyDateBegin;
    }

    public Date getApplyDateEnd() {
        return applyDateEnd;
    }

    public void setApplyDateEnd(Date applyDateEnd) {
        this.applyDateEnd = applyDateEnd;
    }

    public Date getEnterDateBegin() {
        return enterDateBegin;
    }

    public void setEnterDateBegin(Date enterDateBegin) {
        this.enterDateBegin = enterDateBegin;
    }

    public Date getEnterDateEnd() {
        return enterDateEnd;
    }

    public void setEnterDateEnd(Date enterDateEnd) {
        this.enterDateEnd = enterDateEnd;
    }

    public Date getSignDateBegin() {
        return signDateBegin;
    }

    public void setSignDateBegin(Date signDateBegin) {
        this.signDateBegin = signDateBegin;
    }

    public Date getSiginDateEnd() {
        return siginDateEnd;
    }

    public void setSiginDateEnd(Date siginDateEnd) {
        this.siginDateEnd = siginDateEnd;
    }

    public BigDecimal getBizTotalAmount() {
        return bizTotalAmount;
    }

    public void setBizTotalAmount(BigDecimal bizTotalAmount) {
        this.bizTotalAmount = bizTotalAmount;
    }

    public BizCategory getBiz() {
        return biz;
    }

    public void setBiz(BizCategory biz) {
        this.biz = biz;
    }

    public QueueStats getStats() {
        return stats;
    }

    public void setStats(QueueStats stats) {
        this.stats = stats;
    }

}
