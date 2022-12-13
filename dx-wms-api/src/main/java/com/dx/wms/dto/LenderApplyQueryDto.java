/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyDto.java
 * Author:   蔡登勇
 * Date:     2015年7月27日 下午8:08:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;

import com.dx.framework.dal.pagination.Pagination;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderApplyQueryDto implements Serializable{
    
    /**
     */
    private static final long serialVersionUID = 1L;

    // 出借编号
    private String lenderCode;
    
    // 客户姓名
    private String custName;
    
    // 身份证
    private String idCard;
    
    // 出借方式
    private Long productId;
    
    // 状态
    private String currentStepKey;
    
    // 分页信息
    private Pagination pagination;

    /**
     * @return 出借编号
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * @param lenderCode 出借编号
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**
     * @return 客户姓名
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName 客户姓名
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return 身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard 身份证
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return 出借方式
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId 出借方式
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return 状态
     */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /**
     * @param currentStepKey 状态
     */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
