/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountStatus.java
 * Author:   朱道灵
 * Date:     2015年8月27日 上午11:12:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 客户开户状态枚举
 *
 * @author 朱道灵
 */
public enum AccountStatus {

    /**
     * 未认证
     */
    INIT("A", "待认证", "<span class='label label-danger'>待认证</span>"),

    /**
     * 认证中
     */
    CHECKING("C", "认证中", "<span class='label label-danger'>认证中</span>"),

    /**
     * 认证失败
     */
    FAILED("F", "认证失败", "<span class='label label-error'>认证失败</span>"),

    /**
     * 已认证
     */
    SUCCEED("S", "已认证", "<span class='label label-info'>已认证</span>");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    /**
     * 视图
     */
    private String view;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    AccountStatus(String code, String info, String view) {
        this.code = code;
        this.info = info;
        this.view = view;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static AccountStatus getEunm(String code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (AccountStatus status : AccountStatus.values()) {
            if (Assert.equals(status.getCode(), code)) {
                return status;
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
    public static String getInfo(String code, Boolean flag) {
        AccountStatus status = getEunm(code);
        return !Assert.checkParam(status) ? flag ? WMSConstants.NULL : "-" : status.getInfo();
    }

    public static String getView(String code, Boolean flag) {
        AccountStatus status = getEunm(code);
        return !Assert.checkParam(status) ? flag ? WMSConstants.NULL : "-" : status.getView();
    }

    public static Map<String, String> getMap(String key) {
        Map<String, String> result = new TreeMap<String, String>();
        for (AccountStatus status : AccountStatus.values()) {
            result.put(String.valueOf(status.getCode()), status.getInfo());
        }
        if (Assert.checkParam(key)) {
            result.remove(key);
        }
        return result;
    }

}
