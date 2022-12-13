/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 客户基本信息实体类
 * 
 * @author 王蕊
 *
 */
@Entity(name = "t_cust_base")
public class CustBase implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long custId;

    /** 客户编号 */
    private String custCode;

    /** 客户姓名 */
    private String custName;

    /** 证件类型 */
    private Integer idType;

    /** 证件号码 */
    private String idCard;

    /** 手机号码 */
    private String mobile;

    /** 性别 */
    private Integer sex;

    /** 客户来源 */
    private Integer custSource;

    /** 客户来源其他 */
    private String custSourceOther;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private Long createUser;

    /** 更新时间 */
    private Date updateTime;

    /** 更新人 */
    private Long updateUser;

    /** 数据状态 */
    private String dataStatus;

    /**
     * @return the custId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_id")
    public Long getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * @return the custCode
     */
    @Column(name = "cust_code")
    public String getCustCode() {
        return custCode;
    }

    /**
     * @param custCode the custCode to set
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    /**
     * @return the custName
     */
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the idCategory
     */
    @Column(name = "id_type")
    public Integer getIdType() {
        return idType;
    }

    /**
     * @param idCategory the idCategory to set
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * @return the idCard
     */
    @Column(name = "id_card")
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
     * @return the mobile
     */
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the sex
     */
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the custSource
     */
    @Column(name = "cust_source")
    public Integer getCustSource() {
        return custSource;
    }

    /**
     * @param custSource the custSource to set
     */
    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    /**
     * @return the custSourceOther
     */
    @Column(name = "cust_source_other")
    public String getCustSourceOther() {
        return custSourceOther;
    }

    /**
     * @param custSourceOther the custSourceOther to set
     */
    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    /**
     * @return the createTime
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the createUser
     */
    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the updateTime
     */
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the updateUser
     */
    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return the dataStatus
     */
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * @param dataStatus the dataStatus to set
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public void status(CustAccount account) {
        setDataStatus(account.getDataStatus());
        setUpdateTime(new Date());
    }
}
