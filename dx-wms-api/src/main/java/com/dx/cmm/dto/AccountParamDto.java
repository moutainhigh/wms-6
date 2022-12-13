package com.dx.cmm.dto;

import java.io.Serializable;

/**
 * 
 * 账户参数dto
 *
 * @author tony
 */
public class AccountParamDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 3635017538334581685L;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 账户级别
     */
    private Long accountLevelId;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(Long accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

}
