/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductDto.java
 * Author:   蔡登勇
 * Date:     2015年7月28日 下午9:39:37
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 产品对象
 *
 * @author 蔡登勇
 */
public class ProductDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8601826533536576338L;

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

    /** 父产品信息 */
    private ProductDto parentProductDto;

    /** 综合费率 */
    private List<BigDecimal> synthesizeRatios;

    /** 产品期限 */
    private List<Integer> periods;

    public ProductDto getParentProductDto() {
        return parentProductDto;
    }

    public void setParentProductDto(ProductDto parentProductDto) {
        this.parentProductDto = parentProductDto;
    }

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

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductLevel() {
        return productLevel;
    }

    public void setProductLevel(Integer productLevel) {
        this.productLevel = productLevel;
    }

    public Long getUpProductId() {
        return upProductId;
    }

    public void setUpProductId(Long upProductId) {
        this.upProductId = upProductId;
    }

    public BigDecimal getAmountLowerLimit() {
        return amountLowerLimit;
    }

    public void setAmountLowerLimit(BigDecimal amountLowerLimit) {
        this.amountLowerLimit = amountLowerLimit;
    }

    public BigDecimal getAmountUpperLimit() {
        return amountUpperLimit;
    }

    public void setAmountUpperLimit(BigDecimal amountUpperLimit) {
        this.amountUpperLimit = amountUpperLimit;
    }

    public BigDecimal getAmountStep() {
        return amountStep;
    }

    public void setAmountStep(BigDecimal amountStep) {
        this.amountStep = amountStep;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public List<BigDecimal> getSynthesizeRatios() {
        return synthesizeRatios;
    }

    public void setSynthesizeRatios(List<BigDecimal> synthesizeRatios) {
        this.synthesizeRatios = synthesizeRatios;
    }

    public List<Integer> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Integer> periods) {
        this.periods = periods;
    }

}
