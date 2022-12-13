package com.dx.cmm.enums;

/**
 * 
 * 收益类型
 *
 * @author tony
 */
public enum IncomeType {

    /**
     * 居间人
     */
    INTERMEDIARY(1, "居间人"),

    /**
     * 公司
     */
    COMPANY(2, "公司");

    private Integer code;

    private String info;

    private IncomeType(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
