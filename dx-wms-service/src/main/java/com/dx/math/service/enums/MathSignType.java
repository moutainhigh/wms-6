package com.dx.math.service.enums;

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
public enum MathSignType {
    /**
     * 算术操作符
     */
    ARITHMETIC("arithmetic", "算术操作符"),

    /**
     * 赋值操作符
     */
    ASSIGNMENT("assignment", "赋值操作符"),

    /**
     * 位操作符
     */
    BITWISE("bitwise", "位操作符"),

    /**
     * 关系操作符
     */
    RELATION("relation", "关系操作符"),

    /**
     * 逻辑操作符
     */
    LOGIC("logic", "逻辑操作符"),

    /**
     * 其他操作符
     */
    OTHER("other", "其他操作符"),

    /**
     * 函数操作符
     */
    FUNCTION("function", "函数操作符");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MathSignType(String code, String info) {
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

    public static MathSignType getByCode(String code) {
        if (MathRelationSign.getEunm(code) != null) {
            return RELATION;
        }
        if (MathArithmeticSign.getEunm(code) != null) {
            return ARITHMETIC;
        }
        if (MathAssignmentSign.getEunm(code) != null) {
            return ASSIGNMENT;
        }
        if (MathFunctionSign.getEunm(code) != null) {
            return FUNCTION;
        }

        throw new BaseException();
    }
}
