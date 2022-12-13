/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Education.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午4:20:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.constant.WMSConstants;

/**
 * 学历枚举类
 * 
 * @author 朱道灵
 */
public enum Education {

    /**
     * 硕士及以上
     */
    MASTER(1, "硕士及以上"),

    /**
     * 本科
     */
    UNDERGRADUATE(2, "本科"),

    /**
     * 大专
     */
    JUNIOR_COLLEGE(3, "大专"),

    /**
     * 中专
     */
    TECHNICAL_SECONDARY(4, "中专"),

    /**
     * 高中
     */
    HIGH_SCHOOL(5, "高中"),

    /**
     * 其他
     */
    OTHER(6, "其他");

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
    Education(int code, String info) {
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
    public static Education getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (Education education : Education.values()) {
            if (education.getCode() == (code)) {
                return education;
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
    public static String getInfo(Integer code,Boolean isView) {
        Education education = getEunm(code);
        return education == null ? isView ? WMSConstants.NULL : "-" : education.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (Education education : Education.values()) {
            result.put(String.valueOf(education.getCode()), education.getInfo());
        }
        return result;
    }
}
