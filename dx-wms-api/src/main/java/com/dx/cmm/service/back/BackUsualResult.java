/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BankUsualResult.java
 * Author:   朱道灵
 * Date:     2016年5月9日 上午9:28:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

import java.math.BigDecimal;

/**
 * 往期回款查询结果
 *
 * @author 朱道灵
 */
public class BackUsualResult extends BackBaseResult{

    /**
     */
    private static final long serialVersionUID = 783045155503305895L;
    
    
    /**
     * 本报告日出借人实际回收利息
     */
    private BigDecimal lenderIncomeAmount; 
    
    /**
     * 账户级别
     */
    private Integer accountLevelId;
    
    /**
     * 期数
     */
    private Integer currentPeriod;


    public BigDecimal getLenderIncomeAmount() {
        return lenderIncomeAmount;
    }

    public void setLenderIncomeAmount(BigDecimal lenderIncomeAmount) {
        this.lenderIncomeAmount = lenderIncomeAmount;
    }

    public Integer getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(Integer accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    /**
     * @return the currentPeriod
     */
    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * @param currentPeriod the currentPeriod to set
     */
    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

}
