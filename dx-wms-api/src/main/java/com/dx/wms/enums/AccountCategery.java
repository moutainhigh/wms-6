package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;

/**
 * 账号分类 枚举
 *
 * @author 朱道灵
 */
public enum AccountCategery {

    /**
     * 汇款
     */
    REMIT(1, "汇款", "支付账户信息"),

    /**
     * 回款
     */
    RETURNED_MONEY(2, "回款", "回款账户信息"),

    /**
     * 支付
     */
    PAY(3, "支付", "支付账户信息"),

    /**
     * 支付
     */
    OTHERS(4, "其他", "支付账户信息");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    /**
     * 标题
     */
    private String title;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    AccountCategery(Integer code, String info, String title) {
        this.code = code;
        this.info = info;
        this.title = title;
    }

    public int getCode() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static AccountCategery getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (AccountCategery categery : AccountCategery.values()) {
            if (Assert.equals(categery.getCode(), code)) {
                return categery;
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
        AccountCategery categery = getEunm(code);
        return Assert.checkParam(categery) ? categery.getInfo() : "-";
    }

    public static String getTitle(Integer code) {
        AccountCategery categery = getEunm(code);
        return Assert.checkParam(categery) ? categery.getTitle() : "-";
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (AccountCategery categery : AccountCategery.values()) {
            result.put(String.valueOf(categery.getCode()), categery.getInfo());
        }
        return result;
    }
}
