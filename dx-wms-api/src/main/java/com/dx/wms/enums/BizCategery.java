/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountCategery.java
 * Author:   朱道灵
 * Date:     2015年7月24日 上午1:25:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * 业务类别枚举
 *
 * @author 朱道灵
 */
public enum BizCategery {

    /**
     * 汇款
     */
    CCS(1, "信贷"),

    /**
     * 回款
     */
    WMS(2, "理财");

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
    BizCategery(int code, String info) {
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
    public static BizCategery getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (BizCategery bizCategery : BizCategery.values()) {
            if (bizCategery.getCode() == (code)) {
                return bizCategery;
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
        BizCategery bizCategery = getEunm(code);
        return bizCategery == null ? "-" : bizCategery.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (BizCategery bizCategery : BizCategery.values()) {
            result.put(String.valueOf(bizCategery.getCode()), bizCategery.getInfo());
        }
        return result;
    }
}
