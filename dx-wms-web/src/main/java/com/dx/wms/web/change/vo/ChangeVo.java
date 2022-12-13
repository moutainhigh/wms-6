package com.dx.wms.web.change.vo;

import com.dx.wms.web.vo.BaseAttrVo;

public class ChangeVo extends BaseAttrVo {

    /**
     */
    private static final long serialVersionUID = 6425377224391315090L;

    /**
     * 客户编号
     */
    protected String lenderCustCode;

    /**
     * 出借方式
     */
    protected Long productId;

    /**
     * 出借编号
     */
    protected String lenderCode;

    /**
     * 营业部编号
     */
    protected Long orgId;

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

}
