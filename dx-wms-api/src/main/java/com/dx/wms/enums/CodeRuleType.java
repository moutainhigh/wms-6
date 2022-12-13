/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRule.java
 * Author:   蔡登勇
 * Date:     2015年7月16日 下午5:02:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.wms.service.exception.CodeRuleIPIsErrorException;

/**
 * 编号规则枚举
 *
 * @author 蔡登勇
 */
public enum CodeRuleType {

    /**
     * 客户编号规则
     */
    CUST_CODE(1, "custCode"),

    /**
     * 理财端-客户编号规则
     */
    LENDER_CUST_CODE(2, "lenderCustCode"),

    /**
     * 理财端-出借编号规则
     */
    LENDER_CODE(3, "lenderCode"),

    /**
     * 借款端-客户编号规则
     */
    BORROW_CUST_CODE(4, "borrowCustCode");

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
    CodeRuleType(int code, String info) {
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
    public static CodeRuleType getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (CodeRuleType codeRuleType : CodeRuleType.values()) {
            if (codeRuleType.getCode() == (code)) {
                return codeRuleType;
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
        CodeRuleType codeRuleType = getEunm(code);
        if (codeRuleType == null) {
            throw new CodeRuleIPIsErrorException("没有找到对应的规则枚举");
        }
        return codeRuleType.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (CodeRuleType codeRuleType : CodeRuleType.values()) {
            result.put(String.valueOf(codeRuleType.getCode()), codeRuleType.getInfo());
        }
        return result;
    }
}
