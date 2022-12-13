/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FlowCategery.java
 * Author:   朱道灵
 * Date:     2015年7月24日 上午1:35:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * 流向类型 枚举类
 *
 * @author 朱道灵
 */
public enum FlowCategery {

    /**
     * 收入
     */
    INCOME(1, "收入"),

    /**
     * 支出
     */
    EXPENSE(2, "支出");

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
    FlowCategery(int code, String info) {
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
    public static FlowCategery getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (FlowCategery flowCategery : FlowCategery.values()) {
            if (flowCategery.getCode() == (code)) {
                return flowCategery;
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
        FlowCategery flowCategery = getEunm(code);
        return flowCategery == null ? "-" : flowCategery.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (FlowCategery flowCategery : FlowCategery.values()) {
            result.put(String.valueOf(flowCategery.getCode()), flowCategery.getInfo());
        }
        return result;
    }
}
