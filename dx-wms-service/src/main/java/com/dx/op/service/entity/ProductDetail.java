/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductDetail.java
 * Author:   朱道灵
 * Date:     2015年7月14日 下午10:02:32
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类 产品明细
 * 
 * @author 朱道灵
 */
@Entity(name = "t_product_detail")
public class ProductDetail implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 产品明细编号 主键 */
    private Long productDetailId;

    /** 产品明细名称 */
    private String productDetailName;

    /** 产品明细标示 */
    private String productDetailKey;

    /** 产品明细级别 */
    private Long productDetailLevel;

    /** 上级产品明细编号 */
    private Long upProductDetailId;

    /** 产品明细描述 */
    private String productDetailDesc;

    /** 产品明细-类型:{1:"Integer",2:"String",3:"BigDecimal",4:"Date"} */
    private Integer productDetailType;

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
     * 功能描述: 产品明细编号 主键<br>
     *
     * @return the productDetailId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "product_detail_id")
    public Long getProductDetailId() {
        return productDetailId;
    }

    /**
     * 功能描述: 产品明细编号 主键<br>
     *
     * @param productDetailId the productDetailId to set.
     * 
     */
    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    /**
     * 功能描述: 产品明细名称 <br>
     *
     * @return the productDetailName
     */
    @Column(name = "product_detail_name")
    public String getProductDetailName() {
        return productDetailName;
    }

    /**
     * 功能描述: 产品明细名称 <br>
     *
     * @param productDetailName the productDetailName to set.
     * 
     */
    public void setProductDetailName(String productDetailName) {
        this.productDetailName = productDetailName;
    }

    /**
     * 功能描述: 产品明细标示 <br>
     *
     * @return the productDetailKey
     */
    @Column(name = "product_detail_key")
    public String getProductDetailKey() {
        return productDetailKey;
    }

    /**
     * 功能描述: 产品明细标示 <br>
     *
     * @param productDetailKey the productDetailKey to set.
     * 
     */
    public void setProductDetailKey(String productDetailKey) {
        this.productDetailKey = productDetailKey;
    }

    /**
     * 功能描述: 产品明细级别 <br>
     *
     * @return the productDetailLevel
     */
    @Column(name = "product_detail_level")
    public Long getProductDetailLevel() {
        return productDetailLevel;
    }

    /**
     * 功能描述: 产品明细级别<br>
     *
     * @param productDetailLevel the productDetailLevel to set.
     * 
     */
    public void setProductDetailLevel(Long productDetailLevel) {
        this.productDetailLevel = productDetailLevel;
    }

    /**
     * 功能描述: 上级产品明细编号 <br>
     *
     * @return the upProductDetailId
     */
    @Column(name = "up_product_detail_id")
    public Long getUpProductDetailId() {
        return upProductDetailId;
    }

    /**
     * 功能描述: 上级产品明细编号<br>
     *
     * @param upProductDetailId the upProductDetailId to set.
     * 
     */
    public void setUpProductDetailId(Long upProductDetailId) {
        this.upProductDetailId = upProductDetailId;
    }

    /**
     * 功能描述: 产品明细描述 <br>
     *
     * @return the productDetailDesc
     */
    @Column(name = "product_detail_desc")
    public String getProductDetailDesc() {
        return productDetailDesc;
    }

    /**
     * 功能描述: 产品明细描述<br>
     *
     * @param productDetailDesc the productDetailDesc to set.
     * 
     */
    public void setProductDetailDesc(String productDetailDesc) {
        this.productDetailDesc = productDetailDesc;
    }

    /**
     * 功能描述: 产品明细-类型:{1:"Integer",2:"String",3:"BigDecimal",4:"Date"}<br>
     *
     * @return the productDetailType
     */
    @Column(name = "product_detail_type")
    public Integer getProductDetailType() {
        return productDetailType;
    }

    /**
     * 功能描述: 产品明细-类型:{1:"Integer",2:"String",3:"BigDecimal",4:"Date"}<br>
     *
     * @param productDetailType the productDetailType to set.
     * 
     */
    public void setProductDetailType(Integer productDetailType) {
        this.productDetailType = productDetailType;
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
