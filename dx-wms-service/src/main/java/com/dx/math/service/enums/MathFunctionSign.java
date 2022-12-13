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
public enum MathFunctionSign {
    /**
     * round函数
     */
    ROUND("round", "round函数");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MathFunctionSign(String code, String info) {
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

    public static MathFunctionSign getEunm(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BaseException("code is Illegal");
        }
        for (MathFunctionSign functionSign : MathFunctionSign.values()) {
            if (functionSign.getCode().equals((code))) {
                return functionSign;
            }
        }
        return null;
    }
}
