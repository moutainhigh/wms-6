/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountCategery.java
 * Author:   杨宝河
 * Date:     2015年7月30日 13:5:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 支付方式枚举类
 * 
 * @author yangbao
 *
 */
public enum PayWay {

    /**
     * 汇款
     */
    REMITTANCE(1, "汇款"),

    /**
     * 划扣
     */
    DRAW(2, "委托划扣"),

    /**
     * pos机划扣
     */
    POS_DRAW(3, "直接划扣");

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
     * @param code
     * @param info
     */
    private PayWay(Integer code, String info) {
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
     * 根据常量值获取枚举
     * 
     * @param code
     * @return
     */
    public static PayWay getEumn(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (PayWay payWay : PayWay.values()) {
            if (Assert.equals(payWay.getCode(), code)) {
                return payWay;
            }
        }
        return null;
    }

    /**
     * 根据常量值获取内容
     * 
     * @param code
     * @return
     */
    public static String getInfo(Integer code, Boolean isView) {
        PayWay payWay = getEumn(code);
        return Assert.checkParam(payWay) ? payWay.getInfo() : isView ? WMSConstants.NULL : "-";
    }

    /**
     * 返回支付方式的结果集
     * 
     * @return
     */

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (PayWay payWay : PayWay.values()) {
            result.put(String.valueOf(payWay.getCode()), payWay.getInfo());
        }
        return result;
    }

}
