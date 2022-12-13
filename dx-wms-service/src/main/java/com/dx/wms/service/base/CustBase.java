/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.common.service.utils.DateUtils;
import com.dx.wms.common.BaseEntity;

/**
 * 客户基本信息实体类
 * 
 * @author 王蕊
 *
 */
@Entity(name = "t_cust_base")
public class CustBase extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 3120691288151903298L;

    /**
     * 主键ID
     */
    private Long custId;

    /**
     * 客户编号
     */
    private String custCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 客户来源
     */
    private Integer custSource;

    /**
     * 客户来源-其他
     */
    private String custSourceOther;

    /**
     * 注册日期
     */
    private String registerTime;

    public CustBase() {
        setCreateTime(new Date());
        setUpdateTime(new Date());
        setDataStatus("A");
        setRegisterTime();
    }

    /**
     * @return the custId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_id")
    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    @Column(name = "cust_code")
    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Column(name = "id_type")
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "cust_source")
    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    @Column(name = "cust_source_other")
    public String getCustSourceOther() {
        return custSourceOther;
    }

    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime() {
        this.registerTime = DateUtils.formatForDay(getCreateTime());
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

}
