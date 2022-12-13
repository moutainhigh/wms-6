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
public enum EntryTab {
    
    PERSONAGE("tab_account", "active", "个人信息", "hr/detail/personInfo.ftl", 4),
     
    PROVIDENT("tab_apply", "", "公积金信息", "hr/detail/accumulationInfo.ftl", 3),

    VIDEO("tab_video", "", "入职材料", "hr/detail/videoInfo.ftl", 2),
    
    LOG("tab_log", "", "审批信息", "hr/detail/logInfo.ftl", 1);

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

    EntryTab(String tabId, String tabClass, String tabTitle, String tabUrl, Integer index) {
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
        for (EntryTab tab : EntryTab.values()) {
            tabs.add(new TabDetail(tab));
        }
        Collections.sort(tabs, new TabComparator());
        return tabs;
    }

}
