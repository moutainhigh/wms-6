/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: ProductQueryDto.java
 * Author:   蔡登勇
 * Date:     2015年9月10日 下午4:58:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ProductQueryDto implements Serializable{

    /**
     */
    private static final long serialVersionUID = -7402722771635639762L;

    /** 应用Code */
    private String appCode;
    
    /** 产品Id */
    private Long productId;
    
    /** 金额 */
    private BigDecimal amount;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
