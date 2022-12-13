package com.dx.math.service.enums;

import org.apache.commons.lang3.StringUtils;

import com.dx.framework.exception.BaseException;


/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum MathRelationSign {
    /**
     * 大于等于
     */
    MORE_EQUAL("moreEqual", "大于等于"),

    /**
     * 小于
     */
    LESS("less", "小于"),

    /**
     * 等于
     */
    EQUAL("equal", "等于"),

    /**
     * 大于
     */
    MORE("more", "大于"),

    /**
     * 小于等于
     */
    LESS_EQUAL("lessEqual", "小于等于"),

    /**
     * 不等于
     */
    NOT_EQUAL("notEqual", "不等于");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MathRelationSign(String code, String info) {
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

    public static MathRelationSign getEunm(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BaseException("code is Illegal");
        }
        for (MathRelationSign mathRelationSign : MathRelationSign.values()) {
            if (mathRelationSign.getCode().equals((code))) {
                return mathRelationSign;
            }
        }
        return null;
    }
}
