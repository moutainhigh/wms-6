/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AccountCategery.java
 * Author:   朱道灵
 * Date:     2015年7月24日 上午1:25:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 账号分类 枚举
 *
 * @author 朱道灵
 */
public enum BaseAccountCategory {

    /**
     * 汇款
     */
    Remittance(1, "汇款"),

    /**
     * 回款
     */
    RETURNED_MONEY(2, "回款"),
    
    /**
     * 委托划扣
     */
    DRAW(3, "委托划扣"),
    
    /**
     * pos机划扣
     */
    POS_DRAW(4,"直接划扣"),
    
    /**
     * 其他
     */
    OTHER(5, "其他");

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
    BaseAccountCategory(int code, String info) {
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
    public static BaseAccountCategory getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (BaseAccountCategory bizCategery : BaseAccountCategory.values()) {
            if (bizCategery.getCode() == (code)) {
                return bizCategery;
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
        BaseAccountCategory bizCategery = getEunm(code);
        return bizCategery == null ? "-" : bizCategery.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new HashMap<String, String>();
        for (BaseAccountCategory bizCategery : BaseAccountCategory.values()) {
            result.put(String.valueOf(bizCategery.getCode()), bizCategery.getInfo());
        }
        return result;
    }
}
