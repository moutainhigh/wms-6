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
public enum MathArithmeticSign {
    /**
     * 加
     */
    ADD("add", "加"),

    /**
     * 减
     */
    SUBTRACT("subtract", "减"),

    /**
     * 乘
     */
    MULTIPLY("multiply", "乘"),

    /**
     * 除
     */
    DIVIDE("divide", "除"),

    /**
     * 取余
     */
    REM("rem", "取余"),

    /**
     * 递增
     */
    INCREASE("increase", "递增"),

    /**
     * 递减
     */
    DECREASE("decrease", "递减");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MathArithmeticSign(String code, String info) {
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

    public static MathArithmeticSign getEunm(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BaseException("code is Illegal");
        }
        for (MathArithmeticSign mathArithmeticSign : MathArithmeticSign.values()) {
            if (mathArithmeticSign.getCode().equals((code))) {
                return mathArithmeticSign;
            }
        }
        return null;
    }
}
