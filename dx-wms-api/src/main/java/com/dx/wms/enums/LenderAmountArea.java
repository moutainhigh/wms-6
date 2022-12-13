/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderAmount.java
 * Author:   朱道灵
 * Date:     2015年10月19日 下午4:43:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * 出借金额
 *
 *
 * @author 朱道灵
 */
public enum LenderAmountArea {
    /**
     * 5--10万
     */
    FIVE_TEN(1,"5-10万"),
    
    /**
     * 10-20万
     */
    TEN_TWENTY(2,"10-20万"),
    
    /**
     * 20-50万
     */
    TWENTY_FIFTY(3,"20-50万"),
    
    /**
     * 50-100万
     */
    FIFTY_HUNDRED(4,"50-100万"),
    
    /**
     * 100万以上
     */
    BEYOND_HUNDRED(5,"100万以上");
    
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
    LenderAmountArea(int code, String info) {
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
    public static LenderAmountArea getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (LenderAmountArea lenderAmountArea : LenderAmountArea.values()) {
            if (lenderAmountArea.getCode() == (code)) {
                return lenderAmountArea;
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
        LenderAmountArea lenderAmountArea = getEunm(code);
        return lenderAmountArea == null ? "-" : lenderAmountArea.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (LenderAmountArea lenderAmountArea : LenderAmountArea.values()) {
            result.put(String.valueOf(lenderAmountArea.getCode()), lenderAmountArea.getInfo());
        }
        return result;
    }
}

