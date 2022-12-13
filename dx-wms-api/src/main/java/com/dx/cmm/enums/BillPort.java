package com.dx.cmm.enums;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
public enum BillPort {
    /**
     * 1号
     */
    ONE_PORT(1, "1号"),

    /**
     * 16号
     */
    SIXTEEN_PORT(16, "16号");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    private BillPort(Integer code, String info) {
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
