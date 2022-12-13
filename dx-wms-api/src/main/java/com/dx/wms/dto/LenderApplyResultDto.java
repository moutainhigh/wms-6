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
import java.math.BigDecimal;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderApplyResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    private Long lenderApplyId;

    // 出借编号
    private String lenderCode;

    // 客户姓名
    private String custName;

    // 身份证
    private String idCard;

    // 出借方式
    private Long productId;

    // 出借金额
    private BigDecimal lenderAmount;

    // 状态
    private String currentStepKey;

    private Integer currentAction;

    private String lastStepKey;

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
     * @return 出借金额
     */
    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    /**
     * @param lenderAmount 出借金额
     */
    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
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

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public Integer getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    public String getLastStepKey() {
        return lastStepKey;
    }

    public void setLastStepKey(String lastStepKey) {
        this.lastStepKey = lastStepKey;
    }

}
