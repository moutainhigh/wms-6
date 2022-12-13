package com.dx.cmm.web.vo;

import java.io.Serializable;

public class AccountParamVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -3140651885962522949L;

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
