package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

public enum RecoveryMode {
    /**
     * 债权转让处理
     */
    CREDITOR(1, "债权转让处理"),
    /**
     * 自动继续出借
     */
    AUTOMATICALLY(2, "自动继续出借");

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
     */
    RecoveryMode(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
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
    public static RecoveryMode getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (RecoveryMode recovery : RecoveryMode.values()) {
            if (Assert.equals(recovery.getCode(), code)) {
                return recovery;
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
        RecoveryMode recovery = getEunm(code);
        return Assert.checkParam(recovery) ? recovery.getInfo() : isView ? WMSConstants.NULL : "-";
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (RecoveryMode msgWay : RecoveryMode.values()) {
            result.put(String.valueOf(msgWay.getCode()), msgWay.getInfo());
        }
        return result;
    }

}
