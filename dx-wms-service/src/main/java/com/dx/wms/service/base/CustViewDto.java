/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import com.dx.wms.service.account.entity.CustAccount;

/**
 * 
 * 客户视图基本信息DTO
 * 
 * @author 王蕊
 *
 */
public class CustViewDto {

    /**
     * 客户基本信息 实体类
     */
    private CustBase custBase;

    /**
     * 客户账户信息 实体类
     */
    private CustAccount custAccount;

    /**
     * 操作用户 Dto
     */
    private Long actionUserId;

    /**
     * 
     */
    public CustViewDto() {
    
    }
    
    public CustViewDto(Long userId){
        setActionUserId(userId);
    }

    public CustViewDto(CustBase custBase) {
        this.custBase = custBase;
    }

    public CustBase getCustBase() {
        return custBase;
    }

    public void setCustBase(CustBase custBase) {
        this.custBase = custBase;
    }

    
    public Long getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(Long actionUserId) {
        this.actionUserId = actionUserId;
    }

    /**
     * @return the custAccount
     */
    public CustAccount getCustAccount() {
        return custAccount;
    }

    /**
     * @param custAccount the custAccount to set
     */
    public void setCustAccount(CustAccount custAccount) {
        this.custAccount = custAccount;
    }

}
