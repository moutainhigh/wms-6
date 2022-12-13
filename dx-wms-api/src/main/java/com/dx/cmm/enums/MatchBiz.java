package com.dx.cmm.enums;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

/**
 * 
 * 匹配业务
 *
 * @author tony
 */
public enum MatchBiz {

    /**
     * 新增匹配
     */
    ADD_MATCH("add", "新增匹配"),

    /**
     * 回款匹配
     */
    BACK_MATCH("back", "回款匹配"),

    /**
     * 重新匹配
     */
    REPEAT_MATCH("repeat", "重新匹配"),

    /**
     * 异常匹配
     */
    EXCEPTION_MATCH("exception", "异常匹配"),

    /**
     * 续投匹配
     */
    CONTINUE_MATCH("continue", "续投匹配");

    /**
     * 链接
     */
    private String url;

    /**
     * 内容
     */
    private String info;

    private MatchBiz(String url, String info) {
        this.url = url;
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static MatchBiz getEunm(String url) {
        if (!Assert.checkParam(url)) {
            throw new BaseException("not found url");
        }
        for (MatchBiz biz : MatchBiz.values()) {
            if (biz.getUrl().equals(url)) {
                return biz;
            }
        }
        throw new BaseException("not found url");
    }

    public static String getInfo(String url) {
        return getEunm(url).getInfo();
    }

}
