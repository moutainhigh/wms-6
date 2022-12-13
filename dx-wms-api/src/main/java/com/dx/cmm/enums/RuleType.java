package com.dx.cmm.enums;


/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum RuleType {
    /**
     * BigDecimal
     */
    BIGDECIMAL(1L, "BigDecimal"),

    /**
     * String
     */
    STRING(2L, "String"),

    /**
     * Boolean
     */
    BOOLEAN(3L, "Boolean"),

    /**
     * Percent
     */
    PERCENT(4L, "Percent"),

    /**
     * Integer
     */
    INTEGER(5L, "Integer");

    /**
     * 常量值
     */
    private Long code;

    /**
     * 内容
     */
    private String info;

    private RuleType(Long code, String info) {
        this.code = code;
        this.info = info;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static RuleType getEunm(Long code) {
        if (code == null) {
            return null;
        }
        for (RuleType ruleType : RuleType.values()) {
            if (ruleType.getCode().equals(code)) {
                return ruleType;
            }
        }
        return null;
    }
}
