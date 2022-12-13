package com.dx.wms.service.changer;

import com.dx.wms.common.BaseAttrDto;

public class BaseChanger extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 8095378921317156976L;

    /**
     * 客户编号
     */
    protected String lenderCustCode;

    /**
     * 出借编号
     */
    protected String lenderCode;

    /**
     * 客户账户编号
     */
    protected Long custAccountId;

    /**
     * 申请单编号
     */
    protected Long lenderApplyId;

    /**
     * 出借方式
     */
    protected Long productId;

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
