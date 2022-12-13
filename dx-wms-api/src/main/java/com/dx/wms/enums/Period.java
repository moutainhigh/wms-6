package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

public enum Period {
    /**
     * 达信宝
     */
    DXB(11L, "15"),

    /**
     * 月利赢
     */
    YLY(12L, "12"),

    /**
     * 月丰和
     */
    YFH(13L, "1"),

    /**
     * 双季鑫
     */
    SJX(14L, "6"),

    /**
     * 岁悦喜
     */
    SYXI(15L, "12"),

    /**
     * 三月享
     */
    SYX(16L, "3"),
    
    /*
     * 月满盈
     */
    FULL(34L,"12");
    
    /**
     * 常量值
     */
    private Long code;

    /**
     * 内容
     */
    private String info;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    Period(Long code, String info) {
        this.code = code;
        this.info = info;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
    public static Period getEunm(Long code) {
        if (code == null) {
            return null;
        }
        for (Period period : Period.values()) {
            if (period.getCode() == (code)) {
                return period;
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
    public static String getInfo(Long code) {
        Period period = getEunm(code);
        if (period == null) {
            return null;
        }
        return period.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (Period period : Period.values()) {
            result.put(String.valueOf(period.getCode()), period.getInfo());
        }
        return result;
    }
}
