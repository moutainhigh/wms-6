package com.dx.wms.test.service;

import java.util.HashMap;
import java.util.Map;

public enum WorkSituation {
    /**
     * 企业主/股东
     */
    PAYROLL(1, "工薪"),

    /**
     * 正式职员
     */
    SELF(2, "自营"),

    /**
     * 外包/聘用
     */

    STUDENT(3, "学生"),

    /**
     * 其他
     */
    WHITECOLLAR(4, "白领");

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
    WorkSituation(int code, String info) {
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
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static WorkSituation getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (WorkSituation workSit : WorkSituation.values()) {
            if (workSit.getCode() == (code)) {
                return workSit;
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
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getInfo(Integer code) {
        WorkSituation workSit = getEunm(code);
        return workSit == null ? "-" : workSit.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new HashMap<String, String>();
        for (WorkSituation workSit : WorkSituation.values()) {
            result.put(String.valueOf(workSit.getCode()), workSit.getInfo());
        }
        return result;
    }
}
