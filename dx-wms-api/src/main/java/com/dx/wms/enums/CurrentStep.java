/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CurrentStep.java
 * Author:   朱道灵
 * Date:     2015年8月1日 下午2:30:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * 出借日志表 当前环节（状态）枚举
 *
 * @author 朱道灵
 */
public enum CurrentStep {
    
    /**
     * 草稿
     */
    DRAFT(1, "草稿"),
    
    /**
     * 质检
     */
    QUALITY_CHECK(2, "质检"),
    
    /**
     * 投资审核
     */
    INVESTMENT_CHECK(3, "投资审核"),
    
    /**
     * 重新提交
     */
    RESUBIT(4, "重新提交"),
    
    /**
     * 匹配
     */
    MATCH(5, "匹配"),
    
    /**
     * 债权确认
     */
    CREDITOR_CONFIRM(6,"债权确认"),
    
    /**
     * 出资确认contributive
     */
    CONTRIBUTIVE_CONFIRM(7,"出资确认"),
    
    /**
     * 投资确认
     */
    INVESTMENT_CONFIRM(8, "投资确认"),
    
    /**
     * 投资生效
     */
    INVESTMENT_SUCCESS(9,"投资生效"),
    
    /**
     * 投资失效
     */
    INVESTMENT_FAIL(10,"投资失效"),
    /**
     * 即将到期
     */
    SOON_DUE(11,"即将到期"),
    
    /**
     * 到期
     */
    DUE(12,"到期");
    
    
    
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
    CurrentStep(int code, String info) {
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
    public static CurrentStep getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (CurrentStep currentStep : CurrentStep.values()) {
            if (currentStep.getCode() == (code)) {
                return currentStep;
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
        CurrentStep currentStep = getEunm(code);
        return currentStep == null ? "-" : currentStep.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CurrentStep currentStep : CurrentStep.values()) {
            result.put(String.valueOf(currentStep.getCode()), currentStep.getInfo());
        }
        return result;
    }

}
