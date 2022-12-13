/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CurrentStep.java
 * Author:   朱道灵
 * Date:     2015年8月1日 下午2:30:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 出借日志表 当前环节（状态）枚举
 *
 * @author 朱道灵
 */
public enum CurrentStepKey {

    /**
     * 草稿
     */
    DRAFT("draft", "草稿"),

    /**
     * 质检
     */
    QUALITY_CHECK("qualityCheck", "质检"),

    /**
     * 投资审核
     */
    INVESTMENT_CHECK("investmentCheck", "投资审核"),

    /**
     * 重新提交
     */
    RESUBMIT("resubmit", "重新提交"),

    /**
     * 匹配
     */
    MATCH("match", "匹配"),

    /**
     * 债权确认
     */
    CREDITOR_CONFIRM("creditorConfirm", "债权确认"),

    /**
     * 出资确认
     */
    CONTRIBUTIVE_CONFIRM("contributiveConfirm", "出资确认"),

    /**
     * 投资确认
     */
    INVESTMENT_CONFIRM("investmentConfirm", "投资确认"),

    /**
     * 投资生效
     */
    INVESTMENT_SUCCESS("success", "投资生效"),

    /**
     * 投资失效
     */
    INVESTMENT_GIVEUP("giveUp", "客户放弃"),
    
    /**
     * 投资失效
     */
    INVESTMENT_FAIL("fail", "投资失效");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    CurrentStepKey(String code, String info) {
        this.code = code;
        this.info = info;
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

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static CurrentStepKey getEunm(String code) {
        if (code == null) {
            return null;
        }
        for (CurrentStepKey currentStep : CurrentStepKey.values()) {
            if (currentStep.getCode().equals(code)) {
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
    public static String getInfo(String code) {
        CurrentStepKey currentStep = getEunm(code);
        return currentStep == null ? "-" : currentStep.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CurrentStepKey currentStep : CurrentStepKey.values()) {
            result.put(currentStep.getCode(), currentStep.getInfo());
        }
        return result;
    }

    public static Map<String, String> getMap(CurrentStepKey... currentStepKeys) {
        Map<String, String> result = new LinkedHashMap<String, String>();
        for (CurrentStepKey currentStep : currentStepKeys) {
            result.put(currentStep.getCode(), currentStep.getInfo());
        }
        return result;
    }
}
