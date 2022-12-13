package com.dx.wms.enums;

/**
 * 
 * 〈一句话功能简述〉调用接口 推送数据 CODE 〈功能详细描述〉
 *
 * @author 王蕊
 */
public enum PushCode {

    // /**
    // * 即将到期
    // */
    // SOON_DUE(2, "即将到期"),
    //
    // /**
    // * 到期
    // */
    // DUE(3, "到期"),
    //
    // /**
    // * 续投作废
    // */
    // CONTINUE_CANCEL(4, "续投作废"),

    /**
     * 匹配完成
     */
    MATCH_COMPLETE(1, "匹配完成"),

    /**
     * 到期日
     */
    DUE_DATE(2, "到期日"),

    /**
     * 客户放弃
     */
    GIVE_UP(3, "客户放弃");

    /**
     * 常量值
     */
    private int code;

    /**
     * 内容
     */
    private String info;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    PushCode(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static PushCode getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (PushCode wmsPushCode : PushCode.values()) {
            if (wmsPushCode.getCode() == (code)) {
                return wmsPushCode;
            }
        }
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取内容
     *
     * @param code 常量值
     * @return
     */
    public static String getInfo(Integer code) {
        PushCode wmsPushCode = getEunm(code);
        return wmsPushCode == null ? "-" : wmsPushCode.getInfo();
    }
}
