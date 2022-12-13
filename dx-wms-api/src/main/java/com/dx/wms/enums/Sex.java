/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Sex.java
 * Author:   王蕊
 * Date:     2015年7月16日 上午2:10:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 性别
 *
 * @author 王蕊
 */
public enum Sex {

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    Sex(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
    public static Sex getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (Sex sex : Sex.values()) {
            if (Assert.equals(sex.getCode(), code)) {
                return sex;
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
    public static String getInfo(Integer code, Boolean isView) {
        Sex sex = getEunm(code);
        return Assert.checkParam(sex) ? sex.getInfo() : isView ? WMSConstants.NULL : "-";
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (Sex sex : Sex.values()) {
            result.put(String.valueOf(sex.getCode()), sex.getInfo());
        }
        return result;
    }
}
