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
public enum RuleSign {
    /**
     * 大于等于
     */
    MORE_EQUAL(1, "大于等于"),

    /**
     * 小于
     */
    LESS(2, "小于"),

    /**
     * 大于
     */
    EQUAL(3, "等于"),

    /**
     * 大于
     */
    MORE(4, "大于"),

    /**
     * 小于等于
     */
    LESS_EQUAL(5, "小于等于"),
    
    /**
     * 乘以
     */
    MULTIPLY(6,"乘以"),
    
    /**
     * 求与
     */
    AND(7,"求与"),
    
    /**
     * 除以
     */
    DIVIDE(8,"除以");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    private RuleSign(Integer code, String info) {
        this.code = code;
        this.info = info;
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
    
    
}
