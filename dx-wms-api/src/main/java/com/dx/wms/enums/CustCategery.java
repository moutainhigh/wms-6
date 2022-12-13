/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ClientType.java
 * Author:   朱道灵
 * Date:     2015年7月16日 下午4:31:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 客户分类枚举
 * 
 * @author 朱道灵
 */
public enum CustCategery {

    /**
     * 外部客戶
     */
    OUTSIDE_CLIENT(1, "外部客户"),

    /**
     * 公司員工
     */
    COMPANY_STAFF(2, "内部员工");

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
     * @return
     */
    CustCategery(Integer code, String info) {
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
     */
    public static CustCategery getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (CustCategery categery : CustCategery.values()) {
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
    public static String getInfo(Integer code, Boolean isView) {
        CustCategery categery = getEunm(code);
        return !Assert.checkParam(categery) ? isView ? WMSConstants.NULL : "-" : categery.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CustCategery categery : CustCategery.values()) {
            result.put(String.valueOf(categery.getCode()), categery.getInfo());
        }
        return result;
    }
}