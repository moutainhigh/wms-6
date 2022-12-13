/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IdType.java
 * Author:   王蕊
 * Date:     2015年7月16日 上午2:24:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.constant.WMSConstants;

/**
 * 证件类型枚举类
 *
 * @author 王蕊
 */
public enum IdType {
    /**
     * 身份证
     */
    ID_CARD(1, "身份证"),
    /**
     * 护照
     */
    PASSPORT(2, "护照"),
    /**
     * 军官证
     */
    OFFICER_SCERT(3, "军官证"),
    /**
     * 港澳居民往来大陆通行证
     */
    MAINLAND_PASS(4, "港澳居民往来大陆通行证");

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
    IdType(int code, String info) {
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
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static IdType getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (IdType idType : IdType.values()) {
            if (idType.getCode() == (code)) {
                return idType;
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
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getInfo(Integer code,Boolean isView) {
        IdType idType = getEunm(code);
        return idType == null ? isView ? WMSConstants.NULL : "-": idType.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (IdType idType : IdType.values()) {
            result.put(String.valueOf(idType.getCode()), idType.getInfo());
        }
        return result;
    }
}
