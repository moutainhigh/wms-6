package com.dx.cmm.enums;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

/**
 * 
 * 规则类型
 *
 * @author tony
 */
public enum RuleCategory {
    /**
     * 信贷端-匹配规则
     */
    INPUT(1L, "输入"),

    /**
     * 理财端-匹配规则
     */
    OUTPUT(2L, "输出");

    /**
     * 常量值
     */
    private Long code;

    /**
     * 内容
     */
    private String info;

    private RuleCategory(Long code, String info) {
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

    public static RuleCategory getEunm(Long code) {
        Assert.notNull("not found code", code);
        for (RuleCategory category : RuleCategory.values()) {
            if (Assert.equals(category.getCode(), code)) {
                return category;
            }
        }
        throw new BaseException("not found code");
    }
}
