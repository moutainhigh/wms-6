/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: PayWay.java
 * Author:   朱道灵
 * Date:     2015年7月21日 下午6:17:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;

/**
 * 支付方式表
 *
 * @author 朱道灵
 */
@Entity(name = "t_pay_way")
public class PayWay extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -7565681899510080418L;

    /**
     * 支付方式-编号 主键
     */
    private Long payWayId;

    /**
     * 支付方式-名称
     */
    private String payWayName;

    /**
     * 支付方式-标示
     */
    private String payWayKey;

    /**
     * 支付方式-描述
     */
    private String payWayDesc;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "pay_way_id")
    public Long getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Long payWayId) {
        this.payWayId = payWayId;
    }

    @Column(name = "pay_way_name")
    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    @Column(name = "pay_way_key")
    public String getPayWayKey() {
        return payWayKey;
    }

    public void setPayWayKey(String payWayKey) {
        this.payWayKey = payWayKey;
    }

    @Column(name = "pay_way_desc")
    public String getPayWayDesc() {
        return payWayDesc;
    }

    public void setPayWayDesc(String payWayDesc) {
        this.payWayDesc = payWayDesc;
    }

}
