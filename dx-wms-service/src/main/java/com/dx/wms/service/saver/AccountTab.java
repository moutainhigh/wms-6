package com.dx.wms.service.saver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 开户信息板块
 *
 * @author tony
 */
public enum AccountTab {

    BASE("tab_base", "active", "基本信息", "save/base_view.ftl", 1),

    ACCOUNT("tab_account", "", "详细信息", "save/account_edit.ftl",2),
    
    LINKMAN("tab_linkman", "", "通讯信息", "save/comm_edit.ftl", 3),

    VIDEO("tab_video", "", "影像信息", "save/video_edit.ftl", 4);

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

    AccountTab(String tabId, String tabClass, String tabTitle, String tabUrl, Integer index) {
        this.tabId = tabId;
        this.tabClass = tabClass;
        this.tabTitle = tabTitle;
        this.tabUrl = tabUrl;
        this.index = index;
    }

    protected String getTabId() {
        return tabId;
    }

    protected void setTabId(String tabId) {
        this.tabId = tabId;
    }

    protected String getTabClass() {
        return tabClass;
    }

    protected void setTabClass(String tabClass) {
        this.tabClass = tabClass;
    }

    protected String getTabTitle() {
        return tabTitle;
    }

    protected void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    protected String getTabUrl() {
        return tabUrl;
    }

    protected void setTabUrl(String tabUrl) {
        this.tabUrl = tabUrl;
    }

    protected Integer getIndex() {
        return index;
    }

    protected void setIndex(Integer index) {
        this.index = index;
    }

    protected static List<TabSaver> geTabs() {
        List<TabSaver> tabs = new ArrayList<>();
        for (AccountTab tab : AccountTab.values()) {
            tabs.add(new TabSaver(tab));
        }
        Collections.sort(tabs, new TabComparator());
        return tabs;
    }
}
