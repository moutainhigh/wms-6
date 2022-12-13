/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CurrentAction.java
 * Author:   朱道灵
 * Date:     2015年8月1日 下午7:55:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * 当前行为 枚举
 * from t_lender_apply_log
 *
 * @author 朱道灵
 */
public enum CurrentAction {
   
    /**
     * 同意
     */
    AGREE(1, "同意"),
    
    /**
     * 拒绝
     */
    REFUSE(2, "拒绝");
    
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
    CurrentAction(int code, String info) {
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
    public static CurrentAction getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (CurrentAction currentAction : CurrentAction.values()) {
            if (currentAction.getCode() == (code)) {
                return currentAction;
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
        CurrentAction currentAction = getEunm(code);
        return currentAction == null ? "-" : currentAction.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CurrentAction currentAction : CurrentAction.values()) {
            result.put(String.valueOf(currentAction.getCode()), currentAction.getInfo());
        }
        return result;
    }

}
