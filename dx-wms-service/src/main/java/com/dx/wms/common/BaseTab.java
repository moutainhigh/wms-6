package com.dx.wms.common;

import java.io.Serializable;

/**
 * 
 * 基础板块
 *
 * @author tony
 */
public class BaseTab implements Serializable {

    /**
     */
    private static final long serialVersionUID = 691149278616168338L;

    /**
     * 板块编号
     */
    protected String tabId;

    /**
     * 板块样式
     */
    protected String tabClass;

    /**
     * 板块标题
     */
    protected String tabTitle;

    /**
     * 板块渲染地址
     */
    protected String tabUrl;

    /**
     * 顺序
     */
    protected Integer index;

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getTabClass() {
        return tabClass;
    }

    public void setTabClass(String tabClass) {
        this.tabClass = tabClass;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getTabUrl() {
        return tabUrl;
    }

    public void setTabUrl(String tabUrl) {
        this.tabUrl = tabUrl;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

}
