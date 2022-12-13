/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductDetailDto.java
 * Author:   蔡登勇
 * Date:     2015年7月29日 上午12:03:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;

/**
 * 产品详情Dto
 *
 * @author 蔡登勇
 */
public class ProductDetailDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4424135064595428945L;
    
    /**产品编号*/
    private Long productId;
    
    /**产品编码*/
    private String productCode;
    
    /**产品明细编号*/
    private Long detailId;
    
    /**产品明细编码*/
    private String detailKey;
    
    /**产品明细存值*/
    private String detailRelationVal;
    
    /**产品明细关系-顺位*/
    private Integer detailRelationIndex;
    
    /**产品明细名称*/
    private String detailName;
    
    /**产品明细-类型:{1:"Integer",2:"String",3:"Bigdecimal",4:"Date"}*/
    private Integer detailType;
    
    /**产品明细级别*/
    private Integer detailLevel;
    
    /**产品明细描述*/
    private String detailDesc;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getDetailKey() {
        return detailKey;
    }

    public void setDetailKey(String detailKey) {
        this.detailKey = detailKey;
    }

    public String getDetailRelationVal() {
        return detailRelationVal;
    }

    public void setDetailRelationVal(String detailRelationVal) {
        this.detailRelationVal = detailRelationVal;
    }

    public Integer getDetailRelationIndex() {
        return detailRelationIndex;
    }

    public void setDetailRelationIndex(Integer detailRelationIndex) {
        this.detailRelationIndex = detailRelationIndex;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public Integer getDetailLevel() {
        return detailLevel;
    }

    public void setDetailLevel(Integer detailLevel) {
        this.detailLevel = detailLevel;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
    
    
}
