/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: StatusStep.java
 * Author:   朱道灵
 * Date:     2015年8月4日 下午2:58:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 页面显示 状态枚举
 *
 * @author 朱道灵
 */
public enum StatusStep {

    /**
     * 等待质检
     */
    QUALITY_WAIT(10, "等待质检", "qualityCheck"),

    /**
     * 质检拒绝
     */
    QUALITY_REJECTED(11, "质检拒绝"),

    /**
     * 等待投资审核
     */
    INVEST_WAIT(12, "等待投资审核"),

    /**
     * 投资审核拒绝
     */
    INVEST_REJECTED(13, "投资审核拒绝"),

    /**
     * 等待匹配
     */
    MATCH_WAIT(14, "等待匹配"),

    /**
     * 等待债权确认
     */
    CREDIT_WAIT(15, "等待债权确认"),

    /**
     * 重新匹配
     */
    REMATCH(16, "重新匹配"),

    /**
     * 等待出资确认
     */
    FINANCE_WAIT(17, "等待出资确认"),

    /**
     * 原财务确认失败，现改为支付失败
     */
    FINANCE_REJECTED(18, "支付失败"),

    /**
     * 等待到账确认
     */
    INVESTMENT_WAIT(19, "等待到账确认"),

    /**
     * 投资失败
     */
    INVESTMENT_FAIL(20, "投资失效"),

    /**
     * 投资生效
     */
    INVESTMENT_EFFECT(21, "投资生效"),
    /**
     * 即将到期
     */
    DUE_SOON(22, "即将到期"),

    /**
     * 到期
     */
    DUE(23, "到期");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    /**
     * 标示
     */
    private String key;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    StatusStep(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    StatusStep(Integer code, String info, String key) {
        this.code = code;
        this.info = info;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static StatusStep getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (StatusStep statusStep : StatusStep.values()) {
            if (statusStep.getCode() == (code)) {
                return statusStep;
            }
        }
        return null;
    }

    public static String getInfo(String currentStepKey, String lastStepKey, Integer currentAction) {
        return getInfo(getCode(currentStepKey, lastStepKey, currentAction));
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
        StatusStep statusStep = getEunm(code);
        return statusStep == null ? "-" : statusStep.getInfo();
    }

    public static Map<String, String> getMap(String key) {
        Map<String, String> result = new TreeMap<String, String>();
        for (StatusStep statusStep : StatusStep.values()) {
            result.put(String.valueOf(statusStep.getCode()), statusStep.getInfo());
        }
        if (Assert.checkParam(key)) {
            result.remove(key);
        }
        return result;
    }

    public static Map<String, String> getMap(StatusStep... steps) {
        Map<String, String> result = new LinkedHashMap<String, String>();
        for (StatusStep step : steps) {
            result.put(String.valueOf(step.getCode()), step.getInfo());
        }
        return result;
    }

    public static Integer getCode(String currentStepKey, String lastStepKey, Integer currentAction) {
        switch (currentStepKey) {
            case WMSConstants.QUALITY_CHECK:
                return 10;
            case WMSConstants.INVESTMENT_CHECK:
                return 12;
            case WMSConstants.RESUBMIT:
                switch (lastStepKey) {
                    case WMSConstants.QUALITY_CHECK:
                        return 11;
                    case WMSConstants.INVESTMENT_CHECK:
                        return 13;
                }
            case WMSConstants.MATCH:
                switch (lastStepKey) {
                    case WMSConstants.INVESTMENT_CHECK:
                        return 14;
                    case WMSConstants.CREDITOR_CONFIRM:
                        return 16;
                }
            case WMSConstants.CREDITOR_CONFIRM:
                switch (lastStepKey) {
                    case WMSConstants.MATCH:
                        return 15;
                    case WMSConstants.CONTRIBUTIVE_CONFIRM:
                        return 18;
                }
            case WMSConstants.CONTRIBUTIVE_CONFIRM:
                switch (currentAction) {
                    case 0:
                        return 17;
                }
            case WMSConstants.INVESTMENT_CONFIRM:
                return 19;
            case WMSConstants.INVESTMENT_SUCCESS:
                return 21;
            case WMSConstants.GIVEUP:
            case WMSConstants.INVESTMENT_FAIL:
                return 20;
        }
        return 1;
    }

}
