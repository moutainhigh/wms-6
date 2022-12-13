package com.dx.wms.enums;

import java.util.Map;
import java.util.TreeMap;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 
 * 特殊情况类型
 *
 * @author tony
 */
public enum ConditionCategory {

    /**
     * 特殊收益
     */
    INCOME(1, "特殊收益", "%"),

    /**
     * 特殊 额度
     */
    LIMIT(2, "特殊额度", "元");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    /**
     * 单位
     */
    private String unit;

    ConditionCategory(Integer code, String info, String unit) {
        this.code = code;
        this.info = info;
        this.unit = unit;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     */
    public static ConditionCategory getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (ConditionCategory category : ConditionCategory.values()) {
            if (Assert.equals(category.getCode(), code)) {
                return category;
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
        ConditionCategory category = getEunm(code);
        return Assert.checkParam(category) ? category.getInfo() : isView ? WMSConstants.NULL : "-";
    }

    public static String getUnit(Integer code, Boolean isView) {
        ConditionCategory category = getEunm(code);
        return Assert.checkParam(category) ? category.getUnit() : isView ? WMSConstants.NULL : "-";
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new TreeMap<String, String>();
        for (ConditionCategory category : ConditionCategory.values()) {
            result.put(String.valueOf(category.getCode()), category.getInfo());
        }
        return result;
    }

}
