package com.dx.math.service.enums;

import java.math.BigDecimal;

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
public enum MathType {
    /**
     * BigDecimal
     */
    BIG_DECIMAL("bigDecimal", "BigDecimal"),

    /**
     * String
     */
    STRING("string", "String"),

    /**
     * Boolean
     */
    BOOLEAN("boolean", "Boolean"),

    /**
     * long
     */
    LONG("long", "Long"),
    /**
     * Integer
     */
    INTEGER("integer", "Integer");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MathType(String code, String info) {
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

    public static MathType getEunm(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BaseException("code is Illegal");
        }
        for (MathType mathType : MathType.values()) {
            if (mathType.getCode().equals((code))) {
                return mathType;
            }
        }
        throw new BaseException("code is Illegal");
    }

    public static Object getClassType(String code, Object value) {
        if (value == null) {
            throw new BaseException("code is Illegal");
        }
        switch (getEunm(code)) {
            case BIG_DECIMAL:
                return new BigDecimal(value.toString());
            case STRING:
                return value.toString();
            case INTEGER:
                return new Integer(value.toString());
            case BOOLEAN:
                return new Boolean(value.toString());
            case LONG:
                return new Long(value.toString());
            default:
                throw new BaseException("code is Illegal");
        }
    }
}
