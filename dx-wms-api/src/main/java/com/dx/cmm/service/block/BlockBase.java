package com.dx.cmm.service.block;

import java.io.Serializable;

class BlockBase implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4335404068602459851L;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 出借编号
     */
    private String lenderCode;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

}
