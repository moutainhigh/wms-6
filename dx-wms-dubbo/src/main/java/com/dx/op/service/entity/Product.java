/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Product.java
 * Author:   朱道灵
 * Date:     2015年7月14日 下午9:05:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类 产品
 * 
 * @author 朱道灵
 */
@Entity(name = "t_product")
public class Product implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3197632535747222303L;

    /**
     * 理财端
     */
    public static final String WMS = "wms";

    /**
     * 信贷端
     */
    public static final String CCS = "ccs";
    
    /** 产品编号 主键 */
    private Long productId;

    /** 产品编号-规则 */
    private String productCode;

    /** 产品类型 ::{1:"理财端",2:"信贷端"}' */
    private String appCode;

    /** 产品名称 */
    private String productName;

    /** 产品级别 */
    private Integer productLevel;

    /** 上级产品编号 */
    private Long upProductId;

    /** 申请金额-下限 */
    private BigDecimal amountLowerLimit;

    /** 申请金额-上限 */
    private BigDecimal amountUpperLimit;

    /** 申请金额-阶梯 */
    private BigDecimal amountStep;

    /** 产品描述 */
    private String productDesc;

    /** 目标人群 */
    private String targetObject;

    /** 创建者:{"-1":"系统"} */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者:{"-1":"系统"} */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态:{"A":"已生效","D":"已删除"}； */
    private String dataStatus;

    /**
     * 功能描述: 产品编号 主键<br>
     *
     * @return the productId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    /**
     * 功能描述: 产品编号 主键<br>
     *
     * @param productId the productId to set.
     * 
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 功能描述: 产品编号-规则<br>
     *
     * @return the productCode
     */
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    /**
     * 功能描述: 产品编号-规则<br>
     *
     * @param productCode the productCode to set.
     * 
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 产品类型::{1:"理财端",2:"信贷端"}'<br>
     *
     * @return the ProductCategory
     */
    @Column(name = "app_code")
    public String getAppCode() {
        return appCode;
    }

    /**
     * 产品类型::{1:"理财端",2:"信贷端"}'<br>
     *
     * @param productCategory the productCategory to set.
     * 
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * 功能描述: 产品名称<br>
     *
     * @return the productName
     */
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    /**
     * 功能描述: 产品名称<br>
     *
     * @param productName the productName to set.
     * 
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 功能描述: 产品级别<br>
     *
     * @return the productLevel
     */
    @Column(name = "product_level")
    public Integer getProductLevel() {
        return productLevel;
    }

    /**
     * 功能描述:产品级别<br>
     *
     * @param productLevel the productLevel to set.
     * 
     */
    public void setProductLevel(Integer productLevel) {
        this.productLevel = productLevel;
    }

    /**
     * 功能描述: 上级产品编号<br>
     *
     * @return the upProductId
     */
    @Column(name = "up_product_id")
    public Long getUpProductId() {
        return upProductId;
    }

    /**
     * 功能描述: 上级产品编号<br>
     *
     * @param upProductId the upProductId to set.
     * 
     */
    public void setUpProductId(Long upProductId) {
        this.upProductId = upProductId;
    }

    /**
     * 功能描述: 申请金额-下限<br>
     *
     * @return the amountLowerLimit
     */
    @Column(name = "amount_lower_limit")
    public BigDecimal getAmountLowerLimit() {
        return amountLowerLimit;
    }

    /**
     * 功能描述: 申请金额-下限<br>
     *
     * @param amountLowerLimit the amountLowerLimit to set.
     * 
     */
    public void setAmountLowerLimit(BigDecimal amountLowerLimit) {
        this.amountLowerLimit = amountLowerLimit;
    }

    /**
     * 功能描述: 申请金额-上限<br>
     *
     * @return the amountUpperLimit
     */
    @Column(name = "amount_upper_limit")
    public BigDecimal getAmountUpperLimit() {
        return amountUpperLimit;
    }

    /**
     * 功能描述: 申请金额-上限<br>
     *
     * @param amountUpperLimit the amountUpperLimit to set.
     * 
     */
    public void setAmountUpperLimit(BigDecimal amountUpperLimit) {
        this.amountUpperLimit = amountUpperLimit;
    }

    /**
     * 功能描述: 申请金额-阶梯<br>
     *
     * @return the amountStep
     */
    @Column(name = "amount_step")
    public BigDecimal getAmountStep() {
        return amountStep;
    }

    /**
     * 功能描述: 申请金额-阶梯<br>
     *
     * @param amountStep the amountStep to set.
     * 
     */
    public void setAmountStep(BigDecimal amountStep) {
        this.amountStep = amountStep;
    }

    /**
     * 功能描述: 产品描述<br>
     *
     * @return the productDesc
     */
    @Column(name = "product_desc")
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * 功能描述: 产品描述<br>
     *
     * @param productDesc the productDesc to set.
     * 
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * 功能描述: 目标人群<br>
     *
     * @return the targetObject
     */
    @Column(name = "target_object")
    public String getTargetObject() {
        return targetObject;
    }

    /**
     * 功能描述: 目标人群<br>
     *
     * @param targetObject the targetObject to set.
     * 
     */
    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @return the createUser
     */
    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @param createUser the createUser to set.
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @return the createTime
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @param createTime the createTime to set.
     */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"}<br>
     *
     * @return the updateUser
     */
    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"} <br>
     *
     * @param updateUser the updateUser to set.
     */

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 功能描述: updateTime 更新时间 <br>
     *
     * @return the updateTime
     */

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 功能描述: 更新时间 <br>
     *
     * @param updateTime the updateTime to set.
     */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}；<br>
     *
     * @return the dataStatus
     */
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}<br>
     *
     * @param dataStatus the dataStatus to set.
     */

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
