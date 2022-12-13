package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 队列参数Vo<br>
 * 队列参数Vo
 *
 * @author tony
 */
public class QueueParamVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2399083039453192340L;

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

}