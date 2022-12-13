/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: maritalStatus.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午4:02:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.constant.WMSConstants;

/**
 * 婚姻状况枚举类
 *
 * @author 朱道灵
 */
public enum MaritalStatus {

    /**
     * 未婚
     */
    UN_MARRIED(1, "未婚"),

    /**
     * 已婚
     */
    MARRIED(2, "已婚"),

    // /**
    // * 离异
    // */
    // DIVORCED(3, "离异"),

    /**
     * 其他
     */
    OTHER(3, "其他");

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
    MaritalStatus(int code, String info) {
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
    public static MaritalStatus getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if (maritalStatus.getCode() == (code)) {
                return maritalStatus;
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
        MaritalStatus maritalStatus = getEunm(code);
        return maritalStatus == null ? isView ? WMSConstants.NULL : "-" : maritalStatus.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            result.put(String.valueOf(maritalStatus.getCode()), maritalStatus.getInfo());
        }
        return result;
    }

}
