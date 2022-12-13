package com.dx.wms.service.detail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 申请信息板块
 * 
 * @author tony
 */
public enum SynthesizeTab {

    ACCOUNT("tab_detail_account", "active", "账户信息", "detail/account3.ftl", 3),

    APPLY("tab_detail_apply", "", "投资信息", "detail/apply3.ftl", 2),

    LOG("tab_detail_log", "", "日志信息", "detail/log.ftl", 1);

    /**
     * 板块编号
     */
    private String tabId;

    /**
     * 板块样式
     */
    private String tabClass;

    /**
     * 板块标题
     */
    private String tabTitle;

    /**
     * 板块渲染地址
     */
    private String tabUrl;

    /**
     * 顺序
     */
    private Integer index;

    SynthesizeTab(String tabId, String tabClass, String tabTitle, String tabUrl, Integer index) {
        this.tabId = tabId;
        this.tabClass = tabClass;
        this.tabTitle = tabTitle;
        this.tabUrl = tabUrl;
        this.index = index;
    }

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

    protected static List<TabDetail> geTabs() {
        List<TabDetail> tabs = new ArrayList<>();
        for (SynthesizeTab tab : SynthesizeTab.values()) {
            tabs.add(new TabDetail(tab));
        }
        Collections.sort(tabs, new TabComparator());
        return tabs;
    }

}
