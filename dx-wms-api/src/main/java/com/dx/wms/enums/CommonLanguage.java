/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Language.java
 * Author:   朱道灵
 * Date:     2015年7月22日 下午9:44:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 朱道灵
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum CommonLanguage {

    /**
     * 汉语（中文）
     */
    CHINESE(1,"汉语"),
    
    /**
     * 英语
     */
    ENGLISH(2,"英语"),
    
    /**
     * 阿拉伯语
     */
    ARABIC(3,"阿拉伯语"),
    
    /**
     * 俄罗斯语
     */
    RUSSIAN(4,"俄罗斯语"),
    
    /**
     * 法语
     */
    FRENCH(5,"法语"),
    
    /**
     * 西班牙语
     */
    SPANISH(6,"西班牙语");
    
    
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
    CommonLanguage(int code, String info) {
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
    public static CommonLanguage getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (CommonLanguage  commonLanguage  : CommonLanguage.values()) {
            if (commonLanguage.getCode() == (code)) {
                return commonLanguage ;
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
        CommonLanguage  commonLanguage = getEunm(code);
        return commonLanguage == null ? isView ? WMSConstants.NULL : "-" : commonLanguage.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CommonLanguage  commonLanguage : CommonLanguage .values()) {
            result.put(String.valueOf(commonLanguage .getCode()), commonLanguage.getInfo());
        }
        return result;
    }
}
