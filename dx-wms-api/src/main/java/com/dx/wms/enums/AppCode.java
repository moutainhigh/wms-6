/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LendTheWay.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午7:44:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 *系统资源枚举类 
 * 产品编号参考 t_product
 *
 * @author 朱道灵
 */
public enum AppCode {

    /**
     * 理财管理
     */
    WMS(1, "理财管理"),

    /**
     * 还款管理
     */
    RMS(2, "还款管理"),

    /**
     * 信贷管理
     */
    CCS(3, "信贷管理");

    
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
    AppCode(int code, String info) {
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
    public static AppCode getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (AppCode appCode : AppCode.values()) {
            if (appCode.getCode() == (code)) {
                return appCode;
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
        AppCode appCode = getEunm(code);
        return appCode== null ? "-" :appCode.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (AppCode appCode : AppCode.values()) {
            result.put(String.valueOf(appCode.getCode()), appCode.getInfo());
        }
        return result;
    }
}
