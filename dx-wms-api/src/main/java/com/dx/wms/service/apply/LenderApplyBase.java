/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyBase.java
 * Author:   朱道灵
 * Date:     2016年5月10日 上午4:23:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply;

import java.io.Serializable;

/**
 * 出借申请 基类
 *
 * @author 朱道灵
 */
public class LenderApplyBase implements Serializable{

    /**
     */
    private static final long serialVersionUID = 7069452306568741380L;
    
    /**
     * 划扣姓名
     */
    private String payAccountName;
    
    /**
     * 划扣银行
     */
    private Integer payBank;
    
    /**
     * 划扣支行
     */
    private String paySubBank;
    
    /**
     * 划扣帐户
     */
    private String payAccountNum;
    
    /**
     * 支付方式
     */
    private Integer payWayId;

    public String getPayAccountName() {
        return payAccountName;
    }

    public void setPayAccountName(String payAccountName) {
        this.payAccountName = payAccountName;
    }

    public Integer getPayBank() {
        return payBank;
    }

    public void setPayBank(Integer payBank) {
        this.payBank = payBank;
    }

    public String getPaySubBank() {
        return paySubBank;
    }

    public void setPaySubBank(String paySubBank) {
        this.paySubBank = paySubBank;
    }

    public String getPayAccountNum() {
        return payAccountNum;
    }

    public void setPayAccountNum(String payAccountNum) {
        this.payAccountNum = payAccountNum;
    }

    /**
     * @return the payWayId
     */
    public Integer getPayWayId() {
        return payWayId;
    }

    /**
     * @param payWayId the payWayId to set
     */
    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

}
