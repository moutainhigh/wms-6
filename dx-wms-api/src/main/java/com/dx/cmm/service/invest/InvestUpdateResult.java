/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: InvestChangeResult.java
 * Author:   朱道灵
 * Date:     2016年5月8日 上午11:38:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.invest;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 投资变更结果
 *
 * @author 朱道灵
 */
public class InvestUpdateResult extends InvestResult{

    /**
     */
    private static final long serialVersionUID = 4934551761994339680L;
    
    /**
     * 当前资产价值
     */
    private BigDecimal currentTotalAmount;
    
    /**
     * 计息日
     */
    private Date InterestBeginTime;

   
    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    
    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }


   
    public Date getInterestBeginTime() {
        return InterestBeginTime;
    }


  
    public void setInterestBeginTime(Date interestBeginTime) {
        InterestBeginTime = interestBeginTime;
    }

}
