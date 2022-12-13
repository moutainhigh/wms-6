/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductDetailRelation.java
 * Author:   朱道灵
 * Date:     2015年7月15日 上午10:33:12
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
 * 实体类 产品明细 关系
 * 
 * @author 朱道灵
 */
@Entity(name = "t_product_detail_relation")
public class ProductDetailRelation implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1323362553786156037L;

    /**
     * 产品明细关系编号 主键
     */
    private Long productDetailRelationId;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 产品编号-规则
     */
    private String productCode;

    /**
     * 产品明细编号
     */
    private Long productDetailId;

    /**
     * 产品明细标示
     */
    private String productDetailKey;

    /**
     * 产品明细关系-存值
     */
    private String productDetailRelationVal;

    /**
     * 产品明细关系-顺位
     */
    private Long productDetailRelationIndex;

    /**
     * 有效期-起
     */
    private Date validDateBegin;

    /**
     * 有效期-止
     */
    private Date validDateEnd;

    /**
     * 创建者:{"-1":"系统"}
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者:{"-1":"系统"}
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据状态:{"A":"已生效","D":"已删除"}；
     */
    private String dataStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "product_detail_relation_id")
    public Long getProductDetailRelationId() {
        return productDetailRelationId;
    }

    public void setProductDetailRelationId(Long productDetailRelationId) {
        this.productDetailRelationId = productDetailRelationId;
    }

    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Column(name = "product_detail_id")
    public Long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    @Column(name = "product_detail_key")
    public String getProductDetailKey() {
        return productDetailKey;
    }

    public void setProductDetailKey(String productDetailKey) {
        this.productDetailKey = productDetailKey;
    }

    @Column(name = "product_detail_relation_val")
    public String getProductDetailRelationVal() {
        return productDetailRelationVal;
    }

    public void setProductDetailRelationVal(String productDetailRelationVal) {
        this.productDetailRelationVal = productDetailRelationVal;
    }

    @Column(name = "product_detail_relation_index")
    public Long getProductDetailRelationIndex() {
        return productDetailRelationIndex;
    }

    public void setProductDetailRelationIndex(Long productDetailRelationIndex) {
        this.productDetailRelationIndex = productDetailRelationIndex;
    }

    @Column(name = "valid_date_begin")
    public Date getValidDateBegin() {
        return validDateBegin;
    }

    public void setValidDateBegin(Date validDateBegin) {
        this.validDateBegin = validDateBegin;
    }

    @Column(name = "valid_date_end")
    public Date getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(Date validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
