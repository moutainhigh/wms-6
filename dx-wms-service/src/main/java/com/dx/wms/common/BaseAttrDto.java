package com.dx.wms.common;

import java.io.Serializable;

/**
 * 
 * 基础属性Dto
 *
 * @author tony
 */
public class BaseAttrDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -6223799829413810736L;

    /**
     * 客户姓名
     */
    protected String custName;

    /**
     * 证件号码
     */
    protected String idCard;

    /**
     * 移动电话
     */
    protected String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
