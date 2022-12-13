/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: custSource.java
 * Author:   王蕊
 * Date:     2015年7月16日 上午2:54:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 
 * 客户来源枚举类
 *
 * @author 王蕊
 */
public enum CustSource {

    /**
     * 主动拜访
     */
    VISIT(11, "主动拜访"),

    /**
     * 宣传单
     */
    LEAFLETS(12, "宣传单"),

    /**
     * 电销
     */
    TEL(13, "电销"),

    /**
     * 短信
     */
    MSG(14, "短信"),

    /**
     * 网络
     */
    NET(15, "网络"),

    /**
     * 报纸
     */
    PAPER(16, "报纸"),

    /**
     * 市场推广
     */
    MARKET(17, "市场推广"),

    /**
     * 转介绍
     */
    TRANS_INTR(18, "转介绍"),

    /**
     * 朋友介绍
     */
    FRI_INTR(19, "朋友介绍"),

    /**
     * 其他
     */
    OTHER(20, "其他");

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
    CustSource(Integer code, String info) {
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
    public static CustSource getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (CustSource source : CustSource.values()) {
            if (Assert.equals(source.getCode(), code)) {
                return source;
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
        CustSource source = getEunm(code);
        return !Assert.checkParam(source) ? isView ? WMSConstants.NULL : "-" : source.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CustSource source : CustSource.values()) {
            result.put(String.valueOf(source.getCode()), source.getInfo());
        }
        return result;
    }
}
