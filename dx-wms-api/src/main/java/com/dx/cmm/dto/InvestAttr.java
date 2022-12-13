package com.dx.cmm.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.dx.common.service.utils.Assert;

/**
 * 
 * 投资属性
 *
 * @author tony
 */
public class InvestAttr implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3008374174613860394L;

    /**
     * 接受文件方式
     */
    private String msgWay;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 投资池-计息起算时间
     */
    private Date interestBeginTime;

    /**
     * 债权编号集合
     */
    private Set<Long> creditIds;

    /**
     * 支付时间
     */
    private Date payTime;

    public InvestAttr() {

    }

    public InvestAttr(String msgWay, String payWay) {
        setMsgWay(msgWay);
        setPayWay(payWay);
    }

    public String getMsgWay() {
        return msgWay;
    }

    public InvestAttr setMsgWay(String msgWay) {
        this.msgWay = msgWay;
        return this;
    }

    public String getPayWay() {
        return payWay;
    }

    public InvestAttr setPayWay(String payWay) {
        this.payWay = payWay;
        return this;
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public Set<Long> getCreditIds() {
        return creditIds;
    }

    public void setCreditIds(Set<Long> creditIds) {
        this.creditIds = creditIds;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public void update(InvestAttr attr) {
        if (Assert.checkParam(attr.getMsgWay())) {
            setMsgWay(attr.getMsgWay());
        }
        if (Assert.checkParam(attr.getPayWay())) {
            setPayWay(attr.getPayWay());
        }
    }
}