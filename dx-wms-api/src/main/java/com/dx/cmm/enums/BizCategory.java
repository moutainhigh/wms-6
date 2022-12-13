package com.dx.cmm.enums;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

/**
 * 
 * 业务类型
 *
 * @author tony
 */
public enum BizCategory {
    /**
     * 信贷
     */
    CREDIT(1, "信贷", "credit"),

    /**
     * 理财
     */
    INVEST(2, "理财", "invest");

    /**
     * 常量值
     */
    private Integer code;

    /**
     * 内容
     */
    private String info;

    /**
     * 链接
     */
    private String url;

    private BizCategory(Integer code, String info, String url) {
        setCode(code);
        setInfo(info);
        setUrl(url);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static BizCategory getEunm(String url) {
        if (!Assert.checkParam(url)) {
            throw new BaseException("not found url");
        }
        for (BizCategory category : BizCategory.values()) {
            if (category.getUrl().equals(url)) {
                return category;
            }
        }
        throw new BaseException("not found url");
    }

    public static Integer getCode(String url) {
        return getEunm(url).getCode();
    }

}
