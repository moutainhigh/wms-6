package com.dx.cmm.enums;

/**
 * 
 * 收益来源
 *
 * @author tony
 */
public enum IncomeCategory {

    /**
     * 债权
     */
    CREDITOR(1, "债权"),

    /**
     * 服务费
     */
    SERVICE_FEE(2, "服务费"),

    /**
     * 管理费
     */
    MANAGER_FEE(3, "管理费"),

    /**
     * 到期收益
     */
    EXPIRE(4, "到期收益");

    private Integer code;

    private String info;

    private IncomeCategory(Integer code, String info) {
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
