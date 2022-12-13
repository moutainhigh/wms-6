/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountDto.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午3:52:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.index;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 首页显示 dto
 *
 * @author huangjian
 */
public class IndexDisplayResultDto implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = 1L;
    
    /** 出借总额  */
    private BigDecimal sumLenderAmount;
    
    /** 客户经理 */
    private Long createUser;
    
    /** 营业部 */
    private Long orgId;
    
    /**
     * @return 客户经理
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser 客户经理
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return 出借总额
     */
    public BigDecimal getSumLenderAmount() {
        return sumLenderAmount;
    }

    /**
     * @param sumLenderAmount 出借总额
     */
    public void setSumLenderAmount(BigDecimal sumLenderAmount) {
        this.sumLenderAmount = sumLenderAmount;
    }

    /**
     * @return 营业部
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId 营业部
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
}
