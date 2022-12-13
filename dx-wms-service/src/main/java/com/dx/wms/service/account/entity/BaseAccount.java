package com.dx.wms.service.account.entity;

import javax.persistence.Column;

import com.dx.wms.common.BaseEntity;

public class BaseAccount extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -7366183276277099505L;

    /**
     * 客户账户-编号
     */
    protected Long custAccountId;

    /**
     * 功能描述: 客户账户-编号
     *
     * @return the custAccountId
     */
    @Column(name = "cust_account_id")
    public Long getCustAccountId() {
        return custAccountId;
    }

 
}
