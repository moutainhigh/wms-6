package com.dx.wms.enums;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

public enum ApplyBiz {
    /**
     * 新增理财申请
     */
    ADD("add", "新增理财申请"),

    /**
     * 到期理财申请
     */
    DUE("due", "到期理财申请"),

    /**
     * 质检
     */
    QUALITY("quality", "质检"),

    /**
     * 投资审核
     */
    INVEST("invest", "投资审核"),

    /**
     * 债权确认
     */
    CREDIT("creditor", "债权确认"),
    /**
     * 客户信息变更
     */
    INFO_CHANGE("custInfo", "客户信息变更"),
    /**
     * 投资信息变更
     */
    INVEST_CHANGE("investInfo", "投资信息变更");
    /**
     * 链接
     */
    private String url;

    /**
     * 内容
     */
    private String info;

    private ApplyBiz(String url, String info) {
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

    public static ApplyBiz getEunm(String url) {
        if (!Assert.checkParam(url)) {
            throw new BaseException("not found url");
        }
        for (ApplyBiz biz : ApplyBiz.values()) {
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
