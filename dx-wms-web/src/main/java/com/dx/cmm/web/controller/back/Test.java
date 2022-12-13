package com.dx.cmm.web.controller.back;

public class Test {
    /**
     * 主要业务id
     */
    private Long fundId;

    /**
     * 出借编号
     */
    private String lenderCode;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

}
