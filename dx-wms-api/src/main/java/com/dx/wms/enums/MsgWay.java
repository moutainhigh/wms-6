/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AcceptTheFile.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午4:52:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.constant.WMSConstants;

/**
 * 接受文件方式 枚举类
 *
 * @author 朱道灵
 */
public enum MsgWay {

    /**
     * 电子邮件
     */
    EMAIL(1, "电子邮件"),

    /**
     * 电子邮件
     */
    LETTERS(2, "信件");

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
    MsgWay(int code, String info) {
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
    public static MsgWay getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (MsgWay msgWay : MsgWay.values()) {
            if (msgWay.getCode() == (code)) {
                return msgWay;
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
    public static String getInfo(Integer code, Boolean isView) {
        MsgWay msgWay = getEunm(code);
        return msgWay == null ? isView ? WMSConstants.NULL : "-" : msgWay.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (MsgWay msgWay : MsgWay.values()) {
            result.put(String.valueOf(msgWay.getCode()), msgWay.getInfo());
        }
        return result;
    }

}
