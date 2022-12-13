/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountLevel.java
 * Author:   朱道灵
 * Date:     2015年7月19日 下午6:20:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;

/**
 * 
 * 账户级别
 *
 * @author tony
 */
public enum AccountLevel {

    /**
     * 财富账户 标准：0-50万 服务费率(月)0.075%：
     */
    WEATH_ACCOUNT(1, "财富账户", "0.00075"),

    /**
     * 贵宾账户 标准：50-100万 服务费率(月)0.050%：
     */
    VIP_ACCOUNT(2, "贵宾账户", "0.0005"),

    /**
     * 金卡账户 标准：100-300万 服务费率(月)0.035%：
     */
    GOLD_ACCOUNT(3, "金卡账户", "0.00035"),

    /**
     * 白金账户 标准：300-500万 服务费率(月)0.025%：
     */
    PLATINUM_ACCOUNT(4, "白金账户", "0.00025"),

    /**
     * 钻石账户 标准：500万以上 服务费率(月)0.015%：
     */
    DIAMOND_ACCOUNT(5, "钻石账户", "0.00015");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    /**
     * 比例
     */
    private String rate;

    /**
     *
     * @param code 常量值
     * @param value 内容
     */
    AccountLevel(Integer code, String info, String rate) {
        this.code = code;
        this.info = info;
        this.rate = rate;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static AccountLevel getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (AccountLevel accountLevel : AccountLevel.values()) {
            if (accountLevel.getCode() == (code)) {
                return accountLevel;
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
        AccountLevel accountLevel = getEunm(code);
        return accountLevel == null ? "-" : accountLevel.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (AccountLevel accountLevel : AccountLevel.values()) {
            result.put(String.valueOf(accountLevel.getCode()), accountLevel.getInfo());
        }
        return result;
    }

}
