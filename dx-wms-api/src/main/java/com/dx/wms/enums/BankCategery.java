/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Bank.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午5:02:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 银行类枚举
 *
 * @author 朱道灵
 */
public enum BankCategery {

    /**
     * 工商银行
     */
    ICBC(1, "工商银行"),

    /**
     * 农业银行
     */
    ABC(2, "农业银行"),

    /**
     * 建设银行
     */
    CCB(3, "建设银行"),

    /**
     * 中国银行
     */
    BOC(4, "中国银行"),

    /**
     * 中国邮政储蓄银行
     */
    PSBC(5, "邮政储蓄银行"),

    /**
     * 招商银行
     */
    CMB(6, "招商银行"),

    /**
     * 兴业银行
     */
    CIB(7, "兴业银行"),

    /**
     * 广发银行
     */
    GDB(8, "广发银行"),

    /**
     * 平安银行
     */
    PAB(9, "平安银行"),

    /**
     * 中信银行
     */
    CITIC(10, "中信银行"),

    /**
     * 华夏银行
     */
    HXB(11, "华夏银行"),

    /**
     * 中国光大银行
     */
    CEB(12, "中国光大银行"),

    /**
     * 浦发银行
     */
    SPDB(13, "浦发银行"),

    /**
     * 民生银行
     */
    CMBC(14, "民生银行"),

    /**
     * 上海银行
     */
    BOS(15, "上海银行"),

    /**
     * 交通银行
     */
    BCM(16, "交通银行");

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
    BankCategery(int code, String info) {
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
    public static BankCategery getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (BankCategery bankCategery : BankCategery.values()) {
            if (bankCategery.getCode() == (code)) {
                return bankCategery;
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
        BankCategery bankCategery = getEunm(code);
        return bankCategery == null ? "-" : bankCategery.getInfo();
    }

    public static String get(Integer code) {
        BankCategery bankCategery = getEunm(code);
        return bankCategery == null ? "-" : bankCategery.toString();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });
        for (BankCategery bankCategery : BankCategery.values()) {
            result.put(String.valueOf(bankCategery.getCode()), bankCategery.getInfo());
        }
        return result;
    }

}
