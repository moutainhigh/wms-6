/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: profession.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午5:17:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.constant.WMSConstants;

/**
 * 职业类枚举
 *
 * @author 朱道灵
 */
public enum Profession {

    /**
     * 自营业主
     */
    BOSS(1, "自营业主"),

    /**
     * 公司职员
     */
    COMPANY_STAFF(2, "公司职员"),

    /**
     * 公务员
     */
    OFFICIAL(3, "公务员"),

    /**
     * 离/退休人士
     */
    RETIRED(4, "离/退休人士"),

    /**
     * 自由职业者
     */
    FREELANCE(5, "自由职业者");

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
    Profession(int code, String info) {
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
    public static Profession getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (Profession profession : Profession.values()) {
            if (profession.getCode() == (code)) {
                return profession;
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
    public static String getInfo(Integer code, Boolean isView) {
        Profession profession = getEunm(code);
        return profession == null ? isView ? WMSConstants.NULL : "-" : profession.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (Profession profession : Profession.values()) {
            result.put(String.valueOf(profession.getCode()), profession.getInfo());
        }
        return result;
    }

}
