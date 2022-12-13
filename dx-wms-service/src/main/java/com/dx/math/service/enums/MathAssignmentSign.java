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
public enum MathAssignmentSign {
    /**
     * 赋值
     */
    ASSIGN("assign", "赋值"),

    /**
     * 加赋值
     */
    ADD_ASSIGN("addAssign", "加赋值"),

    /**
     * 减赋值
     */
    SUBTRACT_ASSIGN("subtractAssign", "减赋值"),

    /**
     * 除赋值
     */
    DIVIDE_ASSIGN("divideAssign", "除赋值"),

    /**
     * 乘赋值
     */
    MULTIPLY_ASSIGN("multiplyAssign", "乘赋值"),

    /**
     * 取余赋值
     */
    REM_ASSIGN("remAssign", "取余赋值"),

    /**
     * 按位与赋值
     */
    BITWISE_AND_ASSIGN("bitwiseAndAssign", "按位与赋值"),

    /**
     * 按位或赋值
     */
    BITWISE_OR_ASSIGN("bitwiseOrAssign", "按位或赋值"),

    /**
     * 按位异或赋值
     */
    BITWISE_DIFF_OR_ASSIGN("bitwiseDiffOrAssign", "按位异或赋值"),

    /**
     * 左移位赋值
     */
    LEFT_SHIFT_ASSIGN("leftShiftAssign", "左移位赋值"),

    /**
     * 右移位赋值
     */
    RIGHT_SHIFT_ASSIGN("rightShiftAssign", "右移位赋值");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MathAssignmentSign(String code, String info) {
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

    public static MathAssignmentSign getEunm(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BaseException("code is Illegal");
        }
        for (MathAssignmentSign mathAssignmentSign : MathAssignmentSign.values()) {
            if (mathAssignmentSign.getCode().equals((code))) {
                return mathAssignmentSign;
            }
        }
        return null;
    }
}
